package com.example.r17gpagenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_gpa_calculation extends AppCompatActivity {
    LinearLayout l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    TextView showdepart, showsem;
    Spinner s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    Button b;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    Integer subject1_spinner_position, subject2_spinner_position, subject3_spinner_position, subject4_spinner_position, subject5_spinner_position, subject6_spinner_position, subject7_spinner_position, subject8_spinner_position, subject9_spinner_position, subject10_spinner_position;
    Integer subject1_gradepoint, subject2_gradepoint, subject3_gradepoint, subject4_gradepoint, subject5_gradepoint, subject6_gradepoint, subject7_gradepoint, subject8_gradepoint, subject9_gradepoint, subject10_gradepoint;
    Integer subject1_credit = 0, subject2_credit = 0, subject3_credit = 0, subject4_credit = 0, subject5_credit = 0, subject6_credit = 0, subject7_credit = 0, subject8_credit = 0, subject9_credit = 0, subject10_credit = 0;
    Integer c1gp1, c2gp2, c3gp3, c4gp4, c5gp5, c6gp6, c7gp7, c8gp8, c9gp9, c10gp10;
    Integer cgp = 0;
    Float gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculation);
        showdepart = (TextView) findViewById(R.id.textView_departmentname);
        showsem = (TextView) findViewById(R.id.textView_semno);

        l1 = (LinearLayout) findViewById(R.id.linearlayout1);
        l2 = (LinearLayout) findViewById(R.id.linearlayout2);
        l3 = (LinearLayout) findViewById(R.id.linearlayout3);
        l4 = (LinearLayout) findViewById(R.id.linearlayout4);
        l5 = (LinearLayout) findViewById(R.id.linearlayout5);
        l6 = (LinearLayout) findViewById(R.id.linearlayout6);
        l7 = (LinearLayout) findViewById(R.id.linearlayout7);
        l8 = (LinearLayout) findViewById(R.id.linearlayout8);
        l9 = (LinearLayout) findViewById(R.id.linearlayout9);
        l10 = (LinearLayout) findViewById(R.id.linearlayout10);

        t1 = (TextView) findViewById(R.id.textView_subject1);
        t2 = (TextView) findViewById(R.id.textView_subject2);
        t3 = (TextView) findViewById(R.id.textView_subject3);
        t4 = (TextView) findViewById(R.id.textView_subject4);
        t5 = (TextView) findViewById(R.id.textView_subject5);
        t6 = (TextView) findViewById(R.id.textView_subject6);
        t7 = (TextView) findViewById(R.id.textView_subject7);
        t8 = (TextView) findViewById(R.id.textView_subject8);
        t9 = (TextView) findViewById(R.id.textView_subject9);
        t10 = (TextView) findViewById(R.id.textView_subject10);

        s1 = (Spinner) findViewById(R.id.spinner_sub1_grade);
        s2 = (Spinner) findViewById(R.id.spinner_sub2_grade);
        s3 = (Spinner) findViewById(R.id.spinner_sub3_grade);
        s4 = (Spinner) findViewById(R.id.spinner_sub4_grade);
        s5 = (Spinner) findViewById(R.id.spinner_sub5_grade);
        s6 = (Spinner) findViewById(R.id.spinner_sub6_grade);
        s7 = (Spinner) findViewById(R.id.spinner_sub7_grade);
        s8 = (Spinner) findViewById(R.id.spinner_sub8_grade);
        s9 = (Spinner) findViewById(R.id.spinner_sub9_grade);
        s10 = (Spinner) findViewById(R.id.spinner_sub10_grade);

        b = (Button) findViewById(R.id.button_cse_sem1_calculate_gpa);

        final Subject subject = new Subject();

        get_subjectname_credit_on_condition();
        final Float totalcredit = Float.valueOf(subject1_credit + subject2_credit + subject3_credit + subject4_credit + subject5_credit + subject6_credit + subject7_credit + subject8_credit + subject9_credit + subject10_credit);

        String[] grade = {"O", "A+", "A", "B+", "B", "RA", "sa", "w"};

        ArrayAdapter<String> i = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, grade);

        s1.setAdapter(i);
        s2.setAdapter(i);
        s3.setAdapter(i);
        s4.setAdapter(i);
        s5.setAdapter(i);
        s6.setAdapter(i);
        s7.setAdapter(i);
        s8.setAdapter(i);
        s9.setAdapter(i);
        s10.setAdapter(i);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject1_spinner_position = s1.getSelectedItemPosition();
                subject2_spinner_position = s2.getSelectedItemPosition();
                subject3_spinner_position = s3.getSelectedItemPosition();
                subject4_spinner_position = s4.getSelectedItemPosition();
                subject5_spinner_position = s5.getSelectedItemPosition();
                subject6_spinner_position = s6.getSelectedItemPosition();
                subject7_spinner_position = s7.getSelectedItemPosition();
                subject8_spinner_position = s8.getSelectedItemPosition();
                subject9_spinner_position = s9.getSelectedItemPosition();
                subject10_spinner_position = s10.getSelectedItemPosition();

                subject1_gradepoint = subject.calculate_Gradepoint(subject1_spinner_position);
                subject2_gradepoint = subject.calculate_Gradepoint(subject2_spinner_position);
                subject3_gradepoint = subject.calculate_Gradepoint(subject3_spinner_position);
                subject4_gradepoint = subject.calculate_Gradepoint(subject4_spinner_position);
                subject5_gradepoint = subject.calculate_Gradepoint(subject5_spinner_position);
                subject6_gradepoint = subject.calculate_Gradepoint(subject6_spinner_position);
                subject7_gradepoint = subject.calculate_Gradepoint(subject7_spinner_position);
                subject8_gradepoint = subject.calculate_Gradepoint(subject8_spinner_position);
                subject9_gradepoint = subject.calculate_Gradepoint(subject9_spinner_position);
                subject10_gradepoint = subject.calculate_Gradepoint(subject10_spinner_position);


                c1gp1 = subject1_credit * subject1_gradepoint;
                c2gp2 = subject2_credit * subject2_gradepoint;
                c3gp3 = subject3_credit * subject3_gradepoint;
                c4gp4 = subject4_credit * subject4_gradepoint;
                c5gp5 = subject5_credit * subject5_gradepoint;
                c6gp6 = subject6_credit * subject6_gradepoint;
                c7gp7 = subject7_credit * subject7_gradepoint;
                c8gp8 = subject8_credit * subject8_gradepoint;
                c9gp9 = subject9_credit * subject9_gradepoint;
                c10gp10 = subject10_credit * subject10_gradepoint;

                cgp = c1gp1 + c2gp2 + c3gp3 + c4gp4 + c5gp5 + c6gp6 + c7gp7 + c8gp8 + c9gp9 + c10gp10;

                gpa = cgp / totalcredit;


                Toast.makeText(Activity_gpa_calculation.this, gpa + "", Toast.LENGTH_SHORT).show();
                /*Toast.makeText(activity_gpa_cse_sem1.this, subject2_gradepoint+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(activity_gpa_cse_sem1.this, subject3_gradepoint+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(activity_gpa_cse_sem1.this, subject4_gradepoint+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(activity_gpa_cse_sem1.this, subject5_gradepoint+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(activity_gpa_cse_sem1.this, subject6_gradepoint+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(activity_gpa_cse_sem1.this, subject7_gradepoint+"", Toast.LENGTH_SHORT).show();
                Toast.makeText(activity_gpa_cse_sem1.this, subject8_gradepoint+"", Toast.LENGTH_SHORT).show();*/
            }
        });

    }

    private void get_subjectname_credit_on_condition() {
        //cse subjects and their credits
        Integer cse_sem1_subject1_credit = 4, cse_sem1_subject2_credit = 4, cse_sem1_subject3_credit = 3, cse_sem1_subject4_credit = 3, cse_sem1_subject5_credit = 4, cse_sem1_subject6_credit = 3, cse_sem1_subject7_credit = 2, cse_sem1_subject8_credit = 2;
        Integer cse_sem2_subject1_credit = 4, cse_sem2_subject2_credit = 4, cse_sem2_subject3_credit = 3, cse_sem2_subject4_credit = 3, cse_sem2_subject5_credit = 3, cse_sem2_subject6_credit = 3, cse_sem2_subject7_credit = 2, cse_sem2_subject8_credit = 2;
        Integer cse_sem3_subject1_credit = 4, cse_sem3_subject2_credit = 4, cse_sem3_subject3_credit = 3, cse_sem3_subject4_credit = 3, cse_sem3_subject5_credit = 3, cse_sem3_subject6_credit = 2, cse_sem3_subject7_credit = 2, cse_sem3_subject8_credit = 2, cse_sem3_subject9_credit = 2;
        Integer cse_sem4_subject1_credit = 4, cse_sem4_subject2_credit = 3, cse_sem4_subject3_credit = 3, cse_sem4_subject4_credit = 3, cse_sem4_subject5_credit = 3, cse_sem4_subject6_credit = 3, cse_sem4_subject7_credit = 2, cse_sem4_subject8_credit = 2, cse_sem4_subject9_credit = 1;
        Integer cse_sem5_subject1_credit = 4, cse_sem5_subject2_credit = 3, cse_sem5_subject3_credit = 3, cse_sem5_subject4_credit = 3, cse_sem5_subject5_credit = 3, cse_sem5_subject6_credit = 3, cse_sem5_subject7_credit = 2, cse_sem5_subject8_credit = 2, cse_sem5_subject9_credit = 2;
        Integer cse_sem6_subject1_credit = 3, cse_sem6_subject2_credit = 3, cse_sem6_subject3_credit = 3, cse_sem6_subject4_credit = 4, cse_sem6_subject5_credit = 3, cse_sem6_subject6_credit = 3, cse_sem6_subject7_credit = 2, cse_sem6_subject8_credit = 2, cse_sem6_subject9_credit = 1, cse_sem6_subject10_credit = 1;
        Integer cse_sem7_subject1_credit = 3, cse_sem7_subject2_credit = 3, cse_sem7_subject3_credit = 3, cse_sem7_subject4_credit = 3, cse_sem7_subject5_credit = 3, cse_sem7_subject6_credit = 3, cse_sem7_subject7_credit = 2, cse_sem7_subject8_credit = 2;
        Integer cse_sem8_subject1_credit = 3, cse_sem8_subject2_credit = 3, cse_sem8_subject3_credit = 10;

        String cse_sem1_subject1_name = "1 Commulative English -HS8151", cse_sem1_subject2_name = "2 Mathematics I -MA8151", cse_sem1_subject3_name = "3 Engineering Physics - PH8151", cse_sem1_subject4_name = "4 Engineering Chemistry - CY8151", cse_sem1_subject5_name = "5 Engineering Graphics -GE8152", cse_sem1_subject6_name = "6 Problem Solving & Python Programming -GE8151", cse_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", cse_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String cse_sem2_subject1_name = "1 Technical English -HS8251", cse_sem2_subject2_name = "2 Mathematics II -MA8251", cse_sem2_subject3_name = "3 Physics For Information Science- PH8252", cse_sem2_subject4_name = "4 Basic Electrical,Electronic & Measurement Engg-BE8255", cse_sem2_subject5_name = "5 Environmental Science & Engineering -GE8291", cse_sem2_subject6_name = "6 Programming in C -CS8251", cse_sem2_subject7_name = "7 C Programming Lab -CS8261", cse_sem2_subject8_name = "8 Engineering Practice Lab -GE8261";
        String cse_sem3_subject1_name = "1 Discrete Mathematics -MA8351", cse_sem3_subject2_name = "2 Digital Principles & System Design-CS8351", cse_sem3_subject3_name = "3 Data Structures -CS8391", cse_sem3_subject4_name = "4 Object Oriented Programming -CS8392", cse_sem3_subject5_name = "5 Communication Engineering -EC8395", cse_sem3_subject6_name = "6 Data Structure Lab-CS8381", cse_sem3_subject7_name = "7 Object Oriented Programming Lab -CS8383", cse_sem3_subject8_name = "8 Digital System Lab -CS8382", cse_sem3_subject9_name = "9 Interpersnal Skills: Listening & Speaking -HS8381";
        String cse_sem4_subject1_name = "1 Probability & Queueing Theory -MA8402", cse_sem4_subject2_name = "2 Computer Architecture -CS8491", cse_sem4_subject3_name = "3 Database Management Systems -CS8492", cse_sem4_subject4_name = "4 Design & Analysis of Algorithm -CS8451", cse_sem4_subject5_name = "5 Operating Systems -CS8493", cse_sem4_subject6_name = "6 Software Engineering -CS8494", cse_sem4_subject7_name = "7 Operating System Lab -CS8461", cse_sem4_subject8_name = "8 Database Management Systems Lab -CS8481", cse_sem4_subject9_name = "9 Advanced Reading & Writing -HS8461";
        String cse_sem5_subject1_name = "1 Algebra & Number Theory-MA8551", cse_sem5_subject2_name = "2 Computer Networks -CS8591", cse_sem5_subject3_name = "3 Microprocessors and MicroControllers-EC8691", cse_sem5_subject4_name = "4 Theory of Computation-CS8501", cse_sem5_subject5_name = "5 Object Oriented Analysis & Design-CS8592", cse_sem5_subject6_name = "6 Open Elective I -", cse_sem5_subject7_name = "7 Microprocessors and MicroControllers Lab-EC8681", cse_sem5_subject8_name = "8 Object Oriented Analysis & Design Lab -CS8582", cse_sem5_subject9_name = "9 Network Lab -CS8581";
        String cse_sem6_subject1_name = "1 Internet Programming -Cs8651", cse_sem6_subject2_name = "2 Artificial Intelligence -CS8691", cse_sem6_subject3_name = "3 Mobile Computing -CS8601", cse_sem6_subject4_name = "4 Compiler Design -CS8602", cse_sem6_subject5_name = "5 Distributed Systems -CS8603", cse_sem6_subject6_name = "6 Professional Elective I -", cse_sem6_subject7_name = "7 Internet Programming Lab -CS8661", cse_sem6_subject8_name = "8 Mobile Application Development Lab -CS8662", cse_sem6_subject9_name = "9 Mini Project -CS8611", cse_sem6_subject10_name = "10 Professional Communication -HS8581";
        String cse_sem7_subject1_name = "1 Principle of Management -MG8591", cse_sem7_subject2_name = "2 Cryptography & Network Security -CS8792", cse_sem7_subject3_name = "3 Cloud Computing -CS8791", cse_sem7_subject4_name = "4 Open Elective II -", cse_sem7_subject5_name = "5 Professional Elective II -", cse_sem7_subject6_name = "6 Professional Elective III -", cse_sem7_subject7_name = "7 Cloud Computing Lab -CS8711", cse_sem7_subject8_name = "8 Security Lab -IT8761";
        String cse_sem8_subject1_name = "1 Professional Elective IV -CS6801", cse_sem8_subject2_name = "2 Professional Elective V -", cse_sem8_subject3_name = "3 Project Work -CS8811";

        //ece subjects and their credits
        Integer ece_sem1_subject1_credit = 4, ece_sem1_subject2_credit = 4, ece_sem1_subject3_credit = 3, ece_sem1_subject4_credit = 3, ece_sem1_subject5_credit = 4, ece_sem1_subject6_credit = 3, ece_sem1_subject7_credit = 2, ece_sem1_subject8_credit = 2;
        Integer ece_sem2_subject1_credit = 4, ece_sem2_subject2_credit = 4, ece_sem2_subject3_credit = 3, ece_sem2_subject4_credit = 3, ece_sem2_subject5_credit = 4, ece_sem2_subject6_credit = 3, ece_sem2_subject7_credit = 2, ece_sem2_subject8_credit = 2;
        Integer ece_sem3_subject1_credit = 4, ece_sem3_subject2_credit = 3, ece_sem3_subject3_credit = 3, ece_sem3_subject4_credit = 4, ece_sem3_subject5_credit = 3, ece_sem3_subject6_credit = 3, ece_sem3_subject7_credit = 2, ece_sem3_subject8_credit = 2, ece_sem3_subject9_credit = 1;
        Integer ece_sem4_subject1_credit = 4, ece_sem4_subject2_credit = 3, ece_sem4_subject3_credit = 3, ece_sem4_subject4_credit = 4, ece_sem4_subject5_credit = 3, ece_sem4_subject6_credit = 3, ece_sem4_subject7_credit = 2, ece_sem4_subject8_credit = 2;
        Integer ece_sem5_subject1_credit = 3, ece_sem5_subject2_credit = 4, ece_sem5_subject3_credit = 3, ece_sem5_subject4_credit = 3, ece_sem5_subject5_credit = 3, ece_sem5_subject6_credit = 3, ece_sem5_subject7_credit = 2, ece_sem5_subject8_credit = 2, ece_sem5_subject9_credit = 2;
        Integer ece_sem6_subject1_credit = 3, ece_sem6_subject2_credit = 3, ece_sem6_subject3_credit = 3, ece_sem6_subject4_credit = 3, ece_sem6_subject5_credit = 3, ece_sem6_subject6_credit = 3, ece_sem6_subject7_credit = 2, ece_sem6_subject8_credit = 2, ece_sem6_subject9_credit = 1;
        Integer ece_sem7_subject1_credit = 3, ece_sem7_subject2_credit = 3, ece_sem7_subject3_credit = 3, ece_sem7_subject4_credit = 3, ece_sem7_subject5_credit = 3, ece_sem7_subject6_credit = 3, ece_sem7_subject7_credit = 2, ece_sem7_subject8_credit = 2;
        Integer ece_sem8_subject1_credit = 3, ece_sem8_subject2_credit = 3, ece_sem8_subject3_credit = 10;

        String ece_sem1_subject1_name = "1 Commulative English -HS8151", ece_sem1_subject2_name = "2 Mathematics I -MA8151", ece_sem1_subject3_name = "3 Engineering Physics - PH8151", ece_sem1_subject4_name = "4 Engineering Chemistry - CY8151", ece_sem1_subject5_name = "5 Engineering Graphics -GE8152", ece_sem1_subject6_name = "6 Problem Solving & Python Programming -GE8151", ece_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", ece_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String ece_sem2_subject1_name = "1 Technical English - HS8251", ece_sem2_subject2_name = "2 Mathematics II - MA8251", ece_sem2_subject3_name = "3 Physics for Electronics Engineering - PH8253", ece_sem2_subject4_name = "4 Basic Electrical & Instrumentation Engi - BE8254", ece_sem2_subject5_name = "5 circuit Analaysis - EC8251", ece_sem2_subject6_name = "6 electronic Device - EC8252", ece_sem2_subject7_name = "7 Circuits & Devices Lab - GE8261", ece_sem2_subject8_name = "8 Engineering practices Lab - GE8261";
        String ece_sem3_subject1_name = "1 Linear Algebra & Partial Differential Equation -MA8352", ece_sem3_subject2_name = "2 Fundamentals Of Data Structures In C - EC8393", ece_sem3_subject3_name = "3 Electronic Circuits- I - EC8351", ece_sem3_subject4_name = "4 Signals And Systems - EC8352", ece_sem3_subject5_name = "5 Digital Electronics - EC8392", ece_sem3_subject6_name = "6 Control Systems Engineering - EC8391", ece_sem3_subject7_name = "7 Fundamentals Of Data Structures In C Lab - EC8381", ece_sem3_subject8_name = "8 Analog And Digital Circuits Lab - EC8361", ece_sem3_subject9_name = "9 Interpersonal Skills: Listening & Speaking - HS8381";
        String ece_sem4_subject1_name = "1 Probability & Random Processes - MA8451", ece_sem4_subject2_name = "2 Electronic Circuits II - EC8452", ece_sem4_subject3_name = "3 Communication Theory - EC8491", ece_sem4_subject4_name = "4 Electromagnetic Fields - EC8451", ece_sem4_subject5_name = "5 Linear Integrated Circuits - EC8453", ece_sem4_subject6_name = "6 Environmental Science & Engineering - GE8291", ece_sem4_subject7_name = "7 Circuits Design & Simulation lab - EC8461", ece_sem4_subject8_name = "8 Linear Integrated Circuit Lab - EC8462";
        String ece_sem5_subject1_name = "1 Digital Communication -  EC8501", ece_sem5_subject2_name = "2 Discrete-Time Signal Processing - EC8553 ", ece_sem5_subject3_name = "3 Computer Architecture and Organization -EC8552", ece_sem5_subject4_name = "4 Communication Networks - EC8551 ", ece_sem5_subject5_name = "5 Professional Elective I ", ece_sem5_subject6_name = "6 Open Elective I ", ece_sem5_subject7_name = "7 Digital Signal Processing Laboratory- EC8562", ece_sem5_subject8_name = "8 Communication Systems Laboratory - EC8561  ", ece_sem5_subject9_name = "9 Communication Networks Laboratory -EC8563";
        String ece_sem6_subject1_name = "1 Microprocessors and Microcontrollers - EC8691 ", ece_sem6_subject2_name = "2 VLSI Design-  EC8095 ", ece_sem6_subject3_name = "3 Wireless Communication-  EC8652", ece_sem6_subject4_name = "4 Principles of Management - MG8591  ", ece_sem6_subject5_name = "5 Transmission Lines and RF Systems - EC8651 ", ece_sem6_subject6_name = "6 Professional  Elective -II ", ece_sem6_subject7_name = "7 Microprocessors and Microcontrollers Laboratory - EC8681 ", ece_sem6_subject8_name = "8 VLSI Design Laboratory - EC8661 ", ece_sem6_subject9_name = "9  Technical Seminar -EC8611";
        String ece_sem7_subject1_name = "1 Antennas and Microwave Engineering -EC8701", ece_sem7_subject2_name = "2 Optical Communication  -EC8751", ece_sem7_subject3_name = "3 Embedded and Real Time Systems -EC8791", ece_sem7_subject4_name = "4 Ad hoc and Wireless Sensor Networks  -EC8702", ece_sem7_subject5_name = "5 Professional Elective -III ", ece_sem7_subject6_name = "6 Open Elective - II ", ece_sem7_subject7_name = "7 Embedded Laboratory -EC8711", ece_sem7_subject8_name = "8 Advanced Communication Laboratory -EC8761";
        String ece_sem8_subject1_name = "1 Professional  Elective IV -", ece_sem8_subject2_name = "2 Professional Elective V", ece_sem8_subject3_name = "3 Project Work -EC8811";


//eee subjects and their credit=0s
        Integer eee_sem1_subject1_credit = 4, eee_sem1_subject2_credit = 4, eee_sem1_subject3_credit = 3, eee_sem1_subject4_credit = 3, eee_sem1_subject5_credit = 4, eee_sem1_subject6_credit = 3, eee_sem1_subject7_credit = 2, eee_sem1_subject8_credit = 2;
        Integer eee_sem2_subject1_credit = 4, eee_sem2_subject2_credit = 4, eee_sem2_subject3_credit = 3, eee_sem2_subject4_credit = 4, eee_sem2_subject5_credit = 3, eee_sem2_subject6_credit = 3, eee_sem2_subject7_credit = 2, eee_sem2_subject8_credit = 2;
        Integer eee_sem3_subject1_credit = 4, eee_sem3_subject2_credit = 3, eee_sem3_subject3_credit = 3, eee_sem3_subject4_credit = 3, eee_sem3_subject5_credit = 3, eee_sem3_subject6_credit = 3, eee_sem3_subject7_credit = 2, eee_sem3_subject8_credit = 2;
        Integer eee_sem4_subject1_credit = 4, eee_sem4_subject2_credit = 3, eee_sem4_subject3_credit = 3, eee_sem4_subject4_credit = 3, eee_sem4_subject5_credit = 3, eee_sem4_subject6_credit = 4, eee_sem4_subject7_credit = 2, eee_sem4_subject8_credit = 2, eee_sem4_subject9_credit = 1;
        Integer eee_sem5_subject1_credit = 3, eee_sem5_subject2_credit = 3, eee_sem5_subject3_credit = 3, eee_sem5_subject4_credit = 3, eee_sem5_subject5_credit = 3, eee_sem5_subject6_credit = 3, eee_sem5_subject7_credit = 2, eee_sem5_subject8_credit = 1, eee_sem5_subject9_credit = 2;
        Integer eee_sem6_subject1_credit = 3, eee_sem6_subject2_credit = 3, eee_sem6_subject3_credit = 3, eee_sem6_subject4_credit = 3, eee_sem6_subject5_credit = 3, eee_sem6_subject6_credit = 2, eee_sem6_subject7_credit = 2, eee_sem6_subject8_credit = 2;
        Integer eee_sem7_subject1_credit = 3, eee_sem7_subject2_credit = 3, eee_sem7_subject3_credit = 3, eee_sem7_subject4_credit = 3, eee_sem7_subject5_credit = 3, eee_sem7_subject6_credit = 3, eee_sem7_subject7_credit = 2, eee_sem7_subject8_credit = 2;
        Integer eee_sem8_subject1_credit = 3, eee_sem8_subject2_credit = 3, eee_sem8_subject3_credit = 10;

        String eee_sem1_subject1_name = "1 Commulative English -HS8151", eee_sem1_subject2_name = "2 Mathematics I -MA8151", eee_sem1_subject3_name = "3 Engineering Physics - PH8151", eee_sem1_subject4_name = "4 Engineering Chemistry - CY8151", eee_sem1_subject5_name = "5 Engineering Graphics -GE8152", eee_sem1_subject6_name = "6 Problem Solving & Python Programming -GE8151", eee_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", eee_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String eee_sem2_subject1_name = "1 Technical English -HS8251", eee_sem2_subject2_name = "2 Engineering Mathematics - II -MA8251", eee_sem2_subject3_name = "3 Physics for Electronics Engineering -PH8253", eee_sem2_subject4_name = "4 Basic Civil and Mechanical Engineering -BE8252", eee_sem2_subject5_name = "5  Circuit Theory -EE8251", eee_sem2_subject6_name = "6 Environmental Science and Engineering -GE8291", eee_sem2_subject7_name = "7  Engineering Practices Laboratory -GE8261", eee_sem2_subject8_name = "8  Electric Circuits Laboratory -EE8261";
        String eee_sem3_subject1_name = "1  Transforms and Partial Differential Equations -MA8353", eee_sem3_subject2_name = "2  Digital Logic Circuits -EE8351", eee_sem3_subject3_name = "3  Electromagnetic Theory -EE8391", eee_sem3_subject4_name = "4  Electrical  Machines - I -EE8301", eee_sem3_subject5_name = "5  Electron Devices and Circuits -EC8353", eee_sem3_subject6_name = "6  Power Plant Engineering -ME8792", eee_sem3_subject7_name = "7 Electronics Laboratory -EC8311", eee_sem3_subject8_name = "8  Electrical  Machines Laboratory - I -EE8311";
        String eee_sem4_subject1_name = "1  Numerical Methods -MA8491", eee_sem4_subject2_name = "2  Electrical Machines - I -EE8401", eee_sem4_subject3_name = "3 Transmission and Distribution -EE8402", eee_sem4_subject4_name = "4 Measurements and Instrumentation -EE8403", eee_sem4_subject5_name = "5  Linear Integrated Circuits and Applications -EE8451", eee_sem4_subject6_name = "6  Control Systems IC8451", eee_sem4_subject7_name = "7  Electrical Machines Laboratory - II -EE8411", eee_sem4_subject8_name = "8  Linear and Digital Integrated Circuits Laboratory -EE8461", eee_sem4_subject9_name = "9  Technical Seminar -EE8412";
        String eee_sem5_subject1_name = "1  Power System Analysis -EE8501", eee_sem5_subject2_name = "2  Microprocessors and Microcontrollers -EE8551", eee_sem5_subject3_name = "3 Power Electronics -EE8552", eee_sem5_subject4_name = "4  Digital Signal Processing -EE8591", eee_sem5_subject5_name = "5 Object Oriented Programming -CS8392", eee_sem5_subject6_name = "6  Open Elective I* ", eee_sem5_subject7_name = "7  Control and Instrumentation Laboratory -EE8511", eee_sem5_subject8_name = "8  Professional Communication -HS8581", eee_sem5_subject9_name = "9  Object Oriented Programming Laboratory -CS8383";
        String eee_sem6_subject1_name = "1  Solid State Drives -EE8601", eee_sem6_subject2_name = "2  Protection and Switchgear -EE8602", eee_sem6_subject3_name = "3 Embedded Systems -EE8691", eee_sem6_subject4_name = "4 Professional Elective I -", eee_sem6_subject5_name = "5 Professional Elective II -", eee_sem6_subject6_name = "6  Power Electronics and Drives Laboratory -EE8661", eee_sem6_subject7_name = "7  Microprocessors and Microcontrollers Laboratory -EE8681", eee_sem6_subject8_name = "8  Mini Project -EE8611";
        String eee_sem7_subject1_name = "1  High Voltage Engineering -EE8701", eee_sem7_subject2_name = "2  Power System Operation and Control -EE8702", eee_sem7_subject3_name = "3  Renewable Energy Systems -EE8703", eee_sem7_subject4_name = "4  Open Elective  II* ", eee_sem7_subject5_name = "5  Professional Elective III -", eee_sem7_subject6_name = "6  Professional Elective IV -", eee_sem7_subject7_name = "7  Power System Simulation Laboratory -EE8711", eee_sem7_subject8_name = "8  Renewable Energy Systems Laboratory -EE8712";
        String eee_sem8_subject1_name = "1  Professional Elective V -", eee_sem8_subject2_name = "2  Professional Elective VI -", eee_sem8_subject3_name = "3  Project Work -EE8811";

//it subjects and their credit=0s
        Integer it_sem1_subject1_credit = 4, it_sem1_subject2_credit = 4, it_sem1_subject3_credit = 3, it_sem1_subject4_credit = 3, it_sem1_subject5_credit = 3, it_sem1_subject6_credit = 4, it_sem1_subject7_credit = 2, it_sem1_subject8_credit = 2;
        Integer it_sem2_subject1_credit = 4, it_sem2_subject2_credit = 4, it_sem2_subject3_credit = 3, it_sem2_subject4_credit = 3, it_sem2_subject5_credit = 3, it_sem2_subject6_credit = 3, it_sem2_subject7_credit = 2, it_sem2_subject8_credit = 2, it_sem2_subject9_credit = 1;
        Integer it_sem3_subject1_credit = 4, it_sem3_subject2_credit = 4, it_sem3_subject3_credit = 3, it_sem3_subject4_credit = 3, it_sem3_subject5_credit = 3, it_sem3_subject6_credit = 2, it_sem3_subject7_credit = 2, it_sem3_subject8_credit = 2, it_sem3_subject9_credit = 1;
        Integer it_sem4_subject1_credit = 4, it_sem4_subject2_credit = 3, it_sem4_subject3_credit = 3, it_sem4_subject4_credit = 3, it_sem4_subject5_credit = 3, it_sem4_subject6_credit = 3, it_sem4_subject7_credit = 2, it_sem4_subject8_credit = 2, it_sem4_subject9_credit = 1;
        Integer it_sem5_subject1_credit = 4, it_sem5_subject2_credit = 3, it_sem5_subject3_credit = 3, it_sem5_subject4_credit = 3, it_sem5_subject5_credit = 3, it_sem5_subject6_credit = 3, it_sem5_subject7_credit = 2, it_sem5_subject8_credit = 2, it_sem5_subject9_credit = 2;
        Integer it_sem6_subject1_credit = 3, it_sem6_subject2_credit = 3, it_sem6_subject3_credit = 3, it_sem6_subject4_credit = 3, it_sem6_subject5_credit = 3, it_sem6_subject6_credit = 3, it_sem6_subject7_credit = 2, it_sem6_subject8_credit = 2, it_sem6_subject9_credit = 1;
        Integer it_sem7_subject1_credit = 3, it_sem7_subject2_credit = 3, it_sem7_subject3_credit = 3, it_sem7_subject4_credit = 3, it_sem7_subject5_credit = 3, it_sem7_subject6_credit = 3, it_sem7_subject7_credit = 2, it_sem7_subject8_credit = 2;
        Integer it_sem8_subject1_credit = 3, it_sem8_subject2_credit = 3, it_sem8_subject3_credit = 10;

        String it_sem1_subject1_name = "1 Commulative English -HS8151", it_sem1_subject2_name = "2 Mathematics I -MA8151", it_sem1_subject3_name = "3 Engineering Physics - PH8151", it_sem1_subject4_name = "4 Engineering Chemistry - CY8151", it_sem1_subject5_name = "5 Problem Solving & Python Programming -GE8151", it_sem1_subject6_name = "6 Engineering Graphics -GE8152", it_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", it_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String it_sem2_subject1_name = "1 Technical English -HS8251", it_sem2_subject2_name = "2 Mathematics II -MA8251", it_sem2_subject3_name = "3 Physics For Information Science- PH8252", it_sem2_subject4_name = "4 Basic Electrical,Electronic & Measurement Engg-BE8255", it_sem2_subject5_name = "5 Informational Technologies Essentials - IT8201 ", it_sem2_subject6_name = "6 Programming in C -CS8251", it_sem2_subject7_name = "7 C Programming Lab -CS8261", it_sem2_subject8_name = "8 Engineering Practice Lab -GE8261", it_sem2_subject9_name = "9 Informational Technologies Essentials Lab –IT8211";
        String it_sem3_subject1_name = "1 Discrete Mathematics  -MA8351", it_sem3_subject2_name = "2 Digital Principles and System Design -CS8351", it_sem3_subject3_name = "3 Data Structures -CS8391", it_sem3_subject4_name = "4 Object Oriented Programming -CS8392", it_sem3_subject5_name = "5 Analog and Digital Communication -EC8394", it_sem3_subject6_name = "6 Data Structures Laboratory -CS8381", it_sem3_subject7_name = "7 Object Oriented Programming Laboratory -CS8383", it_sem3_subject8_name = "8 Digital Systems Laboratory -CS8382", it_sem3_subject9_name = "9 Interpersonal Skills: Listening & Speaking -HS8381";
        String it_sem4_subject1_name = "1 Probability & Statistics -MA8391", it_sem4_subject2_name = "2 Computer Architecture -CS8491", it_sem4_subject3_name = "3 Database Management Systems -CS8492", it_sem4_subject4_name = "4 Design & Analysis of Algorithm -CS8451", it_sem4_subject5_name = "5 Operating Systems -CS8493", it_sem4_subject6_name = "6 Environmental Science and Engineering -GE8291", it_sem4_subject7_name = "7 Operating System Lab -CS8461", it_sem4_subject8_name = "8 Database Management Systems Lab -CS8481", it_sem4_subject9_name = "9 Advanced Reading & Writing -HS8461";
        String it_sem5_subject1_name = "1 Algebra & Number Theory-MA8551", it_sem5_subject2_name = "2 Computer Networks -CS8591", it_sem5_subject3_name = "3 Microprocessors and MicroControllers-EC8691", it_sem5_subject4_name = "4 Web Technology –IT8501", it_sem5_subject5_name = "5 Software Engineering –CS8494", it_sem5_subject6_name = "6 Open Elective I -", it_sem5_subject7_name = "7 Microprocessors and MicroControllers Lab-EC8681", it_sem5_subject8_name = "8 Network Lab –CS8581", it_sem5_subject9_name = "9 Web Technology Lab –IT8511";
        String it_sem6_subject1_name = "1 Computational Intelligence -IT8601", it_sem6_subject2_name = "2 Object Oriented Analysis and Design -CS8592", it_sem6_subject3_name = "3 Mobile Communication -IT8602", it_sem6_subject4_name = "4 Big Data Analytics -CS8091", it_sem6_subject5_name = "5 Computer Graphics and Multimedia -CS8092", it_sem6_subject6_name = "6 Professional Elective I -", it_sem6_subject7_name = "7 Mobile Application Development Laboratory -CS8662", it_sem6_subject8_name = "8 Object Oriented Analysis and Design Laboratory -CS8582", it_sem6_subject9_name = "9 Mini Project -IT8611";
        String it_sem7_subject1_name = "1 Principles of Management -MG8591", it_sem7_subject2_name = "2 Cryptography and Network Security -CS8792", it_sem7_subject3_name = "3 Cloud Computing -CS8791", it_sem7_subject4_name = "4 Open Elective II -", it_sem7_subject5_name = "5 Professional Elective II -", it_sem7_subject6_name = "6 Professional Elective III -", it_sem7_subject7_name = "7 FOSS and Cloud Computing Lab -IT8711", it_sem7_subject8_name = "8 Security Lab -IT8761";
        String it_sem8_subject1_name = "1 Professional  Elective IV -", it_sem8_subject2_name = "2 Professional  Elective V -", it_sem8_subject3_name = "3 Project Work -IT8811";

//civil subjects and their credit=0s
        Integer civil_sem1_subject1_credit = 4, civil_sem1_subject2_credit = 4, civil_sem1_subject3_credit = 3, civil_sem1_subject4_credit = 3, civil_sem1_subject5_credit = 3, civil_sem1_subject6_credit = 4, civil_sem1_subject7_credit = 2, civil_sem1_subject8_credit = 2;
        Integer civil_sem2_subject1_credit = 4, civil_sem2_subject2_credit = 4, civil_sem2_subject3_credit = 3, civil_sem2_subject4_credit = 3, civil_sem2_subject5_credit = 3, civil_sem2_subject6_credit = 4, civil_sem2_subject7_credit = 2, civil_sem2_subject8_credit = 2;
        Integer civil_sem3_subject1_credit = 4, civil_sem3_subject2_credit = 3, civil_sem3_subject3_credit = 3, civil_sem3_subject4_credit = 3, civil_sem3_subject5_credit = 3, civil_sem3_subject6_credit = 3, civil_sem3_subject7_credit = 2, civil_sem3_subject8_credit = 2, civil_sem3_subject9_credit = 1;
        Integer civil_sem4_subject1_credit = 4, civil_sem4_subject2_credit = 3, civil_sem4_subject3_credit = 3, civil_sem4_subject4_credit = 3, civil_sem4_subject5_credit = 3, civil_sem4_subject6_credit = 3, civil_sem4_subject7_credit = 2, civil_sem4_subject8_credit = 2, civil_sem4_subject9_credit = 1;
        Integer civil_sem5_subject1_credit = 4, civil_sem5_subject2_credit = 3, civil_sem5_subject3_credit = 3, civil_sem5_subject4_credit = 3, civil_sem5_subject5_credit = 3, civil_sem5_subject6_credit = 3, civil_sem5_subject7_credit = 2, civil_sem5_subject8_credit = 2, civil_sem5_subject9_credit = 2;
        Integer civil_sem6_subject1_credit = 4, civil_sem6_subject2_credit = 3, civil_sem6_subject3_credit = 3, civil_sem6_subject4_credit = 3, civil_sem6_subject5_credit = 3, civil_sem6_subject6_credit = 3, civil_sem6_subject7_credit = 2, civil_sem6_subject8_credit = 2, civil_sem6_subject9_credit = 1;
        Integer civil_sem7_subject1_credit = 3, civil_sem7_subject2_credit = 3, civil_sem7_subject3_credit = 4, civil_sem7_subject4_credit = 3, civil_sem7_subject5_credit = 3, civil_sem7_subject6_credit = 2, civil_sem7_subject7_credit = 2;
        Integer civil_sem8_subject1_credit = 3, civil_sem8_subject2_credit = 3, civil_sem8_subject3_credit = 10;

        String civil_sem1_subject1_name = "1 Commulative English -HS8151", civil_sem1_subject2_name = "2 Mathematics I -MA8151", civil_sem1_subject3_name = "3 Engineering Physics - PH8151", civil_sem1_subject4_name = "4 Engineering Chemistry - CY8151", civil_sem1_subject5_name = "5 Problem Solving & Python Programming -GE8151", civil_sem1_subject6_name = "6 Engineering Graphics -GE8152", civil_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", civil_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String civil_sem2_subject1_name = "1  Technical English -HS8251", civil_sem2_subject2_name = "2 Engineering  Mathematics – II -MA8251", civil_sem2_subject3_name = "3  Physics For Civil Engineering -PH8201", civil_sem2_subject4_name = "4 Basic Electrical and Electronics Engineering -BE8251", civil_sem2_subject5_name = "5 Environmental Science and Engineering -GE8291", civil_sem2_subject6_name = "6 Engineering Mechanics -GE8292", civil_sem2_subject7_name = "7 Engineering Practices Laboratory -GE8261", civil_sem2_subject8_name = "8 Computer Aided Building Drawing -CE8211";
        String civil_sem3_subject1_name = "1 Transforms and Partial Differential Equations -MA8353", civil_sem3_subject2_name = "2  Strength of  Materials I -CE8301", civil_sem3_subject3_name = "3  Fluid Mechanics-CE8302", civil_sem3_subject4_name = "4  Surveying -CE8351", civil_sem3_subject5_name = "5  Construction  Materials -CE8391", civil_sem3_subject6_name = "6 Engineering Geology -CE8392", civil_sem3_subject7_name = "7 Construction Materials Laboratory -CE8311", civil_sem3_subject8_name = "8 Surveying Laboratory -CE8361", civil_sem3_subject9_name = "9  Interpersonal Skills: Listening and Speaking -HS8381";
        String civil_sem4_subject1_name = "1  Numerical Methods -MA8491", civil_sem4_subject2_name = "2 Construction Techniques and Practices -CE8401", civil_sem4_subject3_name = "3  Strength of  Materials II -CE8402", civil_sem4_subject4_name = "4 Applied Hydraulic Engineering -CE8403", civil_sem4_subject5_name = "5 Concrete Technology -CE8404", civil_sem4_subject6_name = "6 Soil Mechanics -CE8491", civil_sem4_subject7_name = "7 Strength of Materials Laboratory -CE8481", civil_sem4_subject8_name = "8 Hydraulic Engineering Laboratory -CE8461", civil_sem4_subject9_name = "9 Advanced Reading and Writing -HS8461";
        String civil_sem5_subject1_name = "1 Design of Reinforced Cement Concrete Elements -CE8501", civil_sem5_subject2_name = "2 Structural Analysis I -CE8502", civil_sem5_subject3_name = "3 Water Supply Engineering -EN8491", civil_sem5_subject4_name = "4 Foundation Engineering -CE8591", civil_sem5_subject5_name = "5 Professional  Elective I -", civil_sem5_subject6_name = "6  Open Elective I* -", civil_sem5_subject7_name = "7 Soil Mechanics Laboratory -CE8511", civil_sem5_subject8_name = "8 Water and Waste Water Analysis Laboratory -CE8512", civil_sem5_subject9_name = "9 Survey Camp -CE8513";
        String civil_sem6_subject1_name = "1 Design of Steel Structural Elements -CE8601", civil_sem6_subject2_name = "2 Structural Analysis II -CE8602", civil_sem6_subject3_name = "3 Irrigation Engineering -CE8603", civil_sem6_subject4_name = "4 Highway Engineering -CE8604", civil_sem6_subject5_name = "5 Wastewater Engineering -EN8592", civil_sem6_subject6_name = "6 Professional  Elective II -", civil_sem6_subject7_name = "7 Highway Engineering Laboratory CE8611", civil_sem6_subject8_name = "8 Irrigation and Environmental Engineering Drawing CE8612", civil_sem6_subject9_name = "9 Professional Communication HS8581";
        String civil_sem7_subject1_name = "1 Estimation, Costing and Valuation Engineering -CE8701", civil_sem7_subject2_name = "2 Railways, Airports, Docks and Harbour Engineering -CE8702", civil_sem7_subject3_name = "3 Structural Design and Drawing -CE8703", civil_sem7_subject4_name = "4 Professional  Elective III -", civil_sem7_subject5_name = "5 Open Elective II* -", civil_sem7_subject6_name = "6 Creative and Innovative Project -CE8711", civil_sem7_subject7_name = "7 Industrial Training -CE8712";
        String civil_sem8_subject1_name = "1 Professional   Elective IV -", civil_sem8_subject2_name = "2 Professional  Elective V -", civil_sem8_subject3_name = "3  PROJECT WORK -CE8811";

//mechanical subjects and their credit=0s
        Integer mechanical_sem1_subject1_credit = 4, mechanical_sem1_subject2_credit = 4, mechanical_sem1_subject3_credit = 3, mechanical_sem1_subject4_credit = 3, mechanical_sem1_subject5_credit = 3, mechanical_sem1_subject6_credit = 4, mechanical_sem1_subject7_credit = 2, mechanical_sem1_subject8_credit = 2;
        Integer mechanical_sem2_subject1_credit = 4, mechanical_sem2_subject2_credit = 4, mechanical_sem2_subject3_credit = 3, mechanical_sem2_subject4_credit = 3, mechanical_sem2_subject5_credit = 3, mechanical_sem2_subject6_credit = 4, mechanical_sem2_subject7_credit = 2, mechanical_sem2_subject8_credit = 2;
        Integer mechanical_sem3_subject1_credit = 4, mechanical_sem3_subject2_credit = 4, mechanical_sem3_subject3_credit = 4, mechanical_sem3_subject4_credit = 3, mechanical_sem3_subject5_credit = 3, mechanical_sem3_subject6_credit = 2, mechanical_sem3_subject7_credit = 2, mechanical_sem3_subject8_credit = 2, mechanical_sem3_subject9_credit = 1;
        Integer mechanical_sem4_subject1_credit = 4, mechanical_sem4_subject2_credit = 3, mechanical_sem4_subject3_credit = 3, mechanical_sem4_subject4_credit = 3, mechanical_sem4_subject5_credit = 3, mechanical_sem4_subject6_credit = 3, mechanical_sem4_subject7_credit = 2, mechanical_sem4_subject8_credit = 2, mechanical_sem4_subject9_credit = 1;
        Integer mechanical_sem5_subject1_credit = 3, mechanical_sem5_subject2_credit = 3, mechanical_sem5_subject3_credit = 3, mechanical_sem5_subject4_credit = 4, mechanical_sem5_subject5_credit = 3, mechanical_sem5_subject6_credit = 2, mechanical_sem5_subject7_credit = 2, mechanical_sem5_subject8_credit = 2;
        Integer mechanical_sem6_subject1_credit = 3, mechanical_sem6_subject2_credit = 3, mechanical_sem6_subject3_credit = 4, mechanical_sem6_subject4_credit = 3, mechanical_sem6_subject5_credit = 3, mechanical_sem6_subject6_credit = 3, mechanical_sem6_subject7_credit = 2, mechanical_sem6_subject8_credit = 2, mechanical_sem6_subject9_credit = 1;
        Integer mechanical_sem7_subject1_credit = 3, mechanical_sem7_subject2_credit = 3, mechanical_sem7_subject3_credit = 3, mechanical_sem7_subject4_credit = 3, mechanical_sem7_subject5_credit = 3, mechanical_sem7_subject6_credit = 3, mechanical_sem7_subject7_credit = 2, mechanical_sem7_subject8_credit = 2, mechanical_sem7_subject9_credit = 1;
        Integer mechanical_sem8_subject1_credit = 3, mechanical_sem8_subject2_credit = 3, mechanical_sem8_subject3_credit = 10;

        String mechanical_sem1_subject1_name = "1 Commulative English -HS8151", mechanical_sem1_subject2_name = "2 Mathematics I -MA8151", mechanical_sem1_subject3_name = "3 Engineering Physics - PH8151", mechanical_sem1_subject4_name = "4 Engineering Chemistry - CY8151", mechanical_sem1_subject5_name = "5 Problem Solving & Python Programming -GE8151", mechanical_sem1_subject6_name = "6 Engineering Graphics -GE8152", mechanical_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", mechanical_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String mechanical_sem2_subject1_name = "1 Technical English -HS8251", mechanical_sem2_subject2_name = "2 Engineering Mathematics - II -MA8251", mechanical_sem2_subject3_name = "3 Materials Science -PH8251", mechanical_sem2_subject4_name = "4 Basic Electrical,Electronics and Instrumentation Engineering -BE8253", mechanical_sem2_subject5_name = "5 Environmental Science and Engineering -GE8291", mechanical_sem2_subject6_name = "6 Engineering  Mechanics -GE8292", mechanical_sem2_subject7_name = "7 Engineering Practices Laboratory -GE8261", mechanical_sem2_subject8_name = "8 Basic Electrical,Electronics and Instrumentation Engineering Laboratory -BE8261";
        String mechanical_sem3_subject1_name = "1 Transforms and Partial Differential Equations -MA8353", mechanical_sem3_subject2_name = "2 Engineering Thermodynamics -ME8391", mechanical_sem3_subject3_name = "3 Fluid Mechanics and Machinery -CE8394", mechanical_sem3_subject4_name = "4 Manufacturing Technology-I -ME8351", mechanical_sem3_subject5_name = "5 Electrical Drives and Controls -EE8353", mechanical_sem3_subject6_name = "6 Manufacturing Technology Laboratory - I -ME8361", mechanical_sem3_subject7_name = "7 Computer Aided Machine Drawing -ME8381", mechanical_sem3_subject8_name = "8 Electrical Engineering Laboratory -EE8361", mechanical_sem3_subject9_name = "9 Interpersonal Skills: Listening & Speaking -HS8381";
        String mechanical_sem4_subject1_name = "1 Statistics and Numerical Methods -MA8452", mechanical_sem4_subject2_name = "2 Kinematics of Machinery -ME8492", mechanical_sem4_subject3_name = "3 Manufacturing Technology – II -ME8451", mechanical_sem4_subject4_name = "4 Engineering Metallurgy -ME8491", mechanical_sem4_subject5_name = "5 Strength of Materials for Mechanical Engineers -CE8395", mechanical_sem4_subject6_name = "6 Thermal Engineering- I -ME8493", mechanical_sem4_subject7_name = "7 Manufacturing Technology Laboratory – II -ME8462", mechanical_sem4_subject8_name = "8 Strength of Materials and Fluid Mechanics and  Machinery Laboratory -CE8381", mechanical_sem4_subject9_name = "9 Advanced Reading and Writing -HS8461";
        String mechanical_sem5_subject1_name = "1 Thermal Engineering- II -ME8595", mechanical_sem5_subject2_name = "2 Design of Machine Elements -ME8593", mechanical_sem5_subject3_name = "3 Metrology and Measurements -ME8501", mechanical_sem5_subject4_name = "4 Dynamics of Machines -ME8594", mechanical_sem5_subject5_name = "5 Open Elective I -", mechanical_sem5_subject6_name = "6 Kinematics and Dynamics Laboratory -ME8511", mechanical_sem5_subject7_name = "7 Thermal Engineering Laboratory -ME8512", mechanical_sem5_subject8_name = "8 Metrology and Measurements Laboratory -ME8513";
        String mechanical_sem6_subject1_name = "1 Design of Transmission Systems -ME8651", mechanical_sem6_subject2_name = "2 Computer Aided Design and Manufacturing -ME8691", mechanical_sem6_subject3_name = "3 Heat and Mass Transfer -ME8693", mechanical_sem6_subject4_name = "4 Finite Element Analysis -ME8692", mechanical_sem6_subject5_name = "5 Hydraulics and Pneumatics -ME8694", mechanical_sem6_subject6_name = "6 Professional Elective - I", mechanical_sem6_subject7_name = "7 CAD / CAM Laboratory -ME8681", mechanical_sem6_subject8_name = "8 Design and Fabrication Project-ME8682", mechanical_sem6_subject9_name = "9 Professional Communication -HS8581";
        String mechanical_sem7_subject1_name = "1 Power Plant Engineering -ME8792", mechanical_sem7_subject2_name = "2 Process Planning and Cost Estimation -ME8793", mechanical_sem7_subject3_name = "3 Mechatronics -ME8791", mechanical_sem7_subject4_name = "4 Open Elective - II -", mechanical_sem7_subject5_name = "5 Professional Elective – II -", mechanical_sem7_subject6_name = "6 Professional Elective – III -", mechanical_sem7_subject7_name = "7 Simulation and Analysis Laboratory  -ME8711", mechanical_sem7_subject8_name = "8 Mechatronics Laboratory ME8781", mechanical_sem7_subject9_name = "9 Technical Seminar -ME8712";
        String mechanical_sem8_subject1_name = "1 Principles of Management -MG8591", mechanical_sem8_subject2_name = "2 Professional Elective– IV -", mechanical_sem8_subject3_name = "3 Project Work -ME8811";

//aeronautical subjects and their credit=0s
        Integer aeronautical_sem1_subject1_credit = 4, aeronautical_sem1_subject2_credit = 4, aeronautical_sem1_subject3_credit = 3, aeronautical_sem1_subject4_credit = 3, aeronautical_sem1_subject5_credit = 3, aeronautical_sem1_subject6_credit = 4, aeronautical_sem1_subject7_credit = 2, aeronautical_sem1_subject8_credit = 2;
        Integer aeronautical_sem2_subject1_credit = 4, aeronautical_sem2_subject2_credit = 4, aeronautical_sem2_subject3_credit = 3, aeronautical_sem2_subject4_credit = 3, aeronautical_sem2_subject5_credit = 3, aeronautical_sem2_subject6_credit = 4, aeronautical_sem2_subject7_credit = 2, aeronautical_sem2_subject8_credit = 2;
        Integer aeronautical_sem3_subject1_credit = 4, aeronautical_sem3_subject2_credit = 3, aeronautical_sem3_subject3_credit = 3, aeronautical_sem3_subject4_credit = 4, aeronautical_sem3_subject5_credit = 3, aeronautical_sem3_subject6_credit = 3, aeronautical_sem3_subject7_credit = 2, aeronautical_sem3_subject8_credit = 2, aeronautical_sem3_subject9_credit = 1;
        Integer aeronautical_sem4_subject1_credit = 4, aeronautical_sem4_subject2_credit = 3, aeronautical_sem4_subject3_credit = 3, aeronautical_sem4_subject4_credit = 3, aeronautical_sem4_subject5_credit = 4, aeronautical_sem4_subject6_credit = 4, aeronautical_sem4_subject7_credit = 2, aeronautical_sem4_subject8_credit = 1;
        Integer aeronautical_sem5_subject1_credit = 4, aeronautical_sem5_subject2_credit = 4, aeronautical_sem5_subject3_credit = 3, aeronautical_sem5_subject4_credit = 3, aeronautical_sem5_subject5_credit = 3, aeronautical_sem5_subject6_credit = 3, aeronautical_sem5_subject7_credit = 2, aeronautical_sem5_subject8_credit = 1, aeronautical_sem5_subject9_credit = 1;
        Integer aeronautical_sem6_subject1_credit = 3, aeronautical_sem6_subject2_credit = 3, aeronautical_sem6_subject3_credit = 3, aeronautical_sem6_subject4_credit = 3, aeronautical_sem6_subject5_credit = 3, aeronautical_sem6_subject6_credit = 3, aeronautical_sem6_subject7_credit = 2, aeronautical_sem6_subject8_credit = 2, aeronautical_sem6_subject9_credit = 1;
        Integer aeronautical_sem7_subject1_credit = 3, aeronautical_sem7_subject2_credit = 3, aeronautical_sem7_subject3_credit = 3, aeronautical_sem7_subject4_credit = 3, aeronautical_sem7_subject5_credit = 3, aeronautical_sem7_subject6_credit = 3, aeronautical_sem7_subject7_credit = 2, aeronautical_sem7_subject8_credit = 2, aeronautical_sem7_subject9_credit = 1;
        Integer aeronautical_sem8_subject1_credit = 3, aeronautical_sem8_subject2_credit = 3, aeronautical_sem8_subject3_credit = 10;

        String aeronautical_sem1_subject1_name = "1 Commulative English -HS8151", aeronautical_sem1_subject2_name = "2 Engineering Mathematics I -MA8151", aeronautical_sem1_subject3_name = "3 Engineering Physics - PH8151", aeronautical_sem1_subject4_name = "4 Engineering Chemistry - CY8151", aeronautical_sem1_subject5_name = "5 Problem Solving & Python Programming -GE8151", aeronautical_sem1_subject6_name = "6 Engineering Graphics -GE8152", aeronautical_sem1_subject7_name = "7 Problem Solving and Python Programming Lab -GE8161", aeronautical_sem1_subject8_name = "8 Physics & Chemistry Lab -BS8161";
        String aeronautical_sem2_subject1_name = "1 Technical English -HS8251", aeronautical_sem2_subject2_name = "2 Engineering Mathematics - II -MA8251", aeronautical_sem2_subject3_name = "3 Materials Science -PH8251", aeronautical_sem2_subject4_name = "4 Basic Electrical, Electronics and Instrumentation Engineering -BE8253", aeronautical_sem2_subject5_name = "5 Environmental Science and Engineering -GE8291", aeronautical_sem2_subject6_name = "6 Engineering  Mechanics -GE8292", aeronautical_sem2_subject7_name = "7 Engineering Practices Laboratory -GE8261", aeronautical_sem2_subject8_name = "8 Basic Electrical, Electronics and Instrumentation Engineering Laboratory -BE8261";
        String aeronautical_sem3_subject1_name = "1 Transforms and Partial Differential Equations -MA8353", aeronautical_sem3_subject2_name = "2 Manufacturing Technology -ME8392", aeronautical_sem3_subject3_name = "3 Aero Engineering Thermodynamics -AE8301", aeronautical_sem3_subject4_name = "4 Fluid Mechanics and Machinery -CE8394", aeronautical_sem3_subject5_name = "5 Strength of Materials for Mechanical Engineers -CE8395", aeronautical_sem3_subject6_name = "6 Elements of Aeronautical Engineering -AE8302", aeronautical_sem3_subject7_name = "7 Strength of Materials and Fluid Mechanics & Machinery Laboratory -CE8381", aeronautical_sem3_subject8_name = "8 Thermodynamics  Laboratory -AE8311", aeronautical_sem3_subject9_name = "9 Interpersonal Skills/Listening & Speaking -HS8381";
        String aeronautical_sem4_subject1_name = "1  Numerical Methods -MA8491", aeronautical_sem4_subject2_name = "2 Aerodynamics - I -AE8401", aeronautical_sem4_subject3_name = "3 Aircraft Systems and Instruments -AE8402", aeronautical_sem4_subject4_name = "4 Mechanics of Machines -PR8451", aeronautical_sem4_subject5_name = "5  Aircraft Structures - I -AE8403", aeronautical_sem4_subject6_name = "6 Propulsion - I -AE8404", aeronautical_sem4_subject7_name = "7 Computer Aided Machine Drawing -ME8381", aeronautical_sem4_subject8_name = "8  Aerodynamics  Laboratory  -AE8411";
        String aeronautical_sem5_subject1_name = "1  Flight Dynamics -AE8501", aeronautical_sem5_subject2_name = "2  Aircraft Structures - II -AE8502", aeronautical_sem5_subject3_name = "3 Aerodynamics - II -AE8503", aeronautical_sem5_subject4_name = "4 Propulsion - II -AE8504", aeronautical_sem5_subject5_name = "5  Control Engineering AE8505", aeronautical_sem5_subject6_name = "6 Open Elective - I -", aeronautical_sem5_subject7_name = "7 Aircraft Structures Laboratory -AE8511", aeronautical_sem5_subject8_name = "8 Propulsion Laboratory -AE8512", aeronautical_sem5_subject9_name = "9 Professional Communication -HS8581";
        String aeronautical_sem6_subject1_name = "1  Finite Element Methods -AE8601", aeronautical_sem6_subject2_name = "2 Experimental Aerodynamics -AE8602", aeronautical_sem6_subject3_name = "3  Composite Materials and Structures -AE8603", aeronautical_sem6_subject4_name = "4 Aircraft Design -AE8604", aeronautical_sem6_subject5_name = "5  Experimental Stress Analysis -AE8605", aeronautical_sem6_subject6_name = "6 Professional Elective – I -", aeronautical_sem6_subject7_name = "7 Aero Engine and Airframe  Laboratory -AE8611", aeronautical_sem6_subject8_name = "8 Computer Aided Simulation Laboratory -AE8612", aeronautical_sem6_subject9_name = "9  Aircraft Design Project - I -AE8613";
        String aeronautical_sem7_subject1_name = "1 Total Quality Management -GE8077", aeronautical_sem7_subject2_name = "2  Avionics -AE8751", aeronautical_sem7_subject3_name = "3 Computational Fluid Dynamics -ME8093", aeronautical_sem7_subject4_name = "4 Open Elective - II -", aeronautical_sem7_subject5_name = "5 Professional Elective – II -", aeronautical_sem7_subject6_name = "6 Professional Elective – III -", aeronautical_sem7_subject7_name = "7 Aircraft Systems Laboratory -AE8711", aeronautical_sem7_subject8_name = "8 Flight Integration Systems and Control Laboratory -AE8712", aeronautical_sem7_subject9_name = "9  Aircraft Design Project - II -AE8713";
        String aeronautical_sem8_subject1_name = "1 Professional Elective – IV -", aeronautical_sem8_subject2_name = "2 Professional Elective – V -", aeronautical_sem8_subject3_name = "3 PROJECT WORK -AE8811";

//e&i subjects and their credit=0s
        Integer e_and_i_sem1_subject1_credit = 4, e_and_i_sem1_subject2_credit = 4, e_and_i_sem1_subject3_credit = 3, e_and_i_sem1_subject4_credit = 3, e_and_i_sem1_subject5_credit = 3, e_and_i_sem1_subject6_credit = 4, e_and_i_sem1_subject7_credit = 2, e_and_i_sem1_subject8_credit = 2;
        Integer e_and_i_sem2_subject1_credit = 4, e_and_i_sem2_subject2_credit = 4, e_and_i_sem2_subject3_credit = 3, e_and_i_sem2_subject4_credit = 4, e_and_i_sem2_subject5_credit = 3, e_and_i_sem2_subject6_credit = 3, e_and_i_sem2_subject7_credit = 2, e_and_i_sem2_subject8_credit = 2;
        Integer e_and_i_sem3_subject1_credit = 4, e_and_i_sem3_subject2_credit = 3, e_and_i_sem3_subject3_credit = 3, e_and_i_sem3_subject4_credit = 3, e_and_i_sem3_subject5_credit = 3, e_and_i_sem3_subject6_credit = 3, e_and_i_sem3_subject7_credit = 2, e_and_i_sem3_subject8_credit = 2;
        Integer e_and_i_sem4_subject1_credit = 4, e_and_i_sem4_subject2_credit = 3, e_and_i_sem4_subject3_credit = 3, e_and_i_sem4_subject4_credit = 3, e_and_i_sem4_subject5_credit = 4, e_and_i_sem4_subject6_credit = 3, e_and_i_sem4_subject7_credit = 2, e_and_i_sem4_subject8_credit = 2;
        Integer e_and_i_sem5_subject1_credit = 3, e_and_i_sem5_subject2_credit = 3, e_and_i_sem5_subject3_credit = 3, e_and_i_sem5_subject4_credit = 3, e_and_i_sem5_subject5_credit = 3, e_and_i_sem5_subject6_credit = 3, e_and_i_sem5_subject7_credit = 2, e_and_i_sem5_subject8_credit = 2;
        Integer e_and_i_sem6_subject1_credit = 3, e_and_i_sem6_subject2_credit = 3, e_and_i_sem6_subject3_credit = 3, e_and_i_sem6_subject4_credit = 3, e_and_i_sem6_subject5_credit = 3, e_and_i_sem6_subject6_credit = 3, e_and_i_sem6_subject7_credit = 2, e_and_i_sem6_subject8_credit = 2, e_and_i_sem6_subject9_credit = 1;
        Integer e_and_i_sem7_subject1_credit = 3, e_and_i_sem7_subject2_credit = 3, e_and_i_sem7_subject3_credit = 3, e_and_i_sem7_subject4_credit = 3, e_and_i_sem7_subject5_credit = 3, e_and_i_sem7_subject6_credit = 3, e_and_i_sem7_subject7_credit = 2, e_and_i_sem7_subject8_credit = 2;
        Integer e_and_i_sem8_subject1_credit = 3, e_and_i_sem8_subject2_credit = 3, e_and_i_sem8_subject3_credit = 10;

        String e_and_i_sem1_subject1_name = "1 Communicative English -HS8151", e_and_i_sem1_subject2_name = "2 Engineering Mathematics - I -MA8151", e_and_i_sem1_subject3_name = "3 Engineering Physics -PH8151", e_and_i_sem1_subject4_name = "4 Engineering Chemistry -CY8151", e_and_i_sem1_subject5_name = "5 Problem Solving and Python Programming -GE8151", e_and_i_sem1_subject6_name = "6 Engineering Graphics -GE8152", e_and_i_sem1_subject7_name = "7 Problem Solving and Python Programming Laboratory -GE8161", e_and_i_sem1_subject8_name = "8  Physics and Chemistry Laboratory -BS8161";
        String e_and_i_sem2_subject1_name = "1 Technical English -HS8251", e_and_i_sem2_subject2_name = "2 Engineering Mathematics - II -MA8251", e_and_i_sem2_subject3_name = "3 Physics for Electronics Engineering-PH8253", e_and_i_sem2_subject4_name = "4 Basic Civil and Mechanical Engineering -BE8252", e_and_i_sem2_subject5_name = "5 Circuit Theory -EE8251", e_and_i_sem2_subject6_name = "6  Environmental Science and Engineering -GE8291", e_and_i_sem2_subject7_name = "7 Engineering Practices Laboratory -GE8261", e_and_i_sem2_subject8_name = "8 Electric Circuits Laboratory -EE8261";
        String e_and_i_sem3_subject1_name = "1 Transforms and Partial Differential Equations -MA8353", e_and_i_sem3_subject2_name = "2 Electron Devices and Circuits -EC8353", e_and_i_sem3_subject3_name = "3 Digital Logic Circuits -EE8351", e_and_i_sem3_subject4_name = "4  Electrical Measurements -EI8351", e_and_i_sem3_subject5_name = "5 Transducers Engineering -EI8352", e_and_i_sem3_subject6_name = "6 Object Oriented Programming -CS8392", e_and_i_sem3_subject7_name = "7 Measurements and Transducers Lab -EI8361", e_and_i_sem3_subject8_name = "8 Object Oriented Programming Lab -CS8383 ";
        String e_and_i_sem4_subject1_name = "1 Numerical Methods -MA8491", e_and_i_sem4_subject2_name = "2 Electrical Machines -EI8451", e_and_i_sem4_subject3_name = "3 Industrial Instrumentation - I -EI8452", e_and_i_sem4_subject4_name = "4 Linear Integrated Circuits and Applications -EE8451", e_and_i_sem4_subject5_name = "5 Control Systems -IC8451", e_and_i_sem4_subject6_name = "6 Communication Engineering -EC8395", e_and_i_sem4_subject7_name = "7 Devices and Machines Laboratory -EI8461", e_and_i_sem4_subject8_name = "8  Linear and Digital Integrated Circuits Laboratory -EE8461";
        String e_and_i_sem5_subject1_name = "1 Analytical Instruments -EI8551", e_and_i_sem5_subject2_name = "2 Industrial Instrumentation - II -EI8552", e_and_i_sem5_subject3_name = "3 Process Control -EI8553", e_and_i_sem5_subject4_name = "4 Microprocessors and Microcontrollers -EE8551", e_and_i_sem5_subject5_name = "5 Digital Signal Processing -EE8591", e_and_i_sem5_subject6_name = "6 Open Elective I* -", e_and_i_sem5_subject7_name = "7 Industrial Instrumentation Laboratory -EI8561", e_and_i_sem5_subject8_name = "8  Microprocessors and Microcontrollers Laboratory -EI8681";
        String e_and_i_sem6_subject1_name = "1 Logic and Distributed Control System -EI8651", e_and_i_sem6_subject2_name = "2 Computer Control of Processes -EI8691", e_and_i_sem6_subject3_name = "3 Data Structures -CS8391", e_and_i_sem6_subject4_name = "4 Electronic Instrumentation -EI8692", e_and_i_sem6_subject5_name = "5 Professional Elective I -", e_and_i_sem6_subject6_name = "6 Professional Elective II -", e_and_i_sem6_subject7_name = "7 Data Structures Laboratory -CS8381", e_and_i_sem6_subject8_name = "8 Process Control Laboratory -EI8661", e_and_i_sem6_subject9_name = "9  Professional Communication -HS8581";
        String e_and_i_sem7_subject1_name = "1 Industrial Data Networks -EI8751", e_and_i_sem7_subject2_name = "2 Embedded Systems -EE8691", e_and_i_sem7_subject3_name = "3  Digital Image Processing -EC8093", e_and_i_sem7_subject4_name = "4 Professional Elective III -", e_and_i_sem7_subject5_name = "5 Professional Elective IV -", e_and_i_sem7_subject6_name = "6 Open Elective II* -", e_and_i_sem7_subject7_name = "7 Industrial Automation Laboratory -EI8761", e_and_i_sem7_subject8_name = "8 Instrumentation System Design Laboratory -EI8762";
        String e_and_i_sem8_subject1_name = "1 Professional Elective V -", e_and_i_sem8_subject2_name = "2 Professional Elective VI -", e_and_i_sem8_subject3_name = "3 Project Work -EI8811";

//automobile subjects and their credit=0s
        Integer automobile_sem1_subject1_credit = 4, automobile_sem1_subject2_credit = 4, automobile_sem1_subject3_credit = 3, automobile_sem1_subject4_credit = 3, automobile_sem1_subject5_credit = 3, automobile_sem1_subject6_credit = 4, automobile_sem1_subject7_credit = 2, automobile_sem1_subject8_credit = 2;
        Integer automobile_sem2_subject1_credit = 4, automobile_sem2_subject2_credit = 4, automobile_sem2_subject3_credit = 3, automobile_sem2_subject4_credit = 3, automobile_sem2_subject5_credit = 3, automobile_sem2_subject6_credit = 4, automobile_sem2_subject7_credit = 2, automobile_sem2_subject8_credit = 2;
        Integer automobile_sem3_subject1_credit = 4, automobile_sem3_subject2_credit = 4, automobile_sem3_subject3_credit = 3, automobile_sem3_subject4_credit = 3, automobile_sem3_subject5_credit = 3, automobile_sem3_subject6_credit = 4, automobile_sem3_subject7_credit = 2, automobile_sem3_subject8_credit = 2, automobile_sem3_subject9_credit = 1;
        Integer automobile_sem4_subject1_credit = 4, automobile_sem4_subject2_credit = 3, automobile_sem4_subject3_credit = 3, automobile_sem4_subject4_credit = 3, automobile_sem4_subject5_credit = 3, automobile_sem4_subject6_credit = 3, automobile_sem4_subject7_credit = 2, automobile_sem4_subject8_credit = 2;
        Integer automobile_sem5_subject1_credit = 3, automobile_sem5_subject2_credit = 3, automobile_sem5_subject3_credit = 3, automobile_sem5_subject4_credit = 3, automobile_sem5_subject5_credit = 3, automobile_sem5_subject6_credit = 2, automobile_sem5_subject7_credit = 2, automobile_sem5_subject8_credit = 2, automobile_sem5_subject9_credit = 1;
        Integer automobile_sem6_subject1_credit = 3, automobile_sem6_subject2_credit = 3, automobile_sem6_subject3_credit = 3, automobile_sem6_subject4_credit = 3, automobile_sem6_subject5_credit = 3, automobile_sem6_subject6_credit = 3, automobile_sem6_subject7_credit = 2, automobile_sem6_subject8_credit = 2;
        Integer automobile_sem7_subject1_credit = 3, automobile_sem7_subject2_credit = 3, automobile_sem7_subject3_credit = 3, automobile_sem7_subject4_credit = 3, automobile_sem7_subject5_credit = 3, automobile_sem7_subject6_credit = 3, automobile_sem7_subject7_credit = 2, automobile_sem7_subject8_credit = 2;
        Integer automobile_sem8_subject1_credit = 3, automobile_sem8_subject2_credit = 3, automobile_sem8_subject3_credit = 3, automobile_sem8_subject4_credit = 10;

        String automobile_sem1_subject1_name = "1 Communicative English -HS8151", automobile_sem1_subject2_name = "2 Engineering Mathematics - I -MA8151", automobile_sem1_subject3_name = "3 Engineering Physics -PH8151", automobile_sem1_subject4_name = "4 Engineering Chemistry -CY8151", automobile_sem1_subject5_name = "5 Problem Solving and Python Programming -GE8151", automobile_sem1_subject6_name = "6 Engineering Graphics -GE8152", automobile_sem1_subject7_name = "7 Problem Solving and Python Programming Laboratory -GE8161", automobile_sem1_subject8_name = "8  Physics and Chemistry Laboratory -BS8161";
        String automobile_sem2_subject1_name = "1 Technical English -HS8251", automobile_sem2_subject2_name = "2 Engineering Mathematics - II -MA8251", automobile_sem2_subject3_name = "3 Materials Science -PH8251", automobile_sem2_subject4_name = "4 Basic Electrical, Electronics and Instrumentation Engineering -BE8253", automobile_sem2_subject5_name = "5 Environmental Science and Engineering -GE8291", automobile_sem2_subject6_name = "6 Engineering  Mechanics -GE8292", automobile_sem2_subject7_name = "7 Engineering Practices Laboratory -GE8261", automobile_sem2_subject8_name = "8 Basic Electrical, Electronics and Instrumentation Engineering Laboratory -BE8261";
        String automobile_sem3_subject1_name = "1 Transforms and Partial Differential Equations -MA8353", automobile_sem3_subject2_name = "2 Engineering Thermodynamics -ME8391", automobile_sem3_subject3_name = "3 Strength of Materials for Mechanical Engineers -CE8395", automobile_sem3_subject4_name = "4 Spark Ignition Engines -AT8301", automobile_sem3_subject5_name = "5 Manufacturing Technology -ME8392", automobile_sem3_subject6_name = "6 Fluid Mechanics and Machinery -CE8394", automobile_sem3_subject7_name = "7 Strength of Materials and Fluid Mechanics and Machinery Laboratory -CE8381", automobile_sem3_subject8_name = "8 Computer Aided Machine Drawing -ME8381", automobile_sem3_subject9_name = "9 Interpersonal Skills/Listening & Speaking -HS8381";
        String automobile_sem4_subject1_name = "1  Statistics and Numerical Methods -MA8452", automobile_sem4_subject2_name = "2 Compression Ignition Engines -AT8401", automobile_sem4_subject3_name = "3 Engineering Metallurgy -ME8491", automobile_sem4_subject4_name = "4 Electronics and Microprocessors -EC8396", automobile_sem4_subject5_name = "5 Automotive Chassis -AT8402", automobile_sem4_subject6_name = "6 Mechanics of Machines -PR8451", automobile_sem4_subject7_name = "7 Automotive Components Laboratory -AT8411", automobile_sem4_subject8_name = "8 Electronics and Microprocessors Laboratory -EC8382";
        String automobile_sem5_subject1_name = "1 Design of Machine Elements -ME8593", automobile_sem5_subject2_name = "2 Automotive Transmission -AT8501", automobile_sem5_subject3_name = "3 Automotive Electrical and Electronics Systems -AT8502", automobile_sem5_subject4_name = "4 Vehicle Design Data Characteristics -AT8503", automobile_sem5_subject5_name = "5 Automotive Fuels and Lubricants -AT8504", automobile_sem5_subject6_name = "6 Open Elective - I -", automobile_sem5_subject7_name = "7 Automotive Electrical and Electronics Laboratory -AT8511", automobile_sem5_subject8_name = "8 Automotive Fuels and Lubricants Laboratory -AT8512", automobile_sem5_subject9_name = "9 Professional Communication -HS8581";
        String automobile_sem6_subject1_name = "1 Total Quality Management -GE8077", automobile_sem6_subject2_name = "2 Automotive Engine Components Design -AT8601", automobile_sem6_subject3_name = "3 Automotive Chassis Components Design -AT8602", automobile_sem6_subject4_name = "4 Two and Three Wheelers -AT8603", automobile_sem6_subject5_name = "5 Vehicle Dynamics -AT8604", automobile_sem6_subject6_name = "6 Professional Elective – I -", automobile_sem6_subject7_name = "7 Computer Aided Engine and Chassis Design Laboratory -AT8611", automobile_sem6_subject8_name = "8 Two and Three Wheelers Laboratory -AT8612";
        String automobile_sem7_subject1_name = "1 Engine and Vehicle Management System -AT8701", automobile_sem7_subject2_name = "2 Finite Element Analysis -ME8692", automobile_sem7_subject3_name = "3 Vehicle Maintenance -AT8702", automobile_sem7_subject4_name = "4 Open Elective - II -", automobile_sem7_subject5_name = "5 Professional Elective – II -", automobile_sem7_subject6_name = "6 Professional Elective – III -", automobile_sem7_subject7_name = "7 Engine Performance and Emission Testing Laboratory -AT8711", automobile_sem7_subject8_name = "8 Vehicle Maintenance Laboratory -AT8712";
        String automobile_sem8_subject1_name = "1 Vehicle Body Engineering -AT8801", automobile_sem8_subject2_name = "2 Professional Elective – IV -", automobile_sem8_subject3_name = "3 Professional Elective – V -", automobile_sem8_subject4_name = "4 Project Work -AT8811";

//biotechnology subjects and their credit=0s
        Integer biotechnology_sem1_subject1_credit = 4, biotechnology_sem1_subject2_credit = 4, biotechnology_sem1_subject3_credit = 3, biotechnology_sem1_subject4_credit = 3, biotechnology_sem1_subject5_credit = 3, biotechnology_sem1_subject6_credit = 4, biotechnology_sem1_subject7_credit = 2, biotechnology_sem1_subject8_credit = 2;
        Integer biotechnology_sem2_subject1_credit = 4, biotechnology_sem2_subject2_credit = 4, biotechnology_sem2_subject3_credit = 3, biotechnology_sem2_subject4_credit = 4, biotechnology_sem2_subject5_credit = 3, biotechnology_sem2_subject6_credit = 3, biotechnology_sem2_subject7_credit = 2, biotechnology_sem2_subject8_credit = 2;
        Integer biotechnology_sem3_subject1_credit = 4, biotechnology_sem3_subject2_credit = 4, biotechnology_sem3_subject3_credit = 3, biotechnology_sem3_subject4_credit = 3, biotechnology_sem3_subject5_credit = 3, biotechnology_sem3_subject6_credit = 3, biotechnology_sem3_subject7_credit = 2, biotechnology_sem3_subject8_credit = 2, biotechnology_sem3_subject9_credit = 1;
        Integer biotechnology_sem4_subject1_credit = 4, biotechnology_sem4_subject2_credit = 4, biotechnology_sem4_subject3_credit = 3, biotechnology_sem4_subject4_credit = 3, biotechnology_sem4_subject5_credit = 3, biotechnology_sem4_subject6_credit = 3, biotechnology_sem4_subject7_credit = 2, biotechnology_sem4_subject8_credit = 2, biotechnology_sem4_subject9_credit = 1;
        Integer biotechnology_sem5_subject1_credit = 3, biotechnology_sem5_subject2_credit = 3, biotechnology_sem5_subject3_credit = 3, biotechnology_sem5_subject4_credit = 3, biotechnology_sem5_subject5_credit = 3, biotechnology_sem5_subject6_credit = 3, biotechnology_sem5_subject7_credit = 2, biotechnology_sem5_subject8_credit = 2, biotechnology_sem5_subject9_credit = 1;
        Integer biotechnology_sem6_subject1_credit = 4, biotechnology_sem6_subject2_credit = 4, biotechnology_sem6_subject3_credit = 3, biotechnology_sem6_subject4_credit = 3, biotechnology_sem6_subject5_credit = 3, biotechnology_sem6_subject6_credit = 3, biotechnology_sem6_subject7_credit = 2, biotechnology_sem6_subject8_credit = 2;
        Integer biotechnology_sem7_subject1_credit = 3, biotechnology_sem7_subject2_credit = 3, biotechnology_sem7_subject3_credit = 3, biotechnology_sem7_subject4_credit = 3, biotechnology_sem7_subject5_credit = 3, biotechnology_sem7_subject6_credit = 3, biotechnology_sem7_subject7_credit = 2, biotechnology_sem7_subject8_credit = 2;
        Integer biotechnology_sem8_subject1_credit = 10;

        String biotechnology_sem1_subject1_name = "1 Communicative English -HS8151", biotechnology_sem1_subject2_name = "2 Engineering Mathematics - I -MA8151", biotechnology_sem1_subject3_name = "3 Engineering Physics -PH8151", biotechnology_sem1_subject4_name = "4 Engineering Chemistry -CY8151", biotechnology_sem1_subject5_name = "5 Problem Solving and Python Programming -GE8151", biotechnology_sem1_subject6_name = "6 Engineering Graphics -GE8152", biotechnology_sem1_subject7_name = "7 Problem Solving and Python Programming Laboratory -GE8161", biotechnology_sem1_subject8_name = "8  Physics and Chemistry Laboratory -BS8161";
        String biotechnology_sem2_subject1_name = "1 Technical English -HS8251", biotechnology_sem2_subject2_name = "2 Engineering Mathematics – II -MA8251", biotechnology_sem2_subject3_name = "3 Physics of Materials -PH8254", biotechnology_sem2_subject4_name = "4 Basic Civil and Mechanical Engineering -BE8252", biotechnology_sem2_subject5_name = "5 Microbiology -BT8291", biotechnology_sem2_subject6_name = "6 Biochemistry -BT8251", biotechnology_sem2_subject7_name = "7 Engineering Practices Laboratory -GE8261", biotechnology_sem2_subject8_name = "8 Biochemistry Laboratory -BT8261";
        String biotechnology_sem3_subject1_name = "1 Transforms and Partial Differential Equations -MA8353", biotechnology_sem3_subject2_name = "2 Stoichiometry -BT8301", biotechnology_sem3_subject3_name = "3 Applied Thermodynamics for Biotechnologists -BT8302", biotechnology_sem3_subject4_name = "4 Basic Industrial Biotechnology -BT8303", biotechnology_sem3_subject5_name = "5 Bioorganic Chemistry -BT8304", biotechnology_sem3_subject6_name = "6 Cell Biology -BT8305", biotechnology_sem3_subject7_name = "7 Microbiology Laboratory -BT8361", biotechnology_sem3_subject8_name = "8 Cell Biology Laboratory -BT8311", biotechnology_sem3_subject9_name = "9 Interpersonal Skills/Listening and Speaking -HS8381";
        String biotechnology_sem4_subject1_name = "1 Probability and Statistics -MA8391", biotechnology_sem4_subject2_name = "2 Fluid Mechanics and Heat Transfer Operations -BT8401", biotechnology_sem4_subject3_name = "3 Molecular Biology -BT8402", biotechnology_sem4_subject4_name = "4 Enzyme Technology and Biotransformations -BT8403", biotechnology_sem4_subject5_name = "5 Bioprocess Principles -BT8404", biotechnology_sem4_subject6_name = "6 Environmental Science and Engineering -GE8291", biotechnology_sem4_subject7_name = "7 Chemical Engineering Laboratory for Biotechnologists -BT8411", biotechnology_sem4_subject8_name = "8 Molecular Biology Laboratory -BT8412", biotechnology_sem4_subject9_name = "9 Advanced Reading and Writing -HS8461";
        String biotechnology_sem5_subject1_name = "1 Mass Transfer Operations-BT8501", biotechnology_sem5_subject2_name = "2 Bioprocess Engineering -BT8591", biotechnology_sem5_subject3_name = "3 Analytical Methods and Instrumentation -BT8502", biotechnology_sem5_subject4_name = "4 Protein Engineering -BT8503", biotechnology_sem5_subject5_name = "5 Professional Elective I -", biotechnology_sem5_subject6_name = "6 Open Elective I* -", biotechnology_sem5_subject7_name = "7 Bioprocess Laboratory I -BT8511", biotechnology_sem5_subject8_name = "8 Analytical Methods and Instrumentation Laboratory -BT8512", biotechnology_sem5_subject9_name = "9 Professional Communication -HS8581";
        String biotechnology_sem6_subject1_name = "1 Bioinformatics -BT8651", biotechnology_sem6_subject2_name = "2 Genetic Engineering -BT8601", biotechnology_sem6_subject3_name = "3 Applied Chemical Reaction Engineering -BT8691", biotechnology_sem6_subject4_name = "4 Professional Elective II -", biotechnology_sem6_subject5_name = "5 Professional Elective III - ", biotechnology_sem6_subject6_name = "6 Professional Elective IV -", biotechnology_sem6_subject7_name = "7 Bioprocess Laboratory II -BT8611", biotechnology_sem6_subject8_name = "8 Genetic Engineering Laboratory -BT8612";
        String biotechnology_sem7_subject1_name = "1 Total Quality Management -GE8077", biotechnology_sem7_subject2_name = "2 Downstream Processing -BT8751", biotechnology_sem7_subject3_name = "3 Immunology -BT8791", biotechnology_sem7_subject4_name = "4 Professional Elective V -", biotechnology_sem7_subject5_name = "5 Professional Elective VI -", biotechnology_sem7_subject6_name = "6 Open Elective II * -", biotechnology_sem7_subject7_name = "7 Downstream Processing Laboratory -BT8711", biotechnology_sem7_subject8_name = "8 Immunology Laboratory -BT8712";
        String biotechnology_sem8_subject1_name = "1 Project Work -BT8811";
/*
//mba subjects and their credit=0s
        Integer mba_sem1_subject1_credit=0, mba_sem1_subject2_credit=0, mba_sem1_subject3_credit=0, mba_sem1_subject4_credit=0, mba_sem1_subject5_credit=0, mba_sem1_subject6_credit=0, mba_sem1_subject7_credit=0, mba_sem1_subject8_credit=0;
        Integer mba_sem2_subject1_credit=0, mba_sem2_subject2_credit=0, mba_sem2_subject3_credit=0, mba_sem2_subject4_credit=0, mba_sem2_subject5_credit=0, mba_sem2_subject6_credit=0, mba_sem2_subject7_credit=0, mba_sem2_subject8_credit=0;
        Integer mba_sem3_subject1_credit=0, mba_sem3_subject2_credit=0, mba_sem3_subject3_credit=0, mba_sem3_subject4_credit=0, mba_sem3_subject5_credit=0, mba_sem3_subject6_credit=0, mba_sem3_subject7_credit=0, mba_sem3_subject8_credit=0;
        Integer mba_sem4_subject1_credit=0, mba_sem4_subject2_credit=0, mba_sem4_subject3_credit=0, mba_sem4_subject4_credit=0, mba_sem4_subject5_credit=0, mba_sem4_subject6_credit=0, mba_sem4_subject7_credit=0, mba_sem4_subject8_credit=0;
        Integer mba_sem5_subject1_credit=0, mba_sem5_subject2_credit=0, mba_sem5_subject3_credit=0, mba_sem5_subject4_credit=0, mba_sem5_subject5_credit=0, mba_sem5_subject6_credit=0, mba_sem5_subject7_credit=0, mba_sem5_subject8_credit=0;
        Integer mba_sem6_subject1_credit=0, mba_sem6_subject2_credit=0, mba_sem6_subject3_credit=0, mba_sem6_subject4_credit=0, mba_sem6_subject5_credit=0, mba_sem6_subject6_credit=0, mba_sem6_subject7_credit=0, mba_sem6_subject8_credit=0;
        Integer mba_sem7_subject1_credit=0, mba_sem7_subject2_credit=0, mba_sem7_subject3_credit=0, mba_sem7_subject4_credit=0, mba_sem7_subject5_credit=0, mba_sem7_subject6_credit=0, mba_sem7_subject7_credit=0, mba_sem7_subject8_credit=0;
        Integer mba_sem8_subject1_credit=0, mba_sem8_subject2_credit=0, mba_sem8_subject3_credit=0, mba_sem8_subject4_credit=0, mba_sem8_subject5_credit=0, mba_sem8_subject6_credit=0, mba_sem8_subject7_credit=0, mba_sem8_subject8_credit=0;

        String mba_sem1_subject1_name=, mba_sem1_subject2_name=, mba_sem1_subject3_name=, mba_sem1_subject4_name=, mba_sem1_subject5_name=, mba_sem1_subject6_name=, mba_sem1_subject7_name=, mba_sem1_subject8_name=;
        String mba_sem2_subject1_name=, mba_sem2_subject2_name=, mba_sem2_subject3_name=, mba_sem2_subject4_name=, mba_sem2_subject5_name=, mba_sem2_subject6_name=, mba_sem2_subject7_name=, mba_sem2_subject8_name=;
        String mba_sem3_subject1_name=, mba_sem3_subject2_name=, mba_sem3_subject3_name=, mba_sem3_subject4_name=, mba_sem3_subject5_name=, mba_sem3_subject6_name=, mba_sem3_subject7_name=, mba_sem3_subject8_name=;
        String mba_sem4_subject1_name=, mba_sem4_subject2_name=, mba_sem4_subject3_name=, mba_sem4_subject4_name=, mba_sem4_subject5_name=, mba_sem4_subject6_name=, mba_sem4_subject7_name=, mba_sem4_subject8_name=;
        String mba_sem5_subject1_name=, mba_sem5_subject2_name=, mba_sem5_subject3_name=, mba_sem5_subject4_name=, mba_sem5_subject5_name=, mba_sem5_subject6_name=, mba_sem5_subject7_name=, mba_sem5_subject8_name=;
        String mba_sem6_subject1_name=, mba_sem6_subject2_name=, mba_sem6_subject3_name=, mba_sem6_subject4_name=, mba_sem6_subject5_name=, mba_sem6_subject6_name=, mba_sem6_subject7_name=, mba_sem6_subject8_name=;
        String mba_sem7_subject1_name=, mba_sem7_subject2_name=, mba_sem7_subject3_name=, mba_sem7_subject4_name=, mba_sem7_subject5_name=, mba_sem7_subject6_name=, mba_sem7_subject7_name=, mba_sem7_subject8_name=;
        String mba_sem8_subject1_name=, mba_sem8_subject2_name=, mba_sem8_subject3_name=, mba_sem8_subject4_name=, mba_sem8_subject5_name=, mba_sem8_subject6_name=, mba_sem8_subject7_name=, mba_sem8_subject8_name=;

//mca subjects and their credit=0s
        Integer mca_sem1_subject1_credit=0, mca_sem1_subject2_credit=0, mca_sem1_subject3_credit=0, mca_sem1_subject4_credit=0, mca_sem1_subject5_credit=0, mca_sem1_subject6_credit=0, mca_sem1_subject7_credit=0, mca_sem1_subject8_credit=0;
        Integer mca_sem2_subject1_credit=0, mca_sem2_subject2_credit=0, mca_sem2_subject3_credit=0, mca_sem2_subject4_credit=0, mca_sem2_subject5_credit=0, mca_sem2_subject6_credit=0, mca_sem2_subject7_credit=0, mca_sem2_subject8_credit=0;
        Integer mca_sem3_subject1_credit=0, mca_sem3_subject2_credit=0, mca_sem3_subject3_credit=0, mca_sem3_subject4_credit=0, mca_sem3_subject5_credit=0, mca_sem3_subject6_credit=0, mca_sem3_subject7_credit=0, mca_sem3_subject8_credit=0;
        Integer mca_sem4_subject1_credit=0, mca_sem4_subject2_credit=0, mca_sem4_subject3_credit=0, mca_sem4_subject4_credit=0, mca_sem4_subject5_credit=0, mca_sem4_subject6_credit=0, mca_sem4_subject7_credit=0, mca_sem4_subject8_credit=0;
        Integer mca_sem5_subject1_credit=0, mca_sem5_subject2_credit=0, mca_sem5_subject3_credit=0, mca_sem5_subject4_credit=0, mca_sem5_subject5_credit=0, mca_sem5_subject6_credit=0, mca_sem5_subject7_credit=0, mca_sem5_subject8_credit=0;
        Integer mca_sem6_subject1_credit=0, mca_sem6_subject2_credit=0, mca_sem6_subject3_credit=0, mca_sem6_subject4_credit=0, mca_sem6_subject5_credit=0, mca_sem6_subject6_credit=0, mca_sem6_subject7_credit=0, mca_sem6_subject8_credit=0;
        Integer mca_sem7_subject1_credit=0, mca_sem7_subject2_credit=0, mca_sem7_subject3_credit=0, mca_sem7_subject4_credit=0, mca_sem7_subject5_credit=0, mca_sem7_subject6_credit=0, mca_sem7_subject7_credit=0, mca_sem7_subject8_credit=0;
        Integer mca_sem8_subject1_credit=0, mca_sem8_subject2_credit=0, mca_sem8_subject3_credit=0, mca_sem8_subject4_credit=0, mca_sem8_subject5_credit=0, mca_sem8_subject6_credit=0, mca_sem8_subject7_credit=0, mca_sem8_subject8_credit=0;

        String mca_sem1_subject1_name=, mca_sem1_subject2_name=, mca_sem1_subject3_name=, mca_sem1_subject4_name=, mca_sem1_subject5_name=, mca_sem1_subject6_name=, mca_sem1_subject7_name=, mca_sem1_subject8_name=;
        String mca_sem2_subject1_name=, mca_sem2_subject2_name=, mca_sem2_subject3_name=, mca_sem2_subject4_name=, mca_sem2_subject5_name=, mca_sem2_subject6_name=, mca_sem2_subject7_name=, mca_sem2_subject8_name=;
        String mca_sem3_subject1_name=, mca_sem3_subject2_name=, mca_sem3_subject3_name=, mca_sem3_subject4_name=, mca_sem3_subject5_name=, mca_sem3_subject6_name=, mca_sem3_subject7_name=, mca_sem3_subject8_name=;
        String mca_sem4_subject1_name=, mca_sem4_subject2_name=, mca_sem4_subject3_name=, mca_sem4_subject4_name=, mca_sem4_subject5_name=, mca_sem4_subject6_name=, mca_sem4_subject7_name=, mca_sem4_subject8_name=;
        String mca_sem5_subject1_name=, mca_sem5_subject2_name=, mca_sem5_subject3_name=, mca_sem5_subject4_name=, mca_sem5_subject5_name=, mca_sem5_subject6_name=, mca_sem5_subject7_name=, mca_sem5_subject8_name=;
        String mca_sem6_subject1_name=, mca_sem6_subject2_name=, mca_sem6_subject3_name=, mca_sem6_subject4_name=, mca_sem6_subject5_name=, mca_sem6_subject6_name=, mca_sem6_subject7_name=, mca_sem6_subject8_name=;
        String mca_sem7_subject1_name=, mca_sem7_subject2_name=, mca_sem7_subject3_name=, mca_sem7_subject4_name=, mca_sem7_subject5_name=, mca_sem7_subject6_name=, mca_sem7_subject7_name=, mca_sem7_subject8_name=;
        String mca_sem8_subject1_name=, mca_sem8_subject2_name=, mca_sem8_subject3_name=, mca_sem8_subject4_name=, mca_sem8_subject5_name=, mca_sem8_subject6_name=, mca_sem8_subject7_name=, mca_sem8_subject8_name=;
*/


        Intent intent = getIntent();
        String depart = intent.getStringExtra("k_dept");
        String sem = intent.getStringExtra("k_sem");
        //Toast.makeText(Activity_gpa_cse_sem1.this,depart+" "+sem, Toast.LENGTH_SHORT).show();

        //department checking condition
        if (depart.equals("0"))//cse
        {
            showdepart.setText("cse");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = cse_sem1_subject1_credit;
                subject2_credit = cse_sem1_subject2_credit;
                subject3_credit = cse_sem1_subject3_credit;
                subject4_credit = cse_sem1_subject4_credit;
                subject5_credit = cse_sem1_subject5_credit;
                subject6_credit = cse_sem1_subject6_credit;
                subject7_credit = cse_sem1_subject7_credit;
                subject8_credit = cse_sem1_subject8_credit;

                t1.setText(cse_sem1_subject1_name);
                t2.setText(cse_sem1_subject2_name);
                t3.setText(cse_sem1_subject3_name);
                t4.setText(cse_sem1_subject4_name);
                t5.setText(cse_sem1_subject5_name);
                t6.setText(cse_sem1_subject6_name);
                t7.setText(cse_sem1_subject7_name);
                t8.setText(cse_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibility(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = cse_sem2_subject1_credit;
                subject2_credit = cse_sem2_subject2_credit;
                subject3_credit = cse_sem2_subject3_credit;
                subject4_credit = cse_sem2_subject4_credit;
                subject5_credit = cse_sem2_subject5_credit;
                subject6_credit = cse_sem2_subject6_credit;
                subject7_credit = cse_sem2_subject7_credit;
                subject8_credit = cse_sem2_subject8_credit;

                t1.setText(cse_sem2_subject1_name);
                t2.setText(cse_sem2_subject2_name);
                t3.setText(cse_sem2_subject3_name);
                t4.setText(cse_sem2_subject4_name);
                t5.setText(cse_sem2_subject5_name);
                t6.setText(cse_sem2_subject6_name);
                t7.setText(cse_sem2_subject7_name);
                t8.setText(cse_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();

            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = cse_sem3_subject1_credit;
                subject2_credit = cse_sem3_subject2_credit;
                subject3_credit = cse_sem3_subject3_credit;
                subject4_credit = cse_sem3_subject4_credit;
                subject5_credit = cse_sem3_subject5_credit;
                subject6_credit = cse_sem3_subject6_credit;
                subject7_credit = cse_sem3_subject7_credit;
                subject8_credit = cse_sem3_subject8_credit;
                subject9_credit = cse_sem3_subject9_credit;


                t1.setText(cse_sem3_subject1_name);
                t2.setText(cse_sem3_subject2_name);
                t3.setText(cse_sem3_subject3_name);
                t4.setText(cse_sem3_subject4_name);
                t5.setText(cse_sem3_subject5_name);
                t6.setText(cse_sem3_subject6_name);
                t7.setText(cse_sem3_subject7_name);
                t8.setText(cse_sem3_subject8_name);
                t9.setText(cse_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = cse_sem4_subject1_credit;
                subject2_credit = cse_sem4_subject2_credit;
                subject3_credit = cse_sem4_subject3_credit;
                subject4_credit = cse_sem4_subject4_credit;
                subject5_credit = cse_sem4_subject5_credit;
                subject6_credit = cse_sem4_subject6_credit;
                subject7_credit = cse_sem4_subject7_credit;
                subject8_credit = cse_sem4_subject8_credit;
                subject9_credit = cse_sem4_subject9_credit;

                t1.setText(cse_sem4_subject1_name);
                t2.setText(cse_sem4_subject2_name);
                t3.setText(cse_sem4_subject3_name);
                t4.setText(cse_sem4_subject4_name);
                t5.setText(cse_sem4_subject5_name);
                t6.setText(cse_sem4_subject6_name);
                t7.setText(cse_sem4_subject7_name);
                t8.setText(cse_sem4_subject8_name);
                t9.setText(cse_sem4_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = cse_sem5_subject1_credit;
                subject2_credit = cse_sem5_subject2_credit;
                subject3_credit = cse_sem5_subject3_credit;
                subject4_credit = cse_sem5_subject4_credit;
                subject5_credit = cse_sem5_subject5_credit;
                subject6_credit = cse_sem5_subject6_credit;
                subject7_credit = cse_sem5_subject7_credit;
                subject8_credit = cse_sem5_subject8_credit;
                subject9_credit = cse_sem5_subject9_credit;

                t1.setText(cse_sem5_subject1_name);
                t2.setText(cse_sem5_subject2_name);
                t3.setText(cse_sem5_subject3_name);
                t4.setText(cse_sem5_subject4_name);
                t5.setText(cse_sem5_subject5_name);
                t6.setText(cse_sem5_subject6_name);
                t7.setText(cse_sem5_subject7_name);
                t8.setText(cse_sem5_subject8_name);
                t9.setText(cse_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = cse_sem6_subject1_credit;
                subject2_credit = cse_sem6_subject2_credit;
                subject3_credit = cse_sem6_subject3_credit;
                subject4_credit = cse_sem6_subject4_credit;
                subject5_credit = cse_sem6_subject5_credit;
                subject6_credit = cse_sem6_subject6_credit;
                subject7_credit = cse_sem6_subject7_credit;
                subject8_credit = cse_sem6_subject8_credit;
                subject9_credit = cse_sem6_subject9_credit;
                subject10_credit = cse_sem6_subject10_credit;

                t1.setText(cse_sem6_subject1_name);
                t2.setText(cse_sem6_subject2_name);
                t3.setText(cse_sem6_subject3_name);
                t4.setText(cse_sem6_subject4_name);
                t5.setText(cse_sem6_subject5_name);
                t6.setText(cse_sem6_subject6_name);
                t7.setText(cse_sem6_subject7_name);
                t8.setText(cse_sem6_subject8_name);
                t9.setText(cse_sem6_subject9_name);
                t10.setText(cse_sem6_subject10_name);
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = cse_sem7_subject1_credit;
                subject2_credit = cse_sem7_subject2_credit;
                subject3_credit = cse_sem7_subject3_credit;
                subject4_credit = cse_sem7_subject4_credit;
                subject5_credit = cse_sem7_subject5_credit;
                subject6_credit = cse_sem7_subject6_credit;
                subject7_credit = cse_sem7_subject7_credit;
                subject8_credit = cse_sem7_subject8_credit;

                t1.setText(cse_sem7_subject1_name);
                t2.setText(cse_sem7_subject2_name);
                t3.setText(cse_sem7_subject3_name);
                t4.setText(cse_sem7_subject4_name);
                t5.setText(cse_sem7_subject5_name);
                t6.setText(cse_sem7_subject6_name);
                t7.setText(cse_sem7_subject7_name);
                t8.setText(cse_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = cse_sem8_subject1_credit;
                subject2_credit = cse_sem8_subject2_credit;
                subject3_credit = cse_sem8_subject3_credit;

                t1.setText(cse_sem8_subject1_name);
                t2.setText(cse_sem8_subject2_name);
                t3.setText(cse_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();

            }
        } else if (depart.equals("1"))//ece
        {
            showdepart.setText("ECE");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = ece_sem1_subject1_credit;
                subject2_credit = ece_sem1_subject2_credit;
                subject3_credit = ece_sem1_subject3_credit;
                subject4_credit = ece_sem1_subject4_credit;
                subject5_credit = ece_sem1_subject5_credit;
                subject6_credit = ece_sem1_subject6_credit;
                subject7_credit = ece_sem1_subject7_credit;
                subject8_credit = ece_sem1_subject8_credit;

                t1.setText(ece_sem1_subject1_name);
                t2.setText(ece_sem1_subject2_name);
                t3.setText(ece_sem1_subject3_name);
                t4.setText(ece_sem1_subject4_name);
                t5.setText(ece_sem1_subject5_name);
                t6.setText(ece_sem1_subject6_name);
                t7.setText(ece_sem1_subject7_name);
                t8.setText(ece_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibility(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = ece_sem2_subject1_credit;
                subject2_credit = ece_sem2_subject2_credit;
                subject3_credit = ece_sem2_subject3_credit;
                subject4_credit = ece_sem2_subject4_credit;
                subject5_credit = ece_sem2_subject5_credit;
                subject6_credit = ece_sem2_subject6_credit;
                subject7_credit = ece_sem2_subject7_credit;
                subject8_credit = ece_sem2_subject8_credit;

                t1.setText(ece_sem2_subject1_name);
                t2.setText(ece_sem2_subject2_name);
                t3.setText(ece_sem2_subject3_name);
                t4.setText(ece_sem2_subject4_name);
                t5.setText(ece_sem2_subject5_name);
                t6.setText(ece_sem2_subject6_name);
                t7.setText(ece_sem2_subject7_name);
                t8.setText(ece_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = ece_sem3_subject1_credit;
                subject2_credit = ece_sem3_subject2_credit;
                subject3_credit = ece_sem3_subject3_credit;
                subject4_credit = ece_sem3_subject4_credit;
                subject5_credit = ece_sem3_subject5_credit;
                subject6_credit = ece_sem3_subject6_credit;
                subject7_credit = ece_sem3_subject7_credit;
                subject8_credit = ece_sem3_subject8_credit;
                subject9_credit = ece_sem3_subject9_credit;

                t1.setText(ece_sem3_subject1_name);
                t2.setText(ece_sem3_subject2_name);
                t3.setText(ece_sem3_subject3_name);
                t4.setText(ece_sem3_subject4_name);
                t5.setText(ece_sem3_subject5_name);
                t6.setText(ece_sem3_subject6_name);
                t7.setText(ece_sem3_subject7_name);
                t8.setText(ece_sem3_subject8_name);
                t9.setText(ece_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = ece_sem4_subject1_credit;
                subject2_credit = ece_sem4_subject2_credit;
                subject3_credit = ece_sem4_subject3_credit;
                subject4_credit = ece_sem4_subject4_credit;
                subject5_credit = ece_sem4_subject5_credit;
                subject6_credit = ece_sem4_subject6_credit;
                subject7_credit = ece_sem4_subject7_credit;
                subject8_credit = ece_sem4_subject8_credit;

                t1.setText(ece_sem4_subject1_name);
                t2.setText(ece_sem4_subject2_name);
                t3.setText(ece_sem4_subject3_name);
                t4.setText(ece_sem4_subject4_name);
                t5.setText(ece_sem4_subject5_name);
                t6.setText(ece_sem4_subject6_name);
                t7.setText(ece_sem4_subject7_name);
                t8.setText(ece_sem4_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = ece_sem5_subject1_credit;
                subject2_credit = ece_sem5_subject2_credit;
                subject3_credit = ece_sem5_subject3_credit;
                subject4_credit = ece_sem5_subject4_credit;
                subject5_credit = ece_sem5_subject5_credit;
                subject6_credit = ece_sem5_subject6_credit;
                subject7_credit = ece_sem5_subject7_credit;
                subject8_credit = ece_sem5_subject8_credit;
                subject9_credit = ece_sem5_subject9_credit;

                t1.setText(ece_sem5_subject1_name);
                t2.setText(ece_sem5_subject2_name);
                t3.setText(ece_sem5_subject3_name);
                t4.setText(ece_sem5_subject4_name);
                t5.setText(ece_sem5_subject5_name);
                t6.setText(ece_sem5_subject6_name);
                t7.setText(ece_sem5_subject7_name);
                t8.setText(ece_sem5_subject8_name);
                t9.setText(ece_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = ece_sem6_subject1_credit;
                subject2_credit = ece_sem6_subject2_credit;
                subject3_credit = ece_sem6_subject3_credit;
                subject4_credit = ece_sem6_subject4_credit;
                subject5_credit = ece_sem6_subject5_credit;
                subject6_credit = ece_sem6_subject6_credit;
                subject7_credit = ece_sem6_subject7_credit;
                subject8_credit = ece_sem6_subject8_credit;
                subject9_credit = ece_sem6_subject9_credit;

                t1.setText(ece_sem6_subject1_name);
                t2.setText(ece_sem6_subject2_name);
                t3.setText(ece_sem6_subject3_name);
                t4.setText(ece_sem6_subject4_name);
                t5.setText(ece_sem6_subject5_name);
                t6.setText(ece_sem6_subject6_name);
                t7.setText(ece_sem6_subject7_name);
                t8.setText(ece_sem6_subject8_name);
                t9.setText(ece_sem6_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = ece_sem7_subject1_credit;
                subject2_credit = ece_sem7_subject2_credit;
                subject3_credit = ece_sem7_subject3_credit;
                subject4_credit = ece_sem7_subject4_credit;
                subject5_credit = ece_sem7_subject5_credit;
                subject6_credit = ece_sem7_subject6_credit;
                subject7_credit = ece_sem7_subject7_credit;
                subject8_credit = ece_sem7_subject8_credit;

                t1.setText(ece_sem7_subject1_name);
                t2.setText(ece_sem7_subject2_name);
                t3.setText(ece_sem7_subject3_name);
                t4.setText(ece_sem7_subject4_name);
                t5.setText(ece_sem7_subject5_name);
                t6.setText(ece_sem7_subject6_name);
                t7.setText(ece_sem7_subject7_name);
                t8.setText(ece_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = ece_sem8_subject1_credit;
                subject2_credit = ece_sem8_subject2_credit;
                subject3_credit = ece_sem8_subject3_credit;

                t1.setText(ece_sem8_subject1_name);
                t2.setText(ece_sem8_subject2_name);
                t3.setText(ece_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("2"))//eee
        {
            showdepart.setText("EEE");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = eee_sem1_subject1_credit;
                subject2_credit = eee_sem1_subject2_credit;
                subject3_credit = eee_sem1_subject3_credit;
                subject4_credit = eee_sem1_subject4_credit;
                subject5_credit = eee_sem1_subject5_credit;
                subject6_credit = eee_sem1_subject6_credit;
                subject7_credit = eee_sem1_subject7_credit;
                subject8_credit = eee_sem1_subject8_credit;

                t1.setText(eee_sem1_subject1_name);
                t2.setText(eee_sem1_subject2_name);
                t3.setText(eee_sem1_subject3_name);
                t4.setText(eee_sem1_subject4_name);
                t5.setText(eee_sem1_subject5_name);
                t6.setText(eee_sem1_subject6_name);
                t7.setText(eee_sem1_subject7_name);
                t8.setText(eee_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibility(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = eee_sem2_subject1_credit;
                subject2_credit = eee_sem2_subject2_credit;
                subject3_credit = eee_sem2_subject3_credit;
                subject4_credit = eee_sem2_subject4_credit;
                subject5_credit = eee_sem2_subject5_credit;
                subject6_credit = eee_sem2_subject6_credit;
                subject7_credit = eee_sem2_subject7_credit;
                subject8_credit = eee_sem2_subject8_credit;

                t1.setText(eee_sem2_subject1_name);
                t2.setText(eee_sem2_subject2_name);
                t3.setText(eee_sem2_subject3_name);
                t4.setText(eee_sem2_subject4_name);
                t5.setText(eee_sem2_subject5_name);
                t6.setText(eee_sem2_subject6_name);
                t7.setText(eee_sem2_subject7_name);
                t8.setText(eee_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = eee_sem3_subject1_credit;
                subject2_credit = eee_sem3_subject2_credit;
                subject3_credit = eee_sem3_subject3_credit;
                subject4_credit = eee_sem3_subject4_credit;
                subject5_credit = eee_sem3_subject5_credit;
                subject6_credit = eee_sem3_subject6_credit;
                subject7_credit = eee_sem3_subject7_credit;
                subject8_credit = eee_sem3_subject8_credit;

                t1.setText(eee_sem3_subject1_name);
                t2.setText(eee_sem3_subject2_name);
                t3.setText(eee_sem3_subject3_name);
                t4.setText(eee_sem3_subject4_name);
                t5.setText(eee_sem3_subject5_name);
                t6.setText(eee_sem3_subject6_name);
                t7.setText(eee_sem3_subject7_name);
                t8.setText(eee_sem3_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = eee_sem4_subject1_credit;
                subject2_credit = eee_sem4_subject2_credit;
                subject3_credit = eee_sem4_subject3_credit;
                subject4_credit = eee_sem4_subject4_credit;
                subject5_credit = eee_sem4_subject5_credit;
                subject6_credit = eee_sem4_subject6_credit;
                subject7_credit = eee_sem4_subject7_credit;
                subject8_credit = eee_sem4_subject8_credit;
                subject9_credit = eee_sem4_subject9_credit;

                t1.setText(eee_sem4_subject1_name);
                t2.setText(eee_sem4_subject2_name);
                t3.setText(eee_sem4_subject3_name);
                t4.setText(eee_sem4_subject4_name);
                t5.setText(eee_sem4_subject5_name);
                t6.setText(eee_sem4_subject6_name);
                t7.setText(eee_sem4_subject7_name);
                t8.setText(eee_sem4_subject8_name);
                t9.setText(eee_sem4_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = eee_sem5_subject1_credit;
                subject2_credit = eee_sem5_subject2_credit;
                subject3_credit = eee_sem5_subject3_credit;
                subject4_credit = eee_sem5_subject4_credit;
                subject5_credit = eee_sem5_subject5_credit;
                subject6_credit = eee_sem5_subject6_credit;
                subject7_credit = eee_sem5_subject7_credit;
                subject8_credit = eee_sem5_subject8_credit;
                subject9_credit = eee_sem5_subject9_credit;

                t1.setText(eee_sem5_subject1_name);
                t2.setText(eee_sem5_subject2_name);
                t3.setText(eee_sem5_subject3_name);
                t4.setText(eee_sem5_subject4_name);
                t5.setText(eee_sem5_subject5_name);
                t6.setText(eee_sem5_subject6_name);
                t7.setText(eee_sem5_subject7_name);
                t8.setText(eee_sem5_subject8_name);
                t9.setText(eee_sem5_subject9_name);

                l10.removeAllViewsInLayout();

            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = eee_sem6_subject1_credit;
                subject2_credit = eee_sem6_subject2_credit;
                subject3_credit = eee_sem6_subject3_credit;
                subject4_credit = eee_sem6_subject4_credit;
                subject5_credit = eee_sem6_subject5_credit;
                subject6_credit = eee_sem6_subject6_credit;
                subject7_credit = eee_sem6_subject7_credit;
                subject8_credit = eee_sem6_subject8_credit;

                t1.setText(eee_sem6_subject1_name);
                t2.setText(eee_sem6_subject2_name);
                t3.setText(eee_sem6_subject3_name);
                t4.setText(eee_sem6_subject4_name);
                t5.setText(eee_sem6_subject5_name);
                t6.setText(eee_sem6_subject6_name);
                t7.setText(eee_sem6_subject7_name);
                t8.setText(eee_sem6_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = eee_sem7_subject1_credit;
                subject2_credit = eee_sem7_subject2_credit;
                subject3_credit = eee_sem7_subject3_credit;
                subject4_credit = eee_sem7_subject4_credit;
                subject5_credit = eee_sem7_subject5_credit;
                subject6_credit = eee_sem7_subject6_credit;
                subject7_credit = eee_sem7_subject7_credit;
                subject8_credit = eee_sem7_subject8_credit;

                t1.setText(eee_sem7_subject1_name);
                t2.setText(eee_sem7_subject2_name);
                t3.setText(eee_sem7_subject3_name);
                t4.setText(eee_sem7_subject4_name);
                t5.setText(eee_sem7_subject5_name);
                t6.setText(eee_sem7_subject6_name);
                t7.setText(eee_sem7_subject7_name);
                t8.setText(eee_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = eee_sem8_subject1_credit;
                subject2_credit = eee_sem8_subject2_credit;
                subject3_credit = eee_sem8_subject3_credit;

                t1.setText(eee_sem8_subject1_name);
                t2.setText(eee_sem8_subject2_name);
                t3.setText(eee_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("3"))//it
        {
            showdepart.setText("IT");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = it_sem1_subject1_credit;
                subject2_credit = it_sem1_subject2_credit;
                subject3_credit = it_sem1_subject3_credit;
                subject4_credit = it_sem1_subject4_credit;
                subject5_credit = it_sem1_subject5_credit;
                subject6_credit = it_sem1_subject6_credit;
                subject7_credit = it_sem1_subject7_credit;
                subject8_credit = it_sem1_subject8_credit;

                t1.setText(it_sem1_subject1_name);
                t2.setText(it_sem1_subject2_name);
                t3.setText(it_sem1_subject3_name);
                t4.setText(it_sem1_subject4_name);
                t5.setText(it_sem1_subject5_name);
                t6.setText(it_sem1_subject6_name);
                t7.setText(it_sem1_subject7_name);
                t8.setText(it_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibility(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = it_sem2_subject1_credit;
                subject2_credit = it_sem2_subject2_credit;
                subject3_credit = it_sem2_subject3_credit;
                subject4_credit = it_sem2_subject4_credit;
                subject5_credit = it_sem2_subject5_credit;
                subject6_credit = it_sem2_subject6_credit;
                subject7_credit = it_sem2_subject7_credit;
                subject8_credit = it_sem2_subject8_credit;
                subject9_credit = it_sem2_subject9_credit;

                t1.setText(it_sem2_subject1_name);
                t2.setText(it_sem2_subject2_name);
                t3.setText(it_sem2_subject3_name);
                t4.setText(it_sem2_subject4_name);
                t5.setText(it_sem2_subject5_name);
                t6.setText(it_sem2_subject6_name);
                t7.setText(it_sem2_subject7_name);
                t8.setText(it_sem2_subject8_name);
                t9.setText(it_sem2_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = it_sem3_subject1_credit;
                subject2_credit = it_sem3_subject2_credit;
                subject3_credit = it_sem3_subject3_credit;
                subject4_credit = it_sem3_subject4_credit;
                subject5_credit = it_sem3_subject5_credit;
                subject6_credit = it_sem3_subject6_credit;
                subject7_credit = it_sem3_subject7_credit;
                subject8_credit = it_sem3_subject8_credit;
                subject9_credit = it_sem3_subject9_credit;

                t1.setText(it_sem3_subject1_name);
                t2.setText(it_sem3_subject2_name);
                t3.setText(it_sem3_subject3_name);
                t4.setText(it_sem3_subject4_name);
                t5.setText(it_sem3_subject5_name);
                t6.setText(it_sem3_subject6_name);
                t7.setText(it_sem3_subject7_name);
                t8.setText(it_sem3_subject8_name);
                t9.setText(it_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = it_sem4_subject1_credit;
                subject2_credit = it_sem4_subject2_credit;
                subject3_credit = it_sem4_subject3_credit;
                subject4_credit = it_sem4_subject4_credit;
                subject5_credit = it_sem4_subject5_credit;
                subject6_credit = it_sem4_subject6_credit;
                subject7_credit = it_sem4_subject7_credit;
                subject8_credit = it_sem4_subject8_credit;
                subject9_credit = it_sem4_subject9_credit;


                t1.setText(it_sem4_subject1_name);
                t2.setText(it_sem4_subject2_name);
                t3.setText(it_sem4_subject3_name);
                t4.setText(it_sem4_subject4_name);
                t5.setText(it_sem4_subject5_name);
                t6.setText(it_sem4_subject6_name);
                t7.setText(it_sem4_subject7_name);
                t8.setText(it_sem4_subject8_name);
                t9.setText(it_sem4_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = it_sem5_subject1_credit;
                subject2_credit = it_sem5_subject2_credit;
                subject3_credit = it_sem5_subject3_credit;
                subject4_credit = it_sem5_subject4_credit;
                subject5_credit = it_sem5_subject5_credit;
                subject6_credit = it_sem5_subject6_credit;
                subject7_credit = it_sem5_subject7_credit;
                subject8_credit = it_sem5_subject8_credit;
                subject9_credit = it_sem5_subject9_credit;


                t1.setText(it_sem5_subject1_name);
                t2.setText(it_sem5_subject2_name);
                t3.setText(it_sem5_subject3_name);
                t4.setText(it_sem5_subject4_name);
                t5.setText(it_sem5_subject5_name);
                t6.setText(it_sem5_subject6_name);
                t7.setText(it_sem5_subject7_name);
                t8.setText(it_sem5_subject8_name);
                t9.setText(it_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = it_sem6_subject1_credit;
                subject2_credit = it_sem6_subject2_credit;
                subject3_credit = it_sem6_subject3_credit;
                subject4_credit = it_sem6_subject4_credit;
                subject5_credit = it_sem6_subject5_credit;
                subject6_credit = it_sem6_subject6_credit;
                subject7_credit = it_sem6_subject7_credit;
                subject8_credit = it_sem6_subject8_credit;
                subject9_credit = it_sem6_subject9_credit;

                t1.setText(it_sem6_subject1_name);
                t2.setText(it_sem6_subject2_name);
                t3.setText(it_sem6_subject3_name);
                t4.setText(it_sem6_subject4_name);
                t5.setText(it_sem6_subject5_name);
                t6.setText(it_sem6_subject6_name);
                t7.setText(it_sem6_subject7_name);
                t8.setText(it_sem6_subject8_name);
                t9.setText(it_sem6_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = it_sem7_subject1_credit;
                subject2_credit = it_sem7_subject2_credit;
                subject3_credit = it_sem7_subject3_credit;
                subject4_credit = it_sem7_subject4_credit;
                subject5_credit = it_sem7_subject5_credit;
                subject6_credit = it_sem7_subject6_credit;
                subject7_credit = it_sem7_subject7_credit;
                subject8_credit = it_sem7_subject8_credit;

                t1.setText(it_sem7_subject1_name);
                t2.setText(it_sem7_subject2_name);
                t3.setText(it_sem7_subject3_name);
                t4.setText(it_sem7_subject4_name);
                t5.setText(it_sem7_subject5_name);
                t6.setText(it_sem7_subject6_name);
                t7.setText(it_sem7_subject7_name);
                t8.setText(it_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = it_sem8_subject1_credit;
                subject2_credit = it_sem8_subject2_credit;
                subject3_credit = it_sem8_subject3_credit;

                t1.setText(it_sem8_subject1_name);
                t2.setText(it_sem8_subject2_name);
                t3.setText(it_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("4"))//civil
        {
            showdepart.setText("CIVIL");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = civil_sem1_subject1_credit;
                subject2_credit = civil_sem1_subject2_credit;
                subject3_credit = civil_sem1_subject3_credit;
                subject4_credit = civil_sem1_subject4_credit;
                subject5_credit = civil_sem1_subject5_credit;
                subject6_credit = civil_sem1_subject6_credit;
                subject7_credit = civil_sem1_subject7_credit;
                subject8_credit = civil_sem1_subject8_credit;

                t1.setText(civil_sem1_subject1_name);
                t2.setText(civil_sem1_subject2_name);
                t3.setText(civil_sem1_subject3_name);
                t4.setText(civil_sem1_subject4_name);
                t5.setText(civil_sem1_subject5_name);
                t6.setText(civil_sem1_subject6_name);
                t7.setText(civil_sem1_subject7_name);
                t8.setText(civil_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibilcivily(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = civil_sem2_subject1_credit;
                subject2_credit = civil_sem2_subject2_credit;
                subject3_credit = civil_sem2_subject3_credit;
                subject4_credit = civil_sem2_subject4_credit;
                subject5_credit = civil_sem2_subject5_credit;
                subject6_credit = civil_sem2_subject6_credit;
                subject7_credit = civil_sem2_subject7_credit;
                subject8_credit = civil_sem2_subject8_credit;

                t1.setText(civil_sem2_subject1_name);
                t2.setText(civil_sem2_subject2_name);
                t3.setText(civil_sem2_subject3_name);
                t4.setText(civil_sem2_subject4_name);
                t5.setText(civil_sem2_subject5_name);
                t6.setText(civil_sem2_subject6_name);
                t7.setText(civil_sem2_subject7_name);
                t8.setText(civil_sem2_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = civil_sem3_subject1_credit;
                subject2_credit = civil_sem3_subject2_credit;
                subject3_credit = civil_sem3_subject3_credit;
                subject4_credit = civil_sem3_subject4_credit;
                subject5_credit = civil_sem3_subject5_credit;
                subject6_credit = civil_sem3_subject6_credit;
                subject7_credit = civil_sem3_subject7_credit;
                subject8_credit = civil_sem3_subject8_credit;
                subject9_credit = civil_sem3_subject9_credit;

                t1.setText(civil_sem3_subject1_name);
                t2.setText(civil_sem3_subject2_name);
                t3.setText(civil_sem3_subject3_name);
                t4.setText(civil_sem3_subject4_name);
                t5.setText(civil_sem3_subject5_name);
                t6.setText(civil_sem3_subject6_name);
                t7.setText(civil_sem3_subject7_name);
                t8.setText(civil_sem3_subject8_name);
                t9.setText(civil_sem3_subject9_name);

                //layout handling
                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = civil_sem4_subject1_credit;
                subject2_credit = civil_sem4_subject2_credit;
                subject3_credit = civil_sem4_subject3_credit;
                subject4_credit = civil_sem4_subject4_credit;
                subject5_credit = civil_sem4_subject5_credit;
                subject6_credit = civil_sem4_subject6_credit;
                subject7_credit = civil_sem4_subject7_credit;
                subject8_credit = civil_sem4_subject8_credit;
                subject9_credit = civil_sem4_subject9_credit;

                t1.setText(civil_sem4_subject1_name);
                t2.setText(civil_sem4_subject2_name);
                t3.setText(civil_sem4_subject3_name);
                t4.setText(civil_sem4_subject4_name);
                t5.setText(civil_sem4_subject5_name);
                t6.setText(civil_sem4_subject6_name);
                t7.setText(civil_sem4_subject7_name);
                t8.setText(civil_sem4_subject8_name);
                t9.setText(civil_sem4_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = civil_sem5_subject1_credit;
                subject2_credit = civil_sem5_subject2_credit;
                subject3_credit = civil_sem5_subject3_credit;
                subject4_credit = civil_sem5_subject4_credit;
                subject5_credit = civil_sem5_subject5_credit;
                subject6_credit = civil_sem5_subject6_credit;
                subject7_credit = civil_sem5_subject7_credit;
                subject8_credit = civil_sem5_subject8_credit;
                subject9_credit = civil_sem5_subject9_credit;

                t1.setText(civil_sem5_subject1_name);
                t2.setText(civil_sem5_subject2_name);
                t3.setText(civil_sem5_subject3_name);
                t4.setText(civil_sem5_subject4_name);
                t5.setText(civil_sem5_subject5_name);
                t6.setText(civil_sem5_subject6_name);
                t7.setText(civil_sem5_subject7_name);
                t8.setText(civil_sem5_subject8_name);
                t9.setText(civil_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = civil_sem6_subject1_credit;
                subject2_credit = civil_sem6_subject2_credit;
                subject3_credit = civil_sem6_subject3_credit;
                subject4_credit = civil_sem6_subject4_credit;
                subject5_credit = civil_sem6_subject5_credit;
                subject6_credit = civil_sem6_subject6_credit;
                subject7_credit = civil_sem6_subject7_credit;
                subject8_credit = civil_sem6_subject8_credit;
                subject9_credit = civil_sem6_subject9_credit;

                t1.setText(civil_sem6_subject1_name);
                t2.setText(civil_sem6_subject2_name);
                t3.setText(civil_sem6_subject3_name);
                t4.setText(civil_sem6_subject4_name);
                t5.setText(civil_sem6_subject5_name);
                t6.setText(civil_sem6_subject6_name);
                t7.setText(civil_sem6_subject7_name);
                t8.setText(civil_sem6_subject8_name);
                t9.setText(civil_sem6_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = civil_sem7_subject1_credit;
                subject2_credit = civil_sem7_subject2_credit;
                subject3_credit = civil_sem7_subject3_credit;
                subject4_credit = civil_sem7_subject4_credit;
                subject5_credit = civil_sem7_subject5_credit;
                subject6_credit = civil_sem7_subject6_credit;
                subject7_credit = civil_sem7_subject7_credit;

                t1.setText(civil_sem7_subject1_name);
                t2.setText(civil_sem7_subject2_name);
                t3.setText(civil_sem7_subject3_name);
                t4.setText(civil_sem7_subject4_name);
                t5.setText(civil_sem7_subject5_name);
                t6.setText(civil_sem7_subject6_name);
                t7.setText(civil_sem7_subject7_name);

                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = civil_sem8_subject1_credit;
                subject2_credit = civil_sem8_subject2_credit;
                subject3_credit = civil_sem8_subject3_credit;

                t1.setText(civil_sem8_subject1_name);
                t2.setText(civil_sem8_subject2_name);
                t3.setText(civil_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("5"))//mechanical
        {
            showdepart.setText("MECHANICAL");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = mechanical_sem1_subject1_credit;
                subject2_credit = mechanical_sem1_subject2_credit;
                subject3_credit = mechanical_sem1_subject3_credit;
                subject4_credit = mechanical_sem1_subject4_credit;
                subject5_credit = mechanical_sem1_subject5_credit;
                subject6_credit = mechanical_sem1_subject6_credit;
                subject7_credit = mechanical_sem1_subject7_credit;
                subject8_credit = mechanical_sem1_subject8_credit;

                t1.setText(mechanical_sem1_subject1_name);
                t2.setText(mechanical_sem1_subject2_name);
                t3.setText(mechanical_sem1_subject3_name);
                t4.setText(mechanical_sem1_subject4_name);
                t5.setText(mechanical_sem1_subject5_name);
                t6.setText(mechanical_sem1_subject6_name);
                t7.setText(mechanical_sem1_subject7_name);
                t8.setText(mechanical_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibilmechanicaly(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = mechanical_sem2_subject1_credit;
                subject2_credit = mechanical_sem2_subject2_credit;
                subject3_credit = mechanical_sem2_subject3_credit;
                subject4_credit = mechanical_sem2_subject4_credit;
                subject5_credit = mechanical_sem2_subject5_credit;
                subject6_credit = mechanical_sem2_subject6_credit;
                subject7_credit = mechanical_sem2_subject7_credit;
                subject8_credit = mechanical_sem2_subject8_credit;

                t1.setText(mechanical_sem2_subject1_name);
                t2.setText(mechanical_sem2_subject2_name);
                t3.setText(mechanical_sem2_subject3_name);
                t4.setText(mechanical_sem2_subject4_name);
                t5.setText(mechanical_sem2_subject5_name);
                t6.setText(mechanical_sem2_subject6_name);
                t7.setText(mechanical_sem2_subject7_name);
                t8.setText(mechanical_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = mechanical_sem3_subject1_credit;
                subject2_credit = mechanical_sem3_subject2_credit;
                subject3_credit = mechanical_sem3_subject3_credit;
                subject4_credit = mechanical_sem3_subject4_credit;
                subject5_credit = mechanical_sem3_subject5_credit;
                subject6_credit = mechanical_sem3_subject6_credit;
                subject7_credit = mechanical_sem3_subject7_credit;
                subject8_credit = mechanical_sem3_subject8_credit;
                subject9_credit = mechanical_sem3_subject9_credit;

                t1.setText(mechanical_sem3_subject1_name);
                t2.setText(mechanical_sem3_subject2_name);
                t3.setText(mechanical_sem3_subject3_name);
                t4.setText(mechanical_sem3_subject4_name);
                t5.setText(mechanical_sem3_subject5_name);
                t6.setText(mechanical_sem3_subject6_name);
                t7.setText(mechanical_sem3_subject7_name);
                t8.setText(mechanical_sem3_subject8_name);
                t9.setText(mechanical_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = mechanical_sem4_subject1_credit;
                subject2_credit = mechanical_sem4_subject2_credit;
                subject3_credit = mechanical_sem4_subject3_credit;
                subject4_credit = mechanical_sem4_subject4_credit;
                subject5_credit = mechanical_sem4_subject5_credit;
                subject6_credit = mechanical_sem4_subject6_credit;
                subject7_credit = mechanical_sem4_subject7_credit;
                subject8_credit = mechanical_sem4_subject8_credit;
                subject9_credit = mechanical_sem4_subject9_credit;

                t1.setText(mechanical_sem4_subject1_name);
                t2.setText(mechanical_sem4_subject2_name);
                t3.setText(mechanical_sem4_subject3_name);
                t4.setText(mechanical_sem4_subject4_name);
                t5.setText(mechanical_sem4_subject5_name);
                t6.setText(mechanical_sem4_subject6_name);
                t7.setText(mechanical_sem4_subject7_name);
                t8.setText(mechanical_sem4_subject8_name);
                t9.setText(mechanical_sem4_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = mechanical_sem5_subject1_credit;
                subject2_credit = mechanical_sem5_subject2_credit;
                subject3_credit = mechanical_sem5_subject3_credit;
                subject4_credit = mechanical_sem5_subject4_credit;
                subject5_credit = mechanical_sem5_subject5_credit;
                subject6_credit = mechanical_sem5_subject6_credit;
                subject7_credit = mechanical_sem5_subject7_credit;
                subject8_credit = mechanical_sem5_subject8_credit;

                t1.setText(mechanical_sem5_subject1_name);
                t2.setText(mechanical_sem5_subject2_name);
                t3.setText(mechanical_sem5_subject3_name);
                t4.setText(mechanical_sem5_subject4_name);
                t5.setText(mechanical_sem5_subject5_name);
                t6.setText(mechanical_sem5_subject6_name);
                t7.setText(mechanical_sem5_subject7_name);
                t8.setText(mechanical_sem5_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = mechanical_sem6_subject1_credit;
                subject2_credit = mechanical_sem6_subject2_credit;
                subject3_credit = mechanical_sem6_subject3_credit;
                subject4_credit = mechanical_sem6_subject4_credit;
                subject5_credit = mechanical_sem6_subject5_credit;
                subject6_credit = mechanical_sem6_subject6_credit;
                subject7_credit = mechanical_sem6_subject7_credit;
                subject8_credit = mechanical_sem6_subject8_credit;
                subject9_credit = mechanical_sem6_subject9_credit;

                t1.setText(mechanical_sem6_subject1_name);
                t2.setText(mechanical_sem6_subject2_name);
                t3.setText(mechanical_sem6_subject3_name);
                t4.setText(mechanical_sem6_subject4_name);
                t5.setText(mechanical_sem6_subject5_name);
                t6.setText(mechanical_sem6_subject6_name);
                t7.setText(mechanical_sem6_subject7_name);
                t8.setText(mechanical_sem6_subject8_name);
                t9.setText(mechanical_sem6_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = mechanical_sem7_subject1_credit;
                subject2_credit = mechanical_sem7_subject2_credit;
                subject3_credit = mechanical_sem7_subject3_credit;
                subject4_credit = mechanical_sem7_subject4_credit;
                subject5_credit = mechanical_sem7_subject5_credit;
                subject6_credit = mechanical_sem7_subject6_credit;
                subject7_credit = mechanical_sem7_subject7_credit;
                subject8_credit = mechanical_sem7_subject8_credit;
                subject9_credit = mechanical_sem7_subject9_credit;

                t1.setText(mechanical_sem7_subject1_name);
                t2.setText(mechanical_sem7_subject2_name);
                t3.setText(mechanical_sem7_subject3_name);
                t4.setText(mechanical_sem7_subject4_name);
                t5.setText(mechanical_sem7_subject5_name);
                t6.setText(mechanical_sem7_subject6_name);
                t7.setText(mechanical_sem7_subject7_name);
                t8.setText(mechanical_sem7_subject8_name);
                t9.setText(mechanical_sem7_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = mechanical_sem8_subject1_credit;
                subject2_credit = mechanical_sem8_subject2_credit;
                subject3_credit = mechanical_sem8_subject3_credit;

                t1.setText(mechanical_sem8_subject1_name);
                t2.setText(mechanical_sem8_subject2_name);
                t3.setText(mechanical_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("6"))//aeronautical
        {
            showdepart.setText("AERONAUTICAL");
            //sem checking condaeronauticalion
            //t8.setVisibilaeronauticaly(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = aeronautical_sem1_subject1_credit;
                subject2_credit = aeronautical_sem1_subject2_credit;
                subject3_credit = aeronautical_sem1_subject3_credit;
                subject4_credit = aeronautical_sem1_subject4_credit;
                subject5_credit = aeronautical_sem1_subject5_credit;
                subject6_credit = aeronautical_sem1_subject6_credit;
                subject7_credit = aeronautical_sem1_subject7_credit;
                subject8_credit = aeronautical_sem1_subject8_credit;

                t1.setText(aeronautical_sem1_subject1_name);
                t2.setText(aeronautical_sem1_subject2_name);
                t3.setText(aeronautical_sem1_subject3_name);
                t4.setText(aeronautical_sem1_subject4_name);
                t5.setText(aeronautical_sem1_subject5_name);
                t6.setText(aeronautical_sem1_subject6_name);
                t7.setText(aeronautical_sem1_subject7_name);
                t8.setText(aeronautical_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibilaeronauticaly(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = aeronautical_sem2_subject1_credit;
                subject2_credit = aeronautical_sem2_subject2_credit;
                subject3_credit = aeronautical_sem2_subject3_credit;
                subject4_credit = aeronautical_sem2_subject4_credit;
                subject5_credit = aeronautical_sem2_subject5_credit;
                subject6_credit = aeronautical_sem2_subject6_credit;
                subject7_credit = aeronautical_sem2_subject7_credit;
                subject8_credit = aeronautical_sem2_subject8_credit;

                t1.setText(aeronautical_sem2_subject1_name);
                t2.setText(aeronautical_sem2_subject2_name);
                t3.setText(aeronautical_sem2_subject3_name);
                t4.setText(aeronautical_sem2_subject4_name);
                t5.setText(aeronautical_sem2_subject5_name);
                t6.setText(aeronautical_sem2_subject6_name);
                t7.setText(aeronautical_sem2_subject7_name);
                t8.setText(aeronautical_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = aeronautical_sem3_subject1_credit;
                subject2_credit = aeronautical_sem3_subject2_credit;
                subject3_credit = aeronautical_sem3_subject3_credit;
                subject4_credit = aeronautical_sem3_subject4_credit;
                subject5_credit = aeronautical_sem3_subject5_credit;
                subject6_credit = aeronautical_sem3_subject6_credit;
                subject7_credit = aeronautical_sem3_subject7_credit;
                subject8_credit = aeronautical_sem3_subject8_credit;
                subject9_credit = aeronautical_sem3_subject9_credit;

                t1.setText(aeronautical_sem3_subject1_name);
                t2.setText(aeronautical_sem3_subject2_name);
                t3.setText(aeronautical_sem3_subject3_name);
                t4.setText(aeronautical_sem3_subject4_name);
                t5.setText(aeronautical_sem3_subject5_name);
                t6.setText(aeronautical_sem3_subject6_name);
                t7.setText(aeronautical_sem3_subject7_name);
                t8.setText(aeronautical_sem3_subject8_name);
                t9.setText(aeronautical_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = aeronautical_sem4_subject1_credit;
                subject2_credit = aeronautical_sem4_subject2_credit;
                subject3_credit = aeronautical_sem4_subject3_credit;
                subject4_credit = aeronautical_sem4_subject4_credit;
                subject5_credit = aeronautical_sem4_subject5_credit;
                subject6_credit = aeronautical_sem4_subject6_credit;
                subject7_credit = aeronautical_sem4_subject7_credit;
                subject8_credit = aeronautical_sem4_subject8_credit;

                t1.setText(aeronautical_sem4_subject1_name);
                t2.setText(aeronautical_sem4_subject2_name);
                t3.setText(aeronautical_sem4_subject3_name);
                t4.setText(aeronautical_sem4_subject4_name);
                t5.setText(aeronautical_sem4_subject5_name);
                t6.setText(aeronautical_sem4_subject6_name);
                t7.setText(aeronautical_sem4_subject7_name);
                t8.setText(aeronautical_sem4_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = aeronautical_sem5_subject1_credit;
                subject2_credit = aeronautical_sem5_subject2_credit;
                subject3_credit = aeronautical_sem5_subject3_credit;
                subject4_credit = aeronautical_sem5_subject4_credit;
                subject5_credit = aeronautical_sem5_subject5_credit;
                subject6_credit = aeronautical_sem5_subject6_credit;
                subject7_credit = aeronautical_sem5_subject7_credit;
                subject8_credit = aeronautical_sem5_subject8_credit;
                subject9_credit = aeronautical_sem5_subject9_credit;

                t1.setText(aeronautical_sem5_subject1_name);
                t2.setText(aeronautical_sem5_subject2_name);
                t3.setText(aeronautical_sem5_subject3_name);
                t4.setText(aeronautical_sem5_subject4_name);
                t5.setText(aeronautical_sem5_subject5_name);
                t6.setText(aeronautical_sem5_subject6_name);
                t7.setText(aeronautical_sem5_subject7_name);
                t8.setText(aeronautical_sem5_subject8_name);
                t9.setText(aeronautical_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = aeronautical_sem6_subject1_credit;
                subject2_credit = aeronautical_sem6_subject2_credit;
                subject3_credit = aeronautical_sem6_subject3_credit;
                subject4_credit = aeronautical_sem6_subject4_credit;
                subject5_credit = aeronautical_sem6_subject5_credit;
                subject6_credit = aeronautical_sem6_subject6_credit;
                subject7_credit = aeronautical_sem6_subject7_credit;
                subject8_credit = aeronautical_sem6_subject8_credit;
                subject9_credit = aeronautical_sem6_subject9_credit;

                t1.setText(aeronautical_sem6_subject1_name);
                t2.setText(aeronautical_sem6_subject2_name);
                t3.setText(aeronautical_sem6_subject3_name);
                t4.setText(aeronautical_sem6_subject4_name);
                t5.setText(aeronautical_sem6_subject5_name);
                t6.setText(aeronautical_sem6_subject6_name);
                t7.setText(aeronautical_sem6_subject7_name);
                t8.setText(aeronautical_sem6_subject8_name);
                t9.setText(aeronautical_sem6_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = aeronautical_sem7_subject1_credit;
                subject2_credit = aeronautical_sem7_subject2_credit;
                subject3_credit = aeronautical_sem7_subject3_credit;
                subject4_credit = aeronautical_sem7_subject4_credit;
                subject5_credit = aeronautical_sem7_subject5_credit;
                subject6_credit = aeronautical_sem7_subject6_credit;
                subject7_credit = aeronautical_sem7_subject7_credit;
                subject8_credit = aeronautical_sem7_subject8_credit;
                subject9_credit = aeronautical_sem7_subject9_credit;

                t1.setText(aeronautical_sem7_subject1_name);
                t2.setText(aeronautical_sem7_subject2_name);
                t3.setText(aeronautical_sem7_subject3_name);
                t4.setText(aeronautical_sem7_subject4_name);
                t5.setText(aeronautical_sem7_subject5_name);
                t6.setText(aeronautical_sem7_subject6_name);
                t7.setText(aeronautical_sem7_subject7_name);
                t8.setText(aeronautical_sem7_subject8_name);
                t9.setText(aeronautical_sem7_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = aeronautical_sem8_subject1_credit;
                subject2_credit = aeronautical_sem8_subject2_credit;
                subject3_credit = aeronautical_sem8_subject3_credit;

                t1.setText(aeronautical_sem8_subject1_name);
                t2.setText(aeronautical_sem8_subject2_name);
                t3.setText(aeronautical_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("7"))//e_and_i
        {
            showdepart.setText("E & I");
            //sem checking conde_and_iion
            //t8.setVisibile_and_iy(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = e_and_i_sem1_subject1_credit;
                subject2_credit = e_and_i_sem1_subject2_credit;
                subject3_credit = e_and_i_sem1_subject3_credit;
                subject4_credit = e_and_i_sem1_subject4_credit;
                subject5_credit = e_and_i_sem1_subject5_credit;
                subject6_credit = e_and_i_sem1_subject6_credit;
                subject7_credit = e_and_i_sem1_subject7_credit;
                subject8_credit = e_and_i_sem1_subject8_credit;

                t1.setText(e_and_i_sem1_subject1_name);
                t2.setText(e_and_i_sem1_subject2_name);
                t3.setText(e_and_i_sem1_subject3_name);
                t4.setText(e_and_i_sem1_subject4_name);
                t5.setText(e_and_i_sem1_subject5_name);
                t6.setText(e_and_i_sem1_subject6_name);
                t7.setText(e_and_i_sem1_subject7_name);
                t8.setText(e_and_i_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibile_and_iy(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = e_and_i_sem2_subject1_credit;
                subject2_credit = e_and_i_sem2_subject2_credit;
                subject3_credit = e_and_i_sem2_subject3_credit;
                subject4_credit = e_and_i_sem2_subject4_credit;
                subject5_credit = e_and_i_sem2_subject5_credit;
                subject6_credit = e_and_i_sem2_subject6_credit;
                subject7_credit = e_and_i_sem2_subject7_credit;
                subject8_credit = e_and_i_sem2_subject8_credit;

                t1.setText(e_and_i_sem2_subject1_name);
                t2.setText(e_and_i_sem2_subject2_name);
                t3.setText(e_and_i_sem2_subject3_name);
                t4.setText(e_and_i_sem2_subject4_name);
                t5.setText(e_and_i_sem2_subject5_name);
                t6.setText(e_and_i_sem2_subject6_name);
                t7.setText(e_and_i_sem2_subject7_name);
                t8.setText(e_and_i_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = e_and_i_sem3_subject1_credit;
                subject2_credit = e_and_i_sem3_subject2_credit;
                subject3_credit = e_and_i_sem3_subject3_credit;
                subject4_credit = e_and_i_sem3_subject4_credit;
                subject5_credit = e_and_i_sem3_subject5_credit;
                subject6_credit = e_and_i_sem3_subject6_credit;
                subject7_credit = e_and_i_sem3_subject7_credit;
                subject8_credit = e_and_i_sem3_subject8_credit;

                t1.setText(e_and_i_sem3_subject1_name);
                t2.setText(e_and_i_sem3_subject2_name);
                t3.setText(e_and_i_sem3_subject3_name);
                t4.setText(e_and_i_sem3_subject4_name);
                t5.setText(e_and_i_sem3_subject5_name);
                t6.setText(e_and_i_sem3_subject6_name);
                t7.setText(e_and_i_sem3_subject7_name);
                t8.setText(e_and_i_sem3_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = e_and_i_sem4_subject1_credit;
                subject2_credit = e_and_i_sem4_subject2_credit;
                subject3_credit = e_and_i_sem4_subject3_credit;
                subject4_credit = e_and_i_sem4_subject4_credit;
                subject5_credit = e_and_i_sem4_subject5_credit;
                subject6_credit = e_and_i_sem4_subject6_credit;
                subject7_credit = e_and_i_sem4_subject7_credit;
                subject8_credit = e_and_i_sem4_subject8_credit;

                t1.setText(e_and_i_sem4_subject1_name);
                t2.setText(e_and_i_sem4_subject2_name);
                t3.setText(e_and_i_sem4_subject3_name);
                t4.setText(e_and_i_sem4_subject4_name);
                t5.setText(e_and_i_sem4_subject5_name);
                t6.setText(e_and_i_sem4_subject6_name);
                t7.setText(e_and_i_sem4_subject7_name);
                t8.setText(e_and_i_sem4_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = e_and_i_sem5_subject1_credit;
                subject2_credit = e_and_i_sem5_subject2_credit;
                subject3_credit = e_and_i_sem5_subject3_credit;
                subject4_credit = e_and_i_sem5_subject4_credit;
                subject5_credit = e_and_i_sem5_subject5_credit;
                subject6_credit = e_and_i_sem5_subject6_credit;
                subject7_credit = e_and_i_sem5_subject7_credit;
                subject8_credit = e_and_i_sem5_subject8_credit;

                t1.setText(e_and_i_sem5_subject1_name);
                t2.setText(e_and_i_sem5_subject2_name);
                t3.setText(e_and_i_sem5_subject3_name);
                t4.setText(e_and_i_sem5_subject4_name);
                t5.setText(e_and_i_sem5_subject5_name);
                t6.setText(e_and_i_sem5_subject6_name);
                t7.setText(e_and_i_sem5_subject7_name);
                t8.setText(e_and_i_sem5_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = e_and_i_sem6_subject1_credit;
                subject2_credit = e_and_i_sem6_subject2_credit;
                subject3_credit = e_and_i_sem6_subject3_credit;
                subject4_credit = e_and_i_sem6_subject4_credit;
                subject5_credit = e_and_i_sem6_subject5_credit;
                subject6_credit = e_and_i_sem6_subject6_credit;
                subject7_credit = e_and_i_sem6_subject7_credit;
                subject8_credit = e_and_i_sem6_subject8_credit;
                subject9_credit = e_and_i_sem6_subject9_credit;

                t1.setText(e_and_i_sem6_subject1_name);
                t2.setText(e_and_i_sem6_subject2_name);
                t3.setText(e_and_i_sem6_subject3_name);
                t4.setText(e_and_i_sem6_subject4_name);
                t5.setText(e_and_i_sem6_subject5_name);
                t6.setText(e_and_i_sem6_subject6_name);
                t7.setText(e_and_i_sem6_subject7_name);
                t8.setText(e_and_i_sem6_subject8_name);
                t9.setText(e_and_i_sem6_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = e_and_i_sem7_subject1_credit;
                subject2_credit = e_and_i_sem7_subject2_credit;
                subject3_credit = e_and_i_sem7_subject3_credit;
                subject4_credit = e_and_i_sem7_subject4_credit;
                subject5_credit = e_and_i_sem7_subject5_credit;
                subject6_credit = e_and_i_sem7_subject6_credit;
                subject7_credit = e_and_i_sem7_subject7_credit;
                subject8_credit = e_and_i_sem7_subject8_credit;

                t1.setText(e_and_i_sem7_subject1_name);
                t2.setText(e_and_i_sem7_subject2_name);
                t3.setText(e_and_i_sem7_subject3_name);
                t4.setText(e_and_i_sem7_subject4_name);
                t5.setText(e_and_i_sem7_subject5_name);
                t6.setText(e_and_i_sem7_subject6_name);
                t7.setText(e_and_i_sem7_subject7_name);
                t8.setText(e_and_i_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = e_and_i_sem8_subject1_credit;
                subject2_credit = e_and_i_sem8_subject2_credit;
                subject3_credit = e_and_i_sem8_subject3_credit;

                t1.setText(e_and_i_sem8_subject1_name);
                t2.setText(e_and_i_sem8_subject2_name);
                t3.setText(e_and_i_sem8_subject3_name);

                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("8"))//automobile
        {
            showdepart.setText("AUTOMOBILE");
            //sem checking condition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = automobile_sem1_subject1_credit;
                subject2_credit = automobile_sem1_subject2_credit;
                subject3_credit = automobile_sem1_subject3_credit;
                subject4_credit = automobile_sem1_subject4_credit;
                subject5_credit = automobile_sem1_subject5_credit;
                subject6_credit = automobile_sem1_subject6_credit;
                subject7_credit = automobile_sem1_subject7_credit;
                subject8_credit = automobile_sem1_subject8_credit;

                t1.setText(automobile_sem1_subject1_name);
                t2.setText(automobile_sem1_subject2_name);
                t3.setText(automobile_sem1_subject3_name);
                t4.setText(automobile_sem1_subject4_name);
                t5.setText(automobile_sem1_subject5_name);
                t6.setText(automobile_sem1_subject6_name);
                t7.setText(automobile_sem1_subject7_name);
                t8.setText(automobile_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibilautomobiley(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = automobile_sem2_subject1_credit;
                subject2_credit = automobile_sem2_subject2_credit;
                subject3_credit = automobile_sem2_subject3_credit;
                subject4_credit = automobile_sem2_subject4_credit;
                subject5_credit = automobile_sem2_subject5_credit;
                subject6_credit = automobile_sem2_subject6_credit;
                subject7_credit = automobile_sem2_subject7_credit;
                subject8_credit = automobile_sem2_subject8_credit;

                t1.setText(automobile_sem2_subject1_name);
                t2.setText(automobile_sem2_subject2_name);
                t3.setText(automobile_sem2_subject3_name);
                t4.setText(automobile_sem2_subject4_name);
                t5.setText(automobile_sem2_subject5_name);
                t6.setText(automobile_sem2_subject6_name);
                t7.setText(automobile_sem2_subject7_name);
                t8.setText(automobile_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = automobile_sem3_subject1_credit;
                subject2_credit = automobile_sem3_subject2_credit;
                subject3_credit = automobile_sem3_subject3_credit;
                subject4_credit = automobile_sem3_subject4_credit;
                subject5_credit = automobile_sem3_subject5_credit;
                subject6_credit = automobile_sem3_subject6_credit;
                subject7_credit = automobile_sem3_subject7_credit;
                subject8_credit = automobile_sem3_subject8_credit;
                subject9_credit = automobile_sem3_subject9_credit;

                t1.setText(automobile_sem3_subject1_name);
                t2.setText(automobile_sem3_subject2_name);
                t3.setText(automobile_sem3_subject3_name);
                t4.setText(automobile_sem3_subject4_name);
                t5.setText(automobile_sem3_subject5_name);
                t6.setText(automobile_sem3_subject6_name);
                t7.setText(automobile_sem3_subject7_name);
                t8.setText(automobile_sem3_subject8_name);
                t9.setText(automobile_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = automobile_sem4_subject1_credit;
                subject2_credit = automobile_sem4_subject2_credit;
                subject3_credit = automobile_sem4_subject3_credit;
                subject4_credit = automobile_sem4_subject4_credit;
                subject5_credit = automobile_sem4_subject5_credit;
                subject6_credit = automobile_sem4_subject6_credit;
                subject7_credit = automobile_sem4_subject7_credit;
                subject8_credit = automobile_sem4_subject8_credit;

                t1.setText(automobile_sem4_subject1_name);
                t2.setText(automobile_sem4_subject2_name);
                t3.setText(automobile_sem4_subject3_name);
                t4.setText(automobile_sem4_subject4_name);
                t5.setText(automobile_sem4_subject5_name);
                t6.setText(automobile_sem4_subject6_name);
                t7.setText(automobile_sem4_subject7_name);
                t8.setText(automobile_sem4_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = automobile_sem5_subject1_credit;
                subject2_credit = automobile_sem5_subject2_credit;
                subject3_credit = automobile_sem5_subject3_credit;
                subject4_credit = automobile_sem5_subject4_credit;
                subject5_credit = automobile_sem5_subject5_credit;
                subject6_credit = automobile_sem5_subject6_credit;
                subject7_credit = automobile_sem5_subject7_credit;
                subject8_credit = automobile_sem5_subject8_credit;
                subject9_credit = automobile_sem5_subject9_credit;

                t1.setText(automobile_sem5_subject1_name);
                t2.setText(automobile_sem5_subject2_name);
                t3.setText(automobile_sem5_subject3_name);
                t4.setText(automobile_sem5_subject4_name);
                t5.setText(automobile_sem5_subject5_name);
                t6.setText(automobile_sem5_subject6_name);
                t7.setText(automobile_sem5_subject7_name);
                t8.setText(automobile_sem5_subject8_name);
                t9.setText(automobile_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = automobile_sem6_subject1_credit;
                subject2_credit = automobile_sem6_subject2_credit;
                subject3_credit = automobile_sem6_subject3_credit;
                subject4_credit = automobile_sem6_subject4_credit;
                subject5_credit = automobile_sem6_subject5_credit;
                subject6_credit = automobile_sem6_subject6_credit;
                subject7_credit = automobile_sem6_subject7_credit;
                subject8_credit = automobile_sem6_subject8_credit;

                t1.setText(automobile_sem6_subject1_name);
                t2.setText(automobile_sem6_subject2_name);
                t3.setText(automobile_sem6_subject3_name);
                t4.setText(automobile_sem6_subject4_name);
                t5.setText(automobile_sem6_subject5_name);
                t6.setText(automobile_sem6_subject6_name);
                t7.setText(automobile_sem6_subject7_name);
                t8.setText(automobile_sem6_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = automobile_sem7_subject1_credit;
                subject2_credit = automobile_sem7_subject2_credit;
                subject3_credit = automobile_sem7_subject3_credit;
                subject4_credit = automobile_sem7_subject4_credit;
                subject5_credit = automobile_sem7_subject5_credit;
                subject6_credit = automobile_sem7_subject6_credit;
                subject7_credit = automobile_sem7_subject7_credit;
                subject8_credit = automobile_sem7_subject8_credit;

                t1.setText(automobile_sem7_subject1_name);
                t2.setText(automobile_sem7_subject2_name);
                t3.setText(automobile_sem7_subject3_name);
                t4.setText(automobile_sem7_subject4_name);
                t5.setText(automobile_sem7_subject5_name);
                t6.setText(automobile_sem7_subject6_name);
                t7.setText(automobile_sem7_subject7_name);
                t8.setText(automobile_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = automobile_sem8_subject1_credit;
                subject2_credit = automobile_sem8_subject2_credit;
                subject3_credit = automobile_sem8_subject3_credit;
                subject4_credit = automobile_sem8_subject4_credit;

                t1.setText(automobile_sem8_subject1_name);
                t2.setText(automobile_sem8_subject2_name);
                t3.setText(automobile_sem8_subject3_name);
                t4.setText(automobile_sem8_subject4_name);

                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        } else if (depart.equals("9"))//biotechnology
        {
            showdepart.setText("BIOTECHNOLOGY");
            //sem checking condbition
            //t8.setVisibility(View.INVISIBLE);
            if (sem.equals("0"))//sem1
            {
                showsem.setText("1");
                subject1_credit = biotechnology_sem1_subject1_credit;
                subject2_credit = biotechnology_sem1_subject2_credit;
                subject3_credit = biotechnology_sem1_subject3_credit;
                subject4_credit = biotechnology_sem1_subject4_credit;
                subject5_credit = biotechnology_sem1_subject5_credit;
                subject6_credit = biotechnology_sem1_subject6_credit;
                subject7_credit = biotechnology_sem1_subject7_credit;
                subject8_credit = biotechnology_sem1_subject8_credit;

                t1.setText(biotechnology_sem1_subject1_name);
                t2.setText(biotechnology_sem1_subject2_name);
                t3.setText(biotechnology_sem1_subject3_name);
                t4.setText(biotechnology_sem1_subject4_name);
                t5.setText(biotechnology_sem1_subject5_name);
                t6.setText(biotechnology_sem1_subject6_name);
                t7.setText(biotechnology_sem1_subject7_name);
                t8.setText(biotechnology_sem1_subject8_name);

                //layout handling
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();


                //l9.setVisibilbiotechnologyy(View.INVISIBLE);
            } else if (sem.equals("1"))//sem2
            {
                showsem.setText("2");
                subject1_credit = biotechnology_sem2_subject1_credit;
                subject2_credit = biotechnology_sem2_subject2_credit;
                subject3_credit = biotechnology_sem2_subject3_credit;
                subject4_credit = biotechnology_sem2_subject4_credit;
                subject5_credit = biotechnology_sem2_subject5_credit;
                subject6_credit = biotechnology_sem2_subject6_credit;
                subject7_credit = biotechnology_sem2_subject7_credit;
                subject8_credit = biotechnology_sem2_subject8_credit;

                t1.setText(biotechnology_sem2_subject1_name);
                t2.setText(biotechnology_sem2_subject2_name);
                t3.setText(biotechnology_sem2_subject3_name);
                t4.setText(biotechnology_sem2_subject4_name);
                t5.setText(biotechnology_sem2_subject5_name);
                t6.setText(biotechnology_sem2_subject6_name);
                t7.setText(biotechnology_sem2_subject7_name);
                t8.setText(biotechnology_sem2_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();

            } else if (sem.equals("2"))//sem3
            {
                showsem.setText("3");
                subject1_credit = biotechnology_sem3_subject1_credit;
                subject2_credit = biotechnology_sem3_subject2_credit;
                subject3_credit = biotechnology_sem3_subject3_credit;
                subject4_credit = biotechnology_sem3_subject4_credit;
                subject5_credit = biotechnology_sem3_subject5_credit;
                subject6_credit = biotechnology_sem3_subject6_credit;
                subject7_credit = biotechnology_sem3_subject7_credit;
                subject8_credit = biotechnology_sem3_subject8_credit;
                subject9_credit = biotechnology_sem3_subject9_credit;

                t1.setText(biotechnology_sem3_subject1_name);
                t2.setText(biotechnology_sem3_subject2_name);
                t3.setText(biotechnology_sem3_subject3_name);
                t4.setText(biotechnology_sem3_subject4_name);
                t5.setText(biotechnology_sem3_subject5_name);
                t6.setText(biotechnology_sem3_subject6_name);
                t7.setText(biotechnology_sem3_subject7_name);
                t8.setText(biotechnology_sem3_subject8_name);
                t9.setText(biotechnology_sem3_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("3"))//sem4
            {
                showsem.setText("4");
                subject1_credit = biotechnology_sem4_subject1_credit;
                subject2_credit = biotechnology_sem4_subject2_credit;
                subject3_credit = biotechnology_sem4_subject3_credit;
                subject4_credit = biotechnology_sem4_subject4_credit;
                subject5_credit = biotechnology_sem4_subject5_credit;
                subject6_credit = biotechnology_sem4_subject6_credit;
                subject7_credit = biotechnology_sem4_subject7_credit;
                subject8_credit = biotechnology_sem4_subject8_credit;
                subject9_credit = biotechnology_sem4_subject9_credit;

                t1.setText(biotechnology_sem4_subject1_name);
                t2.setText(biotechnology_sem4_subject2_name);
                t3.setText(biotechnology_sem4_subject3_name);
                t4.setText(biotechnology_sem4_subject4_name);
                t5.setText(biotechnology_sem4_subject5_name);
                t6.setText(biotechnology_sem4_subject6_name);
                t7.setText(biotechnology_sem4_subject7_name);
                t8.setText(biotechnology_sem4_subject8_name);
                t9.setText(biotechnology_sem4_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("4"))//sem5
            {
                showsem.setText("5");
                subject1_credit = biotechnology_sem5_subject1_credit;
                subject2_credit = biotechnology_sem5_subject2_credit;
                subject3_credit = biotechnology_sem5_subject3_credit;
                subject4_credit = biotechnology_sem5_subject4_credit;
                subject5_credit = biotechnology_sem5_subject5_credit;
                subject6_credit = biotechnology_sem5_subject6_credit;
                subject7_credit = biotechnology_sem5_subject7_credit;
                subject8_credit = biotechnology_sem5_subject8_credit;
                subject9_credit = biotechnology_sem5_subject9_credit;

                t1.setText(biotechnology_sem5_subject1_name);
                t2.setText(biotechnology_sem5_subject2_name);
                t3.setText(biotechnology_sem5_subject3_name);
                t4.setText(biotechnology_sem5_subject4_name);
                t5.setText(biotechnology_sem5_subject5_name);
                t6.setText(biotechnology_sem5_subject6_name);
                t7.setText(biotechnology_sem5_subject7_name);
                t8.setText(biotechnology_sem5_subject8_name);
                t9.setText(biotechnology_sem5_subject9_name);

                l10.removeAllViewsInLayout();
            } else if (sem.equals("5"))//sem6
            {
                showsem.setText("6");
                subject1_credit = biotechnology_sem6_subject1_credit;
                subject2_credit = biotechnology_sem6_subject2_credit;
                subject3_credit = biotechnology_sem6_subject3_credit;
                subject4_credit = biotechnology_sem6_subject4_credit;
                subject5_credit = biotechnology_sem6_subject5_credit;
                subject6_credit = biotechnology_sem6_subject6_credit;
                subject7_credit = biotechnology_sem6_subject7_credit;
                subject8_credit = biotechnology_sem6_subject8_credit;

                t1.setText(biotechnology_sem6_subject1_name);
                t2.setText(biotechnology_sem6_subject2_name);
                t3.setText(biotechnology_sem6_subject3_name);
                t4.setText(biotechnology_sem6_subject4_name);
                t5.setText(biotechnology_sem6_subject5_name);
                t6.setText(biotechnology_sem6_subject6_name);
                t7.setText(biotechnology_sem6_subject7_name);
                t8.setText(biotechnology_sem6_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();

            } else if (sem.equals("6"))//sem7
            {
                showsem.setText("7");
                subject1_credit = biotechnology_sem7_subject1_credit;
                subject2_credit = biotechnology_sem7_subject2_credit;
                subject3_credit = biotechnology_sem7_subject3_credit;
                subject4_credit = biotechnology_sem7_subject4_credit;
                subject5_credit = biotechnology_sem7_subject5_credit;
                subject6_credit = biotechnology_sem7_subject6_credit;
                subject7_credit = biotechnology_sem7_subject7_credit;
                subject8_credit = biotechnology_sem7_subject8_credit;

                t1.setText(biotechnology_sem7_subject1_name);
                t2.setText(biotechnology_sem7_subject2_name);
                t3.setText(biotechnology_sem7_subject3_name);
                t4.setText(biotechnology_sem7_subject4_name);
                t5.setText(biotechnology_sem7_subject5_name);
                t6.setText(biotechnology_sem7_subject6_name);
                t7.setText(biotechnology_sem7_subject7_name);
                t8.setText(biotechnology_sem7_subject8_name);

                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            } else if (sem.equals("7"))//sem8
            {
                showsem.setText("8");
                subject1_credit = biotechnology_sem8_subject1_credit;

                t1.setText(biotechnology_sem8_subject1_name);

                l2.removeAllViewsInLayout();
                l3.removeAllViewsInLayout();
                l4.removeAllViewsInLayout();
                l5.removeAllViewsInLayout();
                l6.removeAllViewsInLayout();
                l7.removeAllViewsInLayout();
                l8.removeAllViewsInLayout();
                l9.removeAllViewsInLayout();
                l10.removeAllViewsInLayout();
            }
        }
    }
}
