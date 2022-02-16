package action;

import dao.ProductManagentDao;

public class DeleteDataAction {

	String productId;

	public String execute() {
		String statusCode;
		int rowsDeleted = ProductManagentDao.deleteProduct(productId);
		if(rowsDeleted == 1) {
			statusCode = "success";
		} else {
			statusCode = "error";
		}
		return statusCode;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
