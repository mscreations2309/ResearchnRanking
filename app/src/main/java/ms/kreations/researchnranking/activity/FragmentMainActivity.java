package ms.kreations.researchnranking.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.tuyenmonkey.mkloader.MKLoader;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.fragment.LearnWithRNRFragment;
import ms.kreations.researchnranking.fragment.WhyInvestFragment;

public class FragmentMainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private String fragName = "";
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);
        fragName = getIntent().getStringExtra("fragName");
        FragmentClassOpen();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void FragmentClassOpen() {
        if (fragName.equals("Learn with RNR")) {
            fragment = new LearnWithRNRFragment();
        }if (fragName.equals("Why Invest?")) {
            fragment = new WhyInvestFragment();
        }
        fragmentManager = getSupportFragmentManager();
        try {
            fragmentManager.beginTransaction().replace(R.id.fragmentId, fragment).commit();
        } catch (Exception e) {

        }
    }




}
