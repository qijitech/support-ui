package support.ui.cells;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import support.ui.R;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class CellViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

  private CellModel model;

  private EasyViewHolder.OnItemClickListener itemClickListener;

  public CellViewHolder(View itemView) {
    super(itemView);
  }

  public void bindView(CellModel model) {
    this.model = model;
    if (model.enabled) {
      bindListeners();
      setBackground();
    }
    bindTo(model);
  }

  private void setBackground() {
    if (model.enabled) {
      if (itemView.getBackground() == null) {
        itemView.setBackgroundResource(R.drawable.list_selector);
      }
    } else {
      if (itemView.getBackground() != null) {
        itemView.setBackgroundDrawable(null);
      }
    }
  }

  private void bindListeners() {
    itemView.setOnClickListener(this);
  }

  protected void bindTo(CellModel model) {
  }

  @Override public void onClick(View v) {
    if (itemClickListener == null) return;
    itemClickListener.onItemClick(getAdapterPosition(), v);
  }

  public CellModel model() {
    return this.model;
  }

  public void setItemClickListener(EasyViewHolder.OnItemClickListener itemClickListener) {
    this.itemClickListener = itemClickListener;
  }
}
