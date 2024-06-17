package com.hibernate.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.hibernate.config.HibernateConfig;
import com.hibernate.entity.Department;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Project;

public class DaoImpl {
	SessionFactory sf = HibernateConfig.getSessionFactory();

	public Department addDept(Department emp) {

		Session session = sf.openSession();
		Department emp1 = session.get(Department.class, emp.getId());
		session.save(emp);
		session.beginTransaction().commit();
		return emp1;

	}

	public Employee addEmployee(Employee emp) {

		Session session = sf.openSession();
		Employee emp1 = session.get(Employee.class, emp.getId());
		session.save(emp);
		session.beginTransaction().commit();
		return emp1;

	}

	public Project addProject(Project p) {
		Session session = sf.openSession();
		Project emp1 = session.get(Project.class, p.getId());
		session.save(p);
		session.beginTransaction().commit();
		return emp1;

	}

	public List<Employee> getEmploye() {
		List<Employee> list;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class); // To get record from DB
		list = criteria.list();
		return list;

	}

	public List<Employee> getSalary(double salary) {
		List list;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.gt("salary", salary));
		list = criteria.list();
		return list;

	}

	public List<Employee> getAscOrderLastName() {
		List list;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.asc("lastname"));
		list = criteria.list();
		return list;

	}

	public List<Department> getDeptPagination() {
		int pageNumber = 6;
		int pageSize = 9;
		int firstResult = (pageNumber - 1) * pageSize;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Department.class);
		String hql = "FROM Department";
		Query query = session.createQuery(hql);
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List<Department> list = criteria.list();
		for (Department i : list) {
			System.out.println(i.getName() + " " + i.getId());
		}
		return list;

	}

	public List<Employee> getFirstALastName() {

		Session session = sf.openSession();
//	Transaction	tx=session.beginTransaction();
		Query query = session.createQuery("select firstName,lastName from Employee where id=i");

		query.setParameter("i", 5);
		List<Employee> list = query.getResultList();
		return list;

	}

	public Long getCountEmp() {
		Long count;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.rowCount());
		List<Long> list = criteria.list();// here use <long> because count is not specific
		count = list.get(0);// it spcify 0th index
		return count;

	}

	public Double getMaxsalaryEmp() {
		Double maxbalance;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.max("salary"));
		List<Double> list = criteria.list();
		maxbalance = list.get(0);
		return maxbalance;

	}

	public double getSumSalary() { // using projection we can get maxBalance from table
		double maxBalance;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.sum("salary"));
		List<Double> list = criteria.list();
		maxBalance = list.get(0);
		return maxBalance;

	}

	public double getAvgSalary() { // using projection we can get maxBalance from table
		double maxBalance;
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.setProjection(Projections.avg("salary"));
		List<Double> list = criteria.list();
		maxBalance = list.get(0);
		return maxBalance;
	}

	public List<Department> getDistinctCount() {
		long count;
		Session session = sf.openSession();
		Query query = session.createQuery("select count(name)from Department");
		List list = query.list();
//		Criteria criteria = session.createCriteria(Employee.class);
//		cq.select(cb.countDistinct(departmentNamePath));
		return list;

	}

	public List<Employee> getEmployeeNamesDTO() {
		List<Employee> employeeDTOs;
		Session session = sf.openSession();
		// HQL query to select specific columns (firstName, lastName) and map to
		// EmployeeDTO
		Query<Employee> query = session.createQuery("SELECT NEW Employee(e.firstname, e.lastname) FROM Employee e",
				Employee.class);

		List list = query.list();
		return list;

	}

	public List<Employee> get() {

		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Employee.class);
		PropertyProjection firstNameProjection = Projections.property("firstname");
		PropertyProjection lastNameProjection = Projections.property("lastname");
		criteria.setProjection(Projections.projectionList().add(firstNameProjection).add(lastNameProjection));
		List<Employee> resultList = criteria.list();
		return resultList;

	}

	public List<Object[]> getFirstAndLastName() {
		try (Session session = sf.openSession()) {
			org.hibernate.Criteria criteria = session.createCriteria(Employee.class);

			// Add projections to select only firstName and lastName
			criteria.setProjection(Projections.projectionList().add(Projections.property("firstname"))
					.add(Projections.property("lastname")));

			// Transform result to alias-to-entity-map
			criteria.setResultTransformer(CriteriaSpecification.PROJECTION);

			List<Object[]> rows = criteria.list();
			return rows;
		}
	}

	public List<Object[]> getIdAndFirstName() {
		try (Session session = sf.openSession()) {
			org.hibernate.Criteria criteria = session.createCriteria(Employee.class);

			// Add projections to select only id and firstName
			criteria.setProjection(Projections.projectionList().add(Projections.property("id"))
					.add(Projections.property("firstname")));

			// Transform result to alias-to-entity-map
			criteria.setResultTransformer(CriteriaSpecification.PROJECTION);

			List<Object[]> rows = criteria.list();
			return rows;
		}
	}

	public List<Object[]> getEmpCountByDep() {
		List<Object[]> result;
		try (Session session = sf.openSession()) {

			Query<Object[]> query = session.createQuery(
					"SELECT d.name, COUNT(e) FROM Employee e JOIN e.department d GROUP BY d.name", Object[].class);

			// Execute query and get the result list
			result = query.getResultList();
		}
		return result;

	}

	public List<Employee> getEmpNamesWithDepartments() {
		List<Employee> employee;
		Session session = sf.openSession();

		Query<Employee> query = session.createQuery(
				"SELECT NEW Employee(e.firstname, e.lastname, d.name) " + "FROM Employee e " + "JOIN e.department d");

		// Execute query and get the result list
		employee = query.getResultList();

		return employee;

	}

	public List<Object[]> getEmployeesWithDepartments() {
		try (Session session = sf.openSession()) {
			org.hibernate.Criteria criteria = session.createCriteria(Employee.class, "employee");
			criteria.createAlias("employee.department", "department"); // Inner join with department

			// Add projections to select all fields from employee and department
			criteria.setProjection(Projections.projectionList().add(Projections.property("employee.id"), "employeeId")
					.add(Projections.property("employee.firstname"), "firstname")
					.add(Projections.property("employee.lastname"), "lastname")
					.add(Projections.property("employee.email"), "email")
					.add(Projections.property("employee.salary"), "salary")
					.add(Projections.property("department.id"), "departmentId")
					.add(Projections.property("department.name"), "name")
					.add(Projections.property("department.location"), "location"));

			// Set result transformer to transform the result into a list of maps
			criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

			List<Object[]> result = criteria.list();
			return result;
		}
	}

	public List<Map<String, Object>> getDepartmentsWithEmployees() {
		try (Session session = sf.openSession()) {
			org.hibernate.Criteria criteria = session.createCriteria(Department.class, "department");
			criteria.createAlias("department.employee", "employee", CriteriaSpecification.LEFT_JOIN); // Left join with
																										// employees

			// Add projections to select all fields from department and employee
			criteria.setProjection(
					Projections.projectionList().add(Projections.property("department.id"), "departmentId")
							.add(Projections.property("department.name"), "departmentName")
							.add(Projections.property("department.location"), "departmentLocation")
							.add(Projections.property("employee.id"), "employeeId")
							.add(Projections.property("employee.firstName"), "employeeFirstName")
							.add(Projections.property("employee.lastName"), "employeeLastName")
							.add(Projections.property("employee.email"), "employeeEmail")
							.add(Projections.property("employee.salary"), "employeeSalary"));

			// Set result transformer to transform the result into a list of maps
			criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

			List<Map<String, Object>> result = criteria.list();
			return result;
		}
	}

	public List<Employee> getEmployeesWithDepartments1() {
		try (Session session = sf.openSession()) {
			String hql = "SELECT e FROM Employee e JOIN FETCH e.department";
			Query<Employee> query = session.createQuery(hql, Employee.class);
			List<Employee> employees = query.getResultList();
			return employees;
		}
	}

	public List<Map<String, Object>> getEmployeesWithDepartments2() {
		try (Session session = sf.openSession()) {
			org.hibernate.Criteria criteria = session.createCriteria(Employee.class, "employee");
			criteria.createAlias("employee.department", "department", CriteriaSpecification.INNER_JOIN); // Inner join
																											// with
																											// department

			// Add projections to select specific fields from employee and department
			criteria.setProjection(Projections.projectionList().add(Projections.property("employee.id"), "employeeId")
					.add(Projections.property("employee.firstName"), "firstName")
					.add(Projections.property("employee.lastName"), "lastName")
					.add(Projections.property("employee.email"), "email")
					.add(Projections.property("employee.salary"), "salary")
					.add(Projections.property("department.id"), "departmentId")
					.add(Projections.property("department.name"), "departmentName")
					.add(Projections.property("department.location"), "location"));

			// Set result transformer to transform the result into a list of maps
			criteria.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

			List<Map<String, Object>> result = criteria.list();
			return result;
		}
	}

	public List<Employee> getEmployeesInPune() {
		try (Session session = sf.openSession()) {
			Criteria criteria = session.createCriteria(Employee.class, "employee");
			criteria.createAlias("employee.department", "department", CriteriaSpecification.INNER_JOIN); // Inner join
																											// with
																											// department

			// Add restriction to fetch employees whose department location is 'Pune'
			criteria.add(Restrictions.eq("department.location", "Pune"));

			List<Employee> employees = criteria.list();
			return employees;
		}
	}

	public void insertDepartmentWithEmployeesOneToMany() {
		try (Session session = sf.openSession()) {
			session.beginTransaction();

			// Create a department
			Department department = new Department();
			department.setName("IT");
			department.setLocation("Pune");

			// Create employees
			Employee emp1 = new Employee("John", "Doe", "john.doe@example.com", new Double("5000.00"), department);
			Employee emp2 = new Employee("Jane", "Smith", "jane.smith@example.com", new Double("6000.00"), department);

			// Add employees to department
			department.getEmployees().add(emp1);
			department.getEmployees().add(emp2);

			// Save department (and employees due to CascadeType.ALL)
			session.save(department);

			session.getTransaction().commit();
		}

	}

	public void deleteEmployeeFromDepartmentOneToMany(int employeeId) {
		try (Session session = sf.openSession()) {
			session.beginTransaction();

			// Retrieve the employee by ID
			Employee employee = session.get(Employee.class, employeeId);

			if (employee != null) {
				// Remove employee from department
				Department department = employee.getDepartment();
				if (department != null) {
					department.getEmployees().remove(employee);
				}

				// Delete employee
				session.delete(employee);
			}

			session.getTransaction().commit();
		}
	}
}



    



