package com.yunding.freelotterylist.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.yunding.freelotterylist.DataResp.LotteryBean;
import com.yunding.freelotterylist.R;

import java.util.List;

/**
 * 类 名 称：FreeLotteryList
 * <P/>描    述：
 * <P/>创 建 人：CM
 * <P/>创建时间：2018/3/16
 * <P/>修 改 人：CM
 * <P/>修改时间：2018/3/16
 * <P/>修改备注：
 * <P/>版    本：
 */

public class DataAdapter extends BaseAdapter {
    private List<LotteryBean.DataBean> mDataList;
    private Context mContext;

    public DataAdapter(List<LotteryBean.DataBean> dataList, Context context) {
        this.mDataList = dataList;
        this.mContext = context;
    }

    public void setNewData(List<LotteryBean.DataBean> dataList) {
        this.mDataList = dataList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LotteryHolder holder = null;

        LotteryBean.DataBean item = mDataList.get(i);
//        if (view == null) {
        view = View.inflate(mContext, R.layout.item_lottery, null);
        holder = new LotteryHolder();
        holder.tv_1 = view.findViewById(R.id.tv_1);
        holder.tv_2 = view.findViewById(R.id.tv_2);
        holder.tv_3 = view.findViewById(R.id.tv_3);
        holder.tv_4 = view.findViewById(R.id.tv_4);
        holder.tv_5 = view.findViewById(R.id.tv_5);
        holder.tv_6 = view.findViewById(R.id.tv_6);
        holder.tv_7 = view.findViewById(R.id.tv_7);
        holder.tv_8 = view.findViewById(R.id.tv_8);
        holder.tv_9 = view.findViewById(R.id.tv_9);
        holder.tv_10 = view.findViewById(R.id.tv_10);
        holder.tv_11 = view.findViewById(R.id.tv_11);
        holder.tv_12 = view.findViewById(R.id.tv_12);
        holder.tv_13 = view.findViewById(R.id.tv_13);
        holder.tv_14 = view.findViewById(R.id.tv_14);
        holder.tv_15 = view.findViewById(R.id.tv_15);
        holder.tv_16 = view.findViewById(R.id.tv_16);
        holder.tv_17 = view.findViewById(R.id.tv_17);
        holder.tv_18 = view.findViewById(R.id.tv_18);
        holder.tv_19 = view.findViewById(R.id.tv_19);
        holder.tv_20 = view.findViewById(R.id.tv_20);
        holder.tv_21 = view.findViewById(R.id.tv_21);
        holder.tv_22 = view.findViewById(R.id.tv_22);
        holder.tv_23 = view.findViewById(R.id.tv_23);
        holder.tv_24 = view.findViewById(R.id.tv_24);
        holder.tv_25 = view.findViewById(R.id.tv_25);
        holder.tv_26 = view.findViewById(R.id.tv_26);
        holder.tv_27 = view.findViewById(R.id.tv_27);
        holder.tv_28 = view.findViewById(R.id.tv_28);
        holder.tv_29 = view.findViewById(R.id.tv_29);
        holder.tv_30 = view.findViewById(R.id.tv_30);
        holder.tv_31 = view.findViewById(R.id.tv_31);
        holder.tv_32 = view.findViewById(R.id.tv_32);
        holder.tv_33 = view.findViewById(R.id.tv_33);
        holder.tv_blue = view.findViewById(R.id.tv_blue);
        holder.tv_title = view.findViewById(R.id.tv_title);
//            view.setTag(holder);
//        } else {
//            holder = (LotteryHolder) view.getTag();
//        }
        String[] aaaa = item.getOpencode().split("\\+");
        holder.tv_blue.setText(aaaa[1] + "");
        String[] hong = aaaa[0].split(",");

        int small = 0;
        int middle = 0;
        int large = 0;
        int even = 0;
        for (int k = 0; k < 6; k++) {
            if (Integer.valueOf(hong[k]) < 12) {
                small++;
            } else if (Integer.valueOf(hong[k]) < 23) {
                middle++;
            } else {
                large++;
            }
            if (Integer.valueOf(hong[k]) % 2 == 0) {
                even++;
            }

        }
        holder.tv_title.setText("第 " + item.getExpect() + " 期" + "    开奖时间:  " + item.getOpentime() + "    区间比:  "
                + small + ":" + middle + ":" + large + "          奇偶比:  " + (6 - even) + ":" + even);

        for (int j = 0; j < 6; j++) {
            switch (Integer.valueOf(hong[j])) {
                case 1:
                    holder.tv_1.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_1.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 2:
                    holder.tv_2.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_2.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 3:
                    holder.tv_3.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_3.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 4:
                    holder.tv_4.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_4.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 5:
                    holder.tv_5.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_5.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 6:
                    holder.tv_6.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_6.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 7:
                    holder.tv_7.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_7.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 8:
                    holder.tv_8.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_8.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 9:
                    holder.tv_9.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_9.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 10:
                    holder.tv_10.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_10.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 11:
                    holder.tv_11.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_11.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 12:
                    holder.tv_12.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_12.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 13:
                    holder.tv_13.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_13.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 14:
                    holder.tv_14.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_14.setTextColor(Color.parseColor("#ffffff"));

                    break;
                case 15:
                    holder.tv_15.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_15.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 16:
                    holder.tv_16.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_16.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 17:
                    holder.tv_17.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_17.setTextColor(Color.parseColor("#ffffff"));

                    break;
                case 18:
                    holder.tv_18.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_18.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 19:
                    holder.tv_19.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_19.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 20:
                    holder.tv_20.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_20.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 21:
                    holder.tv_21.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_21.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 22:
                    holder.tv_22.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_22.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 23:
                    holder.tv_23.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_23.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 24:
                    holder.tv_24.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_24.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 25:
                    holder.tv_25.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_25.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 26:
                    holder.tv_26.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_26.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 27:
                    holder.tv_27.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_27.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 28:
                    holder.tv_28.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_28.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 29:
                    holder.tv_29.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_29.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 30:
                    holder.tv_30.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_30.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 31:
                    holder.tv_31.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_31.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 32:
                    holder.tv_32.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_32.setTextColor(Color.parseColor("#ffffff"));


                    break;
                case 33:
                    holder.tv_33.setBackground(mContext.getResources().getDrawable(R.drawable.bg_red));
                    holder.tv_33.setTextColor(Color.parseColor("#ffffff"));


                    break;
                default:

                    break;
            }
        }


        return view;
    }

    class LotteryHolder {
        TextView tv_1;
        TextView tv_2;
        TextView tv_3;
        TextView tv_4;
        TextView tv_5;
        TextView tv_6;
        TextView tv_7;
        TextView tv_8;
        TextView tv_9;
        TextView tv_10;
        TextView tv_11;
        TextView tv_12;
        TextView tv_13;
        TextView tv_14;
        TextView tv_15;
        TextView tv_16;
        TextView tv_17;
        TextView tv_18;
        TextView tv_19;
        TextView tv_20;
        TextView tv_21;
        TextView tv_22;
        TextView tv_23;
        TextView tv_24;
        TextView tv_25;
        TextView tv_26;
        TextView tv_27;
        TextView tv_28;
        TextView tv_29;
        TextView tv_30;
        TextView tv_31;
        TextView tv_32;
        TextView tv_33;
        TextView tv_blue;
        TextView tv_title;
    }
}
