package android.minhna.slide_ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Minh on 1/15/2017.
 */

public class ImageAdapter extends PagerAdapter {

    private Context context;

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    public ImageAdapter (Context context) {
        this.context = context;
    }

    //instantiateItem - destroyItem (pair)
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView view = new TextView(context);
        view.setText("Item "+position);
        view.setGravity(Gravity.CENTER);
        view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));

        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
