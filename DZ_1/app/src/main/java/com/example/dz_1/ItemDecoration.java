package com.example.dz_1;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {
    private int numCol;

    public ItemDecoration(int numCol) {
        this.numCol = numCol;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int margin_left = 9 * numCol;

        outRect.left = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, margin_left,
                view.getResources().getDisplayMetrics());
    }
}
