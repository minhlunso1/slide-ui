package android.minhna.slide_ui.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 15-Jan-17.
 */

public class ImageItem {

    public ImageItem(String image) {
        this.image = image;
    }

    public String image;

    public static List<ImageItem> getDummyList() {
        List<ImageItem> list = new ArrayList<>();
        for (int i=1;i<7;i++) {
            String uri = "@drawable/img_"+i;
            list.add(new ImageItem(uri));
        }
        return list;
    }
}
