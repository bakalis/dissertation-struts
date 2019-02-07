package com.bakalis.struts.actions;

import java.util.ArrayList;

import com.bakalis.models.Category;
import com.bakalis.models.Client;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.TransactionsService;

public class ClientsAction {

	protected ArrayList<Client> clients;
	protected String searchBar=null;
	protected boolean searched=false;
	
	protected String deleteId;
	
	
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
		ContentsService contentsService = new ContentsService();
		if(this.getDeleteId()==null){
			if(this.isSearched()){
				this.setClients(contentsService.getSearchedClients(searchBar));
			}else{
				this.setClients(contentsService.getClients());
			}
			return "clients";
		}else{
			TransactionsService transactionsService = new TransactionsService();
			transactionsService.deleteClient(deleteId);
			return "redirect";
		}
	}
	
}
