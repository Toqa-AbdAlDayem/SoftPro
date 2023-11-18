package com.app.customer;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@PropertySource("classpath:monoGo.properties")
public class Monogo {
    @Value("${mongo.database}")
    private String mongoDatabase;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");

    }

    @Bean
    public MongoTemplate mongoTemplate(final MongoClient mongoClient){
        return new MongoTemplate(mongoClient, mongoDatabase );
    }
}