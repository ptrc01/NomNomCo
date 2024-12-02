package Adapters;

import Models.Cash;
import Models.Transfer;

public class TransferToCash extends Cash{
	private Transfer tf;
	
	public TransferToCash(Transfer transfer) {
		tf = transfer;
	}
	
	@Override
	public double getPrice() {
		return tf.getPrice() * 1.1;
	}
}
