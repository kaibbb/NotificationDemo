package com.dtcj.liukai.notificationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Author: liuk
 * Created at: 16/3/31
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("DetailActivity");
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String detail = getIntent().getStringExtra("detail");

        ((TextView)findViewById(R.id.name)).setText(name);
        ((TextView)findViewById(R.id.description)).setText(description);
        ((TextView)findViewById(R.id.detail)).setText(detail);
    }
}
