package com.jdbc.common;

import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	public static Properties readProps(String fileName){
		Properties props=null;
		try {
			props=new Properties();
			props.load(PropertiesReader.class.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
}
