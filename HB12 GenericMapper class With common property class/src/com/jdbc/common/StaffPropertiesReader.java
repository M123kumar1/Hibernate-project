package com.jdbc.common;

import java.io.IOException;
import java.util.Properties;

public class StaffPropertiesReader {
	public static Properties readProps(){
		Properties props=null;
		try {
			props=new Properties();
			props.load(StaffPropertiesReader.class.getClassLoader().getResourceAsStream("com\\jdbc\\common\\staff.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
}
