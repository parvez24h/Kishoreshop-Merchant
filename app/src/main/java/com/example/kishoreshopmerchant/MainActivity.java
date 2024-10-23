package com.example.kishoreshopmerchant;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;
    private TextView textView;
    private FloatingActionButton addUserButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initViews();

        initListeners();
    }

    private void initViews() {
        searchView = findViewById(R.id.searchView);
        textView = findViewById(R.id.tv);
        addUserButton = findViewById(R.id.addUserBTN);
    }

    private void initListeners() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                textView.setText("Submit: "+ query);

                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                textView.setText("Change: "+ newText);

                return false;
            }
        });
        addUserButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivity(intent);
        });
    }
}