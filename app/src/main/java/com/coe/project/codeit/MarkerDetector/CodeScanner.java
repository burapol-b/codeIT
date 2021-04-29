package com.coe.project.codeit.MarkerDetector;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.coe.project.codeit.CodingPage.RecyclerDragdropActivity;
import com.coe.project.codeit.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CodeScanner extends AppCompatActivity {
    private static final int RC_PERMISSION = 10;
    private com.budiyev.android.codescanner.CodeScanner mCodeScanner;
    private boolean mPermissionGranted;
    List<String> cmdlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cmdlist = new ArrayList<>();
        Intent intent2 = getIntent();
        cmdlist = (ArrayList<String>) intent2.getSerializableExtra("cmdlist");
        int level = (Integer) intent2.getIntExtra("level", 0);

        setContentView(R.layout.codescanner_fragment);
        mCodeScanner = new com.budiyev.android.codescanner.CodeScanner(this, findViewById(R.id.scanner_view));

        //mCodeScanner.setScanMode(ScanMode.CONTINUOUS);

        mCodeScanner.setDecodeCallback(result -> runOnUiThread(() -> {
            cmdlist.add(result.getText());
            System.out.println(cmdlist);
        }));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                mPermissionGranted = false;
                requestPermissions(new String[] {Manifest.permission.CAMERA}, RC_PERMISSION);
            } else {
                mPermissionGranted = true;
            }
        } else {
            mPermissionGranted = true;
        }

        findViewById(R.id.scanner_view).setOnClickListener(view1 -> {
            mCodeScanner.startPreview();
        });

        findViewById(R.id.send_data).setOnClickListener(view1 -> {
            Intent intent = new Intent(CodeScanner.this, RecyclerDragdropActivity.class);
            intent.putExtra("cmdlist", (Serializable) cmdlist);
            intent.putExtra("level", (Integer) level);
            startActivity(intent);
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == RC_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mPermissionGranted = true;
                mCodeScanner.startPreview();
            } else {
                mPermissionGranted = false;
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPermissionGranted) {
            mCodeScanner.startPreview();
        }
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }
}
