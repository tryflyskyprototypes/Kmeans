package com.tryflysky.utils;

import java.util.List;

public class CollectionConverter<T> {




	public T[] toArray(List<T> list) {

		return (T[]) list.toArray(new Object[list.size()]);	//TODO 上手く動きません
	}
}
