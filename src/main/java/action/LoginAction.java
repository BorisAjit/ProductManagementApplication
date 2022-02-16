package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDao;
import pojo.LoginInfo;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	String userName;
	String password;
	
	public String execute() {
		String statusCode = "";
		
		boolean userValid = LoginDao.isUserValid(new LoginInfo(userName, password));
		
		if(userValid) {
			statusCode="success";
		} else {
			statusCode="input";
		}
		
		return statusCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
