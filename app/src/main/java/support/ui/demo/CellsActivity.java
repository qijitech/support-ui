package support.ui.demo;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import support.ui.adapters.EasyViewHolder;
import support.ui.app.SupportApp;
import support.ui.app.SupportCellsActivity;
import support.ui.cells.CellModel;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class CellsActivity extends SupportCellsActivity implements EasyViewHolder.OnItemClickListener {

  private final static int TAG_WIFI = 1;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getAdapter().bind(User.class, AccountHeader.class);
    addItem(new User());
    appendAll(buildData());
  }

  private ArrayList<CellModel> buildData() {
    ArrayList<CellModel> items = new ArrayList<>();
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
    return items;
  }

  @Override protected void onItemClick(Object o) {
    if (o instanceof CellModel) {
      switch (((CellModel)o).tag) {
        case TAG_WIFI:
          startActivity(new Intent(this, SettingsActivity.class));
          break;
      }
      return;
    }

  }
}
