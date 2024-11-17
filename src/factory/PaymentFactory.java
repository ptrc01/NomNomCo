package factory;

import model.Payment;

public interface PaymentFactory {
	public abstract Payment createPayment(double Price);
}
