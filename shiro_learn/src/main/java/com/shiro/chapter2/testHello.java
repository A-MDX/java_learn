package com.shiro.chapter2;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by A-mdx on 2017/3/27.
 */
public class testHello {
	
	@Test
	public void testHelloWorld(){
		System.out.println("进来了？");
		// 1.init
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 2.bind securityUtil
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		// 3.得到subject及创建token -> user/pwd 验证
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
		
		// 4.测试登录
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}

		// 5.判断是否成功
		Assert.assertEquals(true, subject.isAuthenticated());
		
		// 6.退出
		subject.logout();
		System.out.println("进来了。");
	}
	
}
