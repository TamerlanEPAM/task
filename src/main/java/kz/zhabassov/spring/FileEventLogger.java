package kz.zhabassov.spring;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    protected String fileName;
    protected File file ;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
        file = new File(fileName);
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMsg(),"UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init(){
        File file = new File(fileName);
        file.canWrite();
    }

}
