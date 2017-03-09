package solutions.hedron.android_tabbed_fullscreen.helpers;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

import solutions.hedron.android_tabbed_fullscreen.model.MediaImage;

/**
 * Created by armin on 09/03/2017.
 */

public class DecodeBitmap extends AsyncTask<Void, Void, Bitmap> {
    private final WeakReference<ImageView> mImageViewWeakReference;
    private MediaImage image;

    public DecodeBitmap(ImageView imageView, MediaImage image) {
        this.mImageViewWeakReference = new WeakReference<ImageView>(imageView);
        this.image = image;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        BitmapHelper bitmapHelper = new BitmapHelper();
        return bitmapHelper.decodeUri(image.getImgResourceUrl().getPath());
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        final ImageView imageView = mImageViewWeakReference.get();

        if (imageView != null){
            imageView.setImageBitmap(bitmap);
        }
    }
}
