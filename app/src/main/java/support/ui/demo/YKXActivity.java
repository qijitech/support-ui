package support.ui.demo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import support.ui.app.SupportApp;
import support.ui.app.SupportCellsActivity;
import support.ui.cells.CellModel;

public class YKXActivity extends SupportCellsActivity {

  private final static int TAG_WIFI = 1;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    appendAll(buildData());
  }

  private ArrayList<CellModel> buildData() {
    ArrayList<CellModel> items = new ArrayList<>();
    final Resources r = SupportApp.appResources();
    items.add(CellModel.emptyCell(40).build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_notice))
        .drawable(SupportApp.drawable(R.drawable.ic_notice))
        .backgroundResource(R.drawable.list_selector_custom)
        .textColor(0xfff06e4c)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_location_start))
        .drawable(SupportApp.drawable(R.drawable.ic_location_start))
        .needDivider(true)
        .tag(TAG_WIFI)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_location_end))
        .drawable(SupportApp.drawable(R.drawable.ic_location_end))
        .build());
    items.add(CellModel.emptyCell(40).build());

    items.add(CellModel.textHintCell(r.getString(R.string.ykx_time))
        .drawable(SupportApp.drawable(R.drawable.ic_time))
        .needDivider(true)
        .showArrowRight(true)
        .build());
    items.add(CellModel.textHintCell(r.getString(R.string.ykx_people))
        .drawable(SupportApp.drawable(R.drawable.ic_people))
        .showArrowRight(true)
        .build());
    items.add(CellModel.emptyCell(40).build());

    items.add(CellModel.textHintCell(r.getString(R.string.ykx_flight))
        .drawable(SupportApp.drawable(R.drawable.ic_flight))
        .showArrowRight(true)
        .needDivider(true)
        .build());
    items.add(CellModel.textHintCell(r.getString(R.string.ykx_phone))
        .drawable(SupportApp.drawable(R.drawable.ic_phone))
        .showArrowRight(true)
        .value(r.getString(R.string.ykx_phone_other))
        .build());
    items.add(CellModel.emptyCell(40).build());

    items.add(CellModel.textCell(r.getString(R.string.ykx_thanks))
        .drawable(SupportApp.drawable(R.drawable.ic_thank))
        .needDivider(true)
        .showArrowRight(true)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_trips))
        .drawable(SupportApp.drawable(R.drawable.ic_trips))
        .showArrowRight(true)
        .build());
    items.add(CellModel.shadowBottomCell().build());
    return items;
  }

  @Override protected void onItemClick(Object o) {
    if (o instanceof CellModel) {
      return;
    }

  }
}
