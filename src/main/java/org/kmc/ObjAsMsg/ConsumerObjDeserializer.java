package org.kmc.ObjAsMsg;


import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class ConsumerObjDeserializer implements Deserializer
{

    public Obj deserialize(String topic, byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Obj obj = (Obj) objectInputStream.readObject();
            objectInputStream.close();
            return obj;


        } catch (Exception exception) {
            exception.printStackTrace();

        }
        //return new byte[];
        return null;
    }

    public void close() {
        // intentionally left blank
    }
}
