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

public class BuyMedcineDetailsActivity extends AppCompatActivity {

    TextView tvPackagename , tvtotalCost;
    EditText edDetails;
    Button btnBack , btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medcine_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvPackagename = findViewById(R.id.textViewBMDPackageName);
        edDetails = findViewById(R.id.editTextBMDMultiline);
        tvtotalCost = findViewById(R.id.textBMDTottalCost1);
        btnBack = findViewById(R.id.buttonBMDBack);
        btnAddToCart = findViewById(R.id.buttonBMDGoToCart);
        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackagename.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvtotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedcineDetailsActivity.this,BuyMedcineActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username","").toString();
                String product = tvPackagename.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                DataBase db = new DataBase(getApplicationContext(),"healthCare",null,1);

                if (db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(), "Product Already Added",Toast.LENGTH_SHORT).show();
                    //  startActivity(new Intent(LabTestDetailsActivity.this,CartLabActivity.class));


                } else {
                    db.addCart(username,product,price,"mediciene");
                    Toast.makeText(getApplicationContext(),"Record Inserted to Cart",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedcineDetailsActivity.this,BuyMedcineActivity.class));

                }
            }
        });

    }
}