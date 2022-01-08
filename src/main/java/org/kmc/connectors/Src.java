package org.kmc.connectors;

import java.io.*;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class Src
{
    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

          BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\KafkaConnect\\venu.txt")));

            KafkaProducer kafkaProducer = new KafkaProducer(properties);
            while (true)
            {
                String string=bufferedReader.readLine();
                if(string == null)
              {

              }
                else
              {
                    ProducerRecord<String, File> producerRecord = new ProducerRecord("connect-venu", string);
                    System.out.println(producerRecord.value());
                    kafkaProducer.send(producerRecord);
                    kafkaProducer.flush();
                }
            }

        }

    }
