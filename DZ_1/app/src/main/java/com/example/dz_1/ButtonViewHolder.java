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
    private int num;
    private int color;
    private FragmentManager manager;
    private int viewHolderNum;

    public ButtonViewHolder(@NonNull View itemView, FragmentManager manager, int viewHolderNum) {
        super(itemView);
        this.viewHolderNum = viewHolderNum;
        Log.d("ProgramLog", "create_new_holder " + viewHolderNum);
        button = itemView.findViewById(R.id.buttonId);
        button.setOnClickListener(this);
        this.manager = manager;
    }

    public void bind (int num) {
        Log.d("ProgramLog", "bindViewHolder");
        this.num = num;
        button.setText(String.valueOf(num) + "." + viewHolderNum);
        color = num % 2 > 0? Color.BLUE: Color.RED;
        button.setTextColor(color);
    }

    @Override
    public void onClick(View v) {
        Bundle properties = new Bundle();
        properties.putInt("text", num);
        properties.putInt("color", color);

        ZoomFragment fragment = new ZoomFragment();
        fragment.setArguments(properties);

        Log.d("ProgramLog", "click" + num);
        manager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.main_activity, fragment)
                .commit();
    }
}
