package com.jdbc.test;

import java.util.List;

import com.jdbc.accessor.StoreAccessor;
import com.jdbc.beans.Store;

public class StoreTest {
	public static void main(String[] args) {
		StoreAccessor storeAccessor = new StoreAccessor();

		Store store = storeAccessor.getStore(5123);
		System.out.println(store);

		/*
		 * List<Store> stores = storeAccessor.getStores(); for (Store store : stores) {
		 * System.out.println(store); }
		 */

	}
}
