package android.minhna.slide_ui.view.activity;

import android.minhna.slide_ui.R;
import android.minhna.slide_ui.adapter.ImageItemAdapter;
import android.minhna.slide_ui.model.ImageItem;
import android.minhna.slide_ui.view.fragment.SlideFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

/**
 * Created by Minh on 1/12/2017.
 */

public class MainActivity extends AppCompatActivity implements ImageItemAdapter.onItemAction {
    
    RecyclerView rv;
    SlideFragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideBars();
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        buildListView();


    }

    @Override
    protected void onStart() {
        super.onStart();
        //make blur
//        final View content = findViewById(R.id.content);
//        final View baselineBottom = findViewById(R.id.baseline_bottom);
//        baselineBottom.post(new Runnable() {
//            @Override
//            public void run() {
//                baselineBottom.setBackground(new BitmapDrawable(getResources(), BlurBuilder.blur(content)));
//            }
//        });
    }

    private void buildListView() {
        rv.bringToFront();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        ImageItemAdapter adapter = new ImageItemAdapter(this, ImageItem.getDummyList());
        rv.setAdapter(adapter);
    }

    private void hideBars() {
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
    }

    @Override
    public void onItemClick(int index) {
        rv.setVisibility(View.GONE);
        FragmentManager fm = getSupportFragmentManager();
        fragment = SlideFragment.newInstance(index);
        fm.beginTransaction().add(R.id.content, fragment)
                .addToBackStack(SlideFragment.class.getName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStackImmediate();
            rv.setVisibility(View.VISIBLE);
        } else
            super.onBackPressed();
    }
}
