package com.example.dz_1;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ButtonsAdapter extends RecyclerView.Adapter<ButtonViewHolder> {
    private int numElements;
    private FragmentManager manager;
    private int holderNum = 0;

    public ButtonsAdapter (int numElements, FragmentManager manager){
        Log.d("ProgramLog", "Новый адаптер");
        this.numElements = numElements;
        this.manager = manager;
    }

    @NonNull
    @Override
    public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.list_element, viewGroup, false);

        return new ButtonViewHolder(view, manager, ++holderNum);
    }

    @Override
    public void onBindViewHolder(@NonNull ButtonViewHolder buttonViewHolder, int i) {
        buttonViewHolder.bind(i + 1);
    }

    @Override
    public int getItemCount() {
        return numElements;
    }

    public void addElements() {
        this.numElements += 1;
    }
}
