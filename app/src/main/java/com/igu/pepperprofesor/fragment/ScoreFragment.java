package com.igu.pepperprofesor.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.Subject;
import com.igu.pepperprofesor.object.question.OptionQuestion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int nota;
    private Subject s;

    public ScoreFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScoreFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScoreFragment newInstance(String param1, String param2) {
        ScoreFragment fragment = new ScoreFragment();
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
            s = (Subject) getArguments().getSerializable("subject");
            nota = getArguments().getInt("score");
                   }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        TextView t = (TextView) view.findViewById(R.id.score);
        TextView r = (TextView) view.findViewById(R.id.puntos);
        TextView n = (TextView) view.findViewById(R.id.notaScore);
        t.setText(Integer.toString(nota));
        if (nota < 5) {
            n.setText("SUSPENDIDO");
            n.setTextColor(Color.parseColor("#FF0000"));
            t.setTextColor(Color.parseColor("#FF0000"));
            r.setTextColor(Color.parseColor("#FF0000"));
        } else if (nota >= 5 && nota < 7) {
            n.setText("APROBADO");
            n.setTextColor(Color.parseColor("#00FF00"));
            t.setTextColor(Color.parseColor("#00FF00"));
            r.setTextColor(Color.parseColor("#00FF00"));

        } else if (nota >= 7 && nota < 9) {
            n.setText("NOTABLE");
            n.setTextColor(Color.parseColor("#0000FF"));
            t.setTextColor(Color.parseColor("#0000FF"));
            r.setTextColor(Color.parseColor("#0000FF"));

        } else  {
            n.setText("EXCELENTE");
                    }

        return view;
    }
}