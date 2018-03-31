package com.example.sravanreddy.popquizz;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by sravanreddy on 3/31/18.
 */

public class QuestionBank implements Serializable{
    private String question, option1, option2, option3,option4, correctOption;
    boolean isCorrect=false;
    public void addData(String question, String option1, String option2, String option3, String option4, String correctOption){
        this.question=question;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.correctOption=correctOption;
    }
    public void isCorrect(boolean flag){
        isCorrect=flag;
    }
    public String getQuestion(){
        return question;
    }
    public String getOption1(){
        return option1;
    }
    public String getOption2(){
        return option2;
    }
    public String getOption3(){
        return option3;
    }
    public String getOption4(){
        return option4;
    }
    public String getCorrectOption(){
        return correctOption;
    }
    public String getIsCorrect(){
       if(isCorrect==true) return "Correct";
       else return "Wrong";
    }

}
