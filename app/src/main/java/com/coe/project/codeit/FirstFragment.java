package com.coe.project.codeit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.coe.project.codeit.BluetoothConnection.CommandControl;
import com.coe.project.codeit.BluetoothConnection.SelectDeviceActivity;

public class FirstFragment extends Fragment {
    Dialog myDialog;
    Context thiscontext;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState


    ) {
        thiscontext = container.getContext();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDialog = new Dialog(thiscontext);

        view.findViewById(R.id.start_btn).setOnClickListener(view1 -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_recyclerDragdropActivity));



        view.findViewById(R.id.bt_btn).setOnClickListener(view1 -> {
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_selectDeviceActivity);
        });

    }
}