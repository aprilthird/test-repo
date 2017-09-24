package pe.edu.upc.cacthuppc1.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import pe.edu.upc.cacthuppc1.R;
import pe.edu.upc.cacthuppc1.fragments.DashboardFragment;
import pe.edu.upc.cacthuppc1.fragments.SettingsFragment;
import pe.edu.upc.cacthuppc1.fragments.SourcesFragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return navigateAccordingTo(item.getItemId());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigateAccordingTo(R.id.navigation_dashboard);
    }

    private Fragment getFragmentFor(int id){
        switch(id){
            case R.id.navigation_dashboard: return new DashboardFragment();
            case R.id.navigation_sources: return new SourcesFragment();
            case R.id.navigation_settings: return new SettingsFragment();
        }
        return null;
    }

    private boolean navigateAccordingTo(int id){
        try{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, getFragmentFor(id))
                    .commit();
            return true;
        }
        catch(NullPointerException e){
            return false;
        }
    }
}
