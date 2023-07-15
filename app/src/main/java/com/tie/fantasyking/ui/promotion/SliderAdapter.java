package com.tie.fantasyking.ui.promotion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.SlideItemContainerBinding;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{

    Context context;
    List<Promotion_Model.LightDetails> list;
    ViewPager2 viewPager2;

    public SliderAdapter(Context context, List<Promotion_Model.LightDetails> list, ViewPager2 viewPager2) {
        this.context = context;
        this.list = list;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.slide_item_container,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
Promotion_Model.LightDetails lightDetails=list.get(position);

        Glide.with(context).load("https://tiemysql.000webhostapp.com/Images/"+lightDetails.getImg_promotion()).into(holder.binding.imageSlide);


if (position==list.size() - 2){
    viewPager2.post(runnable);
}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder{

        SlideItemContainerBinding binding;
        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=SlideItemContainerBinding.bind(itemView);
        }
    }

    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            list.addAll(list);
            notifyDataSetChanged();
        }
    };
}
