package com.bakalis.struts.actions;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;

import com.bakalis.models.SingleTransaction;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;

public class PastTransactionsAction {
	
	
	protected Authentication auth;
	protected String error;
	//List of all Past Transactions
	ArrayList<SingleTransaction> transactions;
	
	
	//Getters and Setters
	
	public Authentication getAuth() {
		return auth;
	}


	public void setAuth(Authentication auth) {
		this.auth = auth;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public ArrayList<SingleTransaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(ArrayList<SingleTransaction> transactions) {
		this.transactions = transactions;
	}

	//Returning all past transactions with the view
	public String execute(){
		auth = AuthenticationService.getAuth();
		error = ErrorLoggingService.getError();
		ErrorLoggingService.reset();
		ContentsService contentsService = new ContentsService();
		this.setTransactions(contentsService.getPastTransactions());
		return "success";
	}
}
