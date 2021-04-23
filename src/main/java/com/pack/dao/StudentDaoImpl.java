package com.pack.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pack.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao {
Logger logger=Logger.getLogger(StudentDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void insertStudent(Student stu) {
		logger.info("Inside insertStudent() Dao");
		sessionFactory.getCurrentSession().save(stu);
		
	}

	@Override
	public List<Student> fetchAllStudent() {
		logger.info("Inside fetchAllStudent() Dao");
		Query query=sessionFactory.getCurrentSession().createQuery("select s from Student s");
		List slist=query.list();
		
		return slist;
	}

	@Override
	public void deleteStudent(int stuId) {
		logger.info("Inside deleteStudent() Dao");
		Student stu=(Student)sessionFactory.getCurrentSession().get(Student.class, stuId);
		sessionFactory.getCurrentSession().delete(stu);
		
		
	}

	@Override
	public Student fetchStudentById(Integer stuId) {
		logger.info("Inside fetchStudentId() Dao");
		Student stu=(Student)sessionFactory.getCurrentSession().get(Student.class, stuId);
		return stu;
	}

	@Override
	public void updateStudent(Student stu) {
		logger.info("Inside updateStudent() Dao");
		sessionFactory.getCurrentSession().update(stu);
		
	}


}
