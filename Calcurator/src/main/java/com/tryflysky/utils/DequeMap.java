package com.tryflysky.utils;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import org.apache.commons.collections4.CollectionUtils;

import com.tryflysky.expression.model.Structure;


public class DequeMap<E> {

	private HashMap<DequeMapKey, LinkedList<E>> dequeMap = new HashMap<DequeMapKey, LinkedList<E>>();



	public void addDeque(DequeMapKey key) {

		dequeMap.put(key, new LinkedList<E>());
	}


	public Deque<E> getDeque(DequeMapKey key) {

		return dequeMap.get(key);
	}





	public void addFirst(Structure key, E value) {

		dequeMap.get(key).addFirst(value);
	}



	public void addLast(DequeMapKey key, E value) {

		dequeMap.get(key).addLast(value);
	}



	public E removeFirst(DequeMapKey key) {

		return dequeMap.get(key).removeFirst();
	}


	public E getFirst(DequeMapKey key) {

		return dequeMap.get(key).getFirst();
	}







	public boolean isEmpty(DequeMapKey key) {

		return CollectionUtils.isEmpty(dequeMap.get(key));
	}


	public boolean isNotEmpty(DequeMapKey key) {

		return ! isEmpty(key);
	}





	public boolean contains(DequeMapKey key, E value) {

		return MyCollectionUtils.contains(dequeMap.get(key), value);
	}
}
