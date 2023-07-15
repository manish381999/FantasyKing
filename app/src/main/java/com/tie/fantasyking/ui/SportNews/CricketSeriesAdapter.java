package com.tie.fantasyking.ui.SportNews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.CricketseriesLayoutBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CricketSeriesAdapter extends RecyclerView.Adapter<CricketSeriesAdapter.CricketSeriesViewHolder> {

    Context context;
    List<CricketSeriesModel.LightDetails> list;

    public CricketSeriesAdapter(Context context, List<CricketSeriesModel.LightDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CricketSeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cricketseries_layout,parent,false);
        return new CricketSeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketSeriesViewHolder holder, int position) {
      CricketSeriesModel.LightDetails lightDetails=list.get(position);

      holder.binding.seriesName.setText(lightDetails.getName());

        SimpleDateFormat input=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat output=new SimpleDateFormat("dd-MM-yyyy");

        try{
            Date t =input.parse(lightDetails.getStartDate());
            holder.binding.tvStartDate.setText(output.format(t));
        }catch (ParseException e){
            e.printStackTrace();
        }

      holder.binding.tvEndDate.setText(lightDetails.getEndDate());

      int odi1 = (int) lightDetails.getOdi();
      String odi= String.valueOf(odi1);
          holder.binding.tvOdi.setText(odi);

        int t201 = (int) lightDetails.getT20();
        String t20= String.valueOf(t201);
      holder.binding.tvT20.setText(t20);

      int test1=(int) lightDetails.getTest();
      String test= String.valueOf(test1);
        holder.binding.tvTest.setText(test);

        int squads1=(int) lightDetails.getSquads();
        String squads= String.valueOf(squads1);
        holder.binding.tvSquads.setText(squads);

        int matches1=(int) lightDetails.getMatches();
        String matches= String.valueOf(matches1);
        holder.binding.tvMatches.setText(matches);

//        holder.binding.series.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(context, CricketSeries_infoActivity.class);
//                intent.putExtra("id",lightDetails.getId());
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CricketSeriesViewHolder extends RecyclerView.ViewHolder{

        CricketseriesLayoutBinding binding;
        public CricketSeriesViewHolder(@NonNull View itemView) {
            super(itemView);

            binding=CricketseriesLayoutBinding.bind(itemView);
        }
    }
}
