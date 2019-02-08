package com.bakalis.struts.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.security.core.Authentication;

import com.bakalis.models.Category;
import com.bakalis.models.Client;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;
import com.bakalis.struts.services.TransactionsService;

public class AddClientAction implements ServletRequestAware{
	protected Authentication auth;
	protected String error;
	//A String that holds an Id for the Client to be Edited
	protected String editedId;
	//A Category Object to hold the Data of the Category to be Edited
	protected Client editedClient;
	protected HttpServletRequest request;
	//Strings for the new Category to be Added	
	protected String newClientId;
	protected String newClientName;
	
	//Getters and Setters for all the fields
	
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

	public String getNewClientId() {
		return newClientId;
	}

	public void setNewClientId(String newClientId) {
		this.newClientId = newClientId;
	}

	public String getNewClientName() {
		return newClientName;
	}

	public void setNewClientName(String newClientName) {
		this.newClientName = newClientName;
	}

	public Client getEditedClient() {
		return editedClient;
	}

	public void setEditedClient(Client editedClient) {
		this.editedClient = editedClient;
	}

	public String getEditedId() {
		return editedId;
	}

	public void setEditedId(String editedId) {
		this.editedId = editedId;
	}
	
	

	public String execute(){
		//get some static info like the Error message and the Authentication object
		error = ErrorLoggingService.getError();
		auth = AuthenticationService.getAuth();
		//After fetching the error we reset the service
		ErrorLoggingService.reset();
		ContentsService contentsService = new ContentsService();
		//if this was a get method
		if(request.getMethod().equals("GET")){
			//If we didnt access this url by the Link or with a Client to be edited
			if(this.getEditedId()==null){
				return "addClient";
			}else{ //If we accessed this url with a Client to be edited
				this.setEditedClient(contentsService.getEditedClient(editedId));
				return "addClient";
			}
			//Handles the POST request of the form in addCategory.jsp
		}else if(request.getMethod().equals("POST")){
			TransactionsService transactionsService = new TransactionsService();
			//if this was an edit request it edits, otherwise it adds a new;
			if(this.getEditedId()!=null){
				transactionsService.editClient(editedId, this.getEditedClient().getClientName());
				return "redirect";
			}else{
				transactionsService.addClient(this.getNewClientId(), this.getNewClientName());
				return "redirect";
			}
		}
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
