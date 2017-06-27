package com.synerzip.demo;

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
import com.synerzip.demo.model.User;

@Path("user")
public class Versioning {
	
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
  
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User add(User user) {
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(user); 
        tx.commit();
        return user;
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User get(@PathParam("id") String id) {
    	User user = (User)session.get(User.class, id); 
    		return user;
    }
}
