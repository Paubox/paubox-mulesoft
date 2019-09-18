package org.mule.extension.paubox.internal.operations;



import java.io.InputStream;
import java.util.Map;
import org.mule.extension.paubox.api.ResponseStatus;
import org.mule.extension.paubox.internal.config.PauboxConfiguration;
import org.mule.extension.paubox.internal.connection.PauboxConnection;
import org.mule.extension.paubox.internal.error.PauboxErrorProvider;
import org.mule.extension.paubox.internal.service.APIService;
import org.mule.extension.paubox.internal.service.APIServiceImpl;
import org.mule.connectors.commons.template.operation.ConnectorOperations;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.fixed.InputJsonType;
import org.mule.runtime.extension.api.annotation.metadata.fixed.OutputJsonType;
import org.mule.runtime.extension.api.annotation.param.*;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.annotation.param.display.Example;
import org.mule.runtime.extension.api.runtime.operation.Result;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */

public class PauboxOperations extends ConnectorOperations<PauboxConfiguration, PauboxConnection, APIService> {
    public PauboxOperations() {
        super(APIServiceImpl::new);
    }

  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
//  @MediaType(value = ANY, strict = false)
//  public String retrieveInfo(@Config PauboxConfiguration configuration, @Connection PauboxConnection connection){
//    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
//  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String sayHi(String person) {
    return buildHelloMessage(person);
  }

  /**
   * Private Methods are not exposed as operations
   */
  private String buildHelloMessage(String person) {
    return "Hello " + person + "!!!";
  }

  /**
   * Get email disposition
   *
   * @param configuration    Paubox configurations
   * @param connection Paubox connection object
   * @param sourceTrackingId     Source Tracking ID
   * @return email details in given format
   */

  @DisplayName("Get Email Disposition")
  @Throws(PauboxErrorProvider.class)
  @MediaType(value = MediaType.APPLICATION_JSON, strict = false)
  @OutputJsonType(schema = "metadata/get-email-disposition-response-schema.json")
  public Result<InputStream, ResponseStatus> getEmailDisposition(@Config PauboxConfiguration configuration, @Connection PauboxConnection connection,
                                                         String sourceTrackingId
  ) {
	  System.out.println("THIS IS OPERATION RESPONSE");
	  System.out.println(newExecutionBuilder(configuration, connection)
              .execute(APIService::getEmailDispositionResult)
              .withParam(sourceTrackingId));
      return newExecutionBuilder(configuration, connection)
              .execute(APIService::getEmailDispositionResult)
              .withParam(sourceTrackingId);
  }
  
  
  
 /**
  * Send Message
  * 
  * @param configuration Paubox configurations
  * @param connection  Paubox connection object
  * @param messageBody Message Body
  * @return send message success
 */
  @DisplayName("Send Message")
  @Throws(PauboxErrorProvider.class)
  @MediaType(value = MediaType.APPLICATION_JSON, strict = false)  
  public Result<InputStream, ResponseStatus> sendMessage(@Config PauboxConfiguration configuration, @Connection PauboxConnection connection,
                                                      @Summary("Send Message Body") @InputJsonType(schema = "metadata/send-message-request-schema.json") @Content Map<String, Object> messageBody
  ) {

      return newExecutionBuilder(configuration, connection)
              .execute(APIService::getSendMessageResult)
              .withParam(messageBody);
  }
}
