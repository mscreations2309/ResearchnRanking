package ms.kreations.researchnranking.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.adapter.AdapterDashboard;
import ms.kreations.researchnranking.adapter.AdapterLeaderBoard;
import ms.kreations.researchnranking.model.ModelDashboard;
import ms.kreations.researchnranking.model.ModelLeaderBoard;

public class LeaderBoardFragment extends Fragment {


    private ImageView imageViewa;
    private ImageView imageViewb;
    private ImageView imageViewc;
    private TextView nameTxta;
    private TextView nameTxtb;
    private TextView nameTxtc;
    private TextView ponitTxta;
    private TextView ponitTxtb;
    private TextView ponitTxtc;
    private List<ModelLeaderBoard> modelLeaderBoardList;
    private AdapterLeaderBoard adapterLeaderBoard;
    private RecyclerView rVLeaderboard;
    private ArrayList<String> tileNameList = new ArrayList<String>();
    private ArrayList<String> tileImageList = new ArrayList<String>();
    private ArrayList<String> tilePointList = new ArrayList<String>();
    private  View root;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_home, container, false);
        initUI();
        rVLeaderboard.setHasFixedSize(true);
        rVLeaderboard.setLayoutManager(new LinearLayoutManager(getActivity()));
        modelLeaderBoardList = new ArrayList<>();
        setStaticData();
        addNameMethod();
        addImageMethod();
        addPonitsMethod();
        dataShowMethod();
        return root;
    }

    private void initUI() {
        imageViewa=root.findViewById(R.id.imageViewa);
        imageViewb=root.findViewById(R.id.imageViewb);
        imageViewc=root.findViewById(R.id.imageViewc);
        nameTxta=root.findViewById(R.id.nameTxta);
        nameTxtb=root.findViewById(R.id.nameTxtb);
        nameTxtc=root.findViewById(R.id.nameTxtc);
        ponitTxta=root.findViewById(R.id.ponitTxta);
        ponitTxtb=root.findViewById(R.id.ponitTxtb);
        ponitTxtc=root.findViewById(R.id.ponitTxtc);
        rVLeaderboard=root.findViewById(R.id.rVLeaderboard);
    }
    private void setStaticData() {
        nameTxta.setText("Divya");
        nameTxtb.setText("Sharang");
        nameTxtc.setText("Abhijit");
        ponitTxta.setText("2000");
        ponitTxtb.setText("1700");
        ponitTxtc.setText("1600");
        Glide.with(getActivity()).load(Uri.parse(("file:///android_asset/leadera.png"))).into(imageViewa);
        Glide.with(getActivity()).load(Uri.parse(("file:///android_asset/leaderb.png"))).into(imageViewb);
        Glide.with(getActivity()).load(Uri.parse(("file:///android_asset/leaderc.png"))).into(imageViewc);
    }

    private void dataShowMethod() {
        for (int i = 0; i < tilePointList.size(); i++) {
            String tileName=tileNameList.get(i);
            String tileImage=tileImageList.get(i);
            String tilePoint=tilePointList.get(i);
            ModelLeaderBoard modelLeaderBoard=new ModelLeaderBoard(tileName,tileImage,tilePoint);
            modelLeaderBoardList.add(modelLeaderBoard);
        }
        adapterLeaderBoard = new AdapterLeaderBoard(modelLeaderBoardList,getActivity());
        rVLeaderboard.setAdapter(adapterLeaderBoard);
    }

    private void addPonitsMethod() {
        tilePointList.add("1521");
        tilePointList.add("1221");
        tilePointList.add("1210");
        tilePointList.add("1021");
        tilePointList.add("521");
        tilePointList.add("121");
    }

    private void addImageMethod() {
        tileImageList.add("file:///android_asset/leaderd.png");
        tileImageList.add("file:///android_asset/leadere.png");
        tileImageList.add("file:///android_asset/leaderf.png");
        tileImageList.add("file:///android_asset/leaderg.png");
        tileImageList.add("file:///android_asset/leaderh.png");
        tileImageList.add("file:///android_asset/leaderi.png");
    }

    private void addNameMethod() {
        tileNameList.add("Anjali");
        tileNameList.add("Akansha");
        tileNameList.add("Soni");
        tileNameList.add("Deepa");
        tileNameList.add("Gautam");
        tileNameList.add("Manjeet");
    }
}