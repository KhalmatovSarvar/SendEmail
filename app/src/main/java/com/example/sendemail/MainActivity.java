package com.example.sendemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText edtSendTo;
    EditText edtTopic;
    EditText edtMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    void initViews(){
        btnSend = findViewById(R.id.btn_send);
        edtSendTo = findViewById(R.id.edtReciever);
        edtTopic = findViewById(R.id.edtTopic);
        edtMessage = findViewById(R.id.edtMessage);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }
    void sendMessage(){
        String receiver = edtSendTo.getText().toString();
        String topic = edtTopic.getText().toString();
        String message = edtMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {receiver});
        intent.putExtra(Intent.EXTRA_SUBJECT, topic);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent,"Choose an Email... "));
    }
}