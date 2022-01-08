package org.kmc.producers;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class Asynchronus
{
    public static void main(String[] args)
    {
        Properties properties=new Properties();


        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer=new KafkaProducer(properties);

        ProducerRecord< String, String> producerRecord=new ProducerRecord<String, String>("kmccorp", "software kmc company");


        kafkaProducer.send(producerRecord, new Callback()
        {
            public void onCompletion(RecordMetadata metadata, Exception exception)
            {
                if (exception == null)
                {
                    System.out.println("receive info about metadeta : "+"\n topic :"+metadata.topic()+"\n partition :"+metadata.partition()+"\n offset :"+metadata.offset()+"\n timestamp :"+metadata.timestamp());
                }
                else
                {
                    System.out.println("error while producing : "+exception);
                }

            }
        });
        kafkaProducer.flush();
        kafkaProducer.close();

    }
}
