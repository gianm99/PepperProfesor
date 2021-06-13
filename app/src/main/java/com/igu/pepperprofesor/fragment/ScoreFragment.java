package com.igu.pepperprofesor.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.MainActivity;
import com.igu.pepperprofesor.R;

public class ScoreFragment extends Fragment {
    private int score;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) score = getArguments().getInt(MainActivity.SCORE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        TextView t = view.findViewById(R.id.score);
        TextView r = view.findViewById(R.id.puntos);
        TextView n = view.findViewById(R.id.notaScore);
        t.setText(Integer.toString(score));
        if (score < 5) {
            n.setText("SUSPENDIDO");
            n.setTextColor(Color.parseColor("#FF0000"));
            t.setTextColor(Color.parseColor("#FF0000"));
            r.setTextColor(Color.parseColor("#FF0000"));
        } else if (score < 7) {
            n.setText("APROBADO");
            n.setTextColor(Color.parseColor("#00FF00"));
            t.setTextColor(Color.parseColor("#00FF00"));
            r.setTextColor(Color.parseColor("#00FF00"));

        } else if (score < 9) {
            n.setText("NOTABLE");
            n.setTextColor(Color.parseColor("#0000FF"));
            t.setTextColor(Color.parseColor("#0000FF"));
            r.setTextColor(Color.parseColor("#0000FF"));

        } else {
            n.setText("EXCELENTE");
        }
        return view;
    }
}