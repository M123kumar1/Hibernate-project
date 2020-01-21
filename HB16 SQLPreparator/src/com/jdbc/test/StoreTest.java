package com.jdbc.test;

import java.util.List;

import com.jdbc.beans.Store;
import com.jdbc.dao.StoreDAO;

public class StoreTest {
	public static void main(String[] args) {
		StoreDAO storeAccessor = new StoreDAO();
		/*Store store=new Store();
		store.setStoreNumber("5123");
		store.setStoreName("Croma Mall");
		store.setContactNumber("9798733506");
		store.setEmailAddress("croma@pepperfry.com");
		store.setAddressLine1("2nd Lane");
		store.setAddressLine2("Sriram Colony");
		store.setCity("Hydarabad");
		store.setState("TS");
		store.setZip("500038");
		store.setCountry("India");
		int updateStore = storeAccessor.updateStore(store);
		System.out.println(updateStore+" Record updated");*/

		
		/*
		 * Store store = storeAccessor.getStore(5123); System.out.println(store);
		 */
		
		
		  List<Store> stores = storeAccessor.getStores(); for (Store store : stores) {
		  System.out.println(store); }
		 

	}
}
