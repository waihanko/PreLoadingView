package com.shwho.preloadingview.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.shwho.preloadingview.Constants;
import com.shwho.preloadingview.R;
import com.shwho.preloadingview.pojo.PreLoadingAttributes;

import java.util.Random;

public class PreLoadingAdapter extends
        RecyclerView.Adapter<PreLoadingAdapter.ViewHolder> {

    private PreLoadingAttributes PreLoadingAttributes;

    public PreLoadingAdapter(PreLoadingAttributes PreLoadingAttributes) {
        this.PreLoadingAttributes = PreLoadingAttributes;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_place_holder, parent, false);
        return new ViewHolder(contactView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView holderOne = holder.holderOne;
        CardView holderTwo = holder.holderTwo;
        holderOne.setCardBackgroundColor(PreLoadingAttributes.getPlaceHolderCircleColor());
        holderTwo.setCardBackgroundColor(PreLoadingAttributes.getPlaceHolderRectangleColor());
        holderOne.setRadius(PreLoadingAttributes.getPlaceHolderOneRadius());
        holderTwo.setRadius(PreLoadingAttributes.getPlaceHolderTwoRadius());
        holderOne.setElevation(PreLoadingAttributes.getPlaceHolderOneElevation());
        holderTwo.setElevation(PreLoadingAttributes.getPlaceHolderTwoElevation());
        holderOne.setVisibility(PreLoadingAttributes.getIsHolderOneVisible());

        if (PreLoadingAttributes.getIsPlaceHolderRandomly()) {
            resizePlaceHolderItemRandomly(holderTwo);
        }
    }

    @Override
    public int getItemCount() {
        return PreLoadingAttributes.getListItemCount();
    }

    private void resizePlaceHolderItemRandomly(View view2) {
        Random random = new Random(); //To Shuffle place holder width and height randomly
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view2.getLayoutParams();
        params.height = PreLoadingAttributes.getDimenHeight()[random.nextInt(4)];
        if (PreLoadingAttributes.getLayoutType() == Constants.RECYCLER_LIST) {
            params.width = PreLoadingAttributes.getDimenWidth()[random.nextInt(4)];
        }
        view2.setLayoutParams(params);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardView holderOne;
        public CardView holderTwo;

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(View itemView) {
            super(itemView);
            this.holderOne = itemView.findViewById(R.id.v_one);
            this.holderTwo = itemView.findViewById(R.id.v_two);
        }

    }
}