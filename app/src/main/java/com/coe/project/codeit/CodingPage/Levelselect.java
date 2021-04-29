package com.coe.project.codeit.CodingPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.coe.project.codeit.MainActivity;
import com.coe.project.codeit.R;

public class Levelselect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_select);

        ImageButton level1_btn = (ImageButton) findViewById(R.id.level1_btn);

        level1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Levelselect.this, RecyclerDragdropActivity.class);
                intent.putExtra("level", (Integer) 1);
                startActivity(intent);
            }
        });

        ImageButton level2_btn = (ImageButton) findViewById(R.id.level2_btn);

        level2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Levelselect.this, RecyclerDragdropActivity.class);
                intent.putExtra("level", (Integer)2);
                startActivity(intent);
            }
        });

        ImageButton level3_btn = (ImageButton) findViewById(R.id.level3_btn);

        level3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Levelselect.this, RecyclerDragdropActivity.class);
                intent.putExtra("level", (Integer)3);
                startActivity(intent);
            }
        });

        ImageButton level4_btn = (ImageButton) findViewById(R.id.level4_btn);

        level4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Levelselect.this, RecyclerDragdropActivity.class);
                intent.putExtra("level", (Integer)4);
                startActivity(intent);
            }
        });

        ImageButton level5_btn = (ImageButton) findViewById(R.id.level5_btn);

        level5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Levelselect.this, RecyclerDragdropActivity.class);
                intent.putExtra("level", 5);
                startActivity(intent);
            }
        });

        ImageButton back_btn = (ImageButton) findViewById(R.id.back_button);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Levelselect.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
