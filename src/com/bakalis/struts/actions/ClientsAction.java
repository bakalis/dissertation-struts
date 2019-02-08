package com.bakalis.struts.actions;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;

import com.bakalis.models.Category;
import com.bakalis.models.Client;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;
import com.bakalis.struts.services.TransactionsService;

public class ClientsAction {
	protected Authentication auth;
	protected String error;
	//List of the Clients to show
	protected ArrayList<Client> clients;
	//The value of the searchBar textfield in clients.jsp
	protected String searchBar=null;
	//A boolean to help us check if this was a search or not
	protected boolean searched=false;
	//The string that holds the Id of the Client we want to delete
	protected String deleteId;
	
	
	//Getters and Setters of all the fields

	
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
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public String getSearchBar() {
		return searchBar;
	}
	public void setSearchBar(String searchBar) {
		if(!searchBar.isEmpty()){
			this.setSearched(true);
		}
		this.searchBar = searchBar;
	}
	public boolean isSearched() {
		return searched;
	}
	public void setSearched(boolean searched) {
		this.searched = searched;
	}
	
	
	
	
	public String execute(){
		auth = AuthenticationService.getAuth();
		error = ErrorLoggingService.getError();
		ErrorLoggingService.reset();
		ContentsService contentsService = new ContentsService();
		//If this isnt a delete request
		if(this.getDeleteId()==null){
			//if this is a request to search Clients
			if(this.isSearched()){
				//We use the contentsService to get the Searched Clients
				this.setClients(contentsService.getSearchedClients(searchBar));
			}else{
				//We get all the Clients
				this.setClients(contentsService.getClients());
			}
			return "clients";
		}else{
			//We use the transactionsService to delete the Client with the deletedId as Id
			TransactionsService transactionsService = new TransactionsService();
			transactionsService.deleteClient(deleteId);
			return "redirect";
		}
	}
	
}
