package com.bakalis.struts.actions;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;

import com.bakalis.models.Category;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;
import com.bakalis.struts.services.TransactionsService;

public class CategoriesAction {
	protected Authentication auth;
	protected String error;
	//The List of the Categories to show
	protected ArrayList<Category> categories;
	//The value of the searchBar textfield in categories.jsp
	protected String searchBar=null;
	//A boolean to help us check if this was a search or not
	protected boolean searched=false;
	//The string that holds the Id of the Category we want to delete
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
	public ArrayList<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
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
			//if this is a request to search Categories
			if(this.isSearched()){
				//We use the contentsService to get the Searched Categories
				this.setCategories(contentsService.getSearchedCategories(searchBar));
			}else{
				//We get all the Categories
				this.setCategories(contentsService.getCategories());
			}
			return "categories";
		}else{
			//We use the transactionsService to delete the Category with the deletedId as Id
			TransactionsService transactionsService = new TransactionsService();
			transactionsService.deleteCategory(deleteId);
			return "redirect";
		}
	}
	
}
