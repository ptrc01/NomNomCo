package model;

public abstract class Confectionary {
	private String type;
	private String name;
	private String softness;
	private boolean hasTopping;
	private String[] toppings;
	private Payment payment;
	
	public Confectionary(String type, String name, String softness, boolean hasTopping, String[] toppings, Payment payment) {
		super();
		this.type = type;
		this.name = name;
		this.softness = softness;
		
		this.hasTopping = hasTopping;
		if (this.hasTopping == true) this.toppings = toppings;
		else this.toppings = null;
		
		this.payment = payment;
	}

	public void showInformation() {
		System.out.println("Name		: " + this.name + " (" + this.type + ") ");
		System.out.println("Softness	: " + this.softness);
		
		if (this.hasTopping == true) {
			System.out.println("Topping		: " + this.toppings[0] + " " + this.toppings[1] + " " + this.toppings[2]);
		}
		else {
			System.out.println("Topping		: -");
		}
		payment.showPaymentInfo();
		System.out.println("===================================\n");
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSoftness() {
		return softness;
	}
	public void setSoftness(String softness) {
		this.softness = softness;
	}
	public boolean isHasTopping() {
		return hasTopping;
	}
	public void setHasTopping(boolean hasTopping) {
		this.hasTopping = hasTopping;
	}
	public String[] getToppings() {
		return toppings;
	}
	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
