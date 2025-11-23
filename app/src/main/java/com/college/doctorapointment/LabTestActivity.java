package com.college.doctorapointment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {

            {"package 1 : Full Body Checkup","","","","  999"},
            {"package 2 : Blood Glucose Fasting","","","","  299"},
            {"package 3 : COVID-19 AntiBody","","","","  899"},
            {"package 4 : Sugar Test","","","","  199"},
            {"package 5 : Immunity Check","","","","  599"},
            {"package 6 : Blood test","","","","  399"},
    };

    private String[] packag_details = {

      " >  Blood Glucose Fasting\n\n" +
      " >  Complete Hemogram\n\n" +
      " >  Iron Studies\n\n" +
      " >  Kidney function Test\n\n " +
              " >  LDG lactate Dehydrogenase , Serum\n\n" +
              " >  Lipid Profile \n\n" +
              " >  Liver Function Test" ,
              " >  Blood Glucose Fasting",
            " >  COVID-19 Glucose Fasting",
            " >  Thyroid Profile-Total(T3 , T4 & TSH Ultra - sensitive)",
            " >  Complete Hemogram\n\n" +
                    " >  CRP (C Reactive Protein) Quantitative , Serum\n\n" +
                    " >  Iron Studies\n\n" +
                    " >  Kidney Function Test\n\n"+
                    " >  Vitamin D Total-25 Hydroxy\n\n "+
                    " >  Liver Function Test\n\n"+
                    " >  Lipqd Profile"

    };

    HashMap<String , String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnGoToCart = findViewById(R.id.buttonLtGoToCart);
        btnBack = findViewById(R.id.buttonLtBack);
        listView = findViewById(R.id.listViewLabTest);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,homeCard.class));

            }
        });

        list = new ArrayList();
        for (int i =0; i<packages.length; i++){
            item = new HashMap<String , String>();
            item.put("Line1", packages[i][0]);
            item.put("Line2", packages[i][1]);
            item.put("Line3", packages[i][2]);
            item.put("Line4", packages[i][3]);
            item.put("Line5","Total Cost" + packages[i][4] +"/-");
            list.add(item);

        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new  int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
                listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent it =  new Intent(LabTestActivity.this,LabTestDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packag_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);

            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });


    }
}