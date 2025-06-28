package linkedinlearning.cucumbercourse;

import static org.assertj.core.api.Assertions.assertThat;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

public class ScenarioOutlineSteps {

  int InitialBillAmount;
  double TaxRate;

  @Given("I have a customer")
  public void i_have_a_Customer() {

  }

  @Given("User enters initial bill amount as {int}")
  public void user_enters_intial_bill_amount_as(Integer initialBillAmount) {
    this.InitialBillAmount = initialBillAmount;
    System.out.println("InitialBillAmount: " + initialBillAmount);
  }

  @Given("Sales Tax Rate is {double} Percent")
  public void sales_Tax_Rate_is_Percent(Double taxRate) {
    this.TaxRate = taxRate;
    System.out.println("Tax Rate: " + taxRate);
  }

  @Then("final bill amount calculated is {double}")
  public void final_bill_amount_calculate_is(Double expectedValue) {
    double SystemCalcValue = BillCalculationHelper.CalculateBillForCustomer(this.InitialBillAmount, this.TaxRate);
    System.out.println("Expected Value: " + expectedValue);
    System.out.println("Calculated Value: " + SystemCalcValue);
    assertThat(expectedValue).isEqualTo(SystemCalcValue);

    // ********Begin Code for Selenium based Automation*********/
    // String WebpageResponse = invokeWebPage(expectedValue);
    // safer option is to use WebpageResponse.endsWith
    // assertThat(WebpageResponse.endsWith("Final Bill Amount is: $" +
    // expectedValue)).isTrue();
    // ********End Code for Selenium based Automation*********/

    String WebpageResponse = invokeWebPagePlaywright(expectedValue);
    System.out.println("Page Response: " + WebpageResponse);
    assertThat(WebpageResponse.contains("Final Bill Amount is: $" + expectedValue)).isTrue();
  }

  private String invokeWebPage(double expectedValueForWebpage) {
    // set chrome options to not use sandbox
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--no-sandbox");
    // initialize web driver
    WebDriver driver = new ChromeDriver(options);
    driver.get("http://127.0.0.1:8000");
    // set the initial bill amount value on web page's bill amount textbox
    WebElement BillAmountTextBox = driver.findElement(By.id("id_billamount"));
    CharSequence InitialBillAmountString = Integer.toString(InitialBillAmount);
    BillAmountTextBox.sendKeys(InitialBillAmountString);
    // set tax rate on web page's tax rate
    WebElement TaxRateTextBox = driver.findElement(By.id("id_taxrate"));
    CharSequence TaxRateString = Double.toString(TaxRate);
    TaxRateTextBox.sendKeys(TaxRateString);
    // click the button through automation code
    WebElement CalculateButton = driver.findElement(By.id("mybutton"));
    CalculateButton.click();
    // print and extract response
    WebElement Header3Element = driver.findElement(By.xpath("//h3"));
    System.out.println(Header3Element.getText());
    String WebPageResponse = Header3Element.getText();
    // close page
    driver.quit();
    // return response
    return WebPageResponse;
  }

  private String invokeWebPagePlaywright(double expectedValueForWebpage) {
    
    System.out.println("CALLING PLAYWRIGHT");
    String Response = "";
    try (Playwright playwright = Playwright.create()) {
      //launch browser with the right settings
      LaunchOptions options = new LaunchOptions();
      options.headless = false;
      options.chromiumSandbox = false;
      options.setSlowMo(1000);
      Browser browser = playwright.chromium().launch(options);
      Page page = browser.newPage();
      //navigate to the Python Djanfo website
      page.navigate("http://127.0.0.1:8000");
      //set values
      page.fill("#id_billamount", Integer.toString(InitialBillAmount));
      page.fill("#id_taxrate", Double.toString(TaxRate));
      //click button
      page.waitForSelector("#mybutton");
      page.click("#mybutton");
      //read and return response
      Response = page.textContent("h3:first-of-type");
      browser.close();
      return Response;
    }
  }
}
