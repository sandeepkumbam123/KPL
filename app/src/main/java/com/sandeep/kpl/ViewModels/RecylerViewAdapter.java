package com.sandeep.kpl.ViewModels;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sandeep.kpl.R;
import com.sandeep.kpl.databinding.ViewDashboardBinding;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.RecyclerViewHolder>  {

    private static final int GROUP_TYPE = 1;
    private static final int MEMBER_TYPE =2;
    private ViewDashboardBinding mDataBinding;
    private NavigationViewModel.itemClick clickListener;

    public RecylerViewAdapter(NavigationViewModel.itemClick clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == MEMBER_TYPE) {
            mDataBinding = DataBindingUtil.bind((LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.view_dashboard,parent,
                    false)));
           return new RecyclerViewHolder(mDataBinding);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return MEMBER_TYPE;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.itemView.setViewModel(new NavigationViewModel(Utils.listofNavigationItems()[position],clickListener));
    }

    @Override
    public int getItemCount() {
        return Utils.listofNavigationItems().length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        private final ViewDashboardBinding itemView;
        public RecyclerViewHolder(ViewDashboardBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
        }
    }

}
