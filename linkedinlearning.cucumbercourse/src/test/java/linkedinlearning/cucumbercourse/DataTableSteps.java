package linkedinlearning.cucumbercourse;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableSteps {

  @Given("I placed an order for the following items")
public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
    // Double, Byte, Short, Long, BigInteger or BigDecimal.
    //
    // For other transformations you can register a DataTableType.

    //List of Strings
    ///*********Begin Code Block for List of strings **********/
		//List<String> BillData = dataTable.transpose().asList(String.class);
		
		//for (String BillItem : BillData) {
		//    System.out.println(BillItem);
		//}
    ///********** End code clock for list of strings **********/
    ///
    ///*********Begin Code Block for list of list of Strings **********/ 
    //List<List<String>> BillData = dataTable.asLists(String.class);

    //for (List<String> BillItems : BillData) {
    //  for (String BillItem : BillItems) {
    //    System.out.println(BillItem);
    //  }
    //}
    ///********** End code clock for list of list of strings **********/
    //list of maps
    List<Map<String, String>> BillData = dataTable.asMaps(String.class, String.class);
		for (Map<String,String> BillItems : BillData) {
			for (Map.Entry<String, String> BillItem : BillItems.entrySet()) {			    
        System.out.println("Key: " + BillItem.getKey());
			  System.out.println("Value: " + BillItem.getValue());
			}
    } 
}

  @When("I generate the bill")
  public void i_generate_the_bill() {
  }

  @Then("a bill for ${int} should be generated")
  public void a_bill_for_$_should_be_generated(Integer int1) {
  }

}
