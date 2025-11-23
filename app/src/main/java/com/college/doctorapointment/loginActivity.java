package com.college.doctorapointment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {
    EditText edUsername , edUserPaswoed;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quickdoc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edUsername = findViewById(R.id.edittextuserLogin);
        edUserPaswoed = findViewById(R.id.editexgLoginpword);
        btn = findViewById(R.id.Singin);
        tv = findViewById(R.id.RegisterNewUser);

      // startActivity(new Intent(loginActivity.this,RejesterActivity.class));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String userPassword = edUserPaswoed.getText().toString();
                DataBase db = new DataBase(getApplicationContext(),"healthCare",null,1);

               if (username.length()==0 || userPassword.length()==0){
                    Toast.makeText(getApplicationContext(),"please fill all the detalis",Toast.LENGTH_SHORT).show();

                } else {

                  if (db.login(username,userPassword)==1){

                      Toast.makeText(getApplicationContext(), "Login Succes", Toast.LENGTH_SHORT).show();
                      SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                      SharedPreferences.Editor editor = sharedPreferences.edit();
                      editor.putString("username", username);
                      editor.apply();

                        startActivity(new Intent(loginActivity.this,homeCard.class));

                    } else {
                        Toast.makeText(getApplicationContext(), "invalid username and password", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginActivity.this,RejesterActivity.class));
            }
        });
    }

}