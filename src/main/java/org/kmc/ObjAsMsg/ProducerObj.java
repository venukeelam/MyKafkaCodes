package org.kmc.ObjAsMsg;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerObj
{
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.kmc.ObjAsMsg.ProducerObjSerializer");

        KafkaProducer kafkaProducer=new KafkaProducer(properties);

        ProducerRecord<String, Obj> producerRecord = new ProducerRecord("kmccorp", new Obj("venu", "522", "cse"));
        System.out.println(producerRecord.value().toString());

        kafkaProducer.send(producerRecord);
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
