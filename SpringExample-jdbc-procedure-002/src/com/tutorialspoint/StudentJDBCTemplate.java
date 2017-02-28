package com.tutorialspoint;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StudentJDBCTemplate implements StudentDAO {
	
	private DataSource dataSource;
	private SimpleJdbcCall call;
	private JdbcTemplate jdbcTemplate;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.call = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
	}

	@Override
	public void create(String name, Integer age) {
		String sql = "insert into Student (name, age) values (?,?)";
		jdbcTemplate.update(sql, name, age);
		System.out.println("Created Record Name = " + name + " Age = " + age);
		return;
	}

	@Override
	public Student getStudent(Integer id) {
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
//		Student student = jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
		Map<String, Object> out = call.execute(in);
		Student student = new Student();
		student.setId(id);
		student.setName((String)out.get("out_name"));
		student.setAge((Integer)out.get("out_age"));
		return student;
	}

	@Override
	public List<Student> listStudents() {
		String sql = "select * from Student";
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from Student where id = ?";
		jdbcTemplate.update(sql, id);
		System.out.println("Deleted Record with ID = " + id );
		return;
	}

	@Override
	public void update(Integer id, Integer age) {
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplate.update(SQL, age, id);
    System.out.println("Updated Record with ID = " + id );
    return;
	}

}
