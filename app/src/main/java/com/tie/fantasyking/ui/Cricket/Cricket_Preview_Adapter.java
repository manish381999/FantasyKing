package com.tie.fantasyking.ui.Cricket;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tie.fantasyking.R;
import com.tie.fantasyking.databinding.PreviewItemLayoutBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Cricket_Preview_Adapter extends RecyclerView.Adapter<Cricket_Preview_Adapter.CricketViewHolder>{
    Context context;
    List<MatchList_Model.HeavyDetails> list;

    public Cricket_Preview_Adapter(Context context, List<MatchList_Model.HeavyDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CricketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.preview_item_layout,parent,false);

        return new CricketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CricketViewHolder holder, int position) {
MatchList_Model.HeavyDetails details=list.get(position);

        Glide.with(context).load("https://tiemysql.000webhostapp.com/Images/"+details.getImg_team_a()).into(holder.binding.imgTeamA);

        Log.e("img",details.getImg_team_a());

        Glide.with(context).load("https://tiemysql.000webhostapp.com/Images/"+details.getImg_team_b()).into(holder.binding.imgTeamB);


        holder.binding.tvTournamentName.setText(details.getTournament());
        holder.binding.tvTeamAName.setText(details.getTeam_a());
        holder.binding.tvTeamBName.setText(details.getTeam_b());
//        holder.binding.tvDate.setText(details.getDate());
//        holder.binding.tvTime.setText(details.getTime());
        holder.binding.tvMatchName.setText(details.getName());
        holder.binding.tvTeamStatus.setText(details.getTeam_status());

        holder.bindData(details);


        holder.binding.match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Cricket_Preview_Activity.class);
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



    public static class CricketViewHolder extends RecyclerView.ViewHolder{
PreviewItemLayoutBinding binding;
        private CountDownTimer countDownTimer;

        public CricketViewHolder(@NonNull View itemView) {
            super(itemView);
            binding=PreviewItemLayoutBinding.bind(itemView);

        }


            public void bindData(MatchList_Model.HeavyDetails event) {
          binding.tvDate.setText(event.getTime());

                long eventStartTimeInMillis = calculateStartTimeInMillis(event);

                if (countDownTimer != null) {
                    countDownTimer.cancel(); // Cancel any previous countdown timers to avoid conflicts
                }

                // Start the countdown timer
                countDownTimer = new CountDownTimer(eventStartTimeInMillis - System.currentTimeMillis(), 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        // Update the countdownTextView with the remaining time
                        String timeRemaining = formatTime(millisUntilFinished);
                        binding.tvTime.setText(timeRemaining);
                    }

                    @Override
                    public void onFinish() {
                        binding.tvTime.setText("0s"); // Update UI when the timer finishes
                    }
                }.start();
            }

            // Helper method to calculate the start time of the event relative to the current time
            private long calculateStartTimeInMillis(MatchList_Model.HeavyDetails event) {
                String eventTime = event.getTime(); // Get the event time in "hh:mm a" format

                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
                try {
                    Date eventDate = sdf.parse(eventTime);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(eventDate);

                    // Set the event hour and minute from the parsed date
                    int eventHour = calendar.get(Calendar.HOUR_OF_DAY);
                    int eventMinute = calendar.get(Calendar.MINUTE);

                    // Set the event time on the current day
                    Calendar eventTimeCalendar = Calendar.getInstance();
                    eventTimeCalendar.set(Calendar.HOUR_OF_DAY, eventHour);
                    eventTimeCalendar.set(Calendar.MINUTE, eventMinute);
                    eventTimeCalendar.set(Calendar.SECOND, 0);

                    long eventStartTimeInMillis = eventTimeCalendar.getTimeInMillis();
 //                   long currentTimeInMillis = System.currentTimeMillis();

//                    if (eventStartTimeInMillis <= currentTimeInMillis) {
//                        // If the event time has already passed for today, add 1 day to the event start time
//                        eventStartTimeInMillis += 24 * 60 * 60 * 1000;
//                    }

                    return eventStartTimeInMillis;
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return 0;
            }

            // Helper method to format the time in HH:MM:SS format
            private String formatTime(long millis) {
                long seconds = millis / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;
                return String.format("%02d:%02d:%02d", hours, minutes % 60, seconds % 60);
        }
    }



}
