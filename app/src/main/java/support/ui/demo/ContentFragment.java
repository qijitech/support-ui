package support.ui.demo;

import android.content.res.Resources;
import java.util.ArrayList;
import support.ui.app.SupportApp;
import support.ui.app.SupportCellsFragment;
import support.ui.cells.CellModel;

/**
 * Created by YuGang Yang on 04 10, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class ContentFragment extends SupportCellsFragment {

  @Override public void onResume() {
    super.onResume();
    clearAll();
    buildData();
  }

  @Override protected void onItemClick(CellModel cellModel) {

  }

  private ArrayList<CellModel> buildData() {
    ArrayList<CellModel> items = new ArrayList<>();
    final Resources r = SupportApp.appResources();
    items.add(CellModel.emptyCell().build());
    items.add(CellModel.headCell(r.getString(R.string.settings_header_wifi)).build());
    items.add(CellModel.textCell(r.getString(R.string.settings_wifi))
        .drawable(SupportApp.drawable(R.drawable.ic_settings_wifi))
        .needDivider(true)
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


}
