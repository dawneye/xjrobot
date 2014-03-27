package org.dawneye.util;

import java.text.SimpleDateFormat;

/**
 * 日志格式化工具类型
 *
 */
public class DateFormater {

    /**
     * 时间格式 yyyy-MM-dd
     */
    public static final String FORMART1 = "yyyy-MM-dd";
    public static final String FORMART2 = "yyyyMMdd";
    public static final String FORMART3 = "yyyyMMddHHmmss";
    public static final String FORMART4 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMART5 = "yyyyMMddHHmmssSSS";
    public static final String FORMART6 = "HH-mm-ss";

	/**
	 * 将字符串转换成为日期类型
	 *
	 * @param dateFormat
	 *            指定的格式
	 * @param date
	 *            需要转换成日期的字符串
	 * @return 转换后的日期
	 * @throws IllegalArgumentException
	 *             参数不合法异常
	 * @throws java.text.ParseException
	 *             解析日期异常
	 */
	public static java.util.Date stringToDate(String dateFormat, String date)
			throws IllegalArgumentException, java.text.ParseException {
		if (dateFormat == null || dateFormat.equals("")) {
			throw new IllegalArgumentException(
					"parameter dateFormat is not valid");
		}
		if (date == null || date.equalsIgnoreCase("")) {
			throw new IllegalArgumentException(
					"parameter date is not valid");
		}
		SimpleDateFormat formater = new SimpleDateFormat(dateFormat);
		try {
			return formater.parse(date);
		} catch (java.text.ParseException exception) {
			throw exception;
		}

	}
	
	/**
	 * 将字符串转换成为日期类型
	 *
	 * @param dateFormat
	 *            指定的格式
	 * @param date
	 *            需要转换成日期的字符串
	 * @return 转换后的日期
	 * @throws IllegalArgumentException
	 *             参数不合法异常
	 * @throws java.text.ParseException
	 *             解析日期异常
	 */
	public static java.sql.Timestamp stringToTimeStamp(String dateFormat, String date)
			throws IllegalArgumentException, java.text.ParseException {
		if (dateFormat == null || dateFormat.equals("")) {
			throw new IllegalArgumentException(
					"parameter dateFormat is not valid");
		}
		if (date == null || date.equalsIgnoreCase("")) {
			throw new IllegalArgumentException(
					"parameter date is not valid");
		}
		SimpleDateFormat formater = new SimpleDateFormat(dateFormat);
		try {
			return new java.sql.Timestamp(formater.parse(date).getTime());
		} catch (java.text.ParseException exception) {
			throw exception;
		}

	}
	
	/**
	 * 将日期类型转换为字符串的形式
	 *
	 * @param dateFormat
	 *            转换后的格式
	 * @param date
	 *            需要转换的日期
	 * @return 转换后的字符串
	 * @throws IllegalArgumentException
	 */
	public static String dateToString(String dateFormat, java.util.Date date)
			throws IllegalArgumentException {
		if (dateFormat == null || dateFormat.equals("")) {
			throw new IllegalArgumentException(
					"parameter dateFormat is not valid");
		}
		if (date == null) {
			throw new IllegalArgumentException(
					"parameter date is not valid");
		}
		SimpleDateFormat formater = new SimpleDateFormat(dateFormat);
		return formater.format(date);

	}
	
	public static String dateToStringWithouException(String dateFormat, java.util.Date date){
		if (dateFormat == null || dateFormat.equals("")) {
			return "";
		}
		if (date == null) {
			return "";
		}
		SimpleDateFormat formater = new SimpleDateFormat(dateFormat);
		return formater.format(date);
		
	}

	public static void main(String args[]) throws Exception {

              System.out.println(DateFormater.stringToTimeStamp(DateFormater.FORMART1,"1999-10-09"));

		System.out.println(DateFormater.dateToString("yyyyMMddhhmmsss",
				new java.util.Date(System.currentTimeMillis())));
	}
	
	public static String addBeginTime(String beginTime){
		if (beginTime == null || beginTime.equals("")) {
			throw new IllegalArgumentException(
					"parameter dateFormat is not valid");
		}
		return beginTime +" 00:00:00";
	}
	public static String addEndTime(String endTime){
		if (endTime == null || endTime.equals("")) {
			throw new IllegalArgumentException(
					"parameter dateFormat is not valid");
		}
		return endTime +" 23:59:59";
	}

}
