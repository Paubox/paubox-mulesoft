# Paubox Demo

Add below dependency to demo-paubox/pom.xml:

```
<dependency>
    <groupId>com.mulesoft.connectors</groupId>
    <artifactId>mule-paubox-connector</artifactId>
    <version>1.0.0</version>
    <classifier>mule-plugin</classifier>
</dependency>
```
1. Add the configuration values in configuration.yaml located at src/main/resources.
2. Check if global-configuration.xml has picked the properties by clicking on Test Connection.
3. Open one of the mule configuration files and run the project.
4. Once the project gets deployed successfully, hit the endpoints mentioned in listener path from any browser/rest client.