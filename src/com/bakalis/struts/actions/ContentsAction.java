package com.bakalis.struts.actions;

import java.util.ArrayList;

import com.bakalis.models.Product;
import com.bakalis.struts.services.ContentsService;

public class ContentsAction {

	protected ArrayList<Product> contents;

	protected String searchFilter=null;
	protected String searchBar=null;
	
	
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
		ContentsService contentsService = new ContentsService();
		if(searchFilter!=null){
			contents = contentsService.getSearchedContents(searchBar, searchFilter);
			return "success";
		}
		contents = contentsService.getAllContents();
		return "success";
	}
	
}
