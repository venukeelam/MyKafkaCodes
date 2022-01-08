package org.kmc.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Synchronus
{
    public static void main(String[] args)
    {
        Properties properties=new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer kafkaProducer=new KafkaProducer(properties);

        ProducerRecord<String,String> producerRecord=new ProducerRecord<String, String>("kmccorp","company");

        try
        {
            kafkaProducer.send(producerRecord).get();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }


    }
}
