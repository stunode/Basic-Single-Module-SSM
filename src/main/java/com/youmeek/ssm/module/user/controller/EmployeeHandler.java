package com.youmeek.ssm.module.user.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.youmeek.ssm.module.user.dao.DepartmentDao;
import com.youmeek.ssm.module.user.dao.EmployeeDao;
import com.youmeek.ssm.module.user.entities.Employee;

@RequestMapping("/Basic-Single-Module-SSM")
@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
//
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) Integer id,
			Map<String, Object> map){
		if(id != null){
			map.put("employee", employeeDao.get(id));
		}
	}
//
	@RequestMapping(value="/emp", method=RequestMethod.PUT)
	public String update(@ModelAttribute("employee") Employee employee){
		employeeDao.save(employee);

		return "redirect:/Basic-Single-Module-SSM/emps";
	}
//
	@RequestMapping(value="/emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String, Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
//
	@RequestMapping(value="/emp/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/Basic-Single-Module-SSM/emps";
	}
//
//	@RequestMapping(value="/emp", method=RequestMethod.POST)
//	public String save(@Valid Employee employee, Errors result,
//			Map<String, Object> map){
//		System.out.println("save: " + employee);
//
//		if(result.getErrorCount() > 0){
//			System.out.println("������!");
//
//			for(FieldError error:result.getFieldErrors()){
//				System.out.println(error.getField() + ":" + error.getDefaultMessage());
//			}
//
//			//����֤����, ��ת���Ƶ�ҳ��
//			map.put("departments", departmentDao.getDepartments());
//			return "input";
//		}
@RequestMapping(value="/emp", method=RequestMethod.POST)
		public String save(@Valid Employee employee,BindingResult result,Map<String,Object>map){
//	public String save(@Valid Employee employee,BindingResult result){
		System.out.println("save" + employee);
		if(result.getErrorCount()>0) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField() + ":" + error.getDefaultMessage());
			}

			map.put("departments", departmentDao.getDepartments());
			return "input";
		}

		employeeDao.save(employee);
		return "redirect:/Basic-Single-Module-SSM/emps";
	}
//
	@RequestMapping(value="/emp", method=RequestMethod.GET)
	public String input(Map<String, Object> map){
		map.put("departments", departmentDao.getDepartments());
		map.put("employee", new Employee());
		return "input";
	}
	
	@RequestMapping("/emps")
	public String list(Map<String, Object> map){
		System.out.println("employees");
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		binder.setDisallowedFields("lastName");
//	}
	
}