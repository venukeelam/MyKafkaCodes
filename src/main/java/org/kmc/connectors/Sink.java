package org.kmc.connectors;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.io.*;
import java.util.Collections;
import java.util.Properties;

public class Sink
{
    public static void main(String[] args)
    {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"conneectgfhroup0");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");

        KafkaConsumer kafkaConsumer=new KafkaConsumer<>(properties);
        kafkaConsumer.subscribe(Collections.singletonList("connect-venu"));
        try {

           BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("c:\\KafkaConnect\\venuSink.txt"));

            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(100);
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords)
                {
                    System.out.println("key : " + consumerRecord.key() + "  value : " + consumerRecord.value() + "  offset : " + consumerRecord.offset()+"   group_id : "+consumerRecord.topic());
                    bufferedWriter.write(consumerRecord.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
