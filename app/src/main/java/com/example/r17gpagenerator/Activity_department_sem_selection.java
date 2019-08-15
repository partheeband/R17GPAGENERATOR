package com.example.r17gpagenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Activity_department_sem_selection extends AppCompatActivity {
    Spinner s1,s2;
    Button b;
    String spinner_department_position;
    String spinner_sem_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_sem_selection);
        s1=(Spinner)findViewById(R.id.spinner_department_selection);
        s2=(Spinner)findViewById(R.id.spinner_sem_selection);
        b=(Button)findViewById(R.id.button_proceed);



        String[] department={"Cse","Ece","Eee","IT","Civil","Mechanical","Aeronautical","E&I","Automobile","Biotechnology"/*,"Mba","Mca"*/};
        String[] sem={"1","2","3","4","5","6","7","8"};
        ArrayAdapter<String> i=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,department);
        ArrayAdapter<String> i1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sem);

        s1.setAdapter(i);
        s2.setAdapter(i1);
        // Intent intent =new Intent(getApplicationContext(), Activity_gpa_cse_sem1.class);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner_department_position = String.valueOf(s1.getSelectedItemPosition());
                spinner_sem_position = String.valueOf(s2.getSelectedItemPosition());
                Intent i = new Intent(Activity_department_sem_selection.this, Activity_gpa_calculation.class);
                i.putExtra("k_dept", spinner_department_position);
                i.putExtra("k_sem", spinner_sem_position);
                startActivity(i);
            }
        });
    }
}

