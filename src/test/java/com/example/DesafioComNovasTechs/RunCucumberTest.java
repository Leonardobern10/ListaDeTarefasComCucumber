package com.example.DesafioComNovasTechs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith( Cucumber.class )
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.DesafioComNovasTechs.steps",
        plugin = {"pretty"}
        //tags = "@all" -> Define quais cenários executar (ex: cenários com a tag "@all")
)
public class RunCucumberTest {
}
