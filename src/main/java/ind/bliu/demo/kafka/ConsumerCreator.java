package ind.bliu.demo.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerCreator {
    public static Consumer<Long, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, System.getProperty(KafkaConstants.ENV_KAFKA_BROKERS, KafkaConstants.KAFKA_BROKERS));
        props.put(ConsumerConfig.GROUP_ID_CONFIG, System.getProperty(KafkaConstants.ENV_GROUP_ID, KafkaConstants.GROUP_ID_CONFIG));
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, KafkaConstants.MAX_POLL_RECORDS);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, System.getProperty(KafkaConstants.ENV_OFFSET_RESET, KafkaConstants.OFFSET_RESET_EARLIES));
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, System.getProperty(KafkaConstants.ENV_CLIENT_ID, KafkaConstants.CLIENT_ID));

        Consumer<Long, String> consumer = new KafkaConsumer<Long, String>(props);
        consumer.subscribe(Collections.singletonList(System.getProperty(KafkaConstants.ENV_TOPIC_NAME, KafkaConstants.TOPIC_NAME)));
        return consumer;
    }
}
