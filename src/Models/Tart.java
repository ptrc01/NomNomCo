package Models;

public class Tart implements Confectionary {
	private String name;
	private String softness;
	private String[] toppings;
	private double price;
	private String paymentType;
	private String paymentDetails;
	
	
	public Tart(String name, String softness, String[] toppings, double price, String paymentType, String paymentDetails) {
		super();
		this.name = name;
		this.softness = softness;
		this.toppings = toppings;
		this.price = price;
		this.paymentType = paymentType;
		this.paymentDetails = paymentDetails;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Tart";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getSoftness() {
		// TODO Auto-generated method stub
		return softness;
	}

	@Override
	public String[] getToppings() {
		// TODO Auto-generated method stub
		return toppings;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getPaymentType() {
		// TODO Auto-generated method stub
		return paymentType;
	}

	@Override
	public String getPaymentDetails() {
		// TODO Auto-generated method stub
		return paymentDetails;
	}

}
