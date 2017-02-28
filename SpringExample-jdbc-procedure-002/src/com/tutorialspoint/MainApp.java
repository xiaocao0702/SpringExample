package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 中 SQL 的存储过程
 * SimpleJdbcCall 类可以被用于调用一个包含 IN 和 OUT 参数的存储过程。
 * 你可以在处理任何一个 RDBMS 时使用这个方法，就像 Apache Derby， DB2， MySQL， Microsoft SQL Server， Oracle，和 Sybase。
 * 
 * 
 * @author caopl
 *
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("zhangsan", 18);
		studentJDBCTemplate.create("lisi", 12);
		studentJDBCTemplate.create("laowang", 28);
		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for(Student student : students) {
			System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName() );
      System.out.println(", Age : " + student.getAge());
		}
		System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);
		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
    System.out.print("ID : " + student.getId() );
    System.out.print(", Name : " + student.getName() );
    System.out.println(", Age : " + student.getAge());  
	}
}
