package com.example.todonotes.Home;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todonotes.R;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle, mTime;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.titlePlaceholder);
        mTime = itemView.findViewById(R.id.timePlaceHolder);
    }
}
