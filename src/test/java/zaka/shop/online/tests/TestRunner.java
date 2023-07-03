package zaka.shop.online.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    plugin = {
      "pretty",
      "html:target/CucumberReport/cucumber-report.html",
      "json:target/CucumberReport/CucumberReport.json",
      "junit:target/CucumberReport/CucumberReport.xml"
    },
    glue = "zak.aga.shop.online",
    tags = "@Smoke",
    monochrome = true)
public class TestRunner {}
