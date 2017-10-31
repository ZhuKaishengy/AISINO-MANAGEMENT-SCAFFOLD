package com.aisino.utils.shiro;


import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class Encipher extends SimpleCredentialsMatcher{

	/**
	 * MD5 1024此盐值加密 Base64解码
	 */
	@Test
	public void testMd5(){
		String algorithmName = "MD5";
		ByteSource source = ByteSource.Util.bytes("111111");
		ByteSource salt = ByteSource.Util.bytes("admin");
		int hashIterations = 1024;
		//result 为MD5加密结果，用Base64加密
		SimpleHash result = new SimpleHash(algorithmName, source, salt, hashIterations);
		String str = result.toBase64();
		//base64解码过程
		/*byte[] storedBytes = toBytes(result.toString());
		storedBytes = Base64.encode(storedBytes);
		result.setBytes(storedBytes);*/
		
		System.out.println(str);//694a26b3ef0400e1875bf92c8b13c8d1
		

	}
	
}
