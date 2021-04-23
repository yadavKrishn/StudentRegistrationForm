package com.pack.dao;

import java.util.List;

import com.pack.model.Student;

public interface StudentDao {
		public void insertStudent(Student stu);
		public List<Student> fetchAllStudent();
		public void deleteStudent(int stuId);
		public Student fetchStudentById(Integer stuId);
		public void updateStudent(Student stu);
	}


