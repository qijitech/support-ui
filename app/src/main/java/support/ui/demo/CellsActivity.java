package support.ui.demo;

import android.content.Intent;
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

  private final static int TAG_WIFI = 1;

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
    items.add(CellModel.emptyCell().build());
    items.add(CellModel.headCell(r.getString(R.string.settings_header_wifi)).build());
    items.add(CellModel.textCell(r.getString(R.string.settings_wifi))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_wifi))
        .needDivider(true)
        .tag(TAG_WIFI)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.settings_bluetooth))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_bluetooth))
        .needDivider(true)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.settings_more))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_more))
        .build());
    items.add(CellModel.shadowCell().build());

    items.add(CellModel.headCell(r.getString(R.string.settings_header_device)).build());
    items.add(CellModel.textCell(r.getString(R.string.settings_battery))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_battery))
        .build());
    items.add(CellModel.shadowCell().build());

    items.add(CellModel.headCell(r.getString(R.string.settings_header_account)).build());
    items.add(CellModel.textCell(r.getString(R.string.settings_location))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_location))
        .needDivider(true)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.settings_account))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_account))
        .build());
    items.add(CellModel.shadowCell().build());

    items.add(CellModel.headCell(r.getString(R.string.settings_header_system)).build());
    items.add(CellModel.textCell(r.getString(R.string.settings_time))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_time))
        .needDivider(true)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.settings_print))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_print))
        .build());
    items.add(CellModel.shadowBottomCell().build());

    mAdapter.addAll(items);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }

  @Override public void onItemClick(int position, View view) {
    CellModel cellModel = items.get(position);
    switch (cellModel.tag) {
      case TAG_WIFI:
        startActivity(new Intent(this, SettingsActivity.class));
        break;
    }
  }
}
