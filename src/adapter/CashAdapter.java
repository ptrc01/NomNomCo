package adapter;

import model.Cash;
import model.Payment;

public class CashAdapter extends Cash {
	private Payment payment;
	
	public CashAdapter(Payment payment) {
		super(payment.getPrice());
		this.payment = payment;
		this.setFinalPrice();
	}

	public void setFinalPrice() {
		this.setPrice(payment.getPrice() * 1.0);
	}
}
