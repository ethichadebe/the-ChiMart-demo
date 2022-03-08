package com.example.chillersmarket.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.MoreInfoItem;

import java.util.ArrayList;

public class MoreInfoAdapter extends RecyclerView.Adapter<MoreInfoAdapter.MoreInfoViewHolder> {

    private ArrayList<MoreInfoItem> alMoreInfoItems;

    private OnItemClickListener oiclListener;

    public interface OnItemClickListener {
        void toggleExpansionClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        oiclListener = listener;
    }


    public static class MoreInfoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHead, tvBody;

        public MoreInfoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            tvHead = itemView.findViewById(R.id.tvHead);
            tvBody = itemView.findViewById(R.id.tvBody);

            tvHead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.toggleExpansionClick(position);
                        }
                    }
                }
            });

            tvBody.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.toggleExpansionClick(position);
                        }
                    }
                }
            });
        }
    }

    public MoreInfoAdapter(ArrayList<MoreInfoItem> moreInfoItems) {
        this.alMoreInfoItems = moreInfoItems;
    }

    @NonNull
    @Override
    public MoreInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_info_item, parent, false);
        MoreInfoViewHolder mvh = new MoreInfoViewHolder(v, oiclListener);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MoreInfoViewHolder holder, int position) {
        MoreInfoItem currentItem = alMoreInfoItems.get(position);

        holder.tvHead.setText(currentItem.getStrHead());
        holder.tvBody.setText(currentItem.getStrBody());
    }

    @Override
    public int getItemCount() {
        return alMoreInfoItems.size();
    }
}
