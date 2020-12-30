package ms.kreations.researchnranking.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.adapter.SamplePagerAdapter;
import ms.kreations.researchnranking.model.ModelInvest;

public class WhyInvestFragment extends Fragment {
    private RecyclerView rVinvest;
    private ViewPager viewPager;
    private ImageView backbtn;
    private List<ModelInvest> modelInvestList;
    private CircleIndicator circleIndicator;
    private ArrayList<String> tileNameList = new ArrayList<String>();
    private ArrayList<String> tileImageList = new ArrayList<String>();
    private ArrayList<String> tileDescList = new ArrayList<String>();
    public static TextView sno;
    public static TextView tileNamenew;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_why_invest, container, false);
        rVinvest=view.findViewById(R.id.rVinvest);
        viewPager=view.findViewById(R.id.viewPager);
        sno=view.findViewById(R.id.sno);
        tileNamenew=view.findViewById(R.id.tileName);
        backbtn=view.findViewById(R.id.backbtn);
        circleIndicator=view.findViewById(R.id.indicatorCircle);
        modelInvestList = new ArrayList<>();

        addNameMethod();
        addImageMethod();
        addDescriptionMethod();
        dataShowMethod();
        viewPager.setAdapter(new SamplePagerAdapter(modelInvestList,getActivity()));
        circleIndicator.setViewPager(viewPager);
        backbtn.setOnClickListener(view1 -> {
            getActivity().finish();

        });
        return view;
    }
    public WhyInvestFragment() {
        // Required empty public constructor
    }

    public static WhyInvestFragment newInstance() {
        return new WhyInvestFragment();
    }
    private void dataShowMethod() {
        for (int i = 0; i < tileDescList.size(); i++) {
            String tileName=tileNameList.get(i);
            String tileImage=tileImageList.get(i);
            String tileDesc=tileDescList.get(i);
            ModelInvest modelInvest=new ModelInvest(tileName,tileImage,tileDesc);
            modelInvestList.add(modelInvest);
        }
    }

    private void addDescriptionMethod() {
        tileDescList.add("Owning stock means owning a piece of a company.\nInvest funds " +
                "are working for you 24/7. Invested money can grow much faster than cash in a saving account.");
        tileDescList.add("Owning stock means owning a piece of a company.\nInvest funds " +
                "are working for you 24/7. Invested money can grow much faster than cash in a saving account.");
        tileDescList.add("Compound interest is when the money you earn starts earning money." +
                "\nCompounding is the easiest way to become wealthy.\nThe sooner you begin investing, the more time your earning have to compound.");
        tileDescList.add("Compound interest is when the money you earn starts earning money." +
                "\nCompounding is the easiest way to become wealthy.\nThe sooner you begin investing, the more time your earning have to compound.");
        tileDescList.add("Owning stock means owning a piece of a company.\nInvest funds " +
                "are working for you 24/7. Invested money can grow much faster than cash in a saving account.");
        tileDescList.add("Compound interest is when the money you earn starts earning money." +
                "\nCompounding is the easiest way to become wealthy.\nThe sooner you begin investing, the more time your earning have to compound.");

    }

    private void addImageMethod() {
        tileImageList.add("file:///android_asset/investa.jpg");
        tileImageList.add("file:///android_asset/investb.jpg");
        tileImageList.add("file:///android_asset/investc.jpg");
        tileImageList.add("file:///android_asset/investd.jpg");
        tileImageList.add("file:///android_asset/investe.jpg");
        tileImageList.add("file:///android_asset/investf.jpg");
    }

    private void addNameMethod() {
        tileNameList.add("Why Buy Stocks?");
        tileNameList.add("Why Buy Stocks?");
        tileNameList.add("Compound Magic");
        tileNameList.add("Compound Magic");
        tileNameList.add("Why Buy Stocks?");
        tileNameList.add("Compound Magic");
    }
}