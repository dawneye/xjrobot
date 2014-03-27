package org.dawneye.util;

import org.apache.commons.lang.StringUtils;

import java.util.Random;


public class RandomDATAUtil {

	private static final int EMAIL_LENGTH = 15;
	private static final String PREFIX = "t_";
	private static final String ENDFIX = "test.com";
	private static final String AT = "@";
	private static final int LONG_MAX_LENGTH = String.valueOf(Long.MAX_VALUE).length();
	
	public static String genEmail(){
		return genEmail(EMAIL_LENGTH);
	}
	
	public static String genEmail(int length){
		return genEmail(length, PREFIX);
	}
	
	public static String genEmail(int length, String prefix){
		return genEmail(length, prefix, ENDFIX);
	}
	
	public static String genEmail(int length, String prefix, String endfix){
		StringBuffer result = new StringBuffer();
		if(length < EMAIL_LENGTH){
			length = EMAIL_LENGTH;
		}
		int random_length = length - 11;
		String random = genRandomNumber(random_length);
		
		result.append(prefix).append(random).append(AT).append(endfix);
		return result.toString();
	}
	
	public static String genRandomNumber(int length){
		Long num = Math.abs(new Random().nextLong());
		
		if(length < LONG_MAX_LENGTH){
			return StringUtils.leftPad(num.toString().substring(0, length), length ,'0');
		}else{
			return StringUtils.leftPad(num.toString() + genRandomNumber(length - LONG_MAX_LENGTH), length, '0');			
		}
	}
	
	public static String genChinese(int length){
		return ChineseUtils.getFixedLengthChinese(length);
	}
}
