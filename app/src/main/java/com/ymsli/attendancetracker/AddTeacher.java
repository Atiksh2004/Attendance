package com.ymsli.attendancetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddTeacher extends AppCompatActivity {


    private EditText mTName, mTSurname, mTClass;
    private Button button1;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Teachers");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        mTName = findViewById(R.id.tName);
        mTSurname = findViewById(R.id.tSurname);
        mTClass = findViewById(R.id.tClass);

        button1 = findViewById(R.id.teacherAdd);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String teacherName = mTName.getText().toString();
                String teacherSurname = mTSurname.getText().toString();
                String teacherClass = mTClass.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("First Name", teacherName);
                userMap.put("Surname",teacherSurname);
                userMap.put("Class", teacherClass);

                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AddTeacher.this, "Teacher added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
