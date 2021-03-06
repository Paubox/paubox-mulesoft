/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1, a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.extension.paubox.operations;

import org.mule.extension.paubox.common.TestDataBuilder;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;
import org.mule.runtime.api.event.Event;
import org.mule.runtime.api.metadata.DataType;

import java.io.InputStream;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static org.mule.extension.paubox.common.TestDataBuilder.getSuccessfulEmailDispositionData;
import static org.mule.extension.paubox.common.TestDataBuilder.getFailureEmailDispositionData;
import static org.mule.extension.paubox.common.TestDataBuilder.createMessageData;
import static org.mule.extension.paubox.common.TestDataBuilder.createInvalidMessageData;

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