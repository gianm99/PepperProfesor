package com.igu.pepperprofesor.fragment.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.MainActivity;
import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.question.OptionQuestion;

public class ThreeOptionQuestionFragment extends Fragment {
    private OptionQuestion q;
    private int qNumber;

    public ThreeOptionQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            q = (OptionQuestion) getArguments().getSerializable(MainActivity.QUESTION_KEY);
            qNumber = getArguments().getInt(MainActivity.QUESTION_NUMBER_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_option3, container, false);
        TextView t = view.findViewById(R.id.enunciado3);
        TextView n = view.findViewById(R.id.score3);
        TextView rA = view.findViewById(R.id.respuestaA3);
        TextView rB = view.findViewById(R.id.respuestaB3);
        TextView rC = view.findViewById(R.id.respuestaC3);
        t.setText(q.getQuestion());
        rA.setText(q.getOptionList().get(0).getText());
        rB.setText(q.getOptionList().get(1).getText());
        rC.setText(q.getOptionList().get(2).getText());
        n.setText(Integer.toString(qNumber));
        return view;
    }
}