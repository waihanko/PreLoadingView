# Pre Loading View
 ###### This is ui library like facebook comment pre loading. But You can customize with attributes.

 &nbsp;
 &nbsp;
![grab-landing-page](https://github.com/waihanko/PreLoadingView/blob/master/screenshot/PreLoadingView.gif?raw=true)

### Installation
	     	        
```sh
	       dependencies {
	        implementation 'com.github.waihanko:PreLoadingView:Tag'
	}
```

```sh
repositories {
  google()
  jcenter()
  maven { url 'https://jitpack.io' }
}
```
### Example Usages
```sh
<com.shwho.preloadingview.PreLoadingView
        android:id="@+id/plv_view1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:plv_animationDuration="3"
        app:plv_defaultAnimation="down_to_up"
        app:plv_holderTwoColor="#7abcff"
        app:plv_holderOneColor="#7abcff"/>
```

| Attributes   |      param      |      remark      |
|----------|:-------------:| :-------------:| 
|plv_isHolderTwoDimenDynamic|boolean|    -      |
|plv_holderOneVisibility|boolean|      visible, invisible, gone      |
|plv_animationDuration|integer|      in second      |
|plv_listItemCount|integer|      -      |
|plv_holderOneCornerRadius|integer|      -      |
|plv_holderTwoCornerRadius|integer|      -      |
|plv_holderOneElevation|integer|      -      |
|plv_holderTwoElevation|integer|          -      |    
|plv_holderOneColor|color|      -      |
|plv_holderTwoColor|color|      -      |
|plv_layoutType|reference|      list, grid      |
|plv_defaultAnimation|reference|      none, simple, down_to_up, up_to_down, left_to_right, right_to_left, fade_out      |


    
