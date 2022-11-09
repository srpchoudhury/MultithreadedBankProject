//InvalidAmountException.java
package com.rp.sr.custom.exception;

public class InvalidAmountException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public InvalidAmountException() {
		super();
	}
	
	public InvalidAmountException(String errMsg) {
		super(errMsg);
	}
	
	public InvalidAmountException(Exception e) {
		super(e);
	}
	

}
//InsufficientFundsException.java
package com.rp.sr.custom.exception;

public class InsufficientFundsException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	public InsufficientFundsException() {
		super();
	}
	public InsufficientFundsException(String errMsg) {
		super(errMsg);
	}
	
	public InsufficientFundsException(Exception e) {
		super(e);
	}

}
//BankAccount.java
package com.rp.sr.sepc;

import com.rp.sr.custom.exception.InsufficientFundsException;
import com.rp.sr.custom.exception.InvalidAmountException;


public interface BankAccount { 
       public void deposite(double amt) 
    		        throws InvalidAmountException;
       
       public void withdraw(double amt) 
    		        throws InvalidAmountException, InsufficientFundsException;
       
       public void currentBalance();
       
       public void transferAmount(BankAccount destAcc,double amt)
    		        throws InvalidAmountException, InsufficientFundsException;
}
//HDFCBankAccount.java
package com.rp.sr.bean;

import com.rp.sr.custom.exception.InsufficientFundsException;
import com.rp.sr.custom.exception.InvalidAmountException;
import com.rp.sr.sepc.BankAccount;

public class HDFCBankAccount implements BankAccount{
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNum;
	private String accHName;
	private double balance;
	
	public HDFCBankAccount() {
		
	}

	public HDFCBankAccount(long accNum, String accHName, double balance) {
		super();
		this.accNum = accNum;
		this.accHName = accHName;
		this.balance = balance;
	}

	public static String getBankName() {
		return bankName;
	}

	public static void setBankName(String bankName) {
		HDFCBankAccount.bankName = bankName;
	}

	public static String getBranchName() {
		return branchName;
	}

	public static void setBranchName(String branchName) {
		HDFCBankAccount.branchName = branchName;
	}

	public static String getIfsc() {
		return ifsc;
	}

	public static void setIfsc(String ifsc) {
		HDFCBankAccount.ifsc = ifsc;
	}

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public String getAccHName() {
		return accHName;
	}

	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}

	public double getBalance() {;
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public void deposite(double amt) throws InvalidAmountException {
		if(amt == 0)
			throw new InvalidAmountException("Amount can't be zero");
		if(amt < 0)
			throw new InvalidAmountException("Amount can't be -ve value");
		balance=balance+amt;
		alert(amt,"credited");
	}

	@Override
	public void withdraw(double amt) throws InvalidAmountException, InsufficientFundsException {
		
		if(amt == 0)
			throw new InvalidAmountException("Amount can't be zero");
		if(amt < 0)
			throw new InvalidAmountException("Amount can't be -ve value");
		if(amt>balance)
			throw new InsufficientFundsException("Insufficient Funds");
		balance=balance-amt;
		alert(amt,"debited");		
	}
	
	@Override
	public void currentBalance() {
		System.out.println(balance);
		
	}
	@Override
	public void transferAmount(BankAccount destAcc, double amt)
			throws InvalidAmountException,InsufficientFundsException {
		this.withdraw(amt);
		destAcc.deposite(amt);
		System.out.println(amt +" is transferd ");
		
	}
	private void alert(double amt, String action) {
		String threadName=Thread.currentThread().getName();
		System.out.println("in "+threadName+" "+ amt+" is "+action);
		System.out.println(threadName+" thread balance is "+balance);
		
	}
	
	

}
//ICICIBankAccount.java
package com.rp.sr.bean;

import com.rp.sr.custom.exception.InsufficientFundsException;
import com.rp.sr.custom.exception.InvalidAmountException;
import com.rp.sr.sepc.BankAccount;

public class ICICIBankAccount implements BankAccount{
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNum;
	private String accHName;
	private double balance;
	
	public ICICIBankAccount() {
		
	}

	public ICICIBankAccount(long accNum, String accHName, double balance) {
		super();
		this.accNum = accNum;
		this.accHName = accHName;
		this.balance = balance;
	}

	public static String getBankName() {
		return bankName;
	}

	public static void setBankName(String bankName) {
		ICICIBankAccount.bankName = bankName;
	}

	public static String getBranchName() {
		return branchName;
	}

	public static void setBranchName(String branchName) {
		ICICIBankAccount.branchName = branchName;
	}

	public static String getIfsc() {
		return ifsc;
	}

	public static void setIfsc(String ifsc) {
		ICICIBankAccount.ifsc = ifsc;
	}

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public String getAccHName() {
		return accHName;
	}

	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}

	public double getBalance() {;
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public void deposite(double amt) throws InvalidAmountException {
		if(amt == 0)
			throw new InvalidAmountException("Amount can't be zero");
		if(amt < 0)
			throw new InvalidAmountException("Amount can't be -ve value");
		balance=balance+amt;
		alert(amt,"credited");
	}

	@Override
	public void withdraw(double amt) throws InvalidAmountException, InsufficientFundsException {
		
		if(amt == 0)
			throw new InvalidAmountException("Amount can't be zero");
		if(amt < 0)
			throw new InvalidAmountException("Amount can't be -ve value");
		if(amt>balance)
			throw new InsufficientFundsException("Insufficient Funds");
		balance=balance-amt;
		alert(amt,"debited");		
	}
	
	@Override
	public void currentBalance() {
		System.out.println(balance);
		
	}
	@Override
	public void transferAmount(BankAccount destAcc, double amt)
			throws InvalidAmountException,InsufficientFundsException {
		
		this.withdraw(amt);
		destAcc.deposite(amt);
		System.out.println(amt+" is transferred ");
		
	}
	private void alert(double amt, String action) {
		String threadName=Thread.currentThread().getName();
		System.out.println("in "+threadName+" "+ amt+" is "+action);
		System.out.println(threadName+" thread balance is "+balance);
		
	}
	

}
//SBIBankAccount.java
package com.rp.sr.bean;

