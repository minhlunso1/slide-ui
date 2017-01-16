package android.minhna.slide_ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Minh on 1/15/2017.
 */

//just for quick demo. In reality, do not do this :)
public class ImageAdapter extends PagerAdapter {

    private Context context;

    @Override
    public int getCount() {
        return 6;
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
        position++;
        String uri = "@drawable/img_"+position;
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource, null);

        ImageView view = new ImageView(context);
        view.setImageDrawable(res);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);

        CardView cardView = new CardView(context);
        cardView.setRadius(5);
        cardView.setContentPadding(15, 15, 15, 15);
        cardView.setBackgroundColor(Color.parseColor("#ededed"));
        cardView.setMaxCardElevation(15);
        cardView.setCardElevation(9);

        cardView.addView(view);
        container.addView(cardView);
        return cardView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

}
