package com.bakalis.struts.actions;

import java.util.ArrayList;

import com.bakalis.models.Category;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.TransactionsService;

public class CategoriesAction {

	protected ArrayList<Category> categories;
	protected String searchBar=null;
	protected boolean searched=false;
	
	protected String deleteId;
	
	
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
		ContentsService contentsService = new ContentsService();
		if(this.getDeleteId()==null){
			if(this.isSearched()){
				this.setCategories(contentsService.getSearchedCategories(searchBar));
			}else{
				this.setCategories(contentsService.getCategories());
			}
			return "categories";
		}else{
			TransactionsService transactionsService = new TransactionsService();
			transactionsService.deleteCategory(deleteId);
			return "redirect";
		}
	}
	
}
