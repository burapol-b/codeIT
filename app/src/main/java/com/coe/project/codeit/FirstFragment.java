package com.coe.project.codeit;

import android.app.Dialog;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.coe.project.codeit.BluetoothConnection.DeviceInfoModel;
import com.coe.project.codeit.BluetoothConnection.SelectDeviceActivity;

import java.util.Set;

public class FirstFragment extends Fragment {
    private static final Object TAG = "connected";
    Dialog myDialog;
    Context thiscontext;
    private String action;

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
            Intent intent = new Intent(getActivity(), SelectDeviceActivity.class);
            startActivity(intent);
        });
    }
}