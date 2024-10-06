package com.example.gbmain;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser()!=null){

            startActivity(new Intent(MainActivity2.this ,MainActivity.class));
            Toast.makeText(this, "user is not null" +mAuth.getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();
        }
        else {
            startActivity(new Intent(MainActivity2.this ,LoginActivity.class));

            Toast.makeText(this, "Please create an account", Toast.LENGTH_SHORT).show();
        }
    }
}