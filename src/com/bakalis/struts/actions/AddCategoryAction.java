package com.bakalis.struts.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.security.core.Authentication;

import com.bakalis.models.Category;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;
import com.bakalis.struts.services.TransactionsService;

public class AddCategoryAction implements ServletRequestAware{

	
	protected String error;
	protected Authentication auth;
	//A String that holds an Id for the Category to be Edited
	protected String editedId;
	//A Category Object to hold the Data of the Category to be Edited
	protected Category editedCategory;
	protected HttpServletRequest request;
	//Strings for the new Category to be Added
	protected String newCategoryId;
	protected String newCategoryName;
	
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
	
	public String getNewCategoryId() {
		return newCategoryId;
	}

	public void setNewCategoryId(String newCategoryId) {
		this.newCategoryId = newCategoryId;
	}

	public String getNewCategoryName() {
		return newCategoryName;
	}

	public void setNewCategoryName(String newCategoryName) {
		this.newCategoryName = newCategoryName;
	}

	public Category getEditedCategory() {
		return editedCategory;
	}

	public void setEditedCategory(Category editedCategory) {
		this.editedCategory = editedCategory;
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
			//If we didnt access this url by the Link or with a category to be edited
			if(this.getEditedId()==null){
				return "addCategory";
			}else{ //If we accessed this url with a category to be edited
				this.setEditedCategory(contentsService.getEditedCategory(editedId));
				return "addCategory";
		}
		//Handles the POST request of the form in addCategory.jsp
		}else if(request.getMethod().equals("POST")){
			TransactionsService transactionsService = new TransactionsService();
			//if this was an edit request it edits, otherwise it adds a new;
			if(this.getEditedId()!=null){
				transactionsService.editCategory(editedId, this.getEditedCategory().getCategoryName());
				return "redirect";
			}else{
				transactionsService.addCategory(this.getNewCategoryId(), this.getNewCategoryName());
				return "redirect";
			}
		}
		return null;
	}
	
	//Getting the Request Item
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
