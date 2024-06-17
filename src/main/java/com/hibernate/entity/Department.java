package com.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Criteria;
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id ;
	private String name;
	private String location;
	
	@OneToMany(mappedBy ="department",cascade =CascadeType.ALL,orphanRemoval = true)
	private Set <Employee> employees = new HashSet<>();
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department( String name, String location,Set<Employee> employee) {
		super();
		
		this.name = name;
		this.location = location;
		this.employees=employee;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	
	

}
