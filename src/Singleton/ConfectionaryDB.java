package Singleton;

import java.util.ArrayList;

import Models.Confectionary;

public class ConfectionaryDB {
	private static ConfectionaryDB instance;
	private ArrayList<Confectionary> confectionaries;
	
	private ConfectionaryDB() {
		confectionaries = new ArrayList<>();
	}
	
	public static ConfectionaryDB getInstance() {
		if(instance == null) {
			instance = new ConfectionaryDB();
		}
		return instance;
	}
	
	public void addConfectionary(Confectionary confect) {
		confectionaries.add(confect);
	}
	
	public ArrayList<Confectionary> getConfectionary(){
		return confectionaries;
	}
	
	public void deleteConfectionary(String name) {
		int flag = 0;
		for(int i = 0; i < confectionaries.size(); i++) {
			if(confectionaries.get(i).getName().equals(name)) {
				confectionaries.remove(i);
				System.out.println("Remove successfully");
				flag = 1;
			}
		}
		
		if (flag == 0) {
			System.out.println("Confectionary not found");
		}
	}
}
