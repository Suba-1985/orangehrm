package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;





//IN JUNIT
//@RunWith(Cucumber.class)
//@CucumberOptions(plugin= {"html:target/cucumber_html_report.html"},
//					features="src/test/resources/Features",
//					glue="stepDefinition",
//					tags="")
//public class TestRunner {
//
//}

 //


//IN TESTNG



//@CucumberOptions(plugin= {"html:target/cucumber_html_report.html"},
//features="src/test/resources/Features",
//glue="stepDefinition")
//
//public class TestRunner extends AbstractTestNGCucumberTests{
//	
//}


@CucumberOptions(
plugin = {"pretty", "html:target/OrangeProReorts.html"}, //reporting purpose
monochrome=false,  //console output color
tags = "", //tags from feature file
features = {"src/test/resources/Features"}, //location of feature files (should be in src/test/reso
glue="stepDefinition")//location of step definition files


public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
}
