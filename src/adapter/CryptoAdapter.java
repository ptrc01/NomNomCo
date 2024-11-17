package adapter;

import model.Crypto;
import model.Payment;

public class CryptoAdapter extends Crypto {
	private Payment payment;
	
	public CryptoAdapter(Payment payment) {
		super(payment.getPrice());
		this.payment = payment;
		this.setFinalPrice();
	}

	public void setFinalPrice() {
		this.setPrice(payment.getPrice() / 2.0);
	}
}