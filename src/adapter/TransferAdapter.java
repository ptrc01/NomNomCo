package adapter;

import model.Payment;
import model.Transfer;

public class TransferAdapter extends Transfer {
	private Payment payment;
	
	public TransferAdapter(Payment payment) {
		super(payment.getPrice());
		this.payment = payment;
		this.setFinalPrice();
	}
	
	public void setFinalPrice() {
		this.setPrice(payment.getPrice() * 1.1);
	}
}
