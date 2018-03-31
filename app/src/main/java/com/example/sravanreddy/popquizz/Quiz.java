package com.example.sravanreddy.popquizz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Quiz extends AppCompatActivity {
    String answer;
RadioButton optionSelected;
RadioButton option1,option2, option3, option4;
int count;
TextView questionNumber;
Button nextQuestion;
TextView question;
QuestionBank questionBank[];
Questions questions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        answer="";
        questionNumber=findViewById(R.id.question_no);
        count=1;
        questionNumber.setText("Question:"+count);
        nextQuestion=findViewById(R.id.next_question);
        questionBank=new QuestionBank[5];
        for(int i=0;i<5;i++) questionBank[i]=new QuestionBank();
        populateQuestionBank();
        getHandlersForRadio();
        questions=new Questions();
        setQuestions(count-1);

    }

    public void setQuestions(int n){
        question.setText(questionBank[n].getQuestion());
        option1.setText(questionBank[n].getOption1());
        option2.setText(questionBank[n].getOption2());
        option3.setText(questionBank[n].getOption3());
        option4.setText(questionBank[n].getOption4());
    }

    private void getHandlersForRadio() {
        question=findViewById(R.id.question);
        option1=findViewById(R.id.option_one);
        option2=findViewById(R.id.option_two);
        option3=findViewById(R.id.option_three);
        option4=findViewById(R.id.option_four);
    }

    private void populateQuestionBank() {
        questionBank[0].addData("The Eiffel Tower is located where in Paris?","Bois de Boulogne", "Jardin des Plantes", "Parc de Belleville", "Champ de Mars", "Champ de Mars");
        questionBank[1].addData( "Which Apollo mission landed the first humans on the Moon?", "Apollo 7", "Apollo 9", "Apollo 11", "Apollo 13", "Apollo 11");
        questionBank[2].addData("Who starred in the 1959 epic film 'Ben-Hur'?", "Charlton Heston", "Clark Gable","Errol Flynn", "Lee Marvin", "Charlton Heston");
        questionBank[3].addData("What is the International Air Transport Association airport code for Heathrow Airport?", "HRW", "HTR","LHR", "LHW", "LHR");
        questionBank[4].addData("The reactor at the site of the Chernobyl nuclear disaster is now in which country?", "Ukraine", "Slovakia", "Hungary", "Russia", "Ukraine");
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.option_one:
                if (checked)
                {optionSelected=findViewById(R.id.option_one);
                answer=optionSelected.getText().toString();}
                    break;
            case R.id.option_two:
                if (checked)
                {optionSelected=findViewById(R.id.option_two);
                    answer=optionSelected.getText().toString();}
                break;
            case R.id.option_three:
                if (checked)
                {optionSelected=findViewById(R.id.option_three);
                    answer=optionSelected.getText().toString();}

                break;
            case R.id.option_four:
                if (checked)
                {optionSelected=findViewById(R.id.option_four);
                    answer=optionSelected.getText().toString();}
                break;

        }
    }

    public void resetRadioButtons(){
       option1.setChecked(false);
       option2.setChecked(false);
       option3.setChecked(false);
       option4.setChecked(false);
    }
    public void clickHandler(View view) {
        if(count==5)
        {
            if (questionBank[count - 1].getCorrectOption().equals(answer)) {
                questionBank[count - 1].isCorrect(true);
            }
            Intent i=new Intent(Quiz.this, Result.class);
            Bundle b = new Bundle();
            b.putSerializable("Questions", questionBank);
            i.putExtras(b);
            i.setClass(this, Result.class);
            startActivity(i);
            finish();
        }
       else if(count<=5) {
            if(answer==""){
                AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                dialog.setTitle("No Option Selected");
                dialog.setMessage("Do you want to continue with no option selected?");
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (questionBank[count - 1].getCorrectOption().equals(answer)) {
                            questionBank[count - 1].isCorrect(true);
                        }
                        resetRadioButtons();
                        count++;
                        questionNumber.setText("Question:"+count);
                        setQuestions(count - 1);
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      return;
                    }
                });
                dialog.show();
            }
            else {
                if (questionBank[count - 1].getCorrectOption().equals(answer)) {
                    questionBank[count - 1].isCorrect(true);
                }
                resetRadioButtons();
                count++;
                questionNumber.setText("Question:" + count);
                setQuestions(count - 1);
            }
        }

    }
}
