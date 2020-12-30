package ms.kreations.researchnranking.fragment;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.adapter.AdapterDashboard;
import ms.kreations.researchnranking.model.ModelDashboard;
import ms.kreations.researchnranking.utility.GridSpacingItemDecoration;

public class DashboardFragment extends Fragment {

    private RecyclerView rVDashboard;
    private EditText editTxtSearch;
    private ImageView imageViewSearch;
    private List<ModelDashboard> modelDashboardList;
    private AdapterDashboard adapterDashboard;
    private ArrayList<String> tileNameList = new ArrayList<String>();
    private ArrayList<String> tileImageList = new ArrayList<String>();
    private ArrayList<String> tileDescList = new ArrayList<String>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        rVDashboard=root.findViewById(R.id.rVDashboard);
        rVDashboard.setHasFixedSize(true);
        GridLayoutManager  mLayoutManager = new GridLayoutManager(getActivity(), 2);
        rVDashboard.addItemDecoration(new GridSpacingItemDecoration(2, (int) dpToPx(5) , true));
        rVDashboard.setLayoutManager(mLayoutManager);
        modelDashboardList = new ArrayList<>();
        editTxtSearch=root.findViewById(R.id.editTxtSearch);
        imageViewSearch=root.findViewById(R.id.imageViewSearch);
        addNameMethod();
        addImageMethod();
        addDescriptionMethod();
        dataShowMethod();
        return root;
    }

    private Object dpToPx(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private void dataShowMethod() {
        for (int i = 0; i < tileDescList.size(); i++) {
            String tileName=tileNameList.get(i);
            String tileImage=tileImageList.get(i);
            String tileDesc=tileDescList.get(i);
            ModelDashboard modelDashboard=new ModelDashboard(tileName,tileImage,tileDesc);
            modelDashboardList.add(modelDashboard);
        }
        adapterDashboard = new AdapterDashboard(modelDashboardList,getActivity());
        rVDashboard.setAdapter(adapterDashboard);
    }

    private void addDescriptionMethod() {
        tileDescList.add("Start Now");
        tileDescList.add("Watch Now");
        tileDescList.add("Read Now");
        tileDescList.add("Explore Now");
        tileDescList.add("Explore Now");
        tileDescList.add("Explore Now");
    }

    private void addImageMethod() {
        tileImageList.add("file:///android_asset/learn_with_pnr.png");
        tileImageList.add("file:///android_asset/videos.png");
        tileImageList.add("file:///android_asset/blogs_article.png");
        tileImageList.add("file:///android_asset/monthly_nes.png");
        tileImageList.add("file:///android_asset/announcement.png");
        tileImageList.add("file:///android_asset/monthly_research.png");
    }

    private void addNameMethod() {
        tileNameList.add("Learn with RNR");
        tileNameList.add("Videos");
        tileNameList.add("Blogs & Articles");
        tileNameList.add("Monthly Newsletter");
        tileNameList.add("Announcement");
        tileNameList.add("Monthly Research");
    }
}