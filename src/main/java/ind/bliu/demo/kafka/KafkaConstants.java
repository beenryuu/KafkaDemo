package ind.bliu.demo.kafka;

public interface KafkaConstants {
    public static String KAFKA_BROKERS = "10.0.0.62:9092,10.0.0.200:9092,10.0.0.16:9092";
    public static String MESSAGE_COUNT = "1000";
    public static String CLIENT_ID = "client1";
    public static String TOPIC_NAME = "mytopic";
    public static String GROUP_ID_CONFIG = "group1";
    public static String MAX_NO_MESSAGE_FOUND_COUNT = "100";
    public static String OFFSET_RESET_LASTEST = "latest";
    public static String OFFSET_RESET_EARLIES = "earliest";
    public static Integer MAX_POLL_RECORDS = 1;

    public static String ENV_KAFKA_BROKERS = "kafkaBrokers";
    public static String ENV_MESSAGE_COUNT = "messageCount";
    public static String ENV_CLIENT_ID = "clientId";
    public static String ENV_TOPIC_NAME = "topicName";
    public static String ENV_GROUP_ID = "groupId";
    public static String ENV_MAX_NO_MESSAGE_FOUND_COUNT = "maxNoMessageFoundCount";
    public static String ENV_OFFSET_RESET = "offsetReset";
}
