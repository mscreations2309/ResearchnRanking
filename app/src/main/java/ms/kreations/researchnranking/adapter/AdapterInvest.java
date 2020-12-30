package ms.kreations.researchnranking.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.model.ModelInvest;
import ms.kreations.researchnranking.utility.RoundedImageView;


public class AdapterInvest extends RecyclerView.Adapter<AdapterInvest.MyViewHolder> {
    private final List<ModelInvest> modelInvestList;
    private final Context context;
    private Dialog dialogImageShow;
    private AppCompatActivity appCompatActivity;

    public AdapterInvest(List<ModelInvest> modelInvestList, Context applicationContext) {
        this.modelInvestList = modelInvestList;
        this.context = applicationContext;
        this.appCompatActivity = appCompatActivity;
    }

    @NonNull
    @Override
    public AdapterInvest.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_invest_tile, parent, false);
        return new AdapterInvest.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterInvest.MyViewHolder holder, int position) {
        ModelInvest modelLearn = modelInvestList.get(position);
        holder.tileName.setText(modelLearn.getTileName());
        holder.tileDescription.setText(modelLearn.getTileDesc());
        holder.sno.setText("Chapter "+String.valueOf(position+1)+"/"+String.valueOf(modelInvestList.size()));
        Glide.with(context).load(Uri.parse(modelLearn.getTileImage()))
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return modelInvestList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView productImage;
        TextView tileName;
        TextView tileDescription;
        TextView sno;


        public MyViewHolder(View itemView) {
            super(itemView);
            tileName = itemView.findViewById(R.id.tileName);
            sno = itemView.findViewById(R.id.sno);
            tileDescription = itemView.findViewById(R.id.tileDescription);
            productImage = itemView.findViewById(R.id.productImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   /* if (getAdapterPosition()==0){
                        Intent intentProfile = new Intent(context, FragmentMainActivity.class);
                        intentProfile.putExtra("fragName", "Why Invest?");
                        context.startActivity(intentProfile);
                    }
                    else {
                        Toast.makeText(context, "feature not available.", Toast.LENGTH_SHORT).show();
                    }*/
                }
            });


        }
    }



}
