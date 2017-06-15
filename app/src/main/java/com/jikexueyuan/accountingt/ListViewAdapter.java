package com.jikexueyuan.accountingt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class ListViewAdapter extends BaseAdapter {


    private LayoutInflater mInflater;
    private Context mContext;

    private LinkedList<RecordBean> records = new LinkedList<>();

    public ListViewAdapter(Context context){
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }


    public void setData(LinkedList<RecordBean> records){
        this.records = records;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return records.size();
    }

    @Override
    public Object getItem(int i) {
        return records.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        ViewHolder holder;
        if(view == null)
        {

            view = mInflater.inflate(R.layout.cell_list_view, null);

            final RecordBean bean = (RecordBean) getItem(i);
            holder = new ViewHolder(view,bean);

            view.setTag(holder);

        }else {
            holder = (ViewHolder)view.getTag();
        }



        return view;


    }
}



class ViewHolder{

    TextView remarkTV;
    TextView amountTV;
    TextView timeTV;
    ImageView typeIcon;

    public ViewHolder(View itemView,RecordBean record){
        remarkTV = (TextView) itemView.findViewById(R.id.textView_remark);
        amountTV = (TextView) itemView.findViewById(R.id.textView_amount);
        timeTV = (TextView) itemView.findViewById(R.id.textView_time);
        typeIcon = (ImageView) itemView.findViewById(R.id.imageView_type);
    }



}