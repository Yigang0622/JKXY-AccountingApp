package com.jikexueyuan.accountingt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;

public class RecordDatabaseHelper extends SQLiteOpenHelper {

    private static String TAG = "RecordDatabaseHelper";

    public static final String DB_NAME = "Record";

    private static final String CREATE_RECORD_DB = "create table Record ("
            + "id integer primary key autoincrement, "
            + "uuid text, "
            + "type integer, "
            + "category text, "
            + "remark text, "
            + "amount double, "
            + "time integer, "
            + "date date)";


    public RecordDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_RECORD_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void addRecord(RecordBean bean){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid", bean.getUuid());
        values.put("type", bean.getType());
        values.put("category", bean.getCategory());
        values.put("remark", bean.getRemark());
        values.put("amount", bean.getAmount());
        values.put("date", bean.getDate());
        values.put("time", bean.getTimeStamp());
        values.put("isUploaded", 0);
        db.insert(DB_NAME, null, values);
        Log.d(TAG,bean.getRemark()+" Added ");
        values.clear();
    }

    public void removeRecord(String uuid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_NAME, "uuid = ?", new String[] { uuid });
    }

    public void editReocrd(String uuid,RecordBean record){
        removeRecord(uuid);
        record.setUuid(uuid);
        addRecord(record);
    }


    public LinkedList<RecordBean> readRecords(String dateStr){

        LinkedList<RecordBean> beanList = new LinkedList<RecordBean>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;

        cursor = db.rawQuery("select DISTINCT * from Record where date = ? order by time asc", new String[]{dateStr});

        if (cursor.moveToFirst()) {
            do {
                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                String category = cursor.getString(cursor.getColumnIndex("subtype"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                Double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                long time = cursor.getLong(cursor.getColumnIndex("time"));

                RecordBean bean = new RecordBean();
                bean.setUuid(uuid);
                bean.setType(type);
                bean.setCategory(category);
                bean.setRemark(remark);
                bean.setAmount(amount);
                bean.setDate(date);
                bean.setTimeStamp(time);



                beanList.add(bean);

            } while (cursor.moveToNext());
        }

        cursor.close();

        return beanList;
    }

    public LinkedList<String> readAvailableDate(){
        LinkedList<String> list = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT * from Record order by date asc", new String[]{});

        if (cursor.moveToFirst()){
            do {
                String date = cursor.getString(cursor.getColumnIndex("date"));

                if (!list.contains(date)){
                    list.add(date);
                }

            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

}
