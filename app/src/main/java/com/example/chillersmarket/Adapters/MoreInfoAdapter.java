package com.example.chillersmarket.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chillersmarket.R;
import com.example.chillersmarket.RecyclewViewItems.MoreInfoItem;
import com.example.chillersmarket.fragments.HomeFragment;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.google.android.material.transition.Hold;

import java.util.ArrayList;

public class MoreInfoAdapter extends RecyclerView.Adapter<MoreInfoAdapter.MoreInfoViewHolder> {

    private ArrayList<MoreInfoItem> alMoreInfoItems;
    private static Context context;

    private OnItemClickListener oiclListener;

    public interface OnItemClickListener {
        void toggleExpansionClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        oiclListener = listener;
    }


    public static class MoreInfoViewHolder extends RecyclerView.ViewHolder {
        private TextView tvHead, tvBody;
        private ImageView ivSign;
        private ExpandableRelativeLayout expandableLayout;

        public MoreInfoViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            tvHead = itemView.findViewById(R.id.tvHead);
            tvBody = itemView.findViewById(R.id.tvBody);
            ivSign = itemView.findViewById(R.id.ivSign);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            //context.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

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

    public MoreInfoAdapter(Context context, ArrayList<MoreInfoItem> moreInfoItems) {
        this.alMoreInfoItems = moreInfoItems;
        this.context = context;
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

        holder.tvHead.setOnClickListener(view -> {
            if (!holder.expandableLayout.isExpanded()){
                holder.expandableLayout.expand();
                holder.ivSign.setBackgroundResource(R.drawable.ic_remove_24);
            }else {
                holder.expandableLayout.collapse();
                holder.ivSign.setBackgroundResource(R.drawable.ic_add_24);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alMoreInfoItems.size();
    }
}
