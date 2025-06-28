package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class RestaurantSystemHooks {

  // use @Before and @After for applying hooks irrespective of tags
  // @Before
  // tagged hooks
  @Before("@SmokeTest")
  public void BeforeDisplayMessage(Scenario sc) {
    System.out.println("before: " + sc.getName());
  }

  // use @Before and @After for applying hooks irrespective of tags
  // @After
  // tagged hooks
  @After("@SmokeTest")
  public void AfterDisplayMessage(Scenario sc) {
    System.out.println("after: " + sc.getName());
  }

}
