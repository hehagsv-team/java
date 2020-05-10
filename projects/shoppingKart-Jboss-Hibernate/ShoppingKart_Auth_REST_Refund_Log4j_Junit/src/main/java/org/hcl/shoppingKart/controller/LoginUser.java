package org.hcl.shoppingKart.controller;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;

import org.hcl.shoppingKart.filter.ValidationFilter;
import org.hcl.shoppingKart.model.UserAccount;
import org.jboss.logging.Logger;


@Stateful
@Model
public class LoginUser {
	
	static Logger logger = Logger.getLogger(LoginUser.class);
	  
//	    private Logger log;

	    @Inject
	    private EntityManager em;

	    @Inject 
	    private Event<UserAccount> usereventsrc;

	    public UserAccount users;

	    @Produces
	    @Named
	    public UserAccount getUsers()
	    {
	    	logger.debug("getusers: called" + users);
	    	return users;
	    }
	    
	    public void register() throws Exception{
	    	
	    	 try {

	             logger.error("Registering " + users.getName());
	             em.persist(users);
	             usereventsrc.fire(users);
	             initUsers();
	         } 
	    	 catch (Exception e) {
	             Throwable t = e;
	             while ((t.getCause()) != null) {
	                 t = t.getCause();
	             }
	             logger.error("Exception:" + t.getMessage());
	             throw ((Exception) t);
	         }
	       }
	    @PostConstruct
	    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	    public void initUsers()
	    {
	        users = new UserAccount();
	        logger.info("@PostConstruct:initusers called");
	    }  
	    
	}
