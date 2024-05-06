package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		File propertiesFile = new File(
				"C:\\Users\\Nikil\\eclipse-workspace\\April2024\\com.dummyRestAPI\\src\\test\\java\\resources\\global.properties");
		FileInputStream fis = new FileInputStream(propertiesFile);
		prop.load(fis);
		return prop.getProperty(key);
	}

	public static RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream logFile = new PrintStream(new FileOutputStream("APIlogging.txt"));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(logFile))
					.addFilter(ResponseLoggingFilter.logResponseTo(logFile))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

}
