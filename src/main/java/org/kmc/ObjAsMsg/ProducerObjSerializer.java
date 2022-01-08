package org.kmc.ObjAsMsg;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class ProducerObjSerializer implements Serializer
{
    public void configure(Map map, boolean b)
    {

    }
    public byte[] serialize(String topic, Object object)
    {
        try
        {
            ProducerObj producerObj=(ProducerObj) object;
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(producerObj);
            objectOutputStream.close();
            byte[] bytes=byteArrayOutputStream.toByteArray();
            return bytes;

        }
        catch (Exception Exception)
        {
            return  new byte[0];
        }
    }

    public void close()
    {

    }
}
