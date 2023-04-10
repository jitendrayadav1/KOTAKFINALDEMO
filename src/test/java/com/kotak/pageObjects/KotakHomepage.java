package com.kotak.pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KotakHomepage {

	WebDriver ldriver;
	public static String personalLoanUrl="https://www.kotak.com/en/personal-banking/loans/personal-loan.html";

	public static String EMIUrl="https://www.kotak.com/en/personal-banking/loans/personal-loan/personal-loan-emi-calculator.html";

	public KotakHomepage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	//click on Explore Product 
	
	//@FindBy(xpath="//li[@class='dropdown analytics-links']") WebElement exploreProduct;
	@FindBy(xpath="(//li[@class='dropdown analytics-links analytics-line-break'])[1]") WebElement exploreProduct;

	public WebElement getExploreProduct() {
		return exploreProduct;
	}

	//click on loan
	@FindBy(xpath="//ul[@class='tabs-list drop-tabs-list']//li[4]")WebElement loan;
	public WebElement getLoan() {
		return loan;
	}

	//click on personal loan 
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[4]/div[1]/div[1]/ul[1]/li[3]/a[1]") WebElement personalLoan;
	public WebElement getPersonalLoan() {
		return personalLoan;
	}

	//click on EMI Calculator tab 
	@FindBy(xpath="//a[@data-id='calculator1520598575344']") WebElement EMICalculator;

	public WebElement getEMICalculator() {
		return EMICalculator;


	}
	//loan requirment
	@FindBy(xpath="//input[@id='amt']") WebElement loanAmount;

	public WebElement getLoanAmount() {
		return loanAmount;
	}
	//interest rate 
	@FindBy(xpath="//input[@id='per']")WebElement interest_rate;

	public WebElement getInterest_rate() {
		return interest_rate;
	}

	//loan amount 
	@FindBy(xpath="//input[@id='yr']") WebElement Loan_Amount;

	public WebElement getLoan_Amount() {
		return Loan_Amount;
	}

	 //get EMI amount 
	@FindBy(xpath="//p[@class='f48 emi_value']")WebElement EMIamount;

	public WebElement getEMIamount() {
		return EMIamount;
	}
	
	//get Principal amount for assertion 
	@FindBy(xpath="//p[@class='f24 total_principal']") WebElement principal_amt;

	public WebElement getPrincipal_amt() {
		return principal_amt;
	}
	
	//get interest payable for assertion 
	@FindBy(xpath="//p[@class='f24 total_interest']") WebElement interest_payable;

	public WebElement getInterest_payable() {
		return interest_payable;
	}

    //get total payment 
	@FindBy(xpath="//p[@class='f24 total_payment']") WebElement total_payment;

	public WebElement getTotal_payment() {
		return total_payment;
	}

	
	//footer display
	@FindBy(xpath="//footer[@class='footer']") WebElement footer;

	public WebElement getFooter()
	{
		return footer;
	}

	//logo is display 
	@FindBy(xpath="//img[@class=' lazyloaded'][1]")WebElement logo;

	public WebElement getLogo() {
		return logo;
	}
	
	
}