package com.epam.mentoring.core;

import java.util.Random;

public class Utils {

	private static int nextRowIndex = 1;

	public static int getRandomNumberInRange(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}

	public static int getNextRowIndex() {
		return nextRowIndex++;
	}


	public static int getRandomValue(int max) {
		Random rand = new Random();
		int min = 2;

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt(max - min + 1) + min;
		return randomNum;
	}
	
}