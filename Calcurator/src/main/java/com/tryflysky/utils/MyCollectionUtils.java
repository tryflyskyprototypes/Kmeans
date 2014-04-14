package com.tryflysky.utils;

import java.util.Collection;

public class MyCollectionUtils {



	public static Object[] toArray(Collection<? extends Object> collection) {

		return collection.toArray(new String[collection.size()]);
	}




	public static boolean contains(Collection<? extends Object> collection, Object search) {

		//TODO なんか美しくない
		for(Object o : collection) {

			if(o.equals(search)) {

				return true;
			}
		}

		return false;
	}

}
