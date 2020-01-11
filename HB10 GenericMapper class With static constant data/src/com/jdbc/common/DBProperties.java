package com.jdbc.common;

import java.util.Properties;

public class DBProperties {
	public static final Properties STORE_PROPS=new Properties();
	static {
		//Properties STORE_PROPS = new Properties();
		STORE_PROPS.put("store_number", "storeNumber");
		STORE_PROPS.put("store_name", "storeName");
		STORE_PROPS.put("contact_number", "contactNumber");
		STORE_PROPS.put("email_address", "emailAddress");
		STORE_PROPS.put("address_line1", "addressLine1");
		STORE_PROPS.put("address_line2", "addressLine1");
		STORE_PROPS.put("city", "city");
		STORE_PROPS.put("state", "state");
		STORE_PROPS.put("zip", "zip");
		STORE_PROPS.put("country", "country");
	}
	
}
