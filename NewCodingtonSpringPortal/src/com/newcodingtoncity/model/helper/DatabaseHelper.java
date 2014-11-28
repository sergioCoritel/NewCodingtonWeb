package es.codington.model.helper;

import javax.servlet.ServletContext;


public class DatabaseHelper {
	
	private ServletContext context;
	private XMLExtractorHelper xMLExtractorHelper;
	public DatabaseHelper(ServletContext context) {
		xMLExtractorHelper = new XMLExtractorHelper(context);
	}

	public  String getDBUser() {
		return xMLExtractorHelper.getStringFromKey("sql/configuration.xml", "db_user");
	}
	
	public String getDBPassword() {
		return xMLExtractorHelper.getStringFromKey("sql/configuration.xml", "db_password");
	}
	
	public  String getQuery(String queryName) {
		return xMLExtractorHelper.getStringFromKey("sql/queries.xml", queryName);
	}
}
