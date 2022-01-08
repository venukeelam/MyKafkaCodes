package org.kmc.ObjAsMsg;

public class Obj
{
    private String name;
    private String hallticketno;
    private String stream;

    public Obj(String venu, String s, String cse) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHallticketno() {
        return hallticketno;
    }

    public void setHallticketno(String hallticketno) {
        this.hallticketno = hallticketno;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "Obj{" +
                "name='" + name + '\'' +
                ", hallticketno='" + hallticketno + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }
}
