package org.mule.extension.paubox.common;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TestDataBuilder {

	private TestDataBuilder() {
		throw new IllegalStateException("Test DataBuilder Class");
	}

	public static Map<String, Object> createMessageData() {

		Map<String, Object> message = new HashMap<>();
		Map<String, Object> content = new HashMap<>();
		Map<String, Object> header = new HashMap<>();
		Map<String, Object> request = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		List<String> recipientList = new ArrayList<>();

		header.put("subject", "Mulesoft Test");
		header.put("from", "sender@domain.com");
		content.put("text/plain", "This is a Test from Mulesoft Connector");
		recipientList.add("recipient@test.com");

		message.put("recipients", recipientList);
		message.put("headers", header);
		message.put("forceSecureNotification", false);
		message.put("content", content);

		data.put("message", message);
		request.put("data", data);

		return request;
	}

	public static Map<String, Object> createInvalidMessageData() {

		Map<String, Object> message = new HashMap<>();
		Map<String, Object> content = new HashMap<>();
		Map<String, Object> header = new HashMap<>();
		Map<String, Object> request = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		List<String> recipientList = new ArrayList<>();

		header.put("subject", "Mulesoft Test");
		header.put("from", "sender@domain.com");
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
