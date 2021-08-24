package com.ymsli.attendancetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdminHome extends AppCompatActivity {
    Button btnLogout;
    Button btnAddStudent, btnAddTeacher;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        btnLogout = findViewById(R.id.logout);
        btnAddStudent = findViewById(R.id.add_student);
        btnAddTeacher = findViewById(R.id.add_teacher);





        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(AdminHome.this, MainActivity.class);
                startActivity(intToMain);
            }
        });


        btnAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTeacher = new Intent(AdminHome.this, AddTeacher.class);
                startActivity(addTeacher);
            }
        });

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addStudent = new Intent(AdminHome.this, AddStudent.class);
                startActivity(addStudent);
            }
        });

    }
}

