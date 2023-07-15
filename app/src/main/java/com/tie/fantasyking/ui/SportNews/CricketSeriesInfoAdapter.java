package com.tie.fantasyking.ui.SportNews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.CricketSeriesInfoLayoutBinding;

import java.util.List;


public class CricketSeriesInfoAdapter extends RecyclerView.Adapter<CricketSeriesInfoAdapter.seriesInfoViewHolder>{

    Context context;
    List<CricketSeriesInfoModel.MatchList> list;

    public CricketSeriesInfoAdapter(Context context, List<CricketSeriesInfoModel.MatchList> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public seriesInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cricket_series_info_layout,parent,false);
        return new seriesInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull seriesInfoViewHolder holder, int position) {
       CricketSeriesInfoModel.MatchList matchList=list.get(position);

        holder.binding.matchName.setText(matchList.getName());
        holder.binding.matchType.setText(matchList.getMatchType());
        holder.binding.tvStatus.setText(matchList.getStatus());
        holder.binding.tvVenue.setText(matchList.getVenue());
        holder.binding.tvDate.setText(matchList.getDate());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class seriesInfoViewHolder extends RecyclerView.ViewHolder{

        CricketSeriesInfoLayoutBinding binding;
        public seriesInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=CricketSeriesInfoLayoutBinding.bind(itemView);
        }
    }
}
