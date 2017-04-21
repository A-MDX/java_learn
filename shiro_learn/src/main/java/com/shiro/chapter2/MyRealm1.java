package com.shiro.chapter2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by A-mdx on 2017/3/28.
 */
public class MyRealm1 implements Realm {
	public String getName() {
		return "MyRealm1";
	}

	public boolean supports(AuthenticationToken token) {
		// 仅仅支持username password类型的token
		return token instanceof UsernamePasswordToken;
	}

	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String uname = (String) token.getPrincipal();
		String pwd = (String) token.getPrincipal();
		if (!"zhang".equals(uname)){
			throw new UnknownAccountException();
		}
		if (!"123".equals(pwd)){
			throw new IncorrectCredentialsException(); // 密码错误
		}
		return new SimpleAuthenticationInfo(uname, pwd, getName());
	}
}
