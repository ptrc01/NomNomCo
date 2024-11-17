package model;

public class Payment {
	private double price;
	
	protected static Helper helper = new Helper();
	
	public Payment(double price) {
		super();
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void showPaymentInfo() {
		System.out.println("PaymentType	: Cash");
		System.out.println("Price		: $" + getPrice());
	}
}
