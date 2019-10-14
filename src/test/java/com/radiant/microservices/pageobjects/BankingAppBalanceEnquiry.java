 /**
 * @author Subbarao
 */

package com.radiant.microservices.pageobjects;

import org.openqa.selenium.WebElement;

import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.util.JWebElement;

public class BankingAppBalanceEnquiry {

	
	// This method creates object for user Menu in HTML page
	public WebElement userMenu(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for balance Enquiry in HTML page
	public WebElement balanceEnquirySearchbtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

		
	// ==========================================================================
	// This method creates object for Account Number details in HTML page
	public WebElement accountNumberTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Account Number Customer Statement details in HTML page
	public WebElement accountNumberCustomStatementTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	// ==========================================================================
	// This method creates object for Account Number Customer Statement date from  in HTML page
	public WebElement accountNumberCSdateFromTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for Account Number Customer Statement Date To in HTML page
	public WebElement accountNumberCSdateToTxtbox(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
	}

	
	// ==========================================================================
	// This method creates object for Custom Statement Balance Enquiry button in HTML page
	public WebElement customStatementBalanceEnquiryBtn(WebElementDetails webElementDetails) {
		return JWebElement.getWebElement(webElementDetails);
		
	}
	
}
