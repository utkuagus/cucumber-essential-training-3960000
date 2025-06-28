package linkedinlearning.cucumbercourse;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import io.cucumber.core.options.Constants;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("linkedinlearning.cucumbercourse")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "linkedinlearning.cucumbercourse, hooks")
// filter by tag @SmokeTest
// @IncludeTags("SmokeTest")
// filter by tag @SmokeTest OR @NightlyBuildTest
// @IncludeTags("SmokeTest | NightlyBuildTest")
// filter by tag @NightlyBuildTest AND @RegularTest
// @IncludeTags("NightlyBuildTest & RegularTest")
// filter by NOT condition
// @IncludeTags("! NightlyBuildTest")
// alternate syntax filter by tag @SmokeTest will "run" three and skip two
// scenarios
// @ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value =
// "@SmokeTest")
// alternate syntax filter by tag @NightlyBuildTest and @RegularTest
// @ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value =
// "@NightlyBuildTest and @RegularTest")
// alternate syntax filter by tag OR condition
// @ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value =
// "@NightlyBuildTest or @RegularTest")
// you can apply filters from Maven. Just remove any filters on this class and
// run only the first test and skip the other two
// mvn test -Dcucumber.filter.tags="@SmokeTest"
// skip all three tests
// mvn test -Dcucumber.filter.tags="@SmokeTest and @RegularTest"
// run only one test
// mvn test -Dcucumber.filter.tags="@NightlyBuildTest and @RegularTest"
// uncomment next two lines to run reports
// @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, 
// value = "junit:target/cucumber-reports/Cucumber.xml, json:target/cucumber-reports/Cucumber.json, html:target/cucumber-reports/Cucumber.html, timeline:target/cucumber-reports/CucumberTimeline")
// uncomment next two lines to test with dry run = true
// @ConfigurationParameter( key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,
// value = "true")
public class RunCucumberTest {
}
