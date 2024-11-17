package model;

public class Crypto extends Payment {
	private String cryptoAddress;
	
	public Crypto(double price) {
		super(price);
		this.setCryptoAddress();
	}
	
	public String getCryptoAddress() {
		return cryptoAddress;
	}
	public void setCryptoAddress() {
		this.cryptoAddress = helper.crypto();
	}
	
	public void showPaymentInfo() {
		System.out.println("PaymentType	: Crypto");
		System.out.println("Price		: ADA " + getPrice() + " with Address : " + getCryptoAddress());
	}
}
