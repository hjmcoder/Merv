package com.hamedrahimvand.merv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MervAdapter extends RecyclerView.Adapter<MervAdapter.MervViewHolder> {
    private LinkedList<MervModel> mervModelLinkedList = new LinkedList<>();
    private MervClick.OnItemClickListener onItemClickListener;
    private MervConfig mervConfig= null;

    public MervAdapter(ArrayList<MervModel> mervModels, MervClick.OnItemClickListener onItemClickListener) {
        mervModelLinkedList.addAll(mervModels);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MervViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_merv, viewGroup, false);
        return new MervViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MervViewHolder mervViewHolder, int i) {
        mervViewHolder.bind(mervModelLinkedList.get(i));
    }

    @Override
    public int getItemCount() {
        return mervModelLinkedList.size();
    }

    class MervViewHolder extends RecyclerView.ViewHolder {
        ImageButton imbExpand;
        TextView txvName;
        LinearLayout lilParent;

        MervViewHolder(@NonNull View itemView) {
            super(itemView);
            imbExpand = itemView.findViewById(R.id.imb_expand);
            txvName = itemView.findViewById(R.id.txv_name);
            lilParent = itemView.findViewById(R.id.lil_parent);
        }

        void bind(final MervModel mervModel) {
            txvName.setText(mervModel.getName());
            if (mervModel.isHasChild()) {
                imbExpand.setVisibility(View.VISIBLE);
            } else {
                imbExpand.setVisibility(View.INVISIBLE);
            }
            imbExpand.setRotation(mervModel.getRotation());
            if (mervConfig!=null && mervConfig.getSideDrawable()!=null)imbExpand.setImageDrawable(mervConfig.getSideDrawable());
            if (mervConfig!=null && mervConfig.getTextColor()!=0)txvName.setTextColor(mervConfig.getTextColor());


            setListener(mervModel);
        }
        private void setListener(final MervModel mervModel){
            lilParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener==null)return;
                    onItemClickListener.OnItemClick(mervModel);
                }
            });
            imbExpand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mervModel.isHasChild()) {
                        int collapseRotation = 0;
                        int expandRotation = 90;
                        if (mervConfig!=null && mervConfig.getRotationCollapse()!=null){
                            collapseRotation = mervConfig.getRotationCollapse();
                        }
                        if (mervConfig!=null && mervConfig.getRotationExpand()!=null){
                            expandRotation = mervConfig.getRotationExpand();
                        }
                        if (mervModel.getChildList() == null)
                            throw new IllegalArgumentException("index " + getAdapterPosition() + ", child list is null. set child list or change setHasChild to false.");


                        if (mervModel.isOpen()) {
                            remove(mervModel, mervModel.getChildList());

                            mervModel.setRotation(collapseRotation);
                            imbExpand.setRotation(collapseRotation);
                        } else {
                            mervModel.setRotation(expandRotation);
                            imbExpand.setRotation(expandRotation);
                            mervModel.setOpen(true);
                            mervModelLinkedList.addAll(getAdapterPosition() + 1, mervModel.getChildList());
                            notifyItemRangeInserted(getAdapterPosition() + 1, mervModel.getChildList().size());
                        }
                    }
                }
            });
        }
        void remove(MervModel mervModel, List<MervModel> childs) {
            mervModel.setOpen(false);
            mervModel.setRotation(0);
            for (int i = 0; i < childs.size(); i++) {
                MervModel child = childs.get(i);
                if (child.getChildList() != null && child.getChildList().size() > 0 && child.isOpen()) {
                    remove(childs.get(i), childs.get(i).getChildList());
                }
                mervModelLinkedList.remove(getAdapterPosition() + 1);
            }
            notifyItemRangeRemoved(getAdapterPosition() + 1, childs.size());
        }
    }

    public void setMervConfig(MervConfig mervConfig) {
        this.mervConfig= mervConfig;
    }
}
