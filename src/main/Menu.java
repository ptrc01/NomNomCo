package main;

import java.util.Scanner;

import adapter.CashAdapter;
import adapter.CryptoAdapter;
import adapter.TransferAdapter;
import factory.CashFactory;
import factory.ConfectionaryFactory;
import factory.CryptoFactory;
import factory.CupcakeFactory;
import factory.PaymentFactory;
import factory.TartFactory;
import factory.TransferFactory;
import model.Confectionary;
import model.ConfectionaryOrder;
import model.Payment;

public class Menu {
	Scanner scan = new Scanner(System.in);
	ConfectionaryOrder db = ConfectionaryOrder.getInstance();
	
	public void showMainMenu() {
		int choice = 0;
		while (choice != 4) {
			System.out.println("Nom Nom Co.");
			System.out.println("===========");
			System.out.println("1. Bake Convectionary");
			System.out.println("2. View Confectionary Order");
			System.out.println("3. Cancel Confectionary Order");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choice = getInteger();
			
			if (choice == 1) bakeConfectionary();
			else if (choice == 2) viewConfectionaryOrder();
			else if (choice == 3) cancelConfectionaryOrder();
			else break;
		}
	}
	
	public int getInteger() {
		int input = scan.nextInt();
		scan.nextLine();
		return input;
	}
	
	public String getString() {
		String input = scan.nextLine();
		return input;
	}
	
	public double getDouble() {
		double input = scan.nextDouble();
		scan.nextLine();
		return input;
	}
	
	public void bakeConfectionary() {
		String type, name, softness, wantTopping, paymentType;
		boolean hasTopping = false;
		String[] toppings = new String[3];
		double price;
		
		do {
			System.out.print("Input confectionary type [Cupcake | Tart][case sensitive]: ");
			type = getString();
		}while(!type.equals("Cupcake") && !type.equals("Tart"));
		
		do {
			System.out.print("Input confectionary name [length between 5 - 15]: ");
			name = getString();
		}while(name.length() < 5 || name.length() > 15);
		
		do {
			System.out.print("Input confectionary softness [Fluffy | Medium | Hard][case senstive]: ");
			softness = getString();
		}while(!softness.equals("Fluffy") && !softness.equals("Medium") && !softness.equals("Hard"));
		
		do {
			System.out.print("Adding additional topping [Y | N][case sensitive]: ");
			wantTopping = getString();
		}while(!wantTopping.equals("Y") && !wantTopping.equals("N"));
		
		if (wantTopping.equals("Y")) {
			
			do {
				System.out.print("Input topping 1[length between 1-10]: ");
				toppings[0] = getString();
			}while(toppings[0].length() < 1 || toppings[0].length() > 10);
			
			do {
				System.out.print("Input topping 2[length between 1-10]: ");
				toppings[1] = getString();
			}while(toppings[1].length() < 1 || toppings[1].length() > 10);
			
			
			do {
				System.out.print("Input topping 3[length between 1-10]: ");
				toppings[2] = getString();
			}while(toppings[2].length() < 1 || toppings[2].length() > 10);
			
			hasTopping = true;
		}
		else if (wantTopping.equals("N")) {
			hasTopping = false;
		}
		
		do {
			System.out.print("Input confectionary price [10.0 - 50.0]: ");
			price = getDouble();
		}while(price < 10.0 || price > 50.0);
		
		do {
			System.out.print("What kind of payment [Cash | Transfer | Crypto][case sensitive]: ");
			paymentType = getString();
		}while(!paymentType.equals("Cash") && !paymentType.equals("Transfer") && !paymentType.equals("Crypto"));
		
		ConfectionaryFactory confectionaryFactory;
		if (type.equals("Cupcake")) {
			confectionaryFactory = new CupcakeFactory();
		}
		else{
			confectionaryFactory = new TartFactory();
		}
		
		PaymentFactory paymentFactory;
		Payment newPayment;
		if (paymentType.equals("Cash")) {
			paymentFactory = new CashFactory();
			CashAdapter cashAdapter = new CashAdapter(paymentFactory.createPayment(price));
			newPayment = cashAdapter;
		}
		else if (paymentType.equals("Transfer")) {
			paymentFactory = new TransferFactory();
			TransferAdapter transferAdapter = new TransferAdapter(paymentFactory.createPayment(price));
			newPayment = transferAdapter;
		}
		else{
			paymentFactory = new CryptoFactory();
			CryptoAdapter cryptoAdapter = new CryptoAdapter(paymentFactory.createPayment(price));
			newPayment = cryptoAdapter;
		}
		Confectionary newConfectionary = confectionaryFactory.createConfectionary(type, name, softness, hasTopping, toppings, newPayment);
		
		db.insert(newConfectionary);
		
		System.out.println("Confectionary Baked!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public void viewConfectionaryOrder() {
		db.view();
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	public void cancelConfectionaryOrder() {
		System.out.print("Enter the name: ");
		String toDelete = getString();
		db.delete(toDelete);
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
}
