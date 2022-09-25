package com.example.lab7_fragments;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link frag_ml#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag_ml extends Fragment {


    Activity activity;
    View parentHolder;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public frag_ml() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment frag_ml.
     */
    // TODO: Rename and change types and number of parameters
    public static frag_ml newInstance(String param1, String param2) {
        frag_ml fragment = new frag_ml();
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
        activity = getActivity();
        parentHolder = inflater.inflate(R.layout.fragment_frag_ml, container,
                false);

//        VideoView videoView = parentHolder.findViewById(R.id.video_view);
//        String videoPath = "android.resource://" + activity.getPackageName() + "/" + R.raw.video;
//        Uri uri = Uri.parse(videoPath);
//        videoView.setVideoURI(uri);

//        MediaController mediaController = new MediaController((activity));
//        videoView.setMediaController(mediaController);
//        mediaController.setAnchorView(videoView);


//        MediaPlayer mp = MediaPlayer.create(activity.getBaseContext(), R.raw.video);
//        mp.start();


//        VideoView videoView = (VideoView)findViewById(R.id.video_view);
        //MediaController mediaController = new MediaController(this);
        // mediaController.setAnchorView(videoView);
        //videoView.setMediaController(mediaController);

//        videoView.setVideoPath("/Phone storage/Download/check.mp4");
//
//        videoView.start();

        return inflater.inflate(R.layout.fragment_frag_ml, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        VideoView videoView = (VideoView)view.findViewById(R.id.VideoView);
//        videoView.setVideoPath("E:/check.mp4");


        String uriPath = "E:/christttttttttttt/trimester_4/lab7_fragments/app/src/main/res/"+activity.getPackageName()+"/raw/check.mp4";
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();
    }
}