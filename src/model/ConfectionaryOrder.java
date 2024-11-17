package model;

import java.util.ArrayList;

public class ConfectionaryOrder {
	private static ConfectionaryOrder instance = null;
	private ArrayList<Confectionary> confectionaries = new ArrayList<Confectionary>();
	
	private ConfectionaryOrder() {
		super();
	}
	
	public static ConfectionaryOrder getInstance() {
		if (instance == null) instance = new ConfectionaryOrder();
		return instance;
	}
	
	public void insert(Confectionary confectionary) {
		confectionaries.add(confectionary);
	}
	
	public void view() {
		if (confectionaries.isEmpty()) {
			System.out.println("No confectionary yet.");
			return;
		}
		for (int i = 0; i < confectionaries.size(); i++) {
			confectionaries.get(i).showInformation();
		}
	}
	
	public Confectionary getConfectionaryByName(String confectionaryName) {
		if (!confectionaries.isEmpty()) {
			for (Confectionary confectionary : confectionaries) {
				if(confectionary.getName().equals(confectionaryName)) return confectionary;
			}			
		}
		return null;
	}
	
	public void delete(String confectionaryName) {
		Confectionary toDelete = getConfectionaryByName(confectionaryName);
		if(toDelete != null) {
			confectionaries.remove(toDelete);
			System.out.println("Confectionary Order \"" + confectionaryName + "\" has been canceled.");
		}
		else {
			System.out.println("Confectionary is not found.");
		}
	}
}
