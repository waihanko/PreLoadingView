package com.shwho.preloadingview.pojo;

import com.shwho.preloadingview.Constants;

public class PreLoadingAttributes {
    boolean isPlaceHolderRandomly = true;
    int isHolderOneVisible;
    int preLoadingDuration;
    int listItemCount;
    int placeHolderOneElevation;
    int layoutType;
    int placeHolderTwoElevation;
    int placeHolderOneRadius;
    int placeHolderTwoRadius;
    int placeHolderCircleColor;
    int placeHolderRectangleColor;
    int[] dimenWidth = new int[Constants.DEFAULT_DIMEN_WIDTH_COUNT];
    int[] dimenHeight = new int[Constants.DEFAULT_DIMEN_HEIGHT_COUNT];


    public PreLoadingAttributes() {
    }

    public int getPreLoadingDuration() {
        return preLoadingDuration;
    }

    public int getListItemCount() {
        return listItemCount;
    }

    public void setPreLoadingDuration(int preLoadingDuration) {
        this.preLoadingDuration = preLoadingDuration;
    }

    public void setListItemCount(int listItemCount) {
        this.listItemCount = listItemCount;
    }

    public void setDimenWidth(int[] dimenWidth) {
        this.dimenWidth = dimenWidth;
    }

    public void setDimenHeight(int[] dimenHeight) {
        this.dimenHeight = dimenHeight;
    }

    public int[] getDimenWidth() {
        return dimenWidth;
    }

    public int[] getDimenHeight() {
        return dimenHeight;
    }

    public int getPlaceHolderCircleColor() {
        return placeHolderCircleColor;
    }

    public int getPlaceHolderRectangleColor() {
        return placeHolderRectangleColor;
    }

    public void setPlaceHolderCircleColor(int placeHolderCircleColor) {
        this.placeHolderCircleColor = placeHolderCircleColor;
    }

    public void setPlaceHolderRectangleColor(int placeHolderRectangleColor) {
        this.placeHolderRectangleColor = placeHolderRectangleColor;
    }

    public boolean getIsPlaceHolderRandomly() {
        return isPlaceHolderRandomly;
    }

    public void setIsPlaceHolderRandomly(boolean placeHolderRandomly) {
        isPlaceHolderRandomly = placeHolderRandomly;
    }

    public int getPlaceHolderOneRadius() {
        return placeHolderOneRadius;
    }

    public int getPlaceHolderTwoRadius() {
        return placeHolderTwoRadius;
    }

    public void setPlaceHolderOneRadius(int placeHolderOneRadius) {
        this.placeHolderOneRadius = placeHolderOneRadius;
    }

    public void setPlaceHolderTwoRadius(int placeHolderTwoRadius) {
        this.placeHolderTwoRadius = placeHolderTwoRadius;
    }

    public int getPlaceHolderOneElevation() {
        return placeHolderOneElevation;
    }

    public int getPlaceHolderTwoElevation() {
        return placeHolderTwoElevation;
    }

    public void setPlaceHolderOneElevation(int placeHolderOneElevation) {
        this.placeHolderOneElevation = placeHolderOneElevation;
    }

    public void setPlaceHolderTwoElevation(int placeHolderTwoElevation) {
        this.placeHolderTwoElevation = placeHolderTwoElevation;
    }

    public int getIsHolderOneVisible() {
        return isHolderOneVisible;
    }

    public void setIsHolderOneVisible(int isHolderOneVisible) {
        this.isHolderOneVisible = isHolderOneVisible;
    }

    public int getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(int layoutType) {
        this.layoutType = layoutType;
    }

}
