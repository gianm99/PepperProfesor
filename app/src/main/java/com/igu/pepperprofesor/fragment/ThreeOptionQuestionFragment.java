package com.igu.pepperprofesor.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.question.OptionQuestion;
import com.igu.pepperprofesor.object.question.Question;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThreeOptionQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThreeOptionQuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private OptionQuestion q;
    private int qNumber;
    public ThreeOptionQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment option3fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThreeOptionQuestionFragment newInstance(String param1, String param2) {
        ThreeOptionQuestionFragment fragment = new ThreeOptionQuestionFragment();
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
            q = (OptionQuestion) getArguments().getSerializable("question");
            qNumber=  getArguments().getInt("questionNumber");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_option3, container, false);
        TextView t = (TextView) view.findViewById(R.id.enunciado3);
        TextView n = (TextView) view.findViewById(R.id.score3);
        TextView rA = (TextView) view.findViewById(R.id.respuestaA3);
        TextView rB = (TextView) view.findViewById(R.id.respuestaB3);
        TextView rC = (TextView) view.findViewById(R.id.respuestaC3);
        t.setText(q.getQuestion());
        rA.setText(q.getOptionList().get(0).getText());
        rB.setText(q.getOptionList().get(1).getText());
        rC.setText(q.getOptionList().get(2).getText());
        n.setText(Integer.toString(qNumber));
        return view;
    }
}