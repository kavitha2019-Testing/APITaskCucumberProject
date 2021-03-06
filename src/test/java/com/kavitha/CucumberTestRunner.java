package com.kavitha;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="./src/test/resources/features/APITask.feature",
      glue = {"steps"},
        //tags={"@LoginFailure or @loginSuccess"},
        plugin = {"pretty", "html:target/cucumber"},
       monochrome = true,strict = true)
public class CucumberTestRunner {
}



