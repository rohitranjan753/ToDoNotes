package com.example.todonotes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Thread.sleep;

public class AddNotesActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private Button mButton;
    private EditText mTitle,mContent;
    private String uid;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        mTitle = findViewById(R.id.titleId);
        mContent = findViewById(R.id.contentId);
        mButton = findViewById(R.id.submitButton);

        uid = ""+System.currentTimeMillis();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("parentNotes").child(uid);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String curTime=""+System.currentTimeMillis();

                final String title = mTitle.getText().toString();
                final String content  = mContent.getText().toString();

                mDatabase.child("title").setValue(title);
                mDatabase.child("content").setValue(content);
                mDatabase.child("tstamp").setValue(curTime);
                progressDialog = new ProgressDialog(AddNotesActivity.this);
                progressDialog.setMessage("Saving Information");
                progressDialog.show();
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
                Toast.makeText(AddNotesActivity.this, "Saved!!", Toast.LENGTH_SHORT).show();
//                finish();
            }
        });

    }
}