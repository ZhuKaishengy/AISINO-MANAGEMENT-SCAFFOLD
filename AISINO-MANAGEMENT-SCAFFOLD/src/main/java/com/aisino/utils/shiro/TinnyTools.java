package com.aisino.utils.shiro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class TinnyTools {

	Logger logger = Logger.getLogger(TinnyTools.class);
	
	// 包装hibernate-validator 校验结果
	public static Map<String, String> wrapperBindingResult(BindingResult bindingResult) {
		Map<String, String> map = new HashMap<String, String>();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			String field = fieldError.getField();
			String message = fieldError.getDefaultMessage();
			map.put(field, message);
		}
		return map;
	}
	
    /** 
     * 生成(获得)n位随机数串 
     * @param n 生成随机数串的位数 
     * @return 返回生成的 n为数字串 
     */  
    public static String randomCodeGenerator(int n){ 
    	
    	Random random = new Random();
    	
        //  存储中间生成的数串  
        StringBuffer randomDigitStr = new StringBuffer();  
        //  生成的随机数  
        long randomDigit;  
          
        if(n < 18){  
            //  生成 n位随机数（-0.5避免生成的前 n均为 9最终四舍五入时（可能）超出一位数字）  
            randomDigit =   
                    Math.round((random.nextDouble() * Math.pow(10, n)) - 0.5);  
            randomDigitStr.append(randomDigit);  
        } else {  
            //  n超过 18，则通过生成多个 18位随机数连接成更长串  
            for(int i = 0; i < Math.floor(n / 18); ++i){  
                //  生成 18位随机数（long最长为 19位且非所有位均为 9，所以取 18位）  
                randomDigit =  
                        Math.round((random.nextDouble() * Math.pow(10, 18)) - 0.5);  
                randomDigitStr.append(randomDigit);  
            }  
        }  
        //  生成的随机数串位数  
        int randomDigitStrLength = randomDigitStr.length();  
          
        //  生成的随机数串位不足但是也不达 18位时，循环随机插入随机生成的[0, 9]间任意一位数  
        if(randomDigitStrLength < n){  
            for(int i = 0; i < n - randomDigitStrLength; ++i){  
                //  生成可插入的下标位置（若位置为 randomDigitStr.length()，则是在末尾添加）  
                int offset = random.nextInt(randomDigitStr.length() + 1);  
                if(offset < randomDigitStr.length()){  
                    //  在 offset位置（下标）插入随机生成的[0, 9]间一位数  
                    randomDigitStr.insert(offset, random.nextInt(10));  
                } else {  
                    //  在数串末尾添加[0, 9]间一位数  
                    randomDigitStr.append(random.nextInt(10));  
                }  
            }  
        }  
        return randomDigitStr.toString();  
    }  
    
    
	@Test
	public void test(){
		for (int i = 0; i < 50; i++) {
			
			String str = TinnyTools.randomCodeGenerator(5);
			System.out.println(str);
		}
	}
	
}
