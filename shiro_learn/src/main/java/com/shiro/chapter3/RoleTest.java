package com.shiro.chapter3;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by A-mdx on 2017/3/28.
 */
public class RoleTest {
	
	
	
	@Test
	public void testHasRole(){
		Subject subject = login("chapter3/shiro-role.ini", "zhang", "123");
		Assert.assertTrue(subject.hasRole("admin"));
		Assert.assertTrue(subject.hasAllRoles(Arrays.asList("admin", "guest")));
		final boolean[] result = subject.hasRoles(Arrays.asList("admin", "guest", "child"));
		for (int i = 0; i < result.length; i++) {
			System.out.println("result:"+result[i]);
		}
		subject.logout();
	}
	
	@Test
	public void testPermission(){
		Subject subject = login("chapter3/shiro-permission.ini", "zhang","123");
		Assert.assertTrue(subject.isPermitted("user:update"));
		Assert.assertTrue(subject.isPermittedAll("user:update", "user:create"));
		Assert.assertTrue(subject.isPermitted("user:view"));
	}

	@Test
	public void testPermission1(){
		Subject subject = login("chapter3/shiro-permission.ini", "zhang","123");
		subject.checkPermission("user:update");
		subject.checkPermission("user:view");
		Assert.assertTrue(subject.isPermittedAll("user:update", "user:create"));
	}
	
	public Subject login(String filePath, String username, String pwd){
		Factory<SecurityManager> factory = 
				new IniSecurityManagerFactory("classpath:"+filePath);
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);

		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		return subject;
	}
	
}
