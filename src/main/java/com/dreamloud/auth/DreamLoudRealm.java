package com.dreamloud.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SaltedAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;

import com.test.DAOs.DreamLoudDao;
import com.test.DaoFactory.DaoFactory;
import com.test.DaoFactory.DaoOptions;
import com.test.Helpers.LoginHelper;
import com.test.Models.AccountEntity;

/**
 * Custom Shiro Realm configured for hashed and salted passwords
 * @author Matt
 */
public class DreamLoudRealm extends JdbcRealm {
	private DreamLoudDao dao = DaoFactory.getInstance(DaoOptions.HIBERNATE_DAO);
    private LoginHelper loginHelper = new LoginHelper(dao);
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
			throws AuthenticationException {
		
		UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
		final String username = userPassToken.getUsername();

		if (username != null) {
			final AccountEntity accountEntity = loginHelper.getAcctUsingEmail(username);
			System.out.println("username is: "+ username);
			System.out.println("password is: "+ accountEntity.getAcctPw());
			System.out.println("salt is: "+ accountEntity.getSalt());
			
			if (accountEntity == null) {
				System.out.println(username + " tried logging in, but the user does not exist in the databse!");
				return null;
			}

			// return salted credentials
			SaltedAuthenticationInfo info = 
					new UserCredSalt(username, accountEntity.getAcctPw(), accountEntity.getSalt());
			return info;
		} else {
			System.out.println("Username is null.");
			return null;
		}
	}
}