package org.mule.extension.paubox.operations;

import static org.hamcrest.MatcherAssert.assertThat;

import org.mule.extension.paubox.common.TestDataBuilder;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.event.Event;
import org.mule.runtime.api.metadata.DataType;

import static org.hamcrest.Matchers.is;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static org.mule.extension.paubox.common.TestDataBuilder.*;

public class PauboxOperationsTestCase extends MuleArtifactFunctionalTestCase {

	/**
	 * Specifies the mule config xml with the flows that are going to be executed in
	 * the tests, this file lives in the test resources.
	 */
	@Override
	protected String getConfigFile() {
		return "paubox-operation-test.xml";
	}

	@Test
	public void executeGetEmailDispositionFlowOperation_Success() throws Exception {
		Map<String, Object> sourceTrackingData = TestDataBuilder.getSuccessfulEmailDispositionData();
		Event pauboxTest = flowRunner("getEmailDispositionFlow")
				.withVariable("sourceTrackingId", sourceTrackingData.get("sourceTrackingId")).run();
		Object attributes = pauboxTest.getMessage().getAttributes().getValue();
		JSONObject objAttributes = new JSONObject(attributes);
		Assert.assertEquals(200, objAttributes.getInt("statusCode"));
	}

	@Test
	public void executeGetEmailDispositionFlowOperation_Failure() throws Exception {
		Map<String, Object> sourceTrackingData = TestDataBuilder.getFailureEmailDispositionData();
		Event pauboxTest = flowRunner("getEmailDispositionFlow")
				.withVariable("sourceTrackingId", sourceTrackingData.get("sourceTrackingId")).run();
		Object attributes = pauboxTest.getMessage().getAttributes().getValue();
		JSONObject objAttributes = new JSONObject(attributes);
		Assert.assertEquals(404, objAttributes.getInt("statusCode"));
	}

	@Test
	public void executeSendMessageFlowOperation_Success() throws Exception {
		Map<String, Object> pauboxData = TestDataBuilder.createMessageData();
		Event pauboxTest = flowRunner("sendMessageFlow").withPayload(pauboxData).run();
		Object attributes = pauboxTest.getMessage().getAttributes().getValue();
		JSONObject objAttributes = new JSONObject(attributes);
		Assert.assertEquals(200, objAttributes.getInt("statusCode"));
	}

	@Test
	public void executeSendMessageFlowOperation_Failure() throws Exception {
		Map<String, Object> pauboxData = TestDataBuilder.createInvalidMessageData();
		Event pauboxTest = flowRunner("sendMessageFlow").withPayload(pauboxData).run();
		Object attributes = pauboxTest.getMessage().getAttributes().getValue();
		JSONObject objAttributes = new JSONObject(attributes);
		Assert.assertEquals(400, objAttributes.getInt("statusCode"));
	}
}