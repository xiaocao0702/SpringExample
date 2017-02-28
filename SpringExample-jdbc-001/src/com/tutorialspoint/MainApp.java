package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring JDBC 框架
 * Spring JDBC 框架负责所有的低层细节，从开始打开连接，准备和执行 SQL 语句，处理异常，处理事务，到最后关闭连接。
 * 所以当从数据库中获取数据时，你所做的是定义连接参数，指定要执行的 SQL 语句，每次迭代完成所需的工作。
 * Spring JDBC 提供几种方法和数据库中相应的不同的类与接口。
 * 这里给出使用 JdbcTemplate 类框架的经典和最受欢迎的方法。
 * 这是管理所有数据库通信和异常处理的中央框架类。
 * 
 * JdbcTemplate 类
 * JdbcTemplate 类执行 SQL 查询、更新语句和存储过程调用，执行迭代结果集和提取返回参数值。
 * 它也捕获 JDBC 异常并转换它们到 org.springframework.dao 包中定义的通用类、更多的信息、异常层次结构。
 * JdbcTemplate 类的实例是线程安全配置的。
 * 所以你可以配置 JdbcTemplate 的单个实例，然后将这个共享的引用安全地注入到多个 DAOs 中。
 * 使用 JdbcTemplate 类时常见的做法是在你的 Spring 配置文件中配置数据源，
 * 然后共享数据源 bean 依赖注入到 DAO 类中，并在数据源的设值函数中创建了 JdbcTemplate。
 * 
 * 可以在 XML 文件中配置数据源，其中一段代码如下所示：
 * <bean id="dataSource"
 * class="org.springframework.jdbc.datasource.DriverManagerDataSource">
 *    <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
 *    <property name="url" value="jdbc:mysql://localhost:3306/TEST"/>
 *    <property name="username" value="root"/>
 *    <property name="password" value="password"/>
 * </bean>
 * 数据访问对象（DAO）
 * DAO 代表常用的数据库交互的数据访问对象。DAOs 提供一种方法来读取数据并将数据写入到数据库中，它们应该通过一个接口显示此功能，应用程序的其余部分将访问它们。
 * 在 Spring 中，数据访问对象(DAO)支持很容易用统一的方法使用数据访问技术，如 JDBC、Hibernate、JPA 或者 JDO。
 * 
 * 在项目中添加 Spring JDBC 指定的最新的库 
 * mysql-connector-java.jar，
 * org.springframework.jdbc.jar，
 * org.springframework.transaction.jar
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
