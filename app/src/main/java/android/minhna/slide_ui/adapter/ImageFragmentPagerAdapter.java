package android.minhna.slide_ui.adapter;

import android.minhna.slide_ui.view.fragment.DummyFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 16-Jan-17.
 */

public class ImageFragmentPagerAdapter extends FragmentPagerAdapter {

    int count;

    public ImageFragmentPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        return DummyFragment.newInstance(++position);
    }

    @Override
    public int getCount() {
        return count;
    }
}
