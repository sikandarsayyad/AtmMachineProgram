package com.exercise;

import java.util.HashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf{
	
	Map<Double, String> ministmt = new HashMap<>();
	ATM atm = new ATM();
	@Override
	public void viewBalance() {
		System.out.println("Available Balance is: "+ atm.getBalance());
		
	}

	@Override
	public void withdrawAmount(double withdrawAmount) {
		if(withdrawAmount%500==0) {
	
			if(withdrawAmount <= atm.getBalance()) {
				System.out.println("Collect the Cash " +withdrawAmount);
				ministmt.put(withdrawAmount, " Amount Withdrawn");
				atm.setBalance( atm.getBalance()- withdrawAmount);
				viewBalance();
			}else {
				System.out.println("Insufficient Balance !!");
			}
		}
		else {
			System.out.println("Please Enter Amount in Multiple of 500");
		}
		
	}

	@Override
	public void depositAmount(double depositAmount) {
		System.out.println(depositAmount+" Deposited Successfully!!");
		ministmt.put(depositAmount, " Amount Deposited");
		atm.setBalance(atm.getBalance()+depositAmount);
		viewBalance();
	}

	@Override
	public void viewMiniStatement() {
		for(Map.Entry<Double, String> m:ministmt.entrySet()) {
			System.out.println(m.getKey()+ m.getValue());
		}
		
	}

}
