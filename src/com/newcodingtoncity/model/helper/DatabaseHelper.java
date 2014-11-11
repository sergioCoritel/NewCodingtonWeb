package com.newcodingtoncity.model.helper;


public class DatabaseHelper {
	
	public static String getDBUser() {
		return XMLExtractorHelper.getStringFromKey("sql/configuration.xml", "db_user");
	}
	
	public static String getDBPassword() {
		return XMLExtractorHelper.getStringFromKey("sql/configuration.xml", "db_password");
	}
	
	public static String getQuery(String queryName) {
		return XMLExtractorHelper.getStringFromKey("sql/queries.xml", queryName);
	}
}
