package android.minhna.slide_ui.view.activity;

import android.minhna.slide_ui.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Minh on 1/12/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideBars();
        setContentView(R.layout.activity_main);
    }

    private void hideBars() {
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        getWindow().getDecorView().setSystemUiVisibility(uiOptions);
        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();
    }

}
