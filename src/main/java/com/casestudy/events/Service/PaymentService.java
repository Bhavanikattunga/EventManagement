package com.casestudy.events.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.events.Entity.Payment;
import com.casestudy.events.Exceptions.PaymentException;

@Service

public interface PaymentService {

	
	
	public List<Payment> getAllTransactions()throws PaymentException;

	public Payment getTransactionById(int transactionId) throws PaymentException;

	public void deleteTransaction(int transactionId)throws PaymentException;

	/*public Payment updatePayment(int transactionId, Payment payment)throws PaymentException;*/

	public Payment addPayment(Payment payment);



}
