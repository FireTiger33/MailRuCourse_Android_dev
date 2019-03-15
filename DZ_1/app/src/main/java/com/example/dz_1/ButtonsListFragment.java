package com.example.dz_1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class ButtonsListFragment extends Fragment implements View.OnClickListener {
    private ButtonsAdapter buttonsAdapter;
    private int numCol;
    private RecyclerView buttonsList;
    private GridLayoutManager layoutManager;
    private RecyclerView.ItemDecoration decoration;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonsAdapter = new ButtonsAdapter(100, getFragmentManager());
        decoration = new ItemDecoration(numCol);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buttons_list, container, false);

        Button btn_add = view.findViewById(R.id.btn_add_num_in_list);
        btn_add.setOnClickListener(this);

        numCol = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT ?
                3 : 4;
        layoutManager = new GridLayoutManager(this.getContext(), numCol);

        buttonsList = view.findViewById(R.id.container);
        buttonsList.setAdapter(buttonsAdapter);
        buttonsList.setLayoutManager(layoutManager);
        buttonsList.addItemDecoration(decoration);

        return view;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        numCol = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT ?
                3 : 4;
        layoutManager.setSpanCount(numCol);
        buttonsList.setLayoutManager(layoutManager);
        buttonsList.removeItemDecoration(decoration);
        decoration = new ItemDecoration(numCol);
        buttonsList.addItemDecoration(decoration);
    }


    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(this.getContext(), R.anim.button_click);
        v.startAnimation(animation);
        buttonsAdapter.addElements();
        buttonsAdapter.notifyItemInserted(buttonsAdapter.getItemCount());
    }
}
