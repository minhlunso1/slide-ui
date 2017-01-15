package android.minhna.slide_ui.view.fragment;

import android.minhna.slide_ui.R;
import android.minhna.slide_ui.adapter.ImageAdapter;
import android.minhna.slide_ui.util.MyUtils;
import android.minhna.slide_ui.view.custom_view.PageTransformer;
import android.minhna.slide_ui.view.custom_view.PagerContainer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 15-Jan-17.
 */

public class SlideFragment extends Fragment {

    PagerContainer container;
    ViewPager pager;

    public static SlideFragment newInstance(int index) {
        Bundle args = new Bundle();
        SlideFragment fragment = new SlideFragment();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_slide, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int index = getArguments().getInt("index",0);
        container = (PagerContainer) view.findViewById(R.id.pager_container);
//        pager = (ViewPager) view.findViewById(R.id.vp);

        pager = container.getViewPager();
        PagerAdapter adapter = new ImageAdapter(getContext());
        pager.setPageTransformer(false, new PageTransformer());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        int width = new MyUtils().getWidthScreen((AppCompatActivity) getActivity());
        pager.setPageMargin(width/2-480);
        pager.setClipChildren(false);
        pager.setCurrentItem(index);
    }

}
