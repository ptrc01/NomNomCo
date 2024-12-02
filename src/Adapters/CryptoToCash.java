package Adapters;

import Models.Cash;
import Models.Crypto;

public class CryptoToCash extends Cash{
	private Crypto crypto;
	
	public CryptoToCash(Crypto crypto) {
		this.crypto = crypto;
	}
	
	@Override
	public double getPrice() {
		return this.crypto.getPrice()/2;
	}
	
}
