package Factories;

import Models.Confectionary;
import Models.Cupcake;

public class CupcakeFactory extends ConfectionaryFactory{

	@Override
	public Confectionary createConfectionary(String name, String softness, String[] toppings, double price,
			String paymentType, String paymentDetails) {
		// TODO Auto-generated method stub
		return new Cupcake(name, softness, toppings, price, paymentType, paymentDetails);
	}
	
}
