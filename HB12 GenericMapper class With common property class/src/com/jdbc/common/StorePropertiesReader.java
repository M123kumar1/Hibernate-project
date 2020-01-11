package com.jdbc.common;

import java.io.IOException;
import java.util.Properties;

public class StorePropertiesReader {
	public static Properties readProps(){
		Properties props=null;
		try {
			props=new Properties();
			props.load(StorePropertiesReader.class.getClassLoader().getResourceAsStream("com\\jdbc\\common\\store.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
}
