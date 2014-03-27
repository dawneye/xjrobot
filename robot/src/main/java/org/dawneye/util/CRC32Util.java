package org.dawneye.util;

import java.util.zip.CRC32;

public class CRC32Util {
	private static final String spilt = "/";

	/**
	 * 组装数据为待签名的串，使用hnyd作为前缀，`/`为分隔符
	 * @param val
	 * @return
	 */
	public static String assembleData(String... val){
		StringBuffer sb = new StringBuffer("hnyd");
		for (String str : val) {
			sb.append(spilt).append(str);
		}
		return sb.toString();
	}
	
	/**
	 * 计算传入字串的CRC32值
	 * @param data
	 * @return
	 */
	public static String calcCRC32(String data){
		String result = "";
		CRC32 crc32 = new CRC32();
		crc32.update(data.getBytes());
		long crc32val = crc32.getValue();
		if(0L != crc32val){
			result = String.valueOf(crc32val);
		}
		return result;
	}
	
	public static boolean verifyCRC32(String data, String sign){
		boolean result = false;
		if(null == data || null == sign
				|| "".equals(data) || "".equals(sign)){
			result = false;
		}
		if(sign.equals(calcCRC32(data))){
			result = true;
		}
		return result;
	}
	
	public static void main(String[] args) {
//		String data = "hnyd/18900000000/20140304112233/00";
//		System.out.println(CRC32Util.calcCRC32(data));
		String val1 = "18900000000";
		String val2 = "20140304112233";
		String val3 = "00";
		System.out.println(CRC32Util.calcCRC32(CRC32Util.assembleData(val1, val2, val3)));
		
	}
}
