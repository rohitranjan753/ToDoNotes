package com.example.todonotes.Home;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todonotes.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private List<HomeModel> noteList;
    private Context context;

    public HomeAdapter(List<HomeModel> noteList,Context context){
        this.noteList = noteList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_single_row,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        HomeViewHolder rcv = new HomeViewHolder(view);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        final HomeModel temp = noteList.get(position);

        String timeStamp = temp.gethTime();
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(Long.parseLong(timeStamp));
        String dateTime = DateFormat.format("dd/MM/yyyy hh:mm aa",cal).toString();

        holder.mTitle.setText(noteList.get(position).gethTitle());
        holder.mTime.setText(dateTime);

    }

    @Override
    public int getItemCount() {
        return this.noteList.size();
    }
}
