package io.project.app.services;

/**
 *
 * @author gevorga
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "kafkaTopic")
    public void consume(String message) {
        logger.info(String.format("$$$$ => Consumed message: %s", message));
    }
}