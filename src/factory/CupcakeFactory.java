package factory;

import model.Cupcake;
import model.Payment;
import model.Confectionary;

public class CupcakeFactory implements ConfectionaryFactory {
	@Override
	public Confectionary createConfectionary(String type, String name, String softness, boolean hasTopping, String[] toppings, Payment payment) {
		return new Cupcake(type, name, softness, hasTopping, toppings, payment);
	}
	
}
