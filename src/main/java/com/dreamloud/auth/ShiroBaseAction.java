package com.dreamloud.auth;import org.apache.shiro.SecurityUtils;import org.apache.shiro.subject.Subject;import com.test.Models.AccountEntity;public class ShiroBaseAction {	protected transient Subject shiroUser;	protected AccountEntity acctEntity;	/**	 * This method should be called before any others in this class.	 * It populates the ShiroUser from the Security Utility into this	 * object and all others that extend it.	 * @author Matt	 */	public void shiroPrepare() {		this.shiroUser = SecurityUtils.getSubject();	}		public boolean isAuthenticated() {		return (this.shiroUser != null) && (this.shiroUser.isAuthenticated());	}	public Subject getShiroUser() {		return this.shiroUser;	}	public void setShiroUser(Subject shiroUser) {		this.shiroUser = shiroUser;	}			public AccountEntity getAcctEntity() {		return acctEntity;	}	public void setAcctEntity(AccountEntity acctEntity) {		this.acctEntity = acctEntity;	}}