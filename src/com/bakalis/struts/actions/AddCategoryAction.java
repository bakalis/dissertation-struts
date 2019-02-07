package com.bakalis.struts.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.bakalis.models.Category;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.TransactionsService;

public class AddCategoryAction implements ServletRequestAware{

	protected String editedId;
	protected Category editedCategory;
	protected HttpServletRequest request;
	
	protected String newCategoryId;
	protected String newCategoryName;
	
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
		ContentsService contentsService = new ContentsService();
		if(request.getMethod().equals("GET")){
			if(this.getEditedId()==null){
				return "addCategory";
			}else{
				this.setEditedCategory(contentsService.getEditedCategory(editedId));
				return "addCategory";
		}
		}else if(request.getMethod().equals("POST")){
			TransactionsService transactionsService = new TransactionsService();
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

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
