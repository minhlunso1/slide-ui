package android.minhna.slide_ui.view.activity;

/**
 * Created by Minh on 1/13/2017.
 */

import android.app.Activity;
import android.minhna.slide_ui.R;
import android.minhna.slide_ui.adapter.ImageAdapter;
import android.minhna.slide_ui.view.custom_view.PagerContainer;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class SlideActivity extends Activity {

    PagerContainer container;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_test);

        container = (PagerContainer) findViewById(R.id.pager_container);

        ViewPager pager = container.getViewPager();
        PagerAdapter adapter = new ImageAdapter(this);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        pager.setPageMargin(170);
        pager.setClipChildren(false);
    }

}
