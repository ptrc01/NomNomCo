package factory;

import model.Crypto;
import model.Payment;

public class CryptoFactory implements PaymentFactory {
	@Override
	public Payment createPayment(double Price) {
		return new Crypto(Price);
	}
}
