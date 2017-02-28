package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	@Override
	public void create(String name, Integer age, Integer marks, Integer year) {
		try {
			String sql = "insert into Student(name, age) value(?, ?)";
			jdbcTemplate.update(sql, name, age);
			String sql2 = "select max(id) from Student";
			int sid = jdbcTemplate.queryForObject(sql2, Integer.class);
			String sql3 = "insert into Marks(sid, marks, year) values (?, ?, ?)";
			jdbcTemplate.update(sql3, sid, marks, year);
			System.out.println("Created Name = " + name + ", Age = " + age);
			// to simulate the exception.
//      throw new RuntimeException("simulate Error condition") ;
		} catch (DataAccessException e) {
      System.out.println("Error in creating record, rolling back");
      throw e;
    }
	}


	@Override
	public List<StudentMarks> listStudents() {
		String sql = "select * from Student, Marks where Student.id=Marks.sid";
		List<StudentMarks> students = jdbcTemplate.query(sql, new StudentMarksMapper());
		return students;
	}

}
