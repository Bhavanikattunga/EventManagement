package com.casestudy.events.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.events.Entity.Payment;
import com.casestudy.events.Exceptions.PaymentException;
import com.casestudy.events.Repository.PaymentRepository;


@Service
public class PaymentServiceImpl implements PaymentService{
	
    @Autowired
	private PaymentRepository paymentRepository;
    
    
    @Override
	public Payment addPayment(Payment payment){
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> getAllTransactions()throws PaymentException{
		List<Payment>allPayments=paymentRepository.findAll();
		if(PaymentException.checkIfListEmpty(allPayments)) {
			throw new PaymentException("No payments are found in the records");
		}
		return allPayments ;
	}

	@Override
	public Payment getTransactionById(int transactionId) throws PaymentException{
		Optional<Payment> payment=paymentRepository.findById(transactionId);
		if(payment.isPresent())
			return payment.get();
			else 
				throw new PaymentException("No details found with the given id");
		}
	@Override
	public void deleteTransaction(int transactionId)throws PaymentException{
		Optional<Payment> payment=paymentRepository.findById(transactionId);
		if(payment.isPresent())
		{
			paymentRepository.deleteById(transactionId);
		}
		else
		{
			throw new PaymentException("No details found for the given id");
		}
	}
	
}