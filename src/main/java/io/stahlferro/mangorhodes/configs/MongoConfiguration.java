package io.stahlferro.mangorhodes.configs;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.UuidRepresentation;
import org.bson.codecs.UuidCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@Slf4j
public class MongoConfiguration extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.uuidRepresentation(UuidRepresentation.STANDARD);
    }
}
