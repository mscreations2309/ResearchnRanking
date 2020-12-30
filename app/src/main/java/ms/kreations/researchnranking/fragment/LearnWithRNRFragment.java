package ms.kreations.researchnranking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.adapter.AdapterDashboard;
import ms.kreations.researchnranking.adapter.AdapterLearn;
import ms.kreations.researchnranking.model.ModelDashboard;
import ms.kreations.researchnranking.model.ModelLearn;
import ms.kreations.researchnranking.utility.GridSpacingItemDecoration;


public class LearnWithRNRFragment extends Fragment {

    private RecyclerView rVlearn;
    private EditText editTxtSearch;
    private ImageView imageViewSearch;
    private ImageView backbtn;
    private List<ModelLearn> modelLearnList;
    private AdapterLearn adapterLearn;
    private ArrayList<String> tileNameList = new ArrayList<String>();
    private ArrayList<String> tileImageList = new ArrayList<String>();
    private ArrayList<String> tileDescList = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_learn_with_r_n_r, container, false);
        rVlearn=root.findViewById(R.id.rVlearn);
        rVlearn.setHasFixedSize(true);
        rVlearn.setLayoutManager(new GridLayoutManager(getActivity(),1));
        modelLearnList = new ArrayList<>();
        editTxtSearch=root.findViewById(R.id.editTxtSearch);
        backbtn=root.findViewById(R.id.backbtn);
        imageViewSearch=root.findViewById(R.id.imageViewSearch);
        addNameMethod();
        addImageMethod();
        addDescriptionMethod();
        dataShowMethod();
        backbtn.setOnClickListener(view -> {
            getActivity().finish();
        });
        return root;
    }
    private void dataShowMethod() {
        for (int i = 0; i < tileDescList.size(); i++) {
            String tileName=tileNameList.get(i);
            String tileImage=tileImageList.get(i);
            String tileDesc=tileDescList.get(i);
            ModelLearn modelLearn=new ModelLearn(tileName,tileImage,tileDesc);
            modelLearnList.add(modelLearn);
        }
        adapterLearn = new AdapterLearn(modelLearnList,getActivity());
        rVlearn.setAdapter(adapterLearn);
    }

    private void addDescriptionMethod() {
        tileDescList.add("Why you should invest in stock market?");
        tileDescList.add("Why you should know before before investing?");
        tileDescList.add("Why you should invest?");
        tileDescList.add("Everything you should know about investing.");
        tileDescList.add("How you should start investing?");
    }

    private void addImageMethod() {
        tileImageList.add("file:///android_asset/learna.png");
        tileImageList.add("file:///android_asset/learnb.png");
        tileImageList.add("file:///android_asset/learnc.png");
        tileImageList.add("file:///android_asset/learnd.png");
        tileImageList.add("file:///android_asset/learne.png");
    }

    private void addNameMethod() {
        tileNameList.add("Why Invest?");
        tileNameList.add("Basics of stock market.");
        tileNameList.add("Finding great companies.");
        tileNameList.add("Your investing life.");
        tileNameList.add("Getting started");
    }

}