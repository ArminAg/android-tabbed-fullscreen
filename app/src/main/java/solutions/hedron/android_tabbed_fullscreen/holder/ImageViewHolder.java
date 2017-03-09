package solutions.hedron.android_tabbed_fullscreen.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import solutions.hedron.android_tabbed_fullscreen.R;
import solutions.hedron.android_tabbed_fullscreen.helpers.DecodeBitmap;
import solutions.hedron.android_tabbed_fullscreen.model.MediaImage;

/**
 * Created by armin on 09/03/2017.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;

    public ImageView getImageView() {
        return imageView;
    }

    public ImageViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView)itemView.findViewById(R.id.media_image_thumb);
    }

    public void updateUI(MediaImage image){
        DecodeBitmap task = new DecodeBitmap(imageView, image);
        task.execute();
    }
}
