package linkedinlearning.cucumbercourse;

import io.cucumber.java.en.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class MenuManagementSteps {
  RestaurantMenuItem NewMenuItem;
  RestaurantMenu LocationMenu = new RestaurantMenu();

  @Given("I have a menu item with name {string} and price {int}")
  public void i_have_a_menu_item_with_name_and_price(String menuItemName, Integer price) {

    NewMenuItem = new RestaurantMenuItem(menuItemName, menuItemName, price);
    System.out.println("Step 1");
  }

  @When("I add that menu item")
  public void i_add_that_menu_item() {
    LocationMenu.addMenuItem(NewMenuItem);
    System.out.println("Step 2");
  }

  @Then("Menu Item with name {string} should be added")
  public void menu_Item_with_name_should_be_added(String string) {
    boolean ItemExists = LocationMenu.DoesItemExist(NewMenuItem);
    assertThat(ItemExists).isEqualTo(true);
    System.out.println("Step 3: " + ItemExists);
    assertThatNoException();
  }

}
