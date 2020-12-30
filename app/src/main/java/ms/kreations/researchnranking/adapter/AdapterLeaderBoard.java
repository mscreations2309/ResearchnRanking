package ms.kreations.researchnranking.adapter;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ms.kreations.researchnranking.R;
import ms.kreations.researchnranking.model.ModelLeaderBoard;


public class AdapterLeaderBoard extends RecyclerView.Adapter<AdapterLeaderBoard.MyViewHolder> {
    private final List<ModelLeaderBoard> modelLeaderBoardList;
    private final Context context;
    private Dialog dialogImageShow;
    private AppCompatActivity appCompatActivity;

    public AdapterLeaderBoard(List<ModelLeaderBoard> modelLeaderBoardList, Context applicationContext) {
        this.modelLeaderBoardList = modelLeaderBoardList;
        this.context = applicationContext;
        this.appCompatActivity = appCompatActivity;
    }

    @NonNull
    @Override
    public AdapterLeaderBoard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout_leaderboard_tile, parent, false);
        return new AdapterLeaderBoard.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLeaderBoard.MyViewHolder holder, int position) {
        ModelLeaderBoard modelLeaderBoard = modelLeaderBoardList.get(position);
        holder.sno.setText(String.valueOf(position+4));
        holder.points.setText(modelLeaderBoard.getTilePoint()+" Points");
        holder.nameTxt.setText(modelLeaderBoard.getTileName());
        Glide.with(context).load(Uri.parse(modelLeaderBoard.getTileImage()))
                .into(holder.imageViewb);
      /*  Glide.with(context)
                .load(R.drawable.image_placeholder)
                .into(holder.productImage);*/
    }

    @Override
    public int getItemCount() {
        return modelLeaderBoardList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewb;
        TextView points;
        TextView nameTxt;
        TextView sno;


        public MyViewHolder(View itemView) {
            super(itemView);
            points = itemView.findViewById(R.id.points);
            nameTxt = itemView.findViewById(R.id.nameTxt);
            sno = itemView.findViewById(R.id.sno);
            imageViewb = itemView.findViewById(R.id.imageViewb);


        }
    }


}
