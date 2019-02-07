package com.bakalis.struts.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.bakalis.models.Category;
import com.bakalis.models.Client;
import com.bakalis.struts.services.ContentsService;
import com.bakalis.struts.services.TransactionsService;

public class EntryAction implements ServletRequestAware{

	protected HttpServletRequest request;
	protected String productId;
	protected String productName;
	protected String category;
	protected String client;
	protected String quantity;
	protected String code;
	
	protected Map<String, String> categories;
	protected Map<String, String> clients;
	

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
		ContentsService contentsService = new ContentsService();
		ArrayList<Category> cats = contentsService.getCategories();
		ArrayList<Client> clnts = contentsService.getClients();
		categories = new HashMap<String, String>();
		clients = new HashMap<String, String>();
		for(Category cat : cats){
			categories.put(String.valueOf(cat.getId()), cat.getCategoryName());
		}
		for(Client clnt : clnts){
			clients.put(String.valueOf(clnt.getId()), clnt.getClientName());
		}
		if(request.getMethod().equals("GET")){
			return "entry";
		}else if(request.getMethod().equals("POST")){
			TransactionsService transactionsService = new TransactionsService();
			transactionsService.manageEntry(productId, productName, category, client, quantity, code);
			return "redirect";
		}
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}
	
}
