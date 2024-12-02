package Factories;

import Models.Confectionary;
import Models.Tart;

public class TartFactory extends ConfectionaryFactory{

	@Override
	public Confectionary createConfectionary(String name, String softness, String[] toppings, double price,
			String paymentType, String paymentDetails) {
		// TODO Auto-generated method stub
		return new Tart(name, softness, toppings, price, paymentType, paymentDetails);
	}

}
