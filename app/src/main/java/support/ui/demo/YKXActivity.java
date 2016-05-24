package support.ui.demo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Bind;
import java.util.ArrayList;
import support.ui.adapters.EasyRecyclerAdapter;
import support.ui.adapters.EasyViewHolder;
import support.ui.app.SupportActivity;
import support.ui.app.SupportApp;
import support.ui.cells.CellModel;
import support.ui.cells.CellsViewHolderFactory;

public class YKXActivity extends SupportActivity implements EasyViewHolder.OnItemClickListener {

  @Bind(android.R.id.list) RecyclerView mRecyclerView;
  private EasyRecyclerAdapter mAdapter;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setElevation(0);
    }
    setContentView(R.layout.activity_ykx);
    setupAdapter();
    setupRecyclerView();
    appendAll(buildData());
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    mRecyclerView = null;
    mAdapter = null;
  }

  private void setupAdapter() {
    mAdapter = new EasyRecyclerAdapter(this);
    mAdapter.viewHolderFactory(new CellsViewHolderFactory(this));
    mAdapter.setOnClickListener(this);
  }

  private void setupRecyclerView() {
    mRecyclerView.setHasFixedSize(true);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mAdapter);
  }

  @Override public void onItemClick(int position, View view) {
  }

  public void clearAll() {
    mAdapter.clear();
  }

  public void addItem(Object object) {
    mAdapter.add(object);
  }

  public void appendAll(ArrayList<CellModel> items) {
    mAdapter.appendAll(items);
  }

  public void addAll(ArrayList<CellModel> items) {
    mAdapter.addAll(items);
  }

  private ArrayList<CellModel> buildData() {
    ArrayList<CellModel> items = new ArrayList<>();
    final Resources r = SupportApp.appResources();
    items.add(CellModel.textCell(r.getString(R.string.ykx_notice))
        .drawable(SupportApp.drawable(R.drawable.ic_notice))
        .backgroundResource(R.drawable.list_selector_custom)
        .textColor(0xfff06e4c)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_location_start))
        .drawable(SupportApp.drawable(R.drawable.ic_location_start))
        .needDivider(true)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_location_end))
        .drawable(SupportApp.drawable(R.drawable.ic_location_end))
        .build());
    items.add(CellModel.emptyCell().build());

    items.add(CellModel.textHintCell(r.getString(R.string.ykx_time))
        .drawable(SupportApp.drawable(R.drawable.ic_time))
        .needDivider(true)
        .showArrowRight(true)
        .build());
    items.add(CellModel.textHintCell(r.getString(R.string.ykx_people))
        .drawable(SupportApp.drawable(R.drawable.ic_people))
        .showArrowRight(true)
        .build());
    items.add(CellModel.emptyCell().build());

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
    items.add(CellModel.emptyCell().build());

    items.add(CellModel.textCell(r.getString(R.string.ykx_thanks))
        .drawable(SupportApp.drawable(R.drawable.ic_thank))
        .needDivider(true)
        .showArrowRight(true)
        .build());
    items.add(CellModel.textCell(r.getString(R.string.ykx_trips))
        .drawable(SupportApp.drawable(R.drawable.ic_trips))
        .showArrowRight(true)
        .build());
    items.add(CellModel.shadowCell(30).build());
    return items;
  }
}
