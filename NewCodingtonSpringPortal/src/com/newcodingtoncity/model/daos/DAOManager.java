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


	/**
	 * 
	 * @param queryProperties
	 */
	public void setQueryProperties(Properties queryProperties) {
		this.queryProperties = queryProperties;
	}


	/**
	 * 
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){  
		this.jdbcTemplate = jdbcTemplate;  
	}  

	
	/**
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource) {  
		this.jdbcTemplate = new JdbcTemplate(dataSource);  
	}  
	
	
	/**
	 * Return an instance of JdbcTemplate
	 * 
	 * @return JdbcTemplate
	 */
	public JdbcTemplate getTemplate(){  
		return jdbcTemplate;  
	}  


	/**
	 * Return an instance of IEventDAO
	 * 
	 * @return EventDAO
	 */
	public IEventDAO getEventDAO() {		 	
		return new EventDAO(jdbcTemplate,queryProperties);				 			
	}		 	


	/**
	 * Return an instance of IPlaceDAO
	 * 
	 * @return IPlaceDAO
	 */
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