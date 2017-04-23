package test;

import models.entities.Order;
import persistence.RandomTwo;

public class TestFiles {
	
	public static void main(String[] args) {
		RandomTwo randomTwo = new RandomTwo(".\\src\\file.prs");
		
		
		Order order = new Order(12, null, 3, 5, 7, 2);
	}

}
