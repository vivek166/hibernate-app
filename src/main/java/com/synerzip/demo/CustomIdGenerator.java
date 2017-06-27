package com.synerzip.demo;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.synerzip.demo.model.Employee;

@Path("employee")
public class CustomIdGenerator {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
  
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee add(Employee employee) {
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	employee.setDate(Calendar.getInstance().getTime());
    	session.save(employee); 
        tx.commit();
        return employee;
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee get(@PathParam("id") String id) {
    	Employee employee = (Employee)session.get(Employee.class, id); 
    	Date date = employee.getDate();
    	if(employee.getCountry().equals("india")){
    		return employee;
    	} else {
    		return employee;
    	}
        
    }
}
