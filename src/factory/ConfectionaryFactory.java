package factory;

import model.Confectionary;
import model.Payment;

public interface ConfectionaryFactory {
	public abstract Confectionary createConfectionary(String type, String name, String softness, boolean hasTopping, String[] toppings, Payment payment);
}
