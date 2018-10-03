package ind.bliu.demo.kafka;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class AppConsumer {
    public static void main(String[] args) {
        runConsumer();
    }

    static void runConsumer() {
        int maxNoMessageFoundCount = Integer.parseInt(System.getProperty(KafkaConstants.ENV_MAX_NO_MESSAGE_FOUND_COUNT, KafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT));
        Consumer<Long, String> consumer = ConsumerCreator.createConsumer();

        int noMessageFound = 0;
        ConsumerRecords<Long, String> consumerRecords;

        while(true) {
            consumerRecords = consumer.poll(1000);
            if (consumerRecords.count() == 0) {
                if (++noMessageFound > maxNoMessageFoundCount) {
                    break;
                } else {
                    continue;
                }
            }

            for (ConsumerRecord<Long, String> consumerRecord : consumerRecords) {
                System.out.println("==========");
                System.out.println("RecordKey:" + consumerRecord.key());
                System.out.println("RecordValue:" + consumerRecord.value());
                System.out.println("Partition:" + consumerRecord.partition());
                System.out.println("RecordOffset:" + consumerRecord.offset());
            }
            consumer.commitAsync();
        }
        System.out.println("consumer is going down.");
        consumer.close();
    }
}