import com.rp.sr.custom.exception.InsufficientFundsException;
import com.rp.sr.custom.exception.InvalidAmountException;
import com.rp.sr.sepc.BankAccount;

public class SBIBankAccount implements BankAccount{
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNum;
	private String accHName;
	private double balance;
	
	public SBIBankAccount() {
		
	}

	public SBIBankAccount(long accNum, String accHName, double balance) {
		super();
		this.accNum = accNum;
		this.accHName = accHName;
		this.balance = balance;
	}

	public static String getBankName() {
		return bankName;
	}

	public static void setBankName(String bankName) {
		SBIBankAccount.bankName = bankName;
	}

	public static String getBranchName() {
		return branchName;
	}

	public static void setBranchName(String branchName) {
		SBIBankAccount.branchName = branchName;
	}

	public static String getIfsc() {
		return ifsc;
	}

	public static void setIfsc(String ifsc) {
		SBIBankAccount.ifsc = ifsc;
	}

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public String getAccHName() {
		return accHName;
	}

	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}

	public double getBalance() {;
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public void deposite(double amt) throws InvalidAmountException {
		if(amt == 0)
			throw new InvalidAmountException("Amount can't be zero");
		if(amt < 0)
			throw new InvalidAmountException("Amount can't be -ve value");
		balance=balance+amt;
		alert(amt,"credited");
	}

	@Override
	public void withdraw(double amt) throws InvalidAmountException, InsufficientFundsException {
		
		if(amt == 0)
			throw new InvalidAmountException("Amount can't be zero");
		if(amt < 0)
			throw new InvalidAmountException("Amount can't be -ve value");
		if(amt>balance)
			throw new InsufficientFundsException("Insufficient Funds");
		balance=balance-amt;
		alert(amt,"debited");		
	}
	
	@Override
	public void currentBalance() {
		System.out.println(balance);
		
	}
	@Override
	public void transferAmount(BankAccount destAcc, double amt)
			throws InvalidAmountException,InsufficientFundsException {
		
		this.withdraw(amt);
		destAcc.deposite(amt);
		System.out.println(amt+" is transferred ");
		
	}
	private void alert(double amt, String action) {
		String threadName=Thread.currentThread().getName();
		System.out.println("in "+threadName+" "+ amt+" is "+action);
		System.out.println(threadName+" thread balance is "+balance);
		
	}
	

}


//DepositerThread.java
package com.rp.sr.thread;

import com.rp.sr.custom.exception.InvalidAmountException;
import com.rp.sr.sepc.BankAccount;

public class DepositerThread extends Thread {
	private BankAccount acc;
	private double amt;
	//private String  name;
		
     public DepositerThread(BankAccount acc, double amt,String name) {
    	 super(name);
		this.acc = acc;
		this.amt = amt;
	}


	@Override
    public void run() {
    	    try {
				acc.deposite(amt);
			} catch (InvalidAmountException e) {
				System.out.println(e.getMessage());
			}
    }
}
//WithdraweeThread.java
package com.rp.sr.thread;

import com.rp.sr.custom.exception.InsufficientFundsException;
import com.rp.sr.custom.exception.InvalidAmountException;
import com.rp.sr.sepc.BankAccount;

public class WithdraweeThread extends Thread {
     private BankAccount acc;
     private double amt;
     //private String name;
     
	public WithdraweeThread(BankAccount acc, double amt,String name) {
		super(name);
		this.acc = acc;
		this.amt = amt;
	}
	
	@Override
	public void run() {
		try {
			acc.withdraw(amt);
		} catch (InvalidAmountException | InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}
     
}
//Bank.java
package com.rp.sr.user;

import com.rp.sr.bean.HDFCBankAccount;
import com.rp.sr.bean.ICICIBankAccount;
import com.rp.sr.bean.SBIBankAccount;
import com.rp.sr.sepc.BankAccount;
import com.rp.sr.thread.DepositerThread;
import com.rp.sr.thread.WithdraweeThread;

public class Bank {
    public static void main(String[] args) throws InterruptedException {
		BankAccount acc1=new HDFCBankAccount();
		BankAccount acc2=new ICICIBankAccount();
		BankAccount acc3=new SBIBankAccount();
		
		        DepositerThread dt1=new DepositerThread(acc1, 5000,"acc1");
				DepositerThread dt2=new DepositerThread(acc2, 10000,"acc2");
				DepositerThread dt3=new DepositerThread(acc3, 20000,"acc3");
				
				WithdraweeThread wt1=new WithdraweeThread(acc2, 7000,"acc3");
				
				//acc3.transferAmount(acc1, 3000);
				System.out.println();
				dt1.start();
				dt2.start();
				dt3.start();
				wt1.start();
				System.out.println();
				
				System.out.println();
				Thread.sleep(1000);
				System.out.print("acc1 balance: ");acc1.currentBalance();
				Thread.sleep(1000);
				System.out.print("acc2 balance: ");acc2.currentBalance();
				Thread.sleep(1000);
				System.out.print("acc3 balance: ");acc3.currentBalance();
		
		
	}
}
