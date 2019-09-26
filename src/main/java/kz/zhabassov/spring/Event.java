package kz.zhabassov.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.id = new Random(System.currentTimeMillis()).nextInt(100000000);
        System.out.println(id);
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
