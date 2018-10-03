package ind.bliu.demo.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class AppProducer {
    public static void main(String[] arg) {
        runProducer();
    }

    static void runProducer() {
        Producer<Long, String> producer = ProducerCreator.createProducer();
        int messageCount = Integer.parseInt(System.getProperty(KafkaConstants.ENV_MESSAGE_COUNT, KafkaConstants.MESSAGE_COUNT));
        String topicName = System.getProperty(KafkaConstants.ENV_TOPIC_NAME, KafkaConstants.TOPIC_NAME);

        for(int index = 1; index <= messageCount; index++) {
            ProducerRecord<Long, String> producerRecord = new ProducerRecord<Long, String>(topicName, (long)index,"This is record " + index);

            try {
                RecordMetadata metadata = producer.send(producerRecord).get();
                System.out.println("==========");
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition() + " with offset " + metadata.offset());
            } catch (ExecutionException e) {
                System.out.println("Error in sending record.");
                System.out.println(e);
            } catch (InterruptedException e) {
                System.out.println("Error in sending record.");
                System.out.println(e);
            }
        }
    }
}
