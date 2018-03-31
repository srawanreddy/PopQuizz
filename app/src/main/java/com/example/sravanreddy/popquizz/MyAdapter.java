package com.example.sravanreddy.popquizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sravanreddy on 3/31/18.
 */

public class MyAdapter extends BaseAdapter {
    ArrayList<String> questions, results;
    Context context;
    LayoutInflater layoutInflater;
    MyAdapter(    ArrayList<String> questions, ArrayList<String> results , Context context){
        this.context=context;
        this.questions=questions;
        this.results=results;
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.customlist, null);
        TextView question_textview=view.findViewById(R.id.question_result);
        TextView result_textview=view.findViewById(R.id.result_result);
        question_textview.setText(questions.get(i));
        result_textview.setText(results.get(i));
        return view;
    }
}
