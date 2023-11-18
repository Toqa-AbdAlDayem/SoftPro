package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C://Users//PC//Desktop//selcuc//selcuc//src//Test//resources//features" ,
        glue = "StepDefinitions"
)



public class acceptanceTest {
}
