package com.example.dz_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ZoomFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle args = this.getArguments();
        assert args != null;

        View view = inflater.inflate(R.layout.fragment_zoom, container, false);

        TextView textView = view.findViewById(R.id.elementText);
        textView.setText(args.getString("text"));
        textView.setTextColor(args.getInt("color"));

        return view;
    }
}
