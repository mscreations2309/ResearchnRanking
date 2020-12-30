package ms.kreations.researchnranking.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.fragment.DashboardFragment;
import ms.kreations.researchnranking.fragment.HomeFragment;
import ms.kreations.researchnranking.fragment.LeaderBoardFragment;
import ms.kreations.researchnranking.fragment.NotificationsFragment;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadFragment(new DashboardFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new DashboardFragment();
                break;

            case R.id.navigation_profile:
                fragment = new HomeFragment();
                break;

            case R.id.navigation_leaderboard:
                fragment = new LeaderBoardFragment();
                break;
                case R.id.navigation_explore:
                fragment = new NotificationsFragment();
                break;

        }

        return loadFragment(fragment);
    }
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}