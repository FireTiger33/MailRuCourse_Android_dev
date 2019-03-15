package com.example.dz_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

class ButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private Button button;
    private String num;
    private int color;
    private FragmentManager manager;


    public ButtonViewHolder(@NonNull View itemView, FragmentManager manager) {
        super(itemView);
        button = itemView.findViewById(R.id.buttonId);
        button.setOnClickListener(this);
        this.manager = manager;
    }


    public void bind (int num) {
        this.num = String.valueOf(num);
        button.setText(this.num);
        color = num % 2 > 0? Color.BLUE: Color.RED;
        button.setTextColor(color);
    }


    @Override
    public void onClick(View v) {
        Bundle properties = new Bundle();
        properties.putString("text", num);
        properties.putInt("color", color);

        ZoomFragment fragment = new ZoomFragment();
        fragment.setArguments(properties);

        manager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_activity, fragment)
                .commit();
    }
}
