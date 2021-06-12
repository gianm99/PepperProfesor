package com.igu.pepperprofesor.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.igu.pepperprofesor.R;
import com.igu.pepperprofesor.object.question.ImageQuestion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageQuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private ImageQuestion q;
    private int qNumber;

    public ImageQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment imagefragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageQuestionFragment newInstance(String param1, String param2) {
        ImageQuestionFragment fragment = new ImageQuestionFragment();
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
            q = (ImageQuestion) getArguments().getSerializable("question");
            qNumber=  getArguments().getInt("questionNumber");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_image, container, false);
        TextView t = view.findViewById(R.id.enunciadoImagen);
        TextView n = view.findViewById(R.id.scoreqi);
        ImageView iv= view.findViewById(R.id.imagenP);
        t.setText(q.getQuestion());
        n.setText(Integer.toString(qNumber));
        iv.setImageResource(q.getImageId());
        return view;
    }
}