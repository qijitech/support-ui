package support.ui.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import java.util.ArrayList;
import support.ui.cells.CellModel;
import support.ui.cells.CellsAdapter;

/**
 * Created by YuGang Yang on 04 09, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public abstract class SupportCellsActivity extends AppCompatActivity
    implements EasyViewHolder.OnItemClickListener {

  private RecyclerView mRecyclerView;
  private CellsAdapter mAdapter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupRecyclerView();
    setupAdapter();
    setContentView(mRecyclerView);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mRecyclerView = null;
    mAdapter = null;
  }

  private void setupAdapter() {
    mAdapter = new CellsAdapter(this);
    mAdapter.setOnItemClickListener(this);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mAdapter);
  }

  private void setupRecyclerView() {
    mRecyclerView = new RecyclerView(this);
    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT);
    mRecyclerView.setLayoutParams(params);
  }

  @Override public void onItemClick(int position, View view) {
    onItemClick(mAdapter.getItem(position));
  }

  public RecyclerView getRecyclerView() {
    return mRecyclerView;
  }

  public ArrayList<CellModel> getItems() {
    return mAdapter.getItems();
  }

  public CellsAdapter getAdapter() {
    return mAdapter;
  }

  public void clearAll() {
    mAdapter.clearAll();
  }

  public void addItem(CellModel cellModel) {
    mAdapter.addItem(cellModel);
  }

  public void addAll(ArrayList<CellModel> items) {
    mAdapter.addAll(items);
  }

  protected abstract void onItemClick(CellModel cellModel);
}
