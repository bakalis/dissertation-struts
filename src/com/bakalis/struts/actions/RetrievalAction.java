package com.bakalis.struts.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.security.core.Authentication;

import com.bakalis.models.Category;
import com.bakalis.models.Client;
import com.bakalis.struts.services.AuthenticationService;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.ErrorLoggingService;
import com.bakalis.struts.services.TransactionsService;

public class RetrievalAction implements ServletRequestAware{

	protected Authentication auth;
	protected String error;
	protected HttpServletRequest request;
	//Strings for the Form fields
	protected String productId;
	protected String productName;
	protected String category;
	protected String client;
	protected String quantity;
	protected String code;
	//Maps to be used to populate the Struts 2 Select tags
	protected Map<String, String> categories;
	protected Map<String, String> clients;
	
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

	public Map<String, String> getCategories() {
		return categories;
	}

	public void setCategories(Map<String, String> categories) {
		this.categories = categories;
	}

	public Map<String, String> getClients() {
		return clients;
	}

	public void setClients(Map<String, String> clients) {
		this.clients = clients;
	}

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String execute(){
		auth = AuthenticationService.getAuth();
		error = ErrorLoggingService.getError();
		ErrorLoggingService.reset();
		ContentsService contentsService = new ContentsService();
		//We get all the Categories and Clients
		ArrayList<Category> cats = contentsService.getCategories();
		ArrayList<Client> clnts = contentsService.getClients();
		//We instantiate the Maps
		categories = new HashMap<String, String>();
		clients = new HashMap<String, String>();
		//We populate the maps using the Categories and Clients objects
		for(Category cat : cats){
			categories.put(String.valueOf(cat.getId()), cat.getCategoryName());
		}
		for(Client clnt : clnts){
			clients.put(String.valueOf(clnt.getId()), clnt.getClientName());
		}
		//If it's a GET just return the View
		if(request.getMethod().equals("GET")){
			return "retrieval";
		//If it's a POST use the TransactionsService to save the Data.
		}else if(request.getMethod().equals("POST")){
			TransactionsService transactionsService = new TransactionsService();
			transactionsService.manageRetrieval(productId, productName, category, client, quantity, code);
			return "redirect";
		}
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
}
