package com.example.topway.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SendBroadCast(View view ){
       // Intent intent=new Intent(this,MyBroadCastReceiver.class);
        Intent intent=new Intent("my.custom.action.name");
        intent.putExtra("name","Siddique");
        intent.putExtra("age",10);
        sendBroadcast(intent);
    }

    public void MyThirdBroadCastReceiver(View view){
       // Intent intent=new Intent(this,MyThirdBroadCastReceiver.class);
        Intent intent2=new Intent();
        Intent intent=new Intent("my.custom.thirdBroadCastReceiver");

        Bundle bundle=new Bundle();
        bundle.putString("name","Siddique khan");
        bundle.putInt("age",220);
        intent.putExtras(bundle);
        sendBroadcast(intent);
    }


    public static class MyThirdBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String name;
            int age;
            name=intent.getExtras().getString("name");
            age=intent.getExtras().getInt("age");
            
            Log.d(TAG, "onReceive: This is the third broad cast receiver ");
            Toast.makeText(context, "This is done by siddique khan "+name
                    +" \n My age is "+age, Toast.LENGTH_LONG).show();
        }
    }
}
