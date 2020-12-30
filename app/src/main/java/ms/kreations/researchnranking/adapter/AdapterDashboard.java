package ms.kreations.researchnranking.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
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
import ms.kreations.researchnranking.model.ModelDashboard;


public class AdapterDashboard extends RecyclerView.Adapter<AdapterDashboard.MyViewHolder> {
    private final List<ModelDashboard> modelDashboardList;
    private final Context context;
    private Dialog dialogImageShow;
    private AppCompatActivity appCompatActivity;

    public AdapterDashboard(List<ModelDashboard> modelDashboardList, Context applicationContext) {
        this.modelDashboardList = modelDashboardList;
        this.context = applicationContext;
        this.appCompatActivity = appCompatActivity;
    }

    @NonNull
    @Override
    public AdapterDashboard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_dashboard_tile, parent, false);
        return new AdapterDashboard.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDashboard.MyViewHolder holder, int position) {
        ModelDashboard modelProductList = modelDashboardList.get(position);
        holder.tileName.setText(modelProductList.getTileName());
        holder.tileDescription.setText(modelProductList.getTileDesc());
        Glide.with(context).load(Uri.parse(modelProductList.getTileImage()))
                .into(holder.productImage);
      /*  Glide.with(context)
                .load(R.drawable.image_placeholder)
                .into(holder.productImage);*/
    }

    @Override
    public int getItemCount() {
        return modelDashboardList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
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
                        intentProfile.putExtra("fragName", "Learn with RNR");
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
