package com.shanshan.flightmanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener {

    private OnItemClickListener mOnItemClickListener = null;
    private LayoutInflater mInflater;
    private Context mContext;
    private List<FlightDatas> mDatas;
    private FlightDatas mFlightDatas;

    public RecycleViewAdapter(Context context, FlightDatas Datas){
        this.mContext = context;
        this.mFlightDatas = Datas;
        mInflater = LayoutInflater.from(context);
    }

    /*创建ViewHolder*/
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.item_flight_view, parent , false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        view.setOnClickListener(this);
        return viewHolder;
    }

    /*绑定ViewHolder*/
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.dwhereFrom.setText( mFlightDatas.getWhereFrom());
        holder.dwhereTo.setText( mFlightDatas.getWhereTo());
        holder.dtimeBegin.setText( mFlightDatas.getTimeBegin());
        holder.dtimeEnd.setText( mFlightDatas.getTimeEnd());
        holder.dtransCity.setText( mFlightDatas.getTransCity());
        holder.dDay.setText((mFlightDatas.getDay()));
        holder.itemView.setTag(mFlightDatas);
    }

    @Override
    public int getItemCount() {
       // return mFlightDatas.size();
        return 20;
    }

    @Override
    public void onClick(View v) {
        if(mOnItemClickListener != null ){
            mOnItemClickListener.onItemClick(v, v.toString());
        }
    }

    public static interface OnItemClickListener{
        void onItemClick(View view, String data);
    }

    public void setmOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

}


class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    TextView dwhereFrom;
    TextView dwhereTo ;
    TextView dtimeBegin ;
    TextView dtimeEnd ;
    TextView dtransCity ;
    TextView dDay ;

    public MyViewHolder(View itemView) {
        super(itemView);
        dwhereFrom = (TextView) itemView.findViewById(R.id.where_from);
        dwhereTo = (TextView) itemView.findViewById(R.id.where_to);
        dtimeBegin = (TextView) itemView.findViewById(R.id.time_begin);
        dtimeEnd = (TextView) itemView.findViewById(R.id.time_end);
        dtransCity = (TextView) itemView.findViewById(R.id.trans_city);
        dDay = (TextView) itemView.findViewById(R.id.day);
    }

    @Override
    public void onClick(View v) {

    }
}