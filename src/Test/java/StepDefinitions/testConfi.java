package StepDefinitions;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;

@TestConfiguration
@TestPropertySource
public class testConfi {


    public class Monogo {

        @Value("${mongo.database}")
        private String mongoDatabase;

        @Bean
        public MongoClient mongoClientForTest() {
            return MongoClients.create("mongodb://localhost:27017");

        }

        @Bean
        public MongoTemplate mongoTemplateTest(final MongoClient mongoClient){
            return new MongoTemplate(mongoClient, mongoDatabase );
        }
    }

}
