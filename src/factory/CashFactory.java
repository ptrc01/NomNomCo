package factory;

import model.Cash;
import model.Payment;

public class CashFactory implements PaymentFactory {
	@Override
	public Payment createPayment(double Price) {
		return new Cash(Price);
	}
}
