package com.coe.project.codeit.CodingPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.coe.project.codeit.R;

import static com.coe.project.codeit.BluetoothConnection.CommandControl.connectedThread;


public class RecyclerDragdropActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    List<String> cmdlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showcmd_fragment);
        cmdlist = new ArrayList<>();

        ImageButton forward_btn = (ImageButton) findViewById(R.id.forward_btn);
        ImageButton right_btn = (ImageButton) findViewById(R.id.right_btn);
        ImageButton backward_btn = (ImageButton) findViewById(R.id.backward_btn);
        ImageButton left_btn = (ImageButton) findViewById(R.id.left_btn);
        ImageButton reset_btn = (ImageButton) findViewById(R.id.reset_btn);
        ImageButton run_btn = (ImageButton) findViewById(R.id.run_btn);
        TextView cmdlist_show = (TextView) findViewById(R.id.cmdlist_show);

        forward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmdlist.add("mf");
                recyclerAdapter.notifyDataSetChanged();
                cmdlist_show.setText(cmdlist.toString());
            }
        });

        backward_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmdlist.add("mb");
                recyclerAdapter.notifyDataSetChanged();
                cmdlist_show.setText(cmdlist.toString());
            }
        });

        right_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmdlist.add("mr");
                recyclerAdapter.notifyDataSetChanged();
                cmdlist_show.setText(cmdlist.toString());
            }
        });

        left_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmdlist.add("ml");
                recyclerAdapter.notifyDataSetChanged();
                cmdlist_show.setText(cmdlist.toString());
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmdlist.clear();
                recyclerAdapter.notifyDataSetChanged();
                cmdlist_show.setText(cmdlist.toString());
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cmdlist.clear();
                recyclerAdapter.notifyDataSetChanged();
                cmdlist_show.setText(cmdlist.toString());
            }
        });

        run_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cmd = "";
                for (String s : cmdlist)
                {
                    cmd += s+",";
                }
                if (cmd != null && cmd.length() > 0) {
                    cmd = cmd.substring(0, cmd.length() - 1);
                }
                System.out.println(cmd);
                connectedThread.write(cmd);
            }
        });

        //linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        recyclerAdapter = new RecyclerAdapter(cmdlist);
        recyclerView.setAdapter(recyclerAdapter);
        Drawable mDivider = ContextCompat.getDrawable(this, R.drawable.divider);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(mDivider);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, 0) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

            int fromPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();
            TextView cmdlist_show = (TextView) findViewById(R.id.cmdlist_show);

            Collections.swap(cmdlist, fromPosition, toPosition);
            recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
            cmdlist_show.setText(cmdlist.toString());
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

        }

    };





}