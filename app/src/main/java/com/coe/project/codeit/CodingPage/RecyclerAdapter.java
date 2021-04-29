package com.coe.project.codeit.CodingPage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import com.coe.project.codeit.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";
    List<String> cmdlist;

    public RecyclerAdapter(List<String> cmdlist) {
        this.cmdlist = cmdlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(cmdlist.get(position));

        if (cmdlist.get(position) == "mf") {
            holder.imageView.setImageResource(R.drawable.forward);
        } else if (cmdlist.get(position) == "mb") {
            holder.imageView.setImageResource(R.drawable.backward);
        } else if (cmdlist.get(position) == "mr") {
            holder.imageView.setImageResource(R.drawable.turn_right);
        } else if (cmdlist.get(position) == "ml") {
            holder.imageView.setImageResource(R.drawable.turn_left);
        }
    }

    @Override
    public int getItemCount() {
        return cmdlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView, rowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), cmdlist.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}

