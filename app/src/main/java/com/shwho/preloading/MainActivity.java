package com.shwho.preloading;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.shwho.preloadingview.PreLoadingView;

public class MainActivity extends AppCompatActivity {

    PreLoadingView preloadingViewLayout1;
    PreLoadingView preloadingViewLayout2;
    PreLoadingView preloadingViewLayout3;
    PreLoadingView preloadingViewLayout4;
    ConstraintLayout cslRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preloadingViewLayout1 = (PreLoadingView) findViewById(R.id.plv_view1);
        preloadingViewLayout2 = (PreLoadingView) findViewById(R.id.plv_view2);
        preloadingViewLayout3 = (PreLoadingView) findViewById(R.id.plv_view3);
        preloadingViewLayout4 = (PreLoadingView) findViewById(R.id.plv_view4);
        cslRoot = (ConstraintLayout) findViewById(R.id.csl_root);
        showView(preloadingViewLayout1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.sample1:
                showView(preloadingViewLayout1);
                return true;

            case R.id.sample2:
                showView(preloadingViewLayout2);
                return true;

            case R.id.sample3:
                showView(preloadingViewLayout3);
                return true;

            case R.id.sample4:
                showView(preloadingViewLayout4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showView(PreLoadingView preLoadingView){
        preloadingViewLayout1.setVisibility(View.INVISIBLE);
        preloadingViewLayout2.setVisibility(View.INVISIBLE);
        preloadingViewLayout3.setVisibility(View.INVISIBLE);
        preloadingViewLayout4.setVisibility(View.INVISIBLE);

        preLoadingView.setVisibility(View.VISIBLE);

    }

}