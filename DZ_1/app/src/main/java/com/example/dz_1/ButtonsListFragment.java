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
import android.widget.Button;

import java.util.zip.Inflater;

public class ButtonsListFragment extends Fragment implements View.OnClickListener {
    private ButtonsAdapter buttonsAdapter;
    private Inflater inflater;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        buttonsAdapter = new ButtonsAdapter(100, getFragmentManager());
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int numCol = getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT ?
                3 : 4;

        View view = inflater.inflate(R.layout.fragment_buttons_list, container, false);

        Button btn_add = view.findViewById(R.id.btn_add_num_in_list);
        btn_add.setOnClickListener(this);

        RecyclerView buttonsList = view.findViewById(R.id.container);
        buttonsList.setLayoutManager(new GridLayoutManager(view.getContext(), numCol));
        buttonsList.setAdapter(buttonsAdapter);
        buttonsList.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        buttonsAdapter.addElements();
        buttonsAdapter.notifyItemInserted(buttonsAdapter.getItemCount());
    }
}
