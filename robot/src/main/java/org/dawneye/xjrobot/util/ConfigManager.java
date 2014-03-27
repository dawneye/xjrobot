package org.dawneye.xjrobot.util;

import org.apache.log4j.Logger;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * <p>
 * Title:ƽ̨������Ϣ����
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author cbs
 * @version 1.0
 */

public class ConfigManager {
	private static Logger logger = Logger.getLogger(ConfigManager.class);
	private static ConfigManager singleton;
	private static Hashtable<String, String> confAttris;
	
	/**
	 *  �ļ�������ʱĿ¼
	 */
//	public static String FILE_TEMP_PATH = "file_temp_path";
	
	private ConfigManager() {
		initConfig();
	}

	public static synchronized ConfigManager getInstance() {
		if (singleton == null) {
			singleton = new ConfigManager();
		}
		return singleton;
	}

	/**
	 * ��ȡ����ӳ���?
	 * 
	 * @return Hashtable
	 */
	public Hashtable<String, String> getConfAttris() {
		if (confAttris == null) {
			initConfig();
		}
		return confAttris;
	}

	/**
	 * ��ѯ�����ļ�ֵ
	 * @param key
	 * @return
	 */
	public static String getValueFormFile(String key) {
		if (confAttris == null) {
			initConfig();
		}
		return confAttris.get(key);
	}

	/**
	 * ��ʼ�������ļ�
	 */
	private static void initConfig() {
		ResourceBundle rb = ResourceBundle.getBundle("webconfig",
				Locale.ENGLISH);
		confAttris = new Hashtable<String, String>();
		try {
			Enumeration iter = rb.getKeys();
			while (iter.hasMoreElements()) {
				String key = (String) iter.nextElement();
				confAttris.put(key, rb.getString(key));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}
	
	/**
	 * ����ݿ���ȡ�������?
	 * @param key
	 * @return
	 */
	public String getValueFormData(int key) {
		try {
			
		} catch (Exception e) {
			logger.error("System config read error:" + e);
		}
		return null;
	}
}
