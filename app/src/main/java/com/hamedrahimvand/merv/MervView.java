package com.hamedrahimvand.merv;


import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class MervView extends LinearLayout {
    private RecyclerView mervRecyclerView;
    private LinearLayoutManager layoutManager;
    private MervAdapter mervAdapter;

    public MervView(Context context) {
        super(context);
        inflate(context, R.layout.merv, this);

        initialize();
    }

    public MervView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.merv, this);
        initialize();
    }

    public MervView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.merv, this);
        initialize();
    }

    private void initialize() {
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mervRecyclerView = findViewById(R.id.rcv_merv);
        mervRecyclerView.setLayoutManager(layoutManager);
    }

    /**
     * <p>Use this for set MervAdapter to MervRecyclerView</p>
     */
    public void setMervAdapter(MervAdapter mervAdapter) {
        this.mervAdapter = mervAdapter;
        mervRecyclerView.setAdapter(mervAdapter);
    }

    public RecyclerView getMervRecyclerView() {
        return mervRecyclerView;
    }


}
