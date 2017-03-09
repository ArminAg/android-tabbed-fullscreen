package solutions.hedron.android_tabbed_fullscreen.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import solutions.hedron.android_tabbed_fullscreen.R;
import solutions.hedron.android_tabbed_fullscreen.holder.ImageViewHolder;
import solutions.hedron.android_tabbed_fullscreen.model.MediaImage;

/**
 * Created by armin on 09/03/2017.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImageViewHolder>{
    private ArrayList<MediaImage> images;
    private ImageView selectedImage;

    public ImagesAdapter(ArrayList<MediaImage> images, ImageView selectedImage) {
        this.images = images;
        this.selectedImage = selectedImage;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        final MediaImage image = images.get(position);
        holder.updateUI(image);

        final ImageViewHolder vHolder = holder;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImage.setImageDrawable(vHolder.getImageView().getDrawable());
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);
        return new ImageViewHolder(card);
    }
}
