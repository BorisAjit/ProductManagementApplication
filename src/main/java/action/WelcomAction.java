package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductManagentDao;
import pojo.Product;

public class WelcomAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	List<Product> products;
	
	public void initializeProducts() {
		products = ProductManagentDao.getAllProducts();
	}
	
	public String execute() {
		initializeProducts();
		return "success";
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
