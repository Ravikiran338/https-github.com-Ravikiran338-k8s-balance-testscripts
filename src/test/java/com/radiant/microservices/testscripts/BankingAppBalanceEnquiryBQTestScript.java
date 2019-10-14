/**
 * @author Subbarao 
 */
package com.radiant.microservices.testscripts;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.radiant.microservices.db.TAFDBManagerHelper;
import com.radiant.microservices.db.TestCaseDetails;
import com.radiant.microservices.db.TestSuiteDetails;
import com.radiant.microservices.exceptions.TAFException;
import com.radiant.microservices.model.WebElementDataDetails;
import com.radiant.microservices.model.WebElementDetails;
import com.radiant.microservices.pageobjects.BankingAppBalanceEnquiry;
import com.radiant.microservices.util.AppUtil;
import com.radiant.microservices.util.JExcelParser;
import com.radiant.microservices.util.JWebDriver;
import com.radiant.microservices.util.JXMLParser;

@SuppressWarnings("deprecation")
public class BankingAppBalanceEnquiryBQTestScript {

	protected transient final Log log = LogFactory.getLog(getClass());
	private List<WebElementDetails> bankingAppBalanceEnquiryEQWebElementList = null;
	private List<WebElementDataDetails> webElementsData = null;
	
	private TestCaseDetails testCaseDetails = null;
	BankingAppBalanceEnquiry bankingAppBalanceEnquiryEQ;
	
	AppUtil apt = new AppUtil();
	TestSuiteDetails suiteDetails;

	// ==========================================================================

	public BankingAppBalanceEnquiryBQTestScript(TestSuiteDetails testSuiteDetails) {

		this.suiteDetails = testSuiteDetails;
		testCaseDetails = new TestCaseDetails();
		testCaseDetails.setTestSuiteDetailsId(testSuiteDetails.getTestSuiteDetailsId());
	}

	// ==========================================================================

	@BeforeTest
	public void beforeTest() {
		log.info("START of the method beforeTest");
		log.info("END of the method beforeTest");
	}

	// ==========================================================================

	private void setPrerequisites() throws InterruptedException {
		testCaseDetails.setTestCaseName(BankingAppBalanceEnquiryBQTestScript.class.getSimpleName());
		if (bankingAppBalanceEnquiryEQWebElementList == null) {
			bankingAppBalanceEnquiryEQWebElementList = JXMLParser.getInstance().getWebElements(BankingAppBalanceEnquiry.class.getSimpleName());
		}

		if (webElementsData == null) {
		      webElementsData = JExcelParser.getInstance().getDataSet(BankingAppBalanceEnquiry.class.getSimpleName(), BankingAppBalanceEnquiryBQTestScript.class.getSimpleName());
		   }
		
	}

	// ==========================================================================

	@Test(description = "Adding new Group time cycle record")
	public void GetStatementBankingAccount() {
		log.info("START of the method addNewbankingAppBalanceEnquiryEQRecord");
		bankingAppBalanceEnquiryEQ = new BankingAppBalanceEnquiry();
		String customMessage = null;
		WebDriver driver = null;
		
		try {
			testCaseDetails.setMethodName(AppUtil.getMethodName());
			setPrerequisites();
			driver = JWebDriver.getInstance().getWebDriver();
			ResourceBundle resourceBundle = ResourceBundle.getBundle("ApplicationResources");
			driver.get(resourceBundle.getString("application.url"));
			Thread.sleep(6000);
			customMessage = "Click on Add button";
			WebElementDetails userMenuobj = bankingAppBalanceEnquiryEQWebElementList.get(0);
			bankingAppBalanceEnquiryEQ.userMenu(userMenuobj).click();
			Thread.sleep(6000);

			if (bankingAppBalanceEnquiryEQWebElementList != null && bankingAppBalanceEnquiryEQWebElementList.size() > 0) {
				if (webElementsData!=null) {
					for (WebElementDataDetails webElementDataDetails : webElementsData) {
						if (webElementDataDetails.isExecute()) {
							List<String> dataSet = webElementDataDetails.getDataSet();
							if (dataSet != null && dataSet.size() > 0) {
									Actions act = new Actions(driver);
									Thread.sleep(10000);
									JavascriptExecutor js = (JavascriptExecutor) driver;
									js.executeScript("window.scrollBy(0,3000)");
									
									customMessage = "Dialog box GetStatement";
									WebElementDetails accountNumObj = bankingAppBalanceEnquiryEQWebElementList.get(1);
									bankingAppBalanceEnquiryEQ.accountNumberTxtbox(accountNumObj).click();
									bankingAppBalanceEnquiryEQ.accountNumberTxtbox(accountNumObj).clear();
									bankingAppBalanceEnquiryEQ.accountNumberTxtbox(accountNumObj).sendKeys(webElementDataDetails.getDataSet().get(0));
									Thread.sleep(1000);
									 
						 		    customMessage = "Dialog box GetStatement";
									WebElementDetails searchBtnObj = bankingAppBalanceEnquiryEQWebElementList.get(2);
									bankingAppBalanceEnquiryEQ.balanceEnquirySearchbtn(searchBtnObj).click();
									Thread.sleep(4000);
																		
									}
						   }	
						}

					} else {
						log.info(" Unable to execute the script Test data is empty");
					}
					
				} else {
					log.info(" Unable to execute the script as some or all the mandatory objects or values are null");
				}
			} catch (java.lang.AssertionError e) {
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} catch (Exception e) {
				suiteDetails.setTestStatusSuccess(false);
				testCaseDetails = new TAFException().handleException(e, testCaseDetails, customMessage);
			} finally {
				TAFDBManagerHelper.getInstance().saveTestCaseDetails(testCaseDetails);
			}
			log.info("END of the method login");
		}

	// ==========================================================================

	@AfterTest
	public void afterTest() {
		log.info("START of the method afterTest");
		log.info("END of the method afterTest");
	}

	
	// ==========================================================================

	public String handleNavigationPageState() {
		
		String customMessage = "PASS";
				
		return customMessage;
		
	}

	// ==========================================================================

}
