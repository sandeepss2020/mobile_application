package com.example.intente_p5;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frag_nlp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag_nlp extends Fragment {

    Activity activity2;
    View parentHolder2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    MediaPlayer mp;

    public frag_nlp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frag_nlp.
     */
    // TODO: Rename and change types and number of parameters
    public static frag_nlp newInstance(String param1, String param2) {
        frag_nlp fragment = new frag_nlp();
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
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        activity2 = getActivity();

        mp = MediaPlayer.create(activity2.getBaseContext(), R.raw.video);
        mp.start();
        // play video => control(true), puase => control(false)
        return inflater.inflate(R.layout.fragment_frag_nlp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView btn_play = view.findViewById(R.id.btn_play);
        btn_play.setOnClickListener(v -> {
            control(true);
        });

        ImageView btn_pause = view.findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(v -> {
            control(false);
        });

    }

    private void control(boolean play) {
        if (play) {
            mp.start();
        } else {
            mp.pause();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mp.isPlaying()) {
            mp.stop();
            mp.release();
        }
    }
}