package com.newcodingtoncity.model.daos;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;

public class DAOManager {

	private DataSource dataSource;
	private Properties queryProperties;
	private JdbcTemplate jdbcTemplate; 


	public void setQueryProperties(Properties queryProperties) {
		this.queryProperties = queryProperties;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){  
		this.jdbcTemplate = jdbcTemplate;  
	}  

	public void setDataSource(DataSource dataSource) {  
		this.jdbcTemplate = new JdbcTemplate(dataSource);  
	}  

	public JdbcTemplate getTemplate(){  
		return jdbcTemplate;  

	}  


	/**
	 * Return an instance of IEventDAO
	 * @return
	 */
	public IEventDAO getEventDAO() {		 	
		return new EventDAO(jdbcTemplate,queryProperties);				 			
	}		 	


	public IPlaceDAO getPlaceDAO() {
		return new PlaceDAO(jdbcTemplate,queryProperties);				
	}

	/**
	 * Return an instance of IVisitorDAO
	 * 
	 * @return IVisitorDAO
	 */
	public IUserDAO getUserDAO() {
		return new UserDAO(jdbcTemplate, queryProperties);	
	}

	/**
	 * Return an instance of IEventSignUpDAO
	 * 
	 * @return IEventSignUpDAO
	 */
	public IEventSignUpDAO getEventSignUpDAO() {
		return new EventSignUpDAO(jdbcTemplate, queryProperties);		
	}




}