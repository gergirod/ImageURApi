package app.android.girod.imageur.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.android.girod.imageur.R;
import app.android.girod.imageur.data.model.Image;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;

/**
 * Created by germangirod on 8/30/16.
 */
public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageRowHolder> {

    private List<Image> images;

    public ImageListAdapter(List<Image> images) {
        this.images = images;
    }


    @Override public ImageRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, parent, false);
        ImageRowHolder imageRowHolder = new ImageRowHolder(v);

        return imageRowHolder;
    }

    @Override public void onBindViewHolder(ImageRowHolder holder, int position) {

        Image image = images.get(position);
        holder.imageTitle.setText(image.getTitle());
        holder.image.setImageURI(image.showImage());
        holder.votes.setText(image.getVote());
        holder.views.setText(String.valueOf(image.getViews()));

    }

    @Override public int getItemCount() {
        return images.size();
    }

    public void setImages(List<Image> images) {
        this.images.clear();
        this.images.addAll(images);
        notifyDataSetChanged();
    }

    public class ImageRowHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.imageTitle) TextView imageTitle;
        @InjectView(R.id.appPicture) SimpleDraweeView image;
        @InjectView(R.id.views) TextView views;
        @InjectView(R.id.votes) TextView votes;

        public ImageRowHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
