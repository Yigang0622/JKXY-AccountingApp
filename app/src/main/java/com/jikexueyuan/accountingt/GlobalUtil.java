package com.jikexueyuan.accountingt;

import android.content.Context;

public class GlobalUtil {

    private static GlobalUtil instance;

    public RecordDatabaseHelper recordDatabaseHelper;

    private Context context;

    public static GlobalUtil getInstance() {
        if (instance == null) {
            instance = new GlobalUtil();
        }
        return instance;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        recordDatabaseHelper = new RecordDatabaseHelper(context, RecordDatabaseHelper.DB_NAME, null, 1);
    }


}
