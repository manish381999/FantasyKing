package com.tie.fantasyking.promotion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.ImageSliderLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {
    Context context;
List<Promotion_Model.LightDetails> list;

    public PromotionAdapter(Context context, List<Promotion_Model.LightDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view= LayoutInflater.from(context).inflate(R.layout.image_slider_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Promotion_Model.LightDetails lightDetails=list.get(position);

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

        imageList.add(new SlideModel("https://tiemysql.000webhostapp.com/Images/"+lightDetails.getImg_promotion(), ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://tiemysql.000webhostapp.com/Images/"+lightDetails.getImg_promotion(),ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://tiemysql.000webhostapp.com/Images/"+lightDetails.getImg_promotion(),ScaleTypes.CENTER_CROP));


       holder.binding.imageSlider.setImageList(imageList);
       holder.binding.imageSlider.setImageList(imageList);
       holder.binding.imageSlider.setImageList(imageList);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
ImageSliderLayoutBinding binding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=ImageSliderLayoutBinding.bind(itemView);
        }
    }
}
