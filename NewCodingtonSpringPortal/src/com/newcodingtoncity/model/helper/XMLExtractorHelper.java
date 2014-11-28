package es.codington.model.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletContext;

public class XMLExtractorHelper {
	private static ServletContext context;
	
	public XMLExtractorHelper(ServletContext context) {
		this.context = context;
	}

	public  String getStringFromKey(String filePath, String XMLkey) {		
		try {
			
			String path = "";
			if(context != null){
				path += context.getRealPath("/");
			}
			File file = new File(path+filePath);
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.loadFromXML(fileInput);
			fileInput.close();

			Enumeration enuKeys = properties.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				if (key.equals(XMLkey)){
					return properties.getProperty(key);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}
