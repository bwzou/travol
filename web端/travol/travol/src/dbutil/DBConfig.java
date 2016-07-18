package dbutil;

import java.io.IOException;
import java.util.Properties;

public class DBConfig {
	// 建立属�?对象
	private static Properties pro = new Properties();
	// 建立静�?�?
	static{
		try {
			pro.load(DBConfig.class.getResourceAsStream("dbinfo.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 建立公有的属�?
	public static String driver = pro.getProperty("driver");
	public static String url = pro.getProperty("url");
	public static String dbname = pro.getProperty("dbname");
	public static String uid = pro.getProperty("uid");
	public static String pwd = pro.getProperty("pwd");
}
