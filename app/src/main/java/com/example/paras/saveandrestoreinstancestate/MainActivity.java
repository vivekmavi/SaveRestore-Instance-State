package com.example.paras.saveandrestoreinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // app to show usage of onSaveInstanceState() and onRestoreInstanceState().
    //it counts how many times onResume was called.

    int count =0;
    TextView tv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        count++;
        tv = (TextView) findViewById(R.id.textView_1);
        tv.setText("counter is : "+count);
    }

   @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count_key",count);
        Log.d("tag_dena_h", count+" saved");
        Toast.makeText(this, count+" saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("count_key");
        Log.d("tag_dena_h",count+" restored");
        Toast.makeText(this, count+" restored", Toast.LENGTH_SHORT).show();
    }
}
