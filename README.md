## Kafka Demo ##

### 概要 ###
Kafka API(Java)を利用した簡単な KafkaProducer と KafkaConsumer。

参考した資料は[こちら](https://dzone.com/articles/kafka-producer-and-consumer-example)。

### 使い方 ###
1. mavenでパッケージング
    ```$xslt
    $ mvn package
    
    // fat jar が作成される
    $ ls -ahl target/KafkaDemo-1.1-SNAPSHOT-jar-with-dependencies.jar 
    -rw-r--r--  1 bliu2  staff    17M Oct  2 18:08 target/KafkaDemo-1.1-SNAPSHOT-jar-with-dependencies.jar 
    ```
1. producer起動
    ```$xslt
    $ java -classpath ./KafkaDemo-1.1-SNAPSHOT-jar-with-dependencies.jar [-DmessageCount=送信するメッセージ数] [-DclientId=producer識別子] [-DtopicName=topic名] [-DkafkaBrokers=brokerリスト] ind.bliu.demo.kafka.AppProducer
    ```
    * messageCount　送信するメッセージ数。指定なしの場合は1000
    * clientId　producerの識別子。指定なしの場合は`client1`
    * topicName　送信先トピック名。指定なしの場合は`mytopic`
    * kafkaBrokers　kafka brokerリスト。指定なしの場合は`10.0.0.62:9092,10.0.0.200:9092,10.0.0.16:9092`
    
1. consumer起動
    ```
    $ java -classpath ./KafkaDemo-1.1-SNAPSHOT-jar-with-dependencies.jar [-DtopicName=topic名] [-DgroupId=consumer group名] [-DoffsetReset=latest|earliest] [-DkafkaBrokers=brokerリスト] [-DmaxNoMessageFoundCount=consumer待機時間] ind.bliu.demo.kafka.AppConsumer
    ```
    * groupId　consumer group名。指定なしの場合は`group1`
    * offsetReset　consumerの受信開始offset（`latest`または`earliest`）。指定なしの場合は`earliest`
    * maxNoMessageFoundCount　consumerが終了するまでに、メッセージ受信しない状態が続く最大時間（秒）。指定なしの場合は`100`
    * topicName　受信先トピック名。指定なしの場合は`mytopic`
    * kafkaBrokers　kafka brokerリスト。指定なしの場合は`10.0.0.62:9092,10.0.0.200:9092,10.0.0.16:9092`
 
