package com.bakalis.struts.actions;

import java.util.ArrayList;

import com.bakalis.models.SingleTransaction;
import com.bakalis.struts.services.ContentsService;

public class PastTransactionsAction {
	
	ArrayList<SingleTransaction> transactions;
	
	
	public ArrayList<SingleTransaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(ArrayList<SingleTransaction> transactions) {
		this.transactions = transactions;
	}


	public String execute(){
		ContentsService contentsService = new ContentsService();
		this.setTransactions(contentsService.getPastTransactions());
		return "success";
	}
}
