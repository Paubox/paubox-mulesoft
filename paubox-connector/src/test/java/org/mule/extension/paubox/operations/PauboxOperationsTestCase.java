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
   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
   */
  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }


  @Test
  public void executeGetEmailDispositionFlowOperation() throws Exception {
	  Map<String, Object> pauboxData=TestDataBuilder.getEmailDispositionData();
	  Event pauboxTest = flowRunner("getEmailDispositionFlow").run();
	  Object payloadValue=  pauboxTest.getMessage().getPayload().getValue();
      JSONObject obj = new JSONObject(payloadValue);
      System.out.println("THIS IS RESPONSE:");
      System.out.println(obj);
      Assert.assertNotNull(obj);
  }


  @Test
  public void executeSendMessageFlowOperation() throws Exception {
	  //Map<String, Object> pauboxData=TestDataBuilder.getEmailDispositionData();
	  Event pauboxTest = flowRunner("sendMessageFlow").run();
	  Object payloadValue=  pauboxTest.getMessage().getPayload().getValue();
      JSONObject obj = new JSONObject(payloadValue);
      System.out.println("THIS IS MESSAGE RESPONSE:");
      System.out.println(obj);
      Assert.assertNotNull(obj);
  }
}
