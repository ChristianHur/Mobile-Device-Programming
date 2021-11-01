package com.christianhur.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Events";

    TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"*** ONCREATE ****");

        txtHello = (TextView) findViewById(R.id.txt_hello);
        String message = txtHello.getText().toString();
        txtHello.setText("Hello Earth!");
    }

    public void goToResult(View view){
        String message = txtHello.getText().toString();
        Intent intent = new Intent(this,Result.class);
        intent.putExtra(Result.RESULT_MSG,message);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"*** STOP ****");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"*** START ****");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"*** RESUME ****");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"*** DESTROY ****");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"*** ONRESTART ****");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"*** PAUSE ****");
    }

}
