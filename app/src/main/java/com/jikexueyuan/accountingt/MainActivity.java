package com.jikexueyuan.accountingt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity {

    private TickerView tickerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tickerView = (TickerView) findViewById(R.id.amount_text);
        tickerView.setCharacterList(TickerUtils.getDefaultNumberList());
        tickerView.setText("1000");

        tickerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tickerView.setText("2234");
            }
        });

    }
}
