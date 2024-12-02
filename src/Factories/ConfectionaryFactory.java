package Factories;

import Models.Confectionary;

public abstract class ConfectionaryFactory {
	public abstract Confectionary createConfectionary(String name, String softness, String[] toppings, double price, String paymentType, String paymentDetails);
}
