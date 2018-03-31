package com.example.sravanreddy.popquizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Result extends AppCompatActivity {
    ListView list;
    int score=0;
    ArrayList<String> questions, results;
    QuestionBank questionBank[];
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        name=findViewById(R.id.userName);

        list=findViewById(R.id.listView);
        questions=new ArrayList<String>();
        results=new ArrayList<String>();
        Bundle bundleObject=getIntent().getExtras();
        questionBank= (QuestionBank[]) bundleObject.getSerializable("Questions");
        for(int i=0;i<5;i++){
            questions.add(questionBank[i].getQuestion());
            results.add(questionBank[i].getIsCorrect());
            if(results.get(i).equals("Correct")) score++;
        }
        name.setText("Hello "+MainActivity.username+": your score "+score+" out of 5");
        MyAdapter adapter=new MyAdapter(questions, results, this);
        list.setAdapter(adapter);
    }
}
