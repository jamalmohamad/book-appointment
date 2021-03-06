package com.codeinbp.bookappointment.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDbConfiguration {

     @Bean
     public DynamoDBMapper dynamoDBMapper() {
          return new DynamoDBMapper(buildAmazonDynamoDB());
     }


     private AmazonDynamoDB buildAmazonDynamoDB() {
          return AmazonDynamoDBClientBuilder
                  .standard()
                  .withEndpointConfiguration(
                          new AwsClientBuilder.EndpointConfiguration(
                                  "dynamodb.us-east-2.amazonaws.com",
                                  "us-east-2"
                          )
                  )
                  .withCredentials(
                          new AWSStaticCredentialsProvider(
                                  new BasicAWSCredentials(
                                          AwsConfig.AWS_ACCESS_KEY,
                                          AwsConfig.AWS_SECRET_KEY
                                  )
                          )
                  )
                  .build();
     }


}
