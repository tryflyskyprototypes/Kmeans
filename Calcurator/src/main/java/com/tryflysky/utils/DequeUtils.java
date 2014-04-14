package com.tryflysky.utils;

import java.util.Deque;
import java.util.List;

public class DequeUtils {


	private DequeUtils() {
		//util class
	}



	public static <E> void transferLastAll(Deque<E> to, Deque<E> from) {

		transferLast(to, from, from.size());
	}



	public static <E> void transferLast(Deque<E> to, Deque<E> from, int transferNum) {

		for(int i = 0; i < transferNum; i++) {

			to.addLast(from.removeFirst());
		}
	}



	public static <E> void copyLastAll(Deque<E> to, Deque<E> from) {

		copyLast(to, from, from.size());
	}



	@SuppressWarnings("unchecked")
	public static <E> void copyLast(Deque<E> to, Deque<E> from, int copyNum) {

		for(int i = 0; i < copyNum; i++) {

			to.addLast((E) ((List<E>) from).get(i));
		}
	}
}
