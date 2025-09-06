package com.qa.opencart.utils;

import org.apache.log4j.Logger;

public class LogUtil {

	public static Logger log = Logger.getLogger(LogUtil.class);

	public static void info(String mesg) {
		log.info(mesg);
	}

	public static void warn(String mesg) {
		log.warn(mesg);
	}

	public static void error(String mesg) {
		log.error(mesg);
	}

	public static void fatal(String mesg) {
		log.fatal(mesg);
	}

}
