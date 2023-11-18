/*
package StepDefinitions;


import com.app.customer.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = SpringJdbcTemplate2OracleApplication.class)
@CucumberContextConfiguration
@ContextConfiguration(classes = {SpringJdbcTemplate2OracleApplication.class, AppointmenRepository.class, AppointmentService.class, CustomerRepository.class, CustomerController.class, SpringIntegrationTest.class})

@ComponentScan(basePackages = {"StepDefinitions", "com.app.customer"})
public class SpringIntegrationTest {

    @Before
    public void setUp() {
        System.out.println("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
}



*/
