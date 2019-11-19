package ru.bkmz.server;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    static public TextView tv;
    Button b;
    Client client;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text);
        b = findViewById(R.id.button);
        client = new Client();
        t = new Thread(client, "client");
        t.start();
    }

    public void out(View view) {
        client.sendData("123");
    }


}
