package com.kotak.testCases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.kotak.Base.TestBase;
import com.kotak.pageObjects.KotakHomepage;
import com.kotak.utilities.ExtentListeners;
import com.kotak.utilities.TestData;
public class KotakHomePageTest extends TestBase {
	TestData testdata;
	ExtentListeners e=new ExtentListeners();
//An_ExtentReport extentTest=new An_ExtentReport();
	public static KotakHomepage homepage;
	@Test
	public void TC01_ExplorePoduct() throws Exception
	{
		driver.get(baseUrl);
		homepage=new KotakHomepage(driver);

		//click on explore product 
		Actions act=new Actions(driver);
		act.moveToElement(homepage.getExploreProduct()).perform();

		//click on loan 
		homepage.getLoan().click();

		//click on personal loan 
		homepage.getPersonalLoan().click();
		Assert.assertEquals(driver.getCurrentUrl(),homepage.personalLoanUrl);
		e.test.log(Status.INFO,"page Navigate Successfully ");
		
		LogoIsPresent();
		e.test.log(Status.INFO,"logo is present on personal loan page" );
	
		
		FooterIsPresent();
		//e.test.log(Status.INFO,"Footer is present on personal loan page" );
	

		//click on EMI Calculator 
		homepage.getEMICalculator().click();
		Assert.assertEquals(driver.getCurrentUrl(),homepage.EMIUrl);
		
		try {
			testdata = new TestData();
			double p=testdata.Principal;
			double r=testdata.rate;
			double y1=testdata.year;

		    int principal = (int)Math.round(p);

			//get loan Data from excel file 
		
			homepage.getLoanAmount().clear();
			homepage.getLoanAmount().sendKeys(String.valueOf(p));
			
			homepage.getInterest_rate().clear();
			homepage.getInterest_rate().sendKeys(String.valueOf(r));
			
			homepage.getLoan_Amount().clear();
			homepage.getLoan_Amount().sendKeys(String.valueOf(y1),Keys.ENTER);

			String EMIAmt=homepage.getEMIamount().getText();
			String emiAmt=EMIAmt.replaceAll(",","");
			int value1=Integer.parseInt(emiAmt);

			//Assertion on EMI amount
			double emiAmount=emi_calculator(principal,r,y1);
			int value2 = (int)Math.round(emiAmount);
			Assert.assertEquals(value1,value2,"Assertion on EMI amount not is successfull ");
			e.test.log(Status.INFO,"Assertion on EMI amount is successfull" );

			//for Principal assertion 
			String princ=homepage.getPrincipal_amt().getText();
			String PrincAmt=princ.replaceAll(",","");
			
			int PrincipalAmount=Integer.parseInt(PrincAmt);
			int P_Amount=(int)Math.round(p);

			Assert.assertEquals(PrincipalAmount,P_Amount,"Assertion on Principal amount is not successfull");
			e.test.log(Status.INFO,"Assertion on Principal amount is successfull" );

			//for interest payable 
			String inter_pay=homepage.getInterest_payable().getText();
			String inter_Amt=inter_pay.replaceAll(",","");
			int I_Amount=Integer.parseInt(inter_Amt);
			int totalamount=P_Amount+I_Amount;

			//for total amount 
			String total=homepage.getTotal_payment().getText();
			String totalAmt=total.replaceAll(",","");
			Assert.assertEquals(Integer.parseInt(totalAmt),totalamount);
			e.test.log(Status.INFO,"assertion on total amount is successfull");
		
		} catch (Exception e) {
			e.printStackTrace();
		} 

		//logo is present 
		LogoIsPresent();
		e.test.log(Status.INFO,"logo is present on EMI page " );
				
		//footer display 
		FooterIsPresent();
		e.test.log(Status.INFO," footer is present on EMI page " );
		

	}

//	@Test
//	public void BrokenLinks() throws InterruptedException, IOException
//	{
//		driver.get(baseUrl);
//		driver=Brokenlinks();
//	}

	public static void LogoIsPresent()
	{
		Assert.assertTrue(homepage.getLogo().isDisplayed(),"logo is not present");
		

	}
	
	public static void FooterIsPresent()
	{
		Assert.assertTrue(homepage.getFooter().isDisplayed(),"footer is not present");
	 
	}
	public	static double emi_calculator(double p,double r, double t)
	{
		double emi;

		r = r / (12 * 100); 
		t = t * 12; 
		emi = (p * r * (float)Math.pow(1 + r, t)) 
				/ (float)(Math.pow(1 + r, t) - 1);
		return emi;
	}
}












