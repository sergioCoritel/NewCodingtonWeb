package com.newcodingtoncity.model.daos;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.interfaces.daos.IUserDAO;
import com.newcodingtoncity.model.mappers.VisitorMapper;



public class UserDAO implements IUserDAO{


	private JdbcTemplate jdbcTemplateObject;
	private Properties queryProperties;

	public UserDAO(JdbcTemplate jdbcTemplateObject,Properties queryProperties ) {
		this.jdbcTemplateObject = jdbcTemplateObject;
		this.queryProperties = queryProperties;
	} 

	@Override
	public User loginDAO(final User u) throws SQLException, ClassNotFoundException{	
		List<Visitor> users =  jdbcTemplateObject.query(queryProperties.getProperty("selec_login"),new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setString(1, u.getUserName());
				statement.setString(2, u.getPassword());
			}
		}, new VisitorMapper());
		return users.get(0);
	}	


	@Override
	public int updateInfoDAO(final User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("change_info"), 
				new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setString(1, u.getFirstName());
				statement.setString(2, u.getLastName());
				statement.setString(3, u.getDni());
				statement.setString(4, u.getEmail());
				statement.setString(5, u.getPhoneNumber());
				statement.setString(6, u.getAddress());
				statement.setInt(7, u.getUserId());
			}
		});

		return affectedRows;
	}  



	@Override
	public boolean updatePasswordDAO(final User u, final String new_pass) throws SQLException, ClassNotFoundException {
		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("change_pass"), 
				new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setString(1, new_pass);
				statement.setInt(2, u.getUserId());
			}
		});
		return affectedRows == 1;
	}



	@Override
	public boolean registerNewVisitorDAO(final User u) throws SQLException, ClassNotFoundException{

		int affectedRows = 0;

		List<Visitor> users = jdbcTemplateObject.query(queryProperties.getProperty("isAcountExists"), 
				new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setString(1, u.getEmail());
				statement.setString(2, u.getUserName());
				statement.setString(3, u.getDni());
			}
			
		}, new VisitorMapper());
		
		if(users.size() == 0){	
			affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("registerUser"), 
					new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement statement)
						throws SQLException {
					statement.setString(1, u.getUserName());
					statement.setString(2, u.getPassword());
					statement.setString(3, u.getFirstName());
					statement.setString(4, u.getLastName());
					statement.setString(5, u.getDni());
					statement.setString(6, u.getEmail());
					statement.setString(7, u.getPhoneNumber());
					statement.setString(8, u.getAddress());
					statement.setInt(9, 0);
				}
			});

			return affectedRows == 1;
		}
		return false;
	}
}
