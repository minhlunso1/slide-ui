package android.minhna.slide_ui.view.activity;

/**
 * Created by Minh on 1/13/2017.
 */

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.minhna.slide_ui.R;
import android.minhna.slide_ui.adapter.ImageAdapter;
import android.minhna.slide_ui.view.custom_view.PageTransformer;
import android.minhna.slide_ui.view.custom_view.PagerContainer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SlideActivity extends AppCompatActivity {

    PagerContainer container;
    ViewPager pager;
    View content;
    TextView tvTitle, tvContent, tvAuthor;
    int index;
    int[] bgColors = {R.color.black_overlay, R.color.grey_overlay, R.color.dark_overlay, R.color.white_overlay};
    public static int colorIndex=3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        index = getIntent().getIntExtra("index", 0);
        setContentView(R.layout.fragment_slide);
        hideBars();

        content = findViewById(R.id.content);
        container = (PagerContainer) findViewById(R.id.pager_container);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvContent = (TextView) findViewById(R.id.tv_content);
        tvAuthor = (TextView) findViewById(R.id.tv_footer);
        content.setBackgroundColor(ContextCompat.getColor(this, bgColors[colorIndex]));
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        pager = container.getViewPager();
        ImageAdapter adapter = new ImageAdapter(this);
        pager.setPageTransformer(false, new PageTransformer());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        pager.setPageMargin(32);
        pager.setClipChildren(false);
        pager.setCurrentItem(index);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                colorIndex++;
                if (colorIndex>3)
                    colorIndex=0;
                content.setBackgroundColor(ContextCompat.getColor(getBaseContext(), bgColors[colorIndex]));
                if (position>index)
                    startTextAnimation(false);
                else if (position<index)
                    startTextAnimation(true);
                index = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("bg_color", bgColors[colorIndex]);
        setResult(AppCompatActivity.RESULT_OK, returnIntent);
        super.onBackPressed();
    }

    private void hideBars() {
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
    }

    private void startTextAnimation(final boolean toLeft) {
        final float toMoveX;
        int duration = 500;
        if (toLeft)
            toMoveX = -8f;
        else
            toMoveX = 8f;

        ObjectAnimator animX = ObjectAnimator.ofFloat(tvTitle, "x", toMoveX);
        animX.setDuration(duration);
        ObjectAnimator animX1 = ObjectAnimator.ofFloat(tvContent, "x", toMoveX);
        animX.setDuration(duration);

        ObjectAnimator animFade = ObjectAnimator.ofFloat(tvTitle, "alpha", 0.4f);
        animFade.setDuration(duration);
        ObjectAnimator animFade1 = ObjectAnimator.ofFloat(tvContent, "alpha", 0.4f);
        animFade.setDuration(duration);
        ObjectAnimator animFade2 = ObjectAnimator.ofFloat(tvAuthor, "alpha", 0.4f);
        animFade.setDuration(duration);

        AnimatorSet animSetCollection = new AnimatorSet();
        animSetCollection.playTogether(animX, animFade, animX1, animFade1, animFade2);
        animSetCollection.start();

        animSetCollection.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                revertTextAnimation(toLeft);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

    }

    private void revertTextAnimation(boolean toLeft) {
        final float toMoveX;
        if (toLeft)
            toMoveX = 3f;
        else
            toMoveX = -3f;

        ObjectAnimator animX = ObjectAnimator.ofFloat(tvTitle, "x", toMoveX);
        ObjectAnimator animX1 = ObjectAnimator.ofFloat(tvContent, "x", toMoveX);

        ObjectAnimator animFade = ObjectAnimator.ofFloat(tvTitle, "alpha", 1f);
        ObjectAnimator animFade1 = ObjectAnimator.ofFloat(tvContent, "alpha", 1f);
        ObjectAnimator animFade2 = ObjectAnimator.ofFloat(tvAuthor, "alpha", 1f);

        AnimatorSet animSetCollection = new AnimatorSet();
        animSetCollection.playTogether(animX, animFade, animX1, animFade1, animFade2);
        animSetCollection.start();
    }

}
