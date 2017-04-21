package com.shiro.chapter5;

import junit.framework.Assert;
import org.apache.shiro.codec.Base64;
import org.junit.Test;

/**
 * Created by A-mdx on 2017/3/28.
 */
public class EncodeTest {
	
	@Test
	public void encodeTest1(){
		String str1 = "hello,Mr.Ma!";
		String base64Encode = Base64.encodeToString(str1.getBytes());
		System.out.println("base64Encode:"+base64Encode);
		String str2 = Base64.decodeToString(base64Encode);
		Assert.assertEquals(str1, str2);
	}
	
}
