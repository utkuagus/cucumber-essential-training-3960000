package linkedinlearning.cucumbercourse;

import static org.assertj.core.api.Assertions.assertThat;
import io.cucumber.java.en.*;

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

  }
}
