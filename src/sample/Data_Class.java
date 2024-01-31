package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Data_Class implements Serializable {
    private static final long serialVersionUID=42L;  // 2020139 all under new scheme done
    private static Data_Class dc;
    private ArrayList<Data_Record> data_Files;
    public Data_Class() {
        data_Files = new ArrayList<Data_Record>();
    }
    public void addData(Data_Record d) {
        data_Files.add(d);
    }

    public void removeData(Data_Record d) {
        if (data_Files.contains(d)) data_Files.remove(d);
    }

    public static void deleteAllProgress() {
        dc = new Data_Class();
    }

    public ArrayList<Data_Record> getDatabaseFiles() {
        return data_Files;
    }



}
