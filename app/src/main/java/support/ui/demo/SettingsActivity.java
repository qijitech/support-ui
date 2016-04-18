package support.ui.demo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import support.ui.app.SupportCellsActivity;
import support.ui.cells.CellModel;

/**
 * Created by YuGang Yang on 04 09, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class SettingsActivity extends SupportCellsActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addAll(buildCellData());
  }

  private ArrayList<CellModel> buildCellData() {
    ArrayList<CellModel> items = new ArrayList<>();
    Resources r = getResources();
    items.add(CellModel.emptyCell().build());
    items.add(CellModel.settingCell(getString(R.string.settings_notifications))
        .value(r.getString(R.string.settings_notifications_on)).build());
    items.add(CellModel.shadowCell().build());
    items.add(CellModel.checkCell(getString(R.string.settings_show_preview_text))
        .checked(true)
        .build());
    items.add(CellModel.infoPrivacyCell(r.getString(R.string.settings_show_preview_text_info)).build());

    items.add(CellModel.checkCell(getString(R.string.settings_alerts))
        .checked(true)
        .build());
    items.add(CellModel.infoPrivacyCell(getString(R.string.settings_alerts_info)).build());

    items.add(CellModel.checkCell(getString(R.string.settings_sounds))
        .needDivider(true)
        .build());
    items.add(CellModel.checkCell(getString(R.string.settings_vibrate))
        .checked(true)
        .build());
    items.add(CellModel.infoPrivacyCell(getString(R.string.settings_vibrate_info)).build());
    items.add(CellModel.checkCell(getString(R.string.settings_moments_updates))
        .checked(true)
        .build());
    items.add(CellModel.infoPrivacyCell(getString(R.string.settings_moments_updates_info))
        .bottom(true)
        .build());
    return items;
  }

  @Override protected void onItemClick(Object object) {

  }
}
