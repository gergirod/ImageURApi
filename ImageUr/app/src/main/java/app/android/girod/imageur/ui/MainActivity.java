package app.android.girod.imageur.ui;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import app.android.girod.imageur.R;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {
    private FragmentTransaction fragmentTransaction;
    @InjectView(R.id.toolbar) Toolbar toolbar;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setToolbar();
        setFragment(new ImageListFragment());

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

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
