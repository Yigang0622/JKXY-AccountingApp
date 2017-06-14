package com.jikexueyuan.accountingt;

import android.util.Log;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Mike on 14/06/2017.
 */

public class RecordBean {

    public enum RecordType {
        RECORD_TYPE_EXPENSE, RECORD_TYPE_INCOME;
    }

    private String uuid;
    private double amount;
    private RecordType type;
    private String category;
    private String remark;
    private String date;
    private long timeStamp;

    public RecordBean(){
        uuid = UUID.randomUUID().toString();
        timeStamp = new Date().getTime();

        Log.d("RecordBean","uuid:"+uuid+"time stamp: "+timeStamp);
        Log.d("RecordBean",DateUtil.getFormattedTime(timeStamp));
    }


}

