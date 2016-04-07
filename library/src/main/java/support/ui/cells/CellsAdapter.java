package support.ui.cells;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.carlosdelachica.easyrecycleradapters.adapter.debouncedlisteners.DebouncedOnClickListener;
import java.util.ArrayList;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class CellsAdapter extends RecyclerView.Adapter<CellViewHolder> {

  private final ArrayList<CellModel> mItems = new ArrayList<>();
  private final Context mContext;

  private EasyViewHolder.OnItemClickListener itemClickListener;

  public CellsAdapter(Context context) {
    mContext = context;
  }

  public void addAll(ArrayList<CellModel> items) {
    mItems.clear();
    mItems.addAll(items);
    notifyDataSetChanged();
  }

  @Override public int getItemViewType(int position) {
    CellModel model = getItem(position);
    return model.itemViewType;
  }

  @Override public CellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final Context context = mContext;
    CellViewHolder cellViewHolder = null;
    switch (viewType) {
      case CellModel.VIEW_TYPE_EMPTY: {
        cellViewHolder = new CellViewHolder(new EmptyCell(context));
        break;
      }
      case CellModel.VIEW_TYPE_HEADER: {
        cellViewHolder = new CellViewHolder(new HeaderCell(context)) {
          @Override protected void bindTo(CellModel model) {
            if (!TextUtils.isEmpty(model.text)) {
              ((HeaderCell)itemView).setText(model.text);
            }
          }
        };
        break;
      }
      case CellModel.VIEW_TYPE_SHADOW: {
        cellViewHolder = new CellViewHolder(new ShadowSectionCell(context));
        break;
      }
      case CellModel.VIEW_TYPE_TEXT:{
        cellViewHolder = new CellViewHolder(new TextCell(context)) {
          @Override protected void bindTo(CellModel model) {
            TextCell textCell = (TextCell) itemView;
            textCell.bindView(model.text, model.drawable, model.detail, null);
          }
        };
        break;
      }
    }

    bindListeners(cellViewHolder);
    return cellViewHolder;
  }

  @Override public void onBindViewHolder(CellViewHolder holder, int position) {
    final CellModel model = mItems.get(position);
    holder.bindView(model);
  }

  @Override public int getItemCount() {
    return mItems.size();
  }

  public void setOnItemClickListener(final EasyViewHolder.OnItemClickListener listener) {
    this.itemClickListener = new DebouncedOnClickListener() {
      @Override public boolean onDebouncedClick(View v, int position) {
        if (listener != null) {
          listener.onItemClick(position, v);
        }
        return true;
      }
    };
  }

  private void bindListeners(CellViewHolder viewHolder) {
    if (viewHolder != null) {
      viewHolder.setItemClickListener(itemClickListener);
    }
  }

  private CellModel getItem(int position) {
    return mItems.get(position);
  }
}
