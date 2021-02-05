package com.coe.project.codeit.CodingPage;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coe.project.codeit.R;

import static com.coe.project.codeit.BluetoothConnection.CommandControl.connectedThread;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CodingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CodingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String cmd = "";

    public CodingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment coding_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CodingFragment newInstance(String param1, String param2) {
        CodingFragment fragment = new CodingFragment();
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
        return inflater.inflate(R.layout.fragment_coding, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final LinearLayout ll = (LinearLayout)view.findViewById(R.id.cmdshow);


        view.findViewById(R.id.forward_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("forward_btn");
                cmd += "moveforward,";
            }
        });

        view.findViewById(R.id.backward_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("backward_btn");
                cmd += "movebackward,";
            }
        });

        view.findViewById(R.id.left_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("left_btn");
                cmd += "moveleft,";
            }
        });

        view.findViewById(R.id.right_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("right_btn");
                cmd += "moveright,";
            }
        });

        view.findViewById(R.id.run_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cmd != null && cmd.length() > 0) {
                    cmd = cmd.substring(0, cmd.length() - 1);
                }
                connectedThread.write(cmd);
                System.out.println(cmd);
            }
        });

        view.findViewById(R.id.reset_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmd ="";
            }
        });

    }

}