package com.example.sravanreddy.popquizz;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by sravanreddy on 3/31/18.
 */

public class Questions extends Fragment {
   // RadioButton option1,option2, option3, option4;
    //TextView question;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.questions, container,false);
//        question=view.findViewById(R.id.question);
//        option1=view.findViewById(R.id.option_one);
//        option2=view.findViewById(R.id.option_two);
//        option3=view.findViewById(R.id.option_three);
//        option4=view.findViewById(R.id.option_four);
        return  view;
    }


}
