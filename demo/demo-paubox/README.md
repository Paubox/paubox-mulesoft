# Paubox Demo

1. You will need a Paubox account and API credentials to run this demo application. Please sign up [here](https://www.paubox.com/join/see-pricing?unit=messages) to create a Paubox account. Once you have an account, follow the instructions on the Rest API dashboard to verify domain ownership and generate API credentials.
2. Add the configuration values in configuration.yaml located at src/main/resources. For example:

    ```yaml
   paubox:
       apiurl: "<url-to-access-paubox-api>"
       apikey: "<api-key-for-paubox-api-domain>"
       apiusername: "<endpoint-username-for-paubox-api-domain>"
    ```

3. Check if global-configuration.xml has picked the properties by clicking on Test Connection.
4. For both **paubox-api-flow.xml** and **send-message-flow.xml** mule configuration files, please modify the recipient from recipient@domain.com to any other recipient email address as per your requirement. Similarly modify the sender from sender@authorized_domain.com to any other sender email address. Please make sure that the sender email address' domain should be an approved sending domain for your Paubox account.
4. Now open **paubox-api-flow.xml** mule configuration file and run the project.
4. Once the project gets deployed successfully, hit the endpoint **localhost:8081/pauboxAPIFlow** as mentioned in listener path from any browser/rest client.
5. Similarly, you can run the **send-message-flow.xml** mule configuration file.
6. For running the **get-email-disposition-flow.xml** mule configuration file, you need to pass a sourceTrackingId as a query parameter to its endpoint. You can get the sourceTrackingId from **send-message-flow.xml** response. Sample response of send-message-flow:

    ```json
    {
        "sourceTrackingId": "3d38ab13-0af8-4028-bd45-52e882e0d584",
        "data": "Service OK",
    }
    ```

   For more information about the Paubox REST API methods and parameters, please refer the
   [Paubox REST API reference.](https://www.paubox.com/solutions/email-api)