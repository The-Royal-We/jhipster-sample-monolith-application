package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.JhipsterSampleMonolithApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jhipster-sample-monolith-application-kafka")
public class JhipsterSampleMonolithApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleMonolithApplicationKafkaResource.class);

    private JhipsterSampleMonolithApplicationKafkaProducer kafkaProducer;

    public JhipsterSampleMonolithApplicationKafkaResource(JhipsterSampleMonolithApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
