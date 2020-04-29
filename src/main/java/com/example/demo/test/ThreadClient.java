package com.example.demo.test;

import java.util.UUID;

public class ThreadClient {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		CharSequence subSequence = uuid.subSequence(0, 4);
		System.out.println(subSequence);
	}

}
