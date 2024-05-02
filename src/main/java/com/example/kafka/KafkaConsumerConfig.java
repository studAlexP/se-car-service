package com.example.kafka;

import com.example.dto.BookingRequestDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${bootstrap.server}")
    private String BOOTSTRAP_SERVER;

    @Value("${group.id}")
    private String GROUP_ID;

    @Value("${trusted.packages}")
    private String TRUSTED_PACKAGES;

    @Bean
    public Map<String, Object> consumerConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, TRUSTED_PACKAGES);

        return configProps;
    }

    @Bean
    public ConsumerFactory<String, BookingRequestDto> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, BookingRequestDto> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, BookingRequestDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
