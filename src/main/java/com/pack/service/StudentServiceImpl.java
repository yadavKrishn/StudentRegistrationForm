package com.pack.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.dao.StudentDao;
import com.pack.model.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
Logger logger=Logger.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void insertStudent(Student stud) {
		logger.info("Inside insertStudent() service");
		studentDao.insertStudent(stud);
	}

	@Override
	public List<Student> fetchAllStudent() {
		logger.info("Inside fetchAllStudent() service");
		List<Student> stuList=studentDao.fetchAllStudent();
		return stuList;
	}

	@Override
	public void deleteStudent(int stuId) {
		logger.info("Inside deleteStudent() service");
		studentDao.deleteStudent(stuId);
		
	}

	@Override
	public Student fetchStudentById(Integer stuId) {
		logger.info("Inside fetchStudentById() service");
		Student stu=studentDao.fetchStudentById(stuId);
		return stu;
	}

	@Override
	public void updateStudent(Student stu) {
		logger.info("Inside updateStudent() service");
		studentDao.updateStudent(stu);
		
	}
}

