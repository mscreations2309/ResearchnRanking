package ms.kreations.researchnranking.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.activity.FragmentMainActivity;
import ms.kreations.researchnranking.model.ModelLearn;
import ms.kreations.researchnranking.utility.RoundedImageView;

public class AdapterLearn extends RecyclerView.Adapter<AdapterLearn.MyViewHolder> {
    private final List<ModelLearn> modelLearnList;
    private final Context context;
    private Dialog dialogImageShow;
    private AppCompatActivity appCompatActivity;

    public AdapterLearn(List<ModelLearn> modelLearnList, Context applicationContext) {
        this.modelLearnList = modelLearnList;
        this.context = applicationContext;
        this.appCompatActivity = appCompatActivity;
    }

    @NonNull
    @Override
    public AdapterLearn.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_learn_tile, parent, false);
        return new AdapterLearn.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLearn.MyViewHolder holder, int position) {
        ModelLearn modelLearn = modelLearnList.get(position);
        holder.tileName.setText(modelLearn.getTileName());
        holder.tileDescription.setText(modelLearn.getTileDesc());
        Glide.with(context).load(Uri.parse(modelLearn.getTileImage()))
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return modelLearnList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        RoundedImageView productImage;
        TextView tileName;
        TextView tileDescription;


        public MyViewHolder(View itemView) {
            super(itemView);
            tileName = itemView.findViewById(R.id.tileName);
            tileDescription = itemView.findViewById(R.id.tileDescription);
            productImage = itemView.findViewById(R.id.productImage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition()==0){
                        Intent intentProfile = new Intent(context, FragmentMainActivity.class);
                        intentProfile.putExtra("fragName", "Why Invest?");
                        context.startActivity(intentProfile);
                    }
                    else {
                        Toast.makeText(context, "feature not available.", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }


}
