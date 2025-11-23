package com.college.doctorapointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_doctor);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.quickdoc), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button Back = findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctor.this , homeCard.class));
            }
        });

        CardView Familyphysicon = findViewById(R.id.cardFDfamilyPhysjion);
        Familyphysicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent(FindDoctor.this , Doctorsdetails.class);
                it.putExtra("tittle","Family\nPhysicon");
                startActivity(it);

            }
        });

        CardView Ditican = findViewById(R.id.cardFDietician);
        Ditican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this , Doctorsdetails.class);
                it.putExtra("tittle","Dietician");
                startActivity(it);
            }
        });

        CardView Dentist = findViewById(R.id.CardFDdentest);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this , Doctorsdetails.class);
                it.putExtra("tittle","Dentist");
                startActivity(it);
            }
        });

        CardView Surgon = findViewById(R.id.cardFDsurgondoctor);
        Surgon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this , Doctorsdetails.class);
                it.putExtra("tittle","Surgon");
                startActivity(it);
            }
        });

        CardView Cardiologislt = findViewById(R.id.cardFDcardiologist);
        Cardiologislt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this , Doctorsdetails.class);
                it.putExtra("tittle","Cardiologislt");
                startActivity(it);
            }
        });

        CardView Neurologist = findViewById(R.id.cardFDnuyrologistdoctor);
        Neurologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this , Doctorsdetails.class);
                it.putExtra("tittle","Neurologist");
                startActivity(it);
            }
        });

    }
}