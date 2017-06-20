package me.mach0319.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    EditText editText;
    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView)findViewById(R.id.listview);
        editText = (EditText)findViewById(R.id.editText);
        sendButton = (Button)findViewById(R.id.button);
        userName = "user" + new Random().nextInt(10000);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        listView.setAdapter(adapter);
    }
}
