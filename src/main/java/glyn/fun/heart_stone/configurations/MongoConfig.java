package glyn.fun.heart_stone.configurations;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "glyn.fun.heart_stone")
public class MongoConfig {
    private static final MongoClientURI uri = new MongoClientURI("mongodb+srv://heart_stone:heart_stone@heart-stone-nres7.mongodb.net/");
    private static final String DB_NAME = "heart-stone";

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        System.out.println(mongoClient == mongoClient());
        return new MongoTemplate(mongoClient, DB_NAME);
    }
}
