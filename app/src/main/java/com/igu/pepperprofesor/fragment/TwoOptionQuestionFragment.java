package com.igu.pepperprofesor.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.question.Question;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TwoOptionQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoOptionQuestionFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Question q;
    private int qNumber;

    public TwoOptionQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment option2fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TwoOptionQuestionFragment newInstance(String param1, String param2) {
        TwoOptionQuestionFragment fragment = new TwoOptionQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            q = (Question) getArguments().getSerializable("question");
            qNumber = getArguments().getInt("questionNumber");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_option2, container, false);
        TextView t = (TextView) view.findViewById(R.id.enunciado2);
        TextView n = (TextView) view.findViewById(R.id.score2);
        t.setText(q.getQuestion());
        n.setText(Integer.toString(qNumber));
        return view;
    }
}