package com.jikexueyuan.accountingt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class MainFragment extends Fragment {



    private View rootView;

    private ListView listView;
    private TextView textView;
    private ListViewAdapter adapter;
    private String date = "";
    private LinkedList<RecordBean> beanList;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return rootView;
    }



    public MainFragment(String date ) {
        this.date = date;
        beanList = new LinkedList<>();
        Log.d("Frag",date);

        beanList.add(new RecordBean());
        beanList.add(new RecordBean());
        beanList.add(new RecordBean());
        beanList.add(new RecordBean());

    }


    private void initView(){

        listView = (ListView) rootView.findViewById(R.id.main_listView);
        textView = (TextView) rootView.findViewById(R.id.day_textView);

        textView.setText(date);
        adapter = new ListViewAdapter(getContext());
        adapter.setData(beanList);
        listView.setAdapter(adapter);


        if (adapter.getCount() > 0){
            rootView.findViewById(R.id.layout_no_record_today).setVisibility(View.INVISIBLE);
        }

       // textView.setText(getDate());

       // refresh();

    }




}
