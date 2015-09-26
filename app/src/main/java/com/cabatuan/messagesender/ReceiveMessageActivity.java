package com.cabatuan.messagesender;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cobalt on 9/26/15.
 */
public class ReceiveMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";
    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        // Handle Explicit Intent
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        messageView = (TextView)findViewById(R.id.message);
        messageView.setText(message);

        // Handle Implicit Intent
        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            }

            //else  {
                 // Handle other types of messages
           // }
        }
    }

    public void handleSendText(Intent intent){
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            // Update UI to reflect text being shared
            messageView.setText(sharedText);
        }
    }

}
