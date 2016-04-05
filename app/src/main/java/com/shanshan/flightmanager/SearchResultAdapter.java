package com.shanshan.flightmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    public static List<FlightDatas> mDatas = new ArrayList<>();
//    private FlightDatas mFlightDatas;

    public SearchResultAdapter(Context context, List<FlightDatas> mDatas){
        this.mContext = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);
    }

    /*创建ViewHolder*/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_flight_view, parent , false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).dwhereFrom.setText( mDatas.get(position).getWhereFrom());
        ((MyViewHolder)holder).dwhereTo.setText( mDatas.get(position).getWhereTo());
        ((MyViewHolder)holder).dtimeBegin.setText( mDatas.get(position).getTimeBegin());
        ((MyViewHolder)holder).dtimeEnd.setText( mDatas.get(position).getTimeEnd());
        ((MyViewHolder)holder).dtransCity.setText( mDatas.get(position).getTransCity());
        ((MyViewHolder)holder).dDay.setText((mDatas.get(position).getDay()));
        ((MyViewHolder)holder).itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        // return mFlightDatas.size();
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView dwhereFrom;
        TextView dwhereTo ;
        TextView dtimeBegin ;
        TextView dtimeEnd ;
        TextView dtransCity ;
        TextView dDay ;

        public MyViewHolder(final View itemView) {
            super(itemView);
            dwhereFrom = (TextView) itemView.findViewById(R.id.where_from);
            dwhereTo = (TextView) itemView.findViewById(R.id.where_to);
            dtimeBegin = (TextView) itemView.findViewById(R.id.time_begin);
            dtimeEnd = (TextView) itemView.findViewById(R.id.time_end);
            dtransCity = (TextView) itemView.findViewById(R.id.trans_city);
            dDay = (TextView) itemView.findViewById(R.id.day);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, ActivityFlightDetails.class);
                    //intent.putExtra()
                    intent.putExtra("id",(int)itemView.getTag());
                    intent.putExtra("isSearchResult",true);
                    mContext.startActivity(intent);
                }
            });
        }

    }

}