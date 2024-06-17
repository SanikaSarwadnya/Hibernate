package com.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;

public class HibernateConfig {
public static SessionFactory getSessionFactory() {
		
		Configuration cfg=new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		cfg.configure().addAnnotatedClass(Department.class);
		cfg.configure().addAnnotatedClass(Project.class);
		SessionFactory sf=cfg.buildSessionFactory();
		return sf;
		
	}




}
