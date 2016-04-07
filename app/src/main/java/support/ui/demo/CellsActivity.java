package support.ui.demo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import java.util.ArrayList;
import support.ui.app.SupportApp;
import support.ui.cells.CellModel;
import support.ui.cells.CellsAdapter;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class CellsActivity extends AppCompatActivity implements EasyViewHolder.OnItemClickListener {

  private CellsAdapter mAdapter;
  ArrayList<CellModel> items = new ArrayList<>();

  @Bind(android.R.id.list) RecyclerView mRecyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cells);
    ButterKnife.bind(this);
    setupRecyclerView();
    buildData();
  }

  private void setupRecyclerView() {
    mAdapter = new CellsAdapter(this);
    mAdapter.setOnItemClickListener(this);
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mAdapter);
  }

  private void buildData() {
    final Resources r = SupportApp.appResources();
    items.add(CellModel.headCell("其他").build());

    items.add(CellModel.textCell(r.getString(R.string.account_publish))
        .drawable(SupportApp.drawable(R.drawable.ic_account_publish))
        .build());
    items.add(CellModel.textCell(r.getString(R.string.account_classes))
        .drawable(SupportApp.drawable(R.drawable.ic_account_class))
        .build());

    items.add(CellModel.textCell(r.getString(R.string.account_collection))
        .drawable(SupportApp.drawable(R.drawable.ic_account_collection))
        .detail("3")
        .build());
    items.add(CellModel.textCell(r.getString(R.string.account_download))
        .drawable(SupportApp.drawable(R.drawable.ic_account_downloads))
        .build());

    items.add(CellModel.textCell(r.getString(R.string.account_settings))
        .drawable(SupportApp.drawable(R.drawable.ic_account_setting))
        .build());
    mAdapter.addAll(items);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }

  @Override public void onItemClick(int position, View view) {

  }
}
