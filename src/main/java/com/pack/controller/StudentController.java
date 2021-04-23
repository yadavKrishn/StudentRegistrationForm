package com.pack.controller;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pack.model.Student;
import com.pack.service.StudentService;

@Controller
public class StudentController {
	Logger logger=Logger.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="/")
	public String employeeRegistrationPage(ModelMap map) {
		logger.info("Inside studentRegistration()");
		Student student=new Student();
		map.addAttribute("studentForm", student);
		return "StudentRegister";
	}
	@RequestMapping(value="/insertStu",method=RequestMethod.POST)
	public String saveStudent(@Validated @ModelAttribute("studentForm")Student stud,
		BindingResult result,ModelMap map) {
		logger.info("Inside saveStudent()");
	String response="";
	if(result.hasErrors()) {
		response="StudentRegister";
	}
	else {
		Random r=new Random();
		int stuid=r.nextInt(99999)+10000;
		stud.setStudentid(stuid);
		studentService.insertStudent(stud);
		List<Student> stuList=studentService.fetchAllStudent();
		map.addAttribute("studentList",stuList);
		response="StudentSuccess";
	}
	return response;
}
	@RequestMapping(value="/deleteStu/{id}")
	public String deleteStudent(@PathVariable("id") Integer stuId,ModelMap map) {
		logger.info("Inside deleteStudent()");
		studentService.deleteStudent(stuId);
		List<Student> stuList=studentService.fetchAllStudent();
		map.addAttribute("studentList",stuList);
		return "StudentSuccess";
	}
	@RequestMapping(value="/fetchById/{eid}")
	public String fetchStudentById(@PathVariable("sid") Integer stuId,ModelMap map) {
		logger.info("fetchStudentById()");
		Student student=studentService.fetchStudentById(stuId);
		map.addAttribute("editForm", student);
		return "StudentUpdate";
				
	}
	@RequestMapping(value="/updateStu",method=RequestMethod.POST)
	public String updateStudent(@Validated @ModelAttribute("editForm")Student stu,
			BindingResult result,ModelMap map) {
		logger.info("updateStudent()");
		String response="";
		if(result.hasErrors()) {
			response="StudentUpdate";
		}
		else {
			studentService.updateStudent(stu);
			List<Student> stuList=studentService.fetchAllStudent();
			map.addAttribute("studentList",stuList);
			return "StudentSuccess";
			
		}
		return response;
		
	}

}
