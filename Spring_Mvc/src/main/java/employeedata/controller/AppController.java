package employeedata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import employeedata.dao.EmployeeDao;
import employeedata.dto.Employee;

@Controller
public class AppController {
	@Autowired
	EmployeeDao dao; 
	
	@RequestMapping("/signup")
	public ModelAndView signup() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("signup.jsp");
		modelandview.addObject("emp", new Employee());
		return modelandview;
	}
	
	@RequestMapping("/saveemployee")
	public ModelAndView saveemployee(@ModelAttribute Employee emp) {
		dao.saveEmployee(emp);
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("login.jsp");
		return modelandview;
		
		
	}
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam String email,@RequestParam String password) {
		Employee emp=dao.FindbyEmail(email);
		if(emp!=null) {
			if(emp.getEmployeepwd().equals(password)) {
				ModelAndView modelandview=new ModelAndView(); 
				modelandview.setViewName("home.jsp");
				modelandview.addObject("emps", dao.FindallEmployees());
				return modelandview;
			}
			else {
				return new ModelAndView("login.jsp");
			}
			
			
		}
		else {
			return new ModelAndView("login.jsp");
		}
		
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("addemployee.jsp");
		modelandview.addObject("emp", new Employee());
		return modelandview;
	}
	
	@RequestMapping("/addemployee")
	public ModelAndView addemployee(@ModelAttribute Employee emp) {
		dao.saveEmployee(emp);
		ModelAndView modelandview=new ModelAndView(); 
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.FindallEmployees());
		return modelandview;
			
	}
	@RequestMapping("/delete")
	public ModelAndView deleteemployee(@RequestParam int id) {
		dao.DeleteEmployee(id);
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.FindallEmployees());
		return modelandview;
		
	}
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam int id) {
		Employee emp=dao.FindEmployee(id);
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("edit.jsp");
		modelandview.addObject("emp",emp);
		return modelandview;
		
	}
	@RequestMapping("/updateemployee")
	public ModelAndView update(@ModelAttribute Employee emp) {
		dao.updateEmployee(emp, emp.getEmployeeid());
		ModelAndView modelandview=new ModelAndView();
		modelandview.setViewName("home.jsp");
		modelandview.addObject("emps", dao.FindallEmployees());
		return modelandview;
	}

}
