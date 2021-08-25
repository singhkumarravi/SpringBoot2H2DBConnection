package com.olive.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.olive.model.Employee;
@Component
public class TestRunner implements CommandLineRunner {
@Autowired
private JdbcTemplate jt; 
public void run(String... args) throws Exception {
	System.out.println("App starting..............");
	String sql="select * from Employees";
	
	          List<Employee> list = jt.query(sql,(rs, rowNum)->{
	        	  
	        	  return new Employee(rs.getInt("eid"),
	        			  rs.getString("ename"),
	        			  rs.getDouble("esal"),
	        			  rs.getString("address"));
	          } );
	
	    for(Employee e:list) {
	    	System.out.println("Record:: " + e);
	    }      
}

}
