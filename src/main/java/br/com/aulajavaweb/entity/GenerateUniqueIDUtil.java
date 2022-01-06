package br.com.aulajavaweb.entity;

import java.util.Random;

public class GenerateUniqueIDUtil {
	Random rand = new Random();
	int maxNumber = 99999;

	public int GetRandomNumber() {
		int randomNumber = rand.nextInt() + 1;
		return randomNumber;
	}
}
