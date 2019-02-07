package com.bakalis.struts.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.bakalis.models.Category;
import com.bakalis.models.Client;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.TransactionsService;

public class AddClientAction implements ServletRequestAware{

	protected String editedId;
	protected Client editedClient;
	protected HttpServletRequest request;
	
	protected String newClientId;
	protected String newClientName;
	
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
		ContentsService contentsService = new ContentsService();
		if(request.getMethod().equals("GET")){
			if(this.getEditedId()==null){
				return "addClient";
			}else{
				this.setEditedClient(contentsService.getEditedClient(editedId));
				return "addClient";
		}
		}else if(request.getMethod().equals("POST")){
			TransactionsService transactionsService = new TransactionsService();
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
