package app.android.girod.imageur.ui;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import app.android.girod.imageur.R;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends BaseActivity {
    private FragmentTransaction fragmentTransaction;
    @InjectView(R.id.toolbar) Toolbar toolbar;


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setToolbar();
        setFragment(new ImageListFragment());

    }

    @Override public void onLocationChanged(Location location) {
        super.onLocationChanged(location);
        Toast.makeText(this, "user location is: latidude: "+location.getLatitude()+" and longitude: "+location.getLongitude(), Toast.LENGTH_LONG).show();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
    }

    public void setFragment(Fragment fragment) {
        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment);
        fragmentTransaction.commit();
    }
}
