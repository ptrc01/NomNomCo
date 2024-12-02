import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Adapters.CryptoToCash;
import Adapters.TransferToCash;
import Factories.ConfectionaryFactory;
import Factories.CupcakeFactory;
import Factories.TartFactory;
import Models.Cash;
import Models.Confectionary;
import Models.Crypto;
import Models.Transfer;
import Singleton.ConfectionaryDB;

public class Main {
	Scanner sc = new Scanner(System.in);
	ConfectionaryDB db = ConfectionaryDB.getInstance();
	ArrayList<Confectionary> list = db.getConfectionary();
	Random rand = new Random();
	
	public void menu() {
		int choice = 0;
		
		while(choice != 4 ) {
			System.out.println("=".repeat(20));
			System.out.println("|    NOM NOM Co.   |");
			System.out.println("=".repeat(20));
			System.out.println("1. Bake Confectionary");
			System.out.println("2. View Confectionary Order");
			System.out.println("3. Delete Confectionary Order");
			System.out.println("4. exit");
			System.out.print(">> ");
			choice = Integer.parseInt(sc.nextLine());
			
			if(choice == 1 ) {
				addBake();
				System.out.println("");
			}else if(choice ==2) {
				viewOrder();
				System.out.println("");
			}else if(choice ==3) {
				deleteOrder();
				System.out.println("");
			}
			
		}
	}

	private void deleteOrder() {
		String del;
		if(!list.isEmpty()) {
			System.out.print("Enter the name to delete: ");
			del = sc.nextLine();
			db.deleteConfectionary(del);
			System.out.println("Successful");
		}else {
			System.out.println("Not confectionary yet");
		}
		
	}

	private void viewOrder() {
		// TODO Auto-generated method stub		
		if(!list.isEmpty()) {
			for(Confectionary i: list) {
				System.out.println("Name: " + i.getName() + " (" + i.getType() + ")");
				System.out.println("Softness: " + i.getSoftness());
				
				String[] topping = i.getToppings();
				if(topping!=null) {
					System.out.println("Toppings: "+ String.join(", ", topping));
				}else {
					System.out.println("Toppings: -");
				}
				
				System.out.println("Payment Type: "+ i.getPaymentType());
				System.out.print("Price: "+ i.getPrice());
				if(i.getPaymentType().equals("Transfer")) {
					System.out.println(" with Account Number: "+ i.getPaymentDetails());
				}else if(i.getPaymentType().equals("Crypto")) {
					System.out.println(" with Crypto Address: "+ i.getPaymentDetails());
				}
				
				System.out.println("-".repeat(20));
			}
			
		}else {
			System.out.println("No confectionary yet");
		}
	}

	private void addBake() {
		// TODO Auto-generated method stub
		String type;
		String name;
		String softness;
		String withToppings;
		boolean isToppings = false;
		String[] toppings = new String[3];
		double price;
		String payment;
		String paymentDetails = null;
		
		do {
			System.out.println("Input confectionary type [Cupcake | Tart][case sensitive]: ");
			type = sc.nextLine();
		}while(!type.equals("Cupcake") && !type.equals("Tart"));
		
		do {
			System.out.print("Input confectionary name [length between 5 - 15]: ");
			name = sc.nextLine();
		}while(name.length()<5 || name.length()>15);
		
		do {
			System.out.print("Input confectionary softness [Fluffy | Medium | Hard][case senstive]: ");
			softness = sc.nextLine();
		}while(!softness.equals("Fluffy") && !softness.equals("Medium") && !softness.equals("Hard"));
		
		do {
			System.out.print("Adding additional topping [Y | N][case sensitive]: ");
			withToppings = sc.nextLine();
		}while(!withToppings.equals("Y") && !withToppings.equals("N"));
		
		if (withToppings.equals("Y")) {
			do {
				System.out.print("Input topping 1[length between 1-10]: ");
				toppings[0] = sc.nextLine();
			}while(toppings[0].length()<1 || toppings[0].length()>10);
			
			do {
				System.out.print("Input topping 2[length between 1-10]: ");
				toppings[1] = sc.nextLine();
			}while(toppings[1].length()<1 || toppings[1].length()>10);
			
			do {
				System.out.print("Input topping 3[length between 1-10]: ");
				toppings[2] = sc.nextLine();
			}while(toppings[2].length()<1 || toppings[2].length()>10);
			
			isToppings = true;
		}
		
		do {
			System.out.print("Input confectionary price [10.0 - 50.0]: ");
			price = Double.parseDouble(sc.nextLine());
		}while(price<10 || price >50);
		
		do {
			System.out.print("What kind of payment [Cash | Transfer | Crypto][case sensitive]: ");
			payment = sc.nextLine();
		}while(!payment.equals("Cash") && !payment.equals("Transfer") && !payment.equals("Crypto"));
		
		Cash cash = new Cash(price);
		Transfer tf = new Transfer(price);
		Crypto crypto = new Crypto(price);
		
		Cash TransferToCash = new TransferToCash(tf);
		Cash CryptoToCash = new CryptoToCash(crypto);
		
		if(payment.equals("Cash")) {
			price = cash.getPrice();
		}else if(payment.equals("Transfer")) {
			price = TransferToCash.getPrice();
			paymentDetails = String.format("%010d", rand.nextInt(1000000000));
		}else if (payment.equals("Crypto")) {
			price = CryptoToCash.getPrice();
			paymentDetails = "0x"+ Integer.toHexString(rand.nextInt());
		}
		
		ConfectionaryFactory cf = type.equals("Cupcake")? new CupcakeFactory(): new TartFactory();
		Confectionary confect = cf.createConfectionary(name, softness, toppings, price, payment, paymentDetails);
		
		db.addConfectionary(confect);
		
		System.out.println("Successful");
	}
	
	public Main() {
		menu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
