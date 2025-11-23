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

public class BuyMedcineActivity extends AppCompatActivity {

    private String[][] packges =  {

            {"uprise - 03 100 IU Capsule ", "","","","50"},
            {"Health Vit Chromium Picolinate 200mch  Capsule ", "","","","305"},
            {"Vitamin B complex Capsule ", "","","","448"},
            {"Inlife Vitamin E Wheat Germ Oil  Capsule ", "","","","539"},
            {"Dolo 650 Tablet  ", "","","","30"},
            {"Crocin 650 Advance Tablet ", "","","","50"},
            {"Strepsils Medicated Lozenges for Sore Throat  ", "","","","40"},
            {"tata !mg Calcium + Vitamin D3 ", "","","","30"},
            {"Feronia = xT Tablet ", "","","","1300"},
    };

    private String[] packages_details = {

            "Building and keeping the bones & teeth strong \n " +
                    "Reducing Fatigue/stress adn muscular pains\n" +
                    "Boosting immunity and increasing resistance against infection " ,
            "Chromium is an essential trace mineral that plays an important role in helping insulin regulantion \n",
            "provides relief from vitamin B deficiencies\n" +
                    "Helps in formation of red blood cells\nn" +
                    "Maintanis healthy nervous system",
            "It promotes health as well as skin benefit \n" +
                    "It helps reduce skin blemish and pigmentation .\n" +
                    "It act as safeguard the skin fro the harsh UVA and UVB  sun rsays . ",
            "Dolo 650 Tablet helps reieve pain and fever by blocking the release of certain chemical message ",
            "Helps relieve fever and bring down a high temperature \n" +
                    "Suitable for people with a heart condition or high blood pressure ",
            "Relieves the symptoms of a bacterial throat infection and soothes the recovery  process \n" +
                    "Provides a warm and comforting feeling during sure throat ",
            "Reduces the risk of calcium deficiency , Rickets, and Osteoporosis\n"+
                    "Promotes mobility and flexibility of joints ",
            "helps to reduce the iron deficiency due to chronic blood loss or low intake of iron "
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medcine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lst = findViewById(R.id.listViewBuyM);
        btnBack = findViewById(R.id.buttonBuyMBack);
        ListView lst = findViewById(R.id.listViewBuyM);
        btnGoToCart = findViewById(R.id.buttonBuyMGoToCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedcineActivity.this,homeCard.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(BuyMedcineActivity.this,CartBuyMedcineActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<packges.length; i++){
            item = new HashMap<String,String>();
            item.put("line1",packges[i][0]);
            item.put("line2",packges[i][1]);
            item.put("line3",packges[i][2]);
            item.put("line4",packges[i][3]);
            item.put("line5","Total Cost : "+packges[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] { "line1","line2","line3","line4","line5"},
                 new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e,});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedcineActivity.this,BuyMedcineDetailsActivity.class);
                it.putExtra("text1",packges[i][0]);
                it.putExtra("text2",packages_details[i]);
                it.putExtra("text3",packges[i][4]);
                startActivity(it);
            }
        });

    }
}