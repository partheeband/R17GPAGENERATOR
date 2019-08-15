package com.example.r17gpagenerator;

public class Subject {
    public Integer calculate_Gradepoint(Integer grade){
        Integer gradepoint = null;

        if (grade==0)
            gradepoint=10;
        else if (grade==1)
            gradepoint=9;
        else if (grade==2)
            gradepoint=8;
        else if (grade==3)
            gradepoint=7;
        else if (grade==4)
            gradepoint=6;
        else
            gradepoint=0;

        return gradepoint;
    }
}
