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

public class AddStudent extends AppCompatActivity {


    private EditText mName, mSurname, mDob, mClass, rNum;
    private Button button;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("Students");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        mName = findViewById(R.id.name);
        mSurname = findViewById(R.id.surname);
        mDob = findViewById(R.id.dob);

        button = findViewById(R.id.studentAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                String surname = mSurname.getText().toString();
                String dob = mDob.getText().toString();
                String sClass = mClass.getText().toString();
                String rollNum = rNum.getText().toString();

                HashMap<String, String> userMap = new HashMap<>();

                userMap.put("First Name", name);
                userMap.put("Surname",surname);
                userMap.put("Class", sClass);
                userMap.put("Roll Number", rollNum);


                root.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(AddStudent.this, "Student added", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
