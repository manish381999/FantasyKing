package com.tie.fantasyking.ui.Football;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.PreviewItemLayoutBinding;
import com.tie.fantasyking.ui.Cricket.Cricket_Preview_Activity;
import com.tie.fantasyking.ui.Cricket.MatchList_Model;

import java.util.List;

public class Football_Preview_Adapter extends RecyclerView.Adapter<Football_Preview_Adapter.FootballViewHolder> {
Context context;
List<MatchList_Model.HeavyDetails> list;

    public Football_Preview_Adapter(Context context, List<MatchList_Model.HeavyDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FootballViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.preview_item_layout,parent,false);
        return new FootballViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballViewHolder holder, int position) {
MatchList_Model.HeavyDetails details=list.get(position);

        Glide.with(context).load("https://tiemysql.000webhostapp.com/Images/"+details.getImg_team_a()).into(holder.binding.imgTeamA);

        Log.e("img",details.getImg_team_a());

        Glide.with(context).load("https://tiemysql.000webhostapp.com/Images/"+details.getImg_team_b()).into(holder.binding.imgTeamB);


        holder.binding.tvTournamentName.setText(details.getTournament());
        holder.binding.tvTeamAName.setText(details.getTeam_a());
        holder.binding.tvTeamBName.setText(details.getTeam_b());
        holder.binding.tvDate.setText(details.getDate());
        holder.binding.tvTime.setText(details.getTime());
        holder.binding.tvMatchName.setText(details.getName());
        holder.binding.tvTeamStatus.setText(details.getTeam_status());

        holder.binding.match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Football_Preview_Activity.class);
                intent.putExtra("id",details.getId());
                intent.putExtra("im_team_a",details.getImg_team_a());
                intent.putExtra("im_team_b",details.getImg_team_b());
                intent.putExtra("match_name",details.getName());
                intent.putExtra("tournament",details.getTournament());
                intent.putExtra("date",details.getDate());
                intent.putExtra("time",details.getTime());
                intent.putExtra("match_quality",details.getQuality());
                intent.putExtra("preview",details.getPreview());
                intent.putExtra("statistics",details.getStatistics());
                intent.putExtra("team_a",details.getTeam_a());
                intent.putExtra("team_b",details.getTeam_b());
                intent.putExtra("A_playing11",details.getTeam_a_playing_11());
                intent.putExtra("B_playing11",details.getTeam_b_playing_11());
                intent.putExtra("captain",details.getCaptain());
                intent.putExtra("Vc",details.getVc_captain());
                intent.putExtra("team_status",details.getTeam_status());
                intent.putExtra("im_team",details.getTeam_img());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class FootballViewHolder extends RecyclerView.ViewHolder{
PreviewItemLayoutBinding binding;
        public FootballViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=PreviewItemLayoutBinding.bind(itemView);
        }
    }
}
