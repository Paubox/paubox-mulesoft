package org.mule.extension.paubox.common;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestDataBuilder {

	private static Properties propTest = new Properties();

	private TestDataBuilder() {
		throw new IllegalStateException("Test DataBuilder Class");
	}

	public static void loadPropertiesFile() throws IOException {
		InputStream input = null;
		try {
			input = new FileInputStream("src/test/resources/paubox-condiguration.properties");

			if (input != null) {
				// load the properties file
				propTest.load(input);
			} else {
				throw new FileNotFoundException("Property file paubox-configuration.properties not found.");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			input.close();
		}
	}

	public static Map<String, Object> createMessageData() throws Exception {

		Map<String, Object> message = new HashMap<>();
		Map<String, Object> content = new HashMap<>();
		Map<String, Object> header = new HashMap<>();
		Map<String, Object> request = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		List<String> recipientList = new ArrayList<>();

		header.put("subject", "Mulesoft Test");
		header.put("from", propTest.getProperty("test.senderEmail"));
		content.put("text/plain", "This is a Test from Mulesoft Connector");
		recipientList.add(propTest.getProperty("test.receiverEmail"));

		message.put("recipients", recipientList);
		message.put("headers", header);
		message.put("forceSecureNotification", false);
		message.put("content", content);

		data.put("message", message);
		request.put("data", data);

		return request;
	}

	public static Map<String, Object> createInvalidMessageData() throws Exception {

		Map<String, Object> message = new HashMap<>();
		Map<String, Object> content = new HashMap<>();
		Map<String, Object> header = new HashMap<>();
		Map<String, Object> request = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		List<String> recipientList = new ArrayList<>();

		header.put("subject", "Mulesoft Test");
		header.put("from", propTest.getProperty("test.senderEmail"));
		content.put("text/plain", "This is a Test from Mulesoft Connector");
		recipientList.add("recipient");

		message.put("recipients", recipientList);
		message.put("headers", header);
		message.put("forceSecureNotification", false);
		message.put("content", content);

		data.put("message", message);
		request.put("data", data);

		return request;
	}

	public static Map<String, Object> getSuccessfulEmailDispositionData() {
		Map<String, Object> sourceTrackingData = new HashMap<>();
		sourceTrackingData.put("sourceTrackingId", "1aed91d1-f7ce-4c3d-8df2-85ecd225a7fc");
		return sourceTrackingData;
	}

	public static Map<String, Object> getFailureEmailDispositionData() {
		Map<String, Object> sourceTrackingData = new HashMap<>();
		sourceTrackingData.put("sourceTrackingId", "1aed91d1-f7ce-4c3d-8ddd-85ecd225a7fc");
		return sourceTrackingData;
	}
}
