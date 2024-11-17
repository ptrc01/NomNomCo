package model;

public class Transfer extends Payment {
	private String accountNumber;
	
	public Transfer(double price) {
		super(price);
		this.setAccountNumber();
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber() {
		this.accountNumber = helper.transfer();
	}
	
	public void showPaymentInfo() {
		System.out.println("PaymentType	: Transfer");
		System.out.println("Price		: $" + getPrice() + " with AccountNumber : " + getAccountNumber());
	}
}
