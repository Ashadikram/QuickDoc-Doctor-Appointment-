package com.college.doctorapointment;

import android.content.Intent;
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

public class RejesterActivity extends AppCompatActivity {

    EditText edUsername , edUserPasword , edEmail, edconformPaswoed;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rejester);

        edUsername = findViewById(R.id.edittextregusername);
        edEmail = findViewById(R.id.edittextuserRegEmail);
        edUserPasword = findViewById(R.id.editexgRegpword);
        edconformPaswoed = findViewById(R.id.editexgconformpword);

        btn = findViewById(R.id.Registerbtn);
        tv = findViewById(R.id.Registerbtn);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quickdoc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RejesterActivity.this,loginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String paswoed = edUserPasword.getText().toString();
                String conform = edconformPaswoed.getText().toString();
                DataBase db = new DataBase(getApplicationContext(),"healthCare",null,1);


                if (username.length() == 0 || email.length() == 0 || paswoed.length() == 0 || conform.length() == 0) {

                    Toast.makeText(getApplicationContext(), "Fill all the details", Toast.LENGTH_SHORT).show();

                } else if (paswoed.compareTo(conform) == 0) {

                    if (isValid(paswoed)){
                        db.register(username,email,paswoed);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RejesterActivity.this, homeCard.class));

                    }else {
                        Toast.makeText(getApplicationContext(), "Password must contain at least 8 character , having letter , digit and special symbol", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "enter a valid number", Toast.LENGTH_SHORT).show();

                }
            }

        });


    }

      public static boolean isValid(String paswordhere){

        int f1 = 0, f2 = 0 ,f3 = 0;
        if (paswordhere.length() <= 8){
            return false;

        } else {

            for (int p =0; p<paswordhere.length(); p++){
                if(Character.isLetter(paswordhere.charAt(p))){
                    f1 = 1;

                }
            }
            for (int r=0; r < paswordhere.length(); r++){
                if (Character.isDigit(paswordhere.charAt(r))) {
                    f2 = 1;

                }
            }
            for (int s=0; s < paswordhere.length(); s++){
                char c = paswordhere.charAt(s);
                f3 = 1;
            }
        }

        if (f1==1 && f2 == 1 && f3 == 1)
            return true;
        return false;


      }
}