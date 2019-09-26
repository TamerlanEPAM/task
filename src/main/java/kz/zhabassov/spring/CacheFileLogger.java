package kz.zhabassov.spring;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger  extends FileEventLogger{
    private int cashSize = 2;
    private List<Event> cache;

    public CacheFileLogger(String fileName) {
        super(fileName);
    }

    public CacheFileLogger(String fileName, int cashSize) {
        super(fileName);
        this.cashSize = cashSize;
    }

    @Override
    public void logEvent(Event event) {
        cache = new ArrayList<>();
        cache.add(event);
        if(cache.size() == cashSize){
            writeEventsCache();
            cache.clear();
        }
    }

    private void writeEventsCache() {
        for (Event event: cache) {
            try {
                FileUtils.writeStringToFile(file, event.getMsg(), "UTF-8", true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void destroy(){
        if(!cache.isEmpty()){
            writeEventsCache();
        }
    }
}
