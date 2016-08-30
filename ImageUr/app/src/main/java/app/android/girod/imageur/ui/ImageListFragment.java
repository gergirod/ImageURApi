package app.android.girod.imageur.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import app.android.girod.imageur.R;
import app.android.girod.imageur.data.model.Image;
import app.android.girod.imageur.data.model.ImagesResponse;
import app.android.girod.imageur.data.presenters.ImagesData;
import app.android.girod.imageur.data.presenters.ImagesPresenter;
import butterknife.ButterKnife;
import butterknife.InjectView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by germangirod on 8/30/16.
 */
public class ImageListFragment extends Fragment implements ImagesPresenter{

    @InjectView(R.id.my_recycler_view) RecyclerView myList;
    @InjectView(R.id.progress_bar) ProgressBar progressBar;
    private ImageListAdapter imageListAdapter;
    private List<Image> imageList = new ArrayList<>();

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_list_fragment, container, false);
        ButterKnife.inject(this, view);

        setList();

        return view;

    }

    private void setList(){

        myList.setHasFixedSize(true);
        myList.setLayoutManager(new LinearLayoutManager(getActivity()));
        imageListAdapter = new ImageListAdapter(imageList);
        myList.setAdapter(imageListAdapter);

    }

    @Override public void onResume() {
        super.onResume();
        getImages();
    }

    public void getImages(){
        progressBar.setVisibility(View.VISIBLE);
        ImagesData imagesData = new ImagesData(this);
        imagesData.getImages();

    }

    @Override public void onImageResponseSuccess(ImagesResponse imagesResponse) {
        Log.e("mirar llego aca ","mirar llego aca ");
        progressBar.setVisibility(View.GONE);
        imageListAdapter.setImages(imagesResponse.getData());

    }

    @Override public void onError(Throwable throwable) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(getActivity(), throwable.toString(), Toast.LENGTH_SHORT).show();
    }
}
