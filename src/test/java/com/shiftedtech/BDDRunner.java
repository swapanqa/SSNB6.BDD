package com.shiftedtech;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = { "@Aceptance" },
        //tags = { "@smoke" },         /* smoke test only */
        //tags = { "@Aceptance,@Functional" }, /* debug or smoke test */
        //tags = { "@Smoke","@Functional" },  /* debug and smoke test */
        
		//monochrome = true,
		
        //features = "src/test/resources/features/",
		
        features = "src/test/resources/features/SpreeLogin2.feature",
        
        //features = {"src/test/resources/features/SpreeLogin.feature",
        //            "src/test/resources/features/SpreeLogin2.feature"},
        
        glue = {"com.shiftedtech.steps"},
        
        //dryRun = true,
        
        plugin={
                "pretty:target/cucumber-test-report/cucumber-pretty.txt",
                "html:target/cucumber-test-report",
                "json:target/cucumber-test-report/cucumber-report.json",
                "junit:target/cucumber-test-report/test-report.xml"
        }
	)
public class BDDRunner {

}
