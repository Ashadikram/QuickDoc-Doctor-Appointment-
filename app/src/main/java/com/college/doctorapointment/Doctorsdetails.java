package com.college.doctorapointment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class Doctorsdetails extends AppCompatActivity {

    private String[][] doctor_detail = {
            {"Doctor name : ajit Sastra \n", "Hospital Address : noida", "Exp ; 5yre", "Mobile no . 9873020980" , "500"},
            {"Doctor name : anket Sharma \n", "Hospital Address : BSR", "Exp ; 4yre", "Mobile no . 7890020980" , "600"},
            {"Doctor name : susma Solank \ni", "Hospital Address : Delhi", "Exp ; 2yre", "Mobile no . 6578020980" , "700"},
            {"Doctor name : sara khan \n", "Hospital Address : noida", "Exp ; 1yre", "Mobile no . 3467020980" , "500"},
            {"Doctor name : ashad Saifi \n", "Hospital Address : pune", "Exp ; 5yre", "Mobile no . 7253908831" , "100"},
            {"Doctor name : adiba saifi \n", "Hospital Address : noida", "Exp ; intern", "Mobile no . 9720878218" , "50"}

    };

    private String[][] doctor_detail1 = {
            {"Doctor name : ajit Sastra", "Hospital Address : noida", "Exp ; 5yre", "Mobile no . 9873020980" , "500"},
            {"Doctor name : anket Sharma", "Hospital Address : BSR", "Exp ; 4yre", "Mobile no . 7890020980" , "600"},
            {"Doctor name : susma Solanki", "Hospital Address : Delhi", "Exp ; 2yre", "Mobile no . 6578020980" , "700"},
            {"Doctor name : sara khan", "Hospital Address : noida", "Exp ; 1yre", "Mobile no . 3467020980" , "500"},
            {"Doctor name : ashad Saifi", "Hospital Address : pune", "Exp ; 5yre", "Mobile no . 7253908831" , "100"},
            {"Doctor name : adiba saifi", "Hospital Address : noida", "Exp ; intern", "Mobile no . 9720878218" , "50"}

    };

    private String[][] doctor_detail2 = {
            {"Doctor name : ajit Sastra", "Hospital Address : noida", "Exp ; 5yre", "Mobile no . 9873020980" , "500"},
            {"Doctor name : anket Sharma", "Hospital Address : BSR", "Exp ; 4yre", "Mobile no . 7890020980" , "600"},
            {"Doctor name : susma Solanki", "Hospital Address : Delhi", "Exp ; 2yre", "Mobile no . 6578020980" , "700"},
            {"Doctor name : sara khan", "Hospital Address : noida", "Exp ; 1yre", "Mobile no . 3467020980" , "500"},
            {"Doctor name : ashad Saifi", "Hospital Address : pune", "Exp ; 5yre", "Mobile no . 7253908831" , "100"},
            {"Doctor name : adiba saifi", "Hospital Address : noida", "Exp ; intern", "Mobile no . 9720878218" , "50"}

    };

    private String[][] doctor_detail3 = {
            {"Doctor name : ajit Sastra", "Hospital Address : noida", "Exp ; 5yre", "Mobile no . 9873020980" , "500"},
            {"Doctor name : anket Sharma", "Hospital Address : BSR", "Exp ; 4yre", "Mobile no . 7890020980" , "600"},
            {"Doctor name : susma Solanki", "Hospital Address : Delhi", "Exp ; 2yre", "Mobile no . 6578020980" , "700"},
            {"Doctor name : sara khan", "Hospital Address : noida", "Exp ; 1yre", "Mobile no . 3467020980" , "500"},
            {"Doctor name : ashad Saifi", "Hospital Address : pune", "Exp ; 5yre", "Mobile no . 7253908831" , "100"},
            {"Doctor name : adiba saifi", "Hospital Address : noida", "Exp ; intern", "Mobile no . 9720878218" , "50"}

    };

    private String[][] doctor_detail4 = {
            {"Doctor name : ajit Sastra", "Hospital Address : noida", "Exp ; 5yre", "Mobile no . 9873020980" , "500"},
            {"Doctor name : anket Sharma", "Hospital Address : BSR", "Exp ; 4yre", "Mobile no . 7890020980" , "600"},
            {"Doctor name : susma Solanki", "Hospital Address : Delhi", "Exp ; 2yre", "Mobile no . 6578020980" , "700"},
            {"Doctor name : sara khan", "Hospital Address : noida", "Exp ; 1yre", "Mobile no . 3467020980" , "500"},
            {"Doctor name : ashad Saifi", "Hospital Address : pune", "Exp ; 5yre", "Mobile no . 7253908831" , "100"},
            {"Doctor name : adiba saifi", "Hospital Address : noida", "Exp ; intern", "Mobile no . 9720878218" , "50"}

    };

    private String[][] doctor_detail5 = {
            {"Doctor name : ajit Sastra", "Hospital Address : noida", "Exp ; 5yre", "Mobile no . 9873020980", "500"},
            {"Doctor name : anket Sharma", "Hospital Address : BSR", "Exp ; 4yre", "Mobile no . 7890020980", "600"},
            {"Doctor name : susma Solanki", "Hospital Address : Delhi", "Exp ; 2yre", "Mobile no . 6578020980", "700"},
            {"Doctor name : sara khan", "Hospital Address : noida", "Exp ; 1yre", "Mobile no . 3467020980", "500"},
            {"Doctor name : ashad Saifi", "Hospital Address : pune", "Exp ; 5yre", "Mobile no . 7253908831", "100"},
            {"Doctor name : adiba saifi", "Hospital Address : noida", "Exp ; intern", "Mobile no . 9720878218" , "50"}

    };

    TextView tv;
    Button btn;

    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    String[][] doctor_details = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctorsdetails);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btn = findViewById(R.id.buttonDDback);
        tv = findViewById(R.id.TextViewDDtilttle);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Doctorsdetails.this , FindDoctor.class));
            }
        });


        Intent it = getIntent();
        String tittle = it.getStringExtra("tittle");
        // TextView textname = findViewById(R.id.textdoctorname);
        tv.setText(tittle);

        if (tittle.compareTo("Family\nphysicon")==0){
            doctor_details = doctor_detail;
        } else if (tittle.compareTo("Ditican")==0){
            doctor_details = doctor_detail1;
        } else if (tittle.compareTo("Dentist")==0) {
            doctor_details = doctor_detail2;
        } else if (tittle.compareTo("Surgon")==0) {
            doctor_details = doctor_detail3;
        } else if (tittle.compareTo("Cardiologislt")==0) {
            doctor_details = doctor_detail4;
        } else if (tittle.compareTo("Neurologist")==0) {
            doctor_details = doctor_detail5;
        } else {
            doctor_details = doctor_detail1;
        }

        list = new ArrayList();
        for (int i =0 ;i<doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1",doctor_details[i][0]);
            item.put("Line2",doctor_details[i][1]);
            item.put("Line3",doctor_details[i][2]);
            item.put("Line4",doctor_details[i][3]);
            item.put("Line5","consultant Fees "+ doctor_details[i][4]+"/-");
            list.add(item);

        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"Line1","Line2","Line3","Line4","Line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(Doctorsdetails.this,BookApointmentActivity2.class);
                it.putExtra("text1",tittle);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);

            }
        });


    }
}