package model;

import java.util.Random;

public class Helper {
	private static Random random = new Random();
	
	public String transfer() {
		StringBuilder accNum = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			accNum.append(random.nextInt(10));
		}
		return accNum.toString();
	}
	
	public String crypto() {
		StringBuilder crypAdd = new StringBuilder("0x");
		String alphabets = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 10; i++) {
			crypAdd.append(alphabets.charAt(random.nextInt(alphabets.length())));
		}
		return crypAdd.toString();
	}
}
