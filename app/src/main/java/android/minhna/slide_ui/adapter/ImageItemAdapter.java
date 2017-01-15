package android.minhna.slide_ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.minhna.slide_ui.R;
import android.minhna.slide_ui.model.ImageItem;
import android.minhna.slide_ui.view.activity.MainActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 15-Jan-17.
 */

public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemAdapter.ImageViewHolder> {

    Context context;
    List<ImageItem> data;
    onItemAction actionListener;

    public interface onItemAction {
        public void onItemClick(int index);
    }

    public ImageItemAdapter(Context context, List<ImageItem> data) {
        this.context = context;
        this.data = data;
        actionListener = (MainActivity) context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        ImageViewHolder holder = new ImageViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        int imageResource = context.getResources().getIdentifier(data.get(position).image, null, context.getPackageName());
        Drawable res = context.getResources().getDrawable(imageResource, null);
        holder.imageView.setImageDrawable(res);
    }

    @Override
    public int getItemCount() {
        return data!=null ? data.size():0;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_preview);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    actionListener.onItemClick(getLayoutPosition());
                }
            });

        }
    }

}
