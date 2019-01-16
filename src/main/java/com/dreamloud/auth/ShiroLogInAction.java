package com.dreamloud.auth;

import org.apache.shiro.authc.UsernamePasswordToken;
import com.test.util.DLConstants;

public class ShiroLogInAction extends ShiroBaseAction {
	private String email;
	private String password;
	private boolean isAuthenticated;
	private String error;
	
	public boolean logInUser() {
		super.shiroPrepare();
		this.isAuthenticated = false;
		
		if (this.shiroUser != null) {
			if (!this.shiroUser.isAuthenticated()) {
				UsernamePasswordToken token = new UsernamePasswordToken(this.email.toLowerCase(), this.password);
				token.setRememberMe(true);
				try {
					this.shiroUser.login(token);
					this.isAuthenticated = true;
				} catch (Exception e) {
					e.printStackTrace();
					this.error = DLConstants.noAccount;
					return false;
				}
			} else if (this.shiroUser.isAuthenticated()) {
				this.isAuthenticated = true;
			}
		}
		
		this.error = DLConstants.noAccount;
		System.out.println("error occured: "+this.error);
		return this.isAuthenticated;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setisAuthenticated(boolean isAuthenticated) {
		this.isAuthenticated = isAuthenticated;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
