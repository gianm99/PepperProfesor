package com.igu.pepperprofesor.fragment.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.MainActivity;
import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.question.Question;

public class QuestionFragment extends Fragment {
    private Question q;
    private int qNumber;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            q = (Question) getArguments().getSerializable(MainActivity.QUESTION_KEY);
            qNumber = getArguments().getInt(MainActivity.QUESTION_NUMBER_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        TextView t = view.findViewById(R.id.preguntaAbierta);
        TextView n = view.findViewById(R.id.scoreq);
        t.setText(q.getQuestion());
        n.setText(Integer.toString(qNumber));
        return view;
    }
}