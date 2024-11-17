package model;

public class Cash extends Payment {
	public Cash(double price) {
		super(price);
	}
	
	public void showPaymentInfo() {
		System.out.println("PaymentType	: Cash");
		System.out.println("Price		: $" + getPrice());
	}
}
