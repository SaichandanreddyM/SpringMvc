package employeedata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import employeedata.dto.Employee;

@Component
public class EmployeeDao {
	@Autowired
	EntityManager em;
	public Employee saveEmployee(Employee emp) {
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		return emp;	
	}
	public Employee FindEmployee(int empid) {
		Employee e=em.find(Employee.class, empid);
		if(e!=null) {
			return e;
		}
		return null;
		
	}
	public Employee updateEmployee(Employee emp,int empid) {
		
		Employee dbemp=FindEmployee(empid);
		if(dbemp!=null) {
			emp.setEmployeeid(empid);
			em.getTransaction().begin();
			em.merge(emp);
			em.getTransaction().commit();
			return emp;
		
		}
		return null;
		
	}
	public Employee DeleteEmployee(int empid) {
		Employee e=em.find(Employee.class, empid);
		if(e!=null) {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			return e;
		}
		return null;
		
	}
	public List<Employee> FindallEmployees() {
		Query query=em.createQuery("select e from Employee e");
		return query.getResultList();
		
	}
	public Employee FindbyEmail(String empmail) {
		Query query=em.createQuery("select e from Employee e where e.employeeemail=?1");
		query.setParameter(1, empmail);
		return (Employee)query.getSingleResult();
		
	}

}
