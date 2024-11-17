package factory;

import model.Confectionary;
import model.Payment;
import model.Tart;

public class TartFactory implements ConfectionaryFactory {
	@Override
	public Confectionary createConfectionary(String type, String name, String softness, boolean hasTopping, String[] toppings, Payment payment) {
		return new Tart(type, name, softness, hasTopping, toppings, payment);
	}
}
