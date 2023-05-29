package com.example.capstoneproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.capstoneproject.activity.ScheduleActivity;
import com.example.capstoneproject.R;
import com.example.capstoneproject.data.game.response.ChatRoomDTO;
import com.example.capstoneproject.data.match.response.plan.GetRemainMatchRoomResult;
import com.example.capstoneproject.data.match.response.plan.GetRemainMatchRoomResultDetail;
import com.example.capstoneproject.view.PostGameView;

import java.util.List;

public class NextMatchViewPageAdapter extends RecyclerView.Adapter<NextMatchViewPageAdapter.ViewHolder> {

    private int oldPosition = -1;
    private int selectedPosition = -1;
    private List<GetRemainMatchRoomResult> result;
    private Context context;
    private String jwt;

    public NextMatchViewPageAdapter(List<GetRemainMatchRoomResult> result, Context context, String jwt) {
        this.result = result;
        this.context = context;
        this.jwt = jwt;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_next_match, parent, false);
        NextMatchViewPageAdapter.ViewHolder vh = new NextMatchViewPageAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int touchIndex = holder.getAdapterPosition();
        RequestOptions requestOptions = RequestOptions.skipMemoryCacheOf(true)
                    .diskCacheStrategy(DiskCacheStrategy.NONE);
        GetRemainMatchRoomResult getResult = result.get(touchIndex);
        List<GetRemainMatchRoomResultDetail> getDetailResult = getResult.getGetRemainMatchRoomResultDetailList();

        holder.date.setText(getResult.getGameTime());
        holder.networkType.setText(getResult.getNetworkType());
        if (getDetailResult.get(0).getCount() == 2) { //개인전일때
            if (getDetailResult.size() == 1) { //아직 상대방이 없을때
                holder.homeTeam.setText(getDetailResult.get(0).getNickName());
                holder.awayTeam.setText("미정");

            } else {//상대방이 있을때
                holder.homeTeam.setText(getDetailResult.get(0).getNickName());
                holder.awayTeam.setText(getDetailResult.get(1).getNickName());
            }
        } else {//팀전
            if (getDetailResult.size() == 1) { //아직 상대방이 없을때
                holder.homeTeam.setText(getDetailResult.get(0).getNickName()+"팀");
                holder.awayTeam.setText("미정");
            }else {//상대방이 있을때
                holder.homeTeam.setText(getDetailResult.get(0).getNickName()+"팀");
                holder.awayTeam.setText(getDetailResult.get(1).getNickName()+"팀");
            }
        }

        if (getDetailResult.size() == 1) {
            if (getDetailResult.get(0).getImageUrl() == " ") {
                holder.homeImageUrl.setImageResource(R.drawable.default_profile);
                holder.awayImageUrl.setImageResource(R.drawable.default_profile);
            } else {
//                Glide.with(holder.itemView.getContext()).load(getDetailResult.get(0).getImageUrl())
//                    .apply(requestOptions)
//                    .into(holder.homeImageUrl);
                holder.homeImageUrl.setImageResource(R.drawable.default_profile);
                holder.awayImageUrl.setImageResource(R.drawable.default_profile);
            }
        }else{
            if (getDetailResult.get(0).getImageUrl() == " ") {
                holder.homeImageUrl.setImageResource(R.drawable.default_profile);
            }else{
//                Glide.with(holder.itemView.getContext()).load(getDetailResult.get(0).getImageUrl())
//                        .apply(requestOptions)
//                        .into(holder.homeImageUrl);
                holder.homeImageUrl.setImageResource(R.drawable.default_profile);
            }
            if (getDetailResult.get(1).getImageUrl() == " ") {
                holder.awayImageUrl.setImageResource(R.drawable.default_profile);
            } else {
//                Glide.with(holder.itemView.getContext()).load(getDetailResult.get(1).getImageUrl())
//                        .apply(requestOptions)
//                        .into(holder.awayImageUrl);
                holder.awayImageUrl.setImageResource(R.drawable.default_profile);
            }
        }
        holder.homeImageUrl.setClipToOutline(true);
        holder.awayImageUrl.setClipToOutline(true);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ScheduleActivity.class);
                intent.putExtra("matchIdx", getResult.getMatchIdx());
                context.startActivity(intent);
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        TextView date, networkType, homeTeam, awayTeam;
        ImageView homeImageUrl, awayImageUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.next_match_layout);
            date = itemView.findViewById(R.id.next_match_date_tv);
            networkType = itemView.findViewById(R.id.next_match_type_tv);
            homeTeam = itemView.findViewById(R.id.next_match_home_tv);
            awayTeam = itemView.findViewById(R.id.next_match_away_tv);
            homeImageUrl = itemView.findViewById(R.id.home_iv);
            awayImageUrl = itemView.findViewById(R.id.away_iv);
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

}
