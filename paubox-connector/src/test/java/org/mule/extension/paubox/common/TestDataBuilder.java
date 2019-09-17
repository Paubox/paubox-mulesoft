/**
 * (c) 2003-2019 MuleSoft, Inc. The software in this package is published under the terms of the Commercial Free Software license V.1 a copy of which has been included with this distribution in the LICENSE.md file.
 */
package org.mule.extension.paubox.common;


import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TestDataBuilder {

	private TestDataBuilder() {
	    throw new IllegalStateException("Test DataBuilder Class");
	  }

	public static Map<String, Object> createMessageData() {

//	        message.setRecipients(new String[] { "test@test.com" });
//
//	        Content content = new Content();
//	        Header header = new Header();
//	        Attachment attachment = new Attachment();
//	        List<Attachment> listAttachments = new ArrayList<Attachment>();
//	        attachment.setFileName("hello_world.txt");
//	        attachment.setContentType("text/plain");
//	        attachment.setContent("SGVsbG8gV29ybGQh\n");
//
//	        listAttachments.add(attachment);
//
//
//	        header.setSubject("Test Mail from java");
//	        header.setFrom("renee@undefeatedgames.com");
//	        content.setPlainText("Hello Again");
//
//	        message.setHeader(header);
//	        message.setContent(content);
//	        message.setAttachments(listAttachments);

		 	Map<String, Object> entry = new HashMap<>();

		    Map<String, Object> borrower = new HashMap<>();
		    Map<String, Object> currentAddress = new HashMap<>();
		    Map<String, Object> name = new HashMap<>();
		    Map<String, Object> propertyAddress = new HashMap<>();
		    Map<String, Object> applicationSource=new HashMap<>();

	        entry.put("loanType", "MORTGAGE");
	        entry.put("applicationType", "FULL_APPLICATION");
	        entry.put("loanPurposeType", "PURCHASE");
	        entry.put("propertyType", "SINGLE_FAMILY");
	        entry.put("propertySearchType", "NOT_STARTED");
	        entry.put("propertyUsageType", "PRIMARY_RESIDENCE");
	        entry.put("loanAmount", 100000);
	        entry.put("propertyValue", 200000);

	        propertyAddress.put("streetAddressLine1", "100 Main St");
	        propertyAddress.put("streetAddressLine2", "Apt 10");
	        propertyAddress.put("city", "Chicago");
	        propertyAddress.put("state", "IL");
	        propertyAddress.put("zipCode", "60007");
	        propertyAddress.put("zipCodePlusFour", "1000");

	        name.put("firstName", "Venkatesh");
	        name.put("middleName", "M");
	        name.put("lastName", "Velisoju");
	        name.put("suffixName", "Mr.");

	        currentAddress.put("streetAddressLine1", "100 Main St");
	        currentAddress.put("streetAddressLine2", "Apt 10");
	        currentAddress.put("city", "Chicago");
	        currentAddress.put("state", "IL");
	        currentAddress.put("zipCode", "60007");
	        currentAddress.put("zipCodePlusFour", "1000");

	        borrower.put("name", name);
	        borrower.put("email", "velisoju.mouny@gmail.com");
	        borrower.put("SSN", "000113933");
	        borrower.put("dateOfBirth", 19081992);
	        borrower.put("homePhone", "7287820821");
	        borrower.put("currentAddress", currentAddress);

	        entry.put("propertyAddress", propertyAddress);
	        entry.put("borrower", borrower);
	        entry.put("leadId", "leadId");
	        entry.put("crmId", "crmId1");
	        entry.put("referenceNumber", "100");
	        entry.put("referrerEmail", "vijay.rao@apisero.com");
	        entry.put("sendEmailInvite", true);
	        entry.put("applicationTemplateId", "");

	        applicationSource.put("type", "LOS");
	        applicationSource.put("name", " Borrower");

	        entry.put("applicationSource", applicationSource);



	        return entry;
	}





	public static Map<String, Object> getEmailDispositionData() {
		Map<String, Object> sourceTrackingData = new HashMap<>();
		sourceTrackingData.put("sourceTrackingId", "964ff961-8ff8-4c43-8b56-f67672e561d8");
//		loanData.put("format", "mismo");
//		loanData.put("version", "3.3.1");
//		loanData.put("borrowerId", BORROWER_ID_VALUE);
		return sourceTrackingData;
	}


}
