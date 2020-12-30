package ms.kreations.researchnranking.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.model.ModelInvest;
import ms.kreations.researchnranking.utility.RoundedImageView;

public class SamplePagerAdapter extends PagerAdapter {

    private final Random random = new Random();
    private int mSize;

    private  List<ModelInvest> modelInvestListnew;
    private  Context context;
    public SamplePagerAdapter() {
        mSize = 6;
    }

    public SamplePagerAdapter(int count) {
        mSize = count;
    }

    public SamplePagerAdapter(List<ModelInvest> modelInvestList, Context applicationContext) {
        this.modelInvestListnew = modelInvestList;
        this.context = applicationContext;
        mSize=modelInvestList.size();
    }
    @Override public int getCount() {
        return mSize;
    }

    @Override public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup view, int position, @NonNull Object object) {
        view.removeView((View) object);
    }

    @SuppressLint("ResourceAsColor")
    @NonNull @Override public Object instantiateItem(@NonNull ViewGroup view, int position) {
        ModelInvest modelLearn = modelInvestListnew.get(position);
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //tv sno
        TextView textViewSno = new TextView(view.getContext());
        textViewSno.setText("Chapter "+String.valueOf(position+1)+"/"+String.valueOf(modelInvestListnew.size()));
        textViewSno.setBackgroundColor(0xffffff);
        textViewSno.setTextColor(Color.parseColor("#0ebc74"));
        textViewSno.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        textViewSno.setTypeface(ResourcesCompat.getFont(context, R.font.poppins_regular));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,80,10,10);
        textViewSno.setLayoutParams(params);
        textViewSno.setGravity(Gravity.CENTER_HORIZONTAL);
        //tv title
        TextView textViewTitle = new TextView(view.getContext());
        textViewTitle.setText(modelLearn.getTileName());
        textViewTitle.setTextColor(Color.parseColor("#000000"));
        textViewTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        textViewTitle.setTypeface(textViewTitle.getTypeface(), Typeface.BOLD);
        textViewTitle.setTypeface(ResourcesCompat.getFont(context, R.font.poppins_regular));
        textViewTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        //card view
        RelativeLayout relativeLayout = new RelativeLayout(view.getContext());
        CardView cardView = new CardView(view.getContext());
        cardView.setRadius(50);
        LinearLayout.LayoutParams paramscardView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramscardView.setMargins(50,30,50,20);
        cardView.setLayoutParams(paramscardView);
        cardView.setPadding(50, 30, 50, 25);
        cardView.setCardBackgroundColor(Color.WHITE);
        cardView.setMaxCardElevation(30);
        cardView.setMaxCardElevation(6);
        //llayout
        LinearLayout linearLayout1=new LinearLayout(view.getContext());
        LinearLayout.LayoutParams paramslinearLayout1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramslinearLayout1.setMargins(10,10,10,10);
        linearLayout1.setLayoutParams(paramslinearLayout1);
        linearLayout1.setPadding(10, 10, 10, 10);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        cardView.addView(linearLayout1);
        //nested scrollview
        NestedScrollView nestedScrollView=new NestedScrollView(view.getContext());
        LinearLayout.LayoutParams paramsnestedScrollView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsnestedScrollView.setMargins(0,0,0,0);
        nestedScrollView.setLayoutParams(paramsnestedScrollView);
        nestedScrollView.setPadding(0, 0, 0, 0);
        linearLayout1.addView(nestedScrollView);
        //llayout2
        LinearLayout linearLayout2=new LinearLayout(view.getContext());
        LinearLayout.LayoutParams paramslinearLayout2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramslinearLayout2.setMargins(0,0,0,0);
        linearLayout2.setLayoutParams(paramslinearLayout2);
        linearLayout2.setPadding(0, 0, 0, 0);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        nestedScrollView.addView(linearLayout2);
        //imageView
        RoundedImageView imageView=new RoundedImageView(view.getContext());
        imageView.setLayoutParams(new android.view.ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,400));
        imageView.setMaxHeight(200);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setMaxWidth(200);
        Glide.with(context).load(Uri.parse(modelLearn.getTileImage()))
                .into(imageView);
        linearLayout2.addView(imageView);

        //scrollview
        ScrollView scrollView=new ScrollView(view.getContext());
        LinearLayout.LayoutParams paramsscrollView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsscrollView.setMargins(10,10,10,10);
        scrollView.setLayoutParams(paramsscrollView);
        scrollView.setPadding(10, 10, 10, 10);
        linearLayout2.addView(scrollView);

        //textview description;
        TextView textViewDesc = new TextView(view.getContext());
        textViewDesc.setText(modelLearn.getTileDesc());
        textViewDesc.setTextColor(Color.parseColor("#000000"));
        textViewDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        textViewDesc.setTypeface(ResourcesCompat.getFont(context, R.font.poppins_regular));
        LinearLayout.LayoutParams paramstextViewDesc = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        paramstextViewDesc.setMargins(0,20,0,20);
        textViewDesc.setLayoutParams(paramstextViewDesc);
        textViewDesc.setPadding(0, 20, 0, 20);
        scrollView.addView(textViewDesc);



        linearLayout.addView(textViewSno);
        linearLayout.addView(textViewTitle);
        relativeLayout.addView(cardView);
        linearLayout.addView(relativeLayout);
        view.addView(linearLayout, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        return linearLayout;
    }

    public void addItem() {
        mSize++;
        notifyDataSetChanged();
    }

    public void removeItem() {
        mSize--;
        mSize = mSize < 0 ? 0 : mSize;

        notifyDataSetChanged();
    }
}