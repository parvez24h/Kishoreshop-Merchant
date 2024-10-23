package com.example.kishoreshopmerchant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddUserActivity extends AppCompatActivity {

    ImageButton backBTN;
    Button submitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();

        initListeners();
    }

    private void initViews() {
        backBTN = findViewById(R.id.backBTN);
        submitBTN = findViewById(R.id.submitBTN);
    }

    private void initListeners() {


        backBTN.setOnClickListener(view -> {
            finish();
        });
        submitBTN.setOnClickListener(view -> {
            Intent intent = new Intent(AddUserActivity.this, UserDetailsActivity.class);
            startActivity(intent);
        });

    }
}