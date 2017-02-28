package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 编程式事务管理
 * 
 * 编程式事务管理方法允许你在对你的源代码编程的帮助下管理事务。这给了你极大地灵活性，但是它很难维护。
 * 
 * 
 * 
 * 
 * @author caopl
 *
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentDAO studentJDBCTemplate = (StudentDAO) context.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("zhangsan", 18, 99, 2017);
		studentJDBCTemplate.create("lisi", 12, 60, 2017);
		studentJDBCTemplate.create("laowang", 28, 80, 2017);
		System.out.println("------Listing Multiple Records--------");
		List<StudentMarks> students = studentJDBCTemplate.listStudents();
		for(StudentMarks student : students) {
			System.out.print("ID : " + student.getId() );
      System.out.print(", Name : " + student.getName());
      System.out.println(", Age : " + student.getAge());
      System.out.print(", Marks : " + student.getMarks());
      System.out.println(", Year : " + student.getYear());
		}
		
	}
}
