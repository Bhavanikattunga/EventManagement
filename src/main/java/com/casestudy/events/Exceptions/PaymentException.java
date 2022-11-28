package com.casestudy.events.Exceptions;

import java.util.List;

import com.casestudy.events.Entity.*;

public class PaymentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PaymentException(String message) {
		super(message);
	}
	public static boolean checkIfListEmpty(List<Payment> allPayments) {
		if(allPayments.isEmpty()) {
			return true;
		}
		return false;
	}
	public static boolean checkIfPaymentExist(List<Payment> allPayments, int transactionId) {
		// TODO Auto-generated method stub
		return false;
	}
}
