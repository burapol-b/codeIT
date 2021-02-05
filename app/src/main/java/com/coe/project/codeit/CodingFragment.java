package com.coe.project.codeit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.coe.project.codeit.BluetoothConnection.CommandControl.*;

import static com.coe.project.codeit.BluetoothConnection.CommandControl.connectedThread;

public class CodingFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.coding_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.moveforward_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cmdText = null;
                System.out.println("Move Forward output from app");
                cmdText = "moveforward";
                connectedThread.write(cmdText);
            }
        });

        view.findViewById(R.id.movebackward_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cmdText = null;
                System.out.println("Move Backward output from app");
                cmdText = "movebackward";
                connectedThread.write(cmdText);
            }
        });

        view.findViewById(R.id.moveleft_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cmdText = null;
                System.out.println("Move Left output from app");
                cmdText = "moveleft";
                connectedThread.write(cmdText);
            }
        });

        view.findViewById(R.id.moveright_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cmdText = null;
                System.out.println("Move Right output from app");
                cmdText = "moveright";
                connectedThread.write(cmdText);
            }
        });

    }
}