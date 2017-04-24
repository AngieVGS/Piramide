package test;

import java.io.IOException;

import models.entities.Order;
import persistence.RandomTwo;

public class TestFiles {
	
	public static void main(String[] args) {
		RandomTwo randomTwo = new RandomTwo(".\\src\\file.prs");
		
		
		Order order = new Order(12, null, 3, 5, 7, 2);
		try {
			randomTwo.writeToFile(".\\src\\file.prs", order.toString(), 0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
