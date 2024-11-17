package factory;

import model.Payment;
import model.Transfer;

public class TransferFactory implements PaymentFactory {
	@Override
	public Payment createPayment(double Price) {
		return new Transfer(Price);
	}
}
