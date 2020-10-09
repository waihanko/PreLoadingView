package com.shwho.preloadingview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shwho.preloadingview.adapter.PreLoadingAdapter;
import com.shwho.preloadingview.pojo.PreLoadingAttributes;


public class PreLoadingView extends FrameLayout {
    RecyclerView rvPreLoading;
    PreLoadingAttributes preLoadingAttributes = new PreLoadingAttributes();
    int deviceWidth;
    int deviceHeight;
    int animResId;
    int layoutType = Constants.RECYCLER_LIST;
    private Handler handler = new Handler();
    int[] randomDimenWidthList = new int[Constants.DEFAULT_DIMEN_WIDTH_COUNT];
    int[] randomPlaceHolderHeightList = {40, 60, 80, 100, 120};
    private int defaultTransition;


    public PreLoadingView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public PreLoadingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        parseCustomAttributes(attrs);
        init(context, attrs, 0);
    }

    public PreLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseCustomAttributes(attrs);
        init(context, attrs, defStyleAttr);

    }

    public void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        LayoutInflater.from(getContext()).inflate(R.layout.pre_loading_view, this, true);
        rvPreLoading = findViewById(R.id.rv_place_holder);
        getDeviceDimen();
        generateRandomPlaceHolderWidth();
        setupTimer();
    }

    private void parseCustomAttributes(AttributeSet attributeSet) {
        try {
            if (attributeSet != null) {
                TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.PreLoading);
                try {
                    layoutType = typedArray.getInt(R.styleable.PreLoading_plv_layoutType, Constants.RECYCLER_LIST);
                    preLoadingAttributes.setLayoutType(layoutType);
                    preLoadingAttributes.setListItemCount(typedArray.getInteger(R.styleable.PreLoading_plv_listItemCount, Constants.DEFAULT_LIST_ITEM_COUNT));
                    preLoadingAttributes.setPreLoadingDuration(typedArray.getInteger(R.styleable.PreLoading_plv_animationDuration, Constants.DEFAULT_ANIMATION_DURATION) * 1000); // * 1000 is to Change Sec to mill Sec
                    preLoadingAttributes.setPlaceHolderCircleColor(typedArray.getColor(R.styleable.PreLoading_plv_holderOneColor, ContextCompat.getColor(getContext(), R.color.color_default)));
                    preLoadingAttributes.setPlaceHolderRectangleColor(typedArray.getColor(R.styleable.PreLoading_plv_holderTwoColor, ContextCompat.getColor(getContext(), R.color.color_default)));
                    preLoadingAttributes.setIsPlaceHolderRandomly(typedArray.getBoolean(R.styleable.PreLoading_plv_isHolderTwoDimenDynamic, true));
                    preLoadingAttributes.setPlaceHolderOneRadius(Utils.dpToPx(typedArray.getInteger(R.styleable.PreLoading_plv_holderOneCornerRadius, Constants.DEFAULT_PLACEHOLDER_ONE_RADIUS)));
                    preLoadingAttributes.setPlaceHolderTwoRadius(Utils.dpToPx(typedArray.getInteger(R.styleable.PreLoading_plv_holderTwoCornerRadius, Constants.DEFAULT_PLACEHOLDER_TWO_RADIUS)));
                    preLoadingAttributes.setPlaceHolderOneElevation(Utils.dpToPx(typedArray.getInteger(R.styleable.PreLoading_plv_holderOneElevation, Constants.DEFAULT_PLACEHOLDER_ONE_ELEVATION)));
                    preLoadingAttributes.setPlaceHolderTwoElevation(Utils.dpToPx(typedArray.getInteger(R.styleable.PreLoading_plv_holderTwoElevation, Constants.DEFAULT_PLACEHOLDER_TWO_ELEVATION)));
                    preLoadingAttributes.setIsHolderOneVisible(typedArray.getInteger(R.styleable.PreLoading_plv_isHolderOneVisible, View.VISIBLE));
                    defaultTransition = typedArray.getInt(R.styleable.PreLoading_plv_defaultAnimation, 1);
                    detectTransition(); //Detect Transition File

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    typedArray.recycle();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void detectTransition() {
        //0 = no transition
        if (defaultTransition == 0) {
            animResId = R.anim.layuot_animation_simple;
        } else if (defaultTransition == 1) {
            animResId = R.anim.layuot_animation_simple;
        } else if (defaultTransition == 2) {
            animResId = R.anim.layout_animation_down_to_up;
        } else if (defaultTransition == 3) {
            animResId = R.anim.layout_animation_up_to_down;
        } else if (defaultTransition == 4) {
            animResId = R.anim.layout_animation_left_to_right;
        } else if (defaultTransition == 5) {
            animResId = R.anim.layout_animation_right_to_left;
        } else if (defaultTransition == 6) {
            animResId = R.anim.layout_animation_fade_out;
        } else {
            animResId = R.anim.layuot_animation_simple;
        }
    }

    private void getDeviceDimen() {
        deviceWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        deviceHeight = getContext().getResources().getDisplayMetrics().heightPixels;
    }

    //Get PlaceHolder List by Device Ratio => (i+1)=> 0.3, 0.4, 0.5, 0.6 ,0.7
    private void generateRandomPlaceHolderWidth() {
        for (int i = 0; i < Constants.DEFAULT_DIMEN_WIDTH_COUNT; i++) {
            randomDimenWidthList[i] = (int) (deviceWidth * (i + 3) / 10.0);
            randomPlaceHolderHeightList[i] = Utils.dpToPx(randomPlaceHolderHeightList[i]);
        }
        preLoadingAttributes.setDimenWidth(randomDimenWidthList);
        preLoadingAttributes.setDimenHeight(randomPlaceHolderHeightList);
    }

    public void inflatePreLoadingList() {
        PreLoadingAdapter preLoadingAdapter;
        if (defaultTransition != 0) {
            final LayoutAnimationController controller =
                    AnimationUtils.loadLayoutAnimation(getContext(), animResId);
            rvPreLoading.setLayoutAnimation(controller);
            rvPreLoading.scheduleLayoutAnimation();
        }

        preLoadingAdapter = new PreLoadingAdapter(preLoadingAttributes);
        rvPreLoading.setHasFixedSize(true);
        if (layoutType == Constants.RECYCLER_GRID) {
            rvPreLoading.setLayoutManager(new GridLayoutManager(getContext(), 3));
        } else {
            rvPreLoading.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        rvPreLoading.setAdapter(preLoadingAdapter);
        preLoadingAdapter.notifyDataSetChanged();

    }

    private void setupTimer() {
        try {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        inflatePreLoadingList();
                        handler.postDelayed(this, preLoadingAttributes.getPreLoadingDuration());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
