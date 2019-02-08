package com.bakalis.struts.actions;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;

import com.bakalis.models.Product;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;

public class ContentsAction {

	protected Authentication auth;
	protected String error;
	//List of all Products in the Warehouse
	protected ArrayList<Product> contents;
	//A String to store the searchFilter used to query the Right Table
	protected String searchFilter=null;
	//A String to store the searchBar in index.jsp
	protected String searchBar=null;
	
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


	public String getSearchBar() {
		return searchBar;
	}


	public void setSearchBar(String searchBar) {
		this.searchBar = searchBar;
	}


	public String getSearchFilter() {
		return searchFilter;
	}


	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	
	public ArrayList<Product> getContents() {
		return contents;
	}


	public void setContents(ArrayList<Product> contents) {
		this.contents = contents;
	}


	public String execute(){
		auth = AuthenticationService.getAuth();
		error = ErrorLoggingService.getError();
		ErrorLoggingService.reset();
		ContentsService contentsService = new ContentsService();
		//if we chose a filter then we get the contents using the contents of the searchBar and the filter
		if(searchFilter!=null){
			contents = contentsService.getSearchedContents(searchBar, searchFilter);
			return "success";
		}
		//if we didn't select a filter we get all Contents
		contents = contentsService.getAllContents();
		return "success";
	}
	
}
