package com.igu.pepperprofesor.fragment.question;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.MainActivity;
import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.question.ImageQuestion;

public class ImageQuestionFragment extends Fragment {
    private ImageQuestion q;
    private int qNumber;

    public ImageQuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            q = (ImageQuestion) getArguments().getSerializable(MainActivity.QUESTION_KEY);
            qNumber = getArguments().getInt(MainActivity.QUESTION_NUMBER_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_image, container, false);
        TextView t = view.findViewById(R.id.enunciadoImagen);
        TextView n = view.findViewById(R.id.scoreqi);
        ImageView iv = view.findViewById(R.id.imagenP);
        t.setText(q.getQuestion());
        n.setText(Integer.toString(qNumber));
        iv.setImageResource(q.getImageId());
        return view;
    }
}