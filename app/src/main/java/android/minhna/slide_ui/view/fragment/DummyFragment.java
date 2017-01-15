package android.minhna.slide_ui.view.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.minhna.slide_ui.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 16-Jan-17.
 */

public class DummyFragment extends Fragment {

    Context context;

    public static DummyFragment newInstance(int index) {
        Bundle args = new Bundle();
        DummyFragment fragment = new DummyFragment();
        args.putInt("index", index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        View v = inflater.inflate(R.layout.fragment_dummy, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imgView = (ImageView) view.findViewById(R.id.img);
        Bundle bundle = getArguments();
        int position = bundle.getInt("index");

        String uri = "@drawable/img_"+position;
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource, null);

        imgView.setImageDrawable(res);
    }

}
