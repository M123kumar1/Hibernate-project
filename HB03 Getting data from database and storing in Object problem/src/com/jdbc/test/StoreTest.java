package com.jdbc.test;

import java.util.List;

import com.jdbc.accessor.StoreAccessor;
import com.jdbc.beans.Store;

public class StoreTest {

	public static void main(String[] args) {
		StoreAccessor accessor=new StoreAccessor();
		
		Store store = accessor.getStore(5124);
		System.out.println(store);
		/*
		 * List<Store> stores = accessor.getStores(); for (Store store : stores) {
		 * System.out.println(store); }
		 */

	}

}
