package support.ui.cells;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.carlosdelachica.easyrecycleradapters.adapter.debouncedlisteners.DebouncedOnClickListener;
import java.util.ArrayList;
import support.ui.R;

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

  public void addItem(CellModel cellModel) {
    mItems.add(cellModel);
    notifyItemChanged(mItems.size() -1);
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
      case CellModel.VIEW_TYPE_LOADING: {
        cellViewHolder = new CellViewHolder(new LoadingCell(context));
        break;
      }
      case CellModel.VIEW_TYPE_DIVIDER: {
        cellViewHolder = new CellViewHolder(new DividerCell(context));
        break;
      }
      case CellModel.VIEW_TYPE_EMPTY: {
        cellViewHolder = new CellViewHolder(new EmptyCell(context)) {
          @Override protected void bindTo(CellModel model) {
            if (model.cellHeight > 0) {
              ((EmptyCell)itemView).setHeight(model.cellHeight);
            }
          }
        };
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
        cellViewHolder = new CellViewHolder(new ShadowSectionCell(context)) {
          @Override protected void bindTo(CellModel model) {
            if (model.cellHeight > 0) {
              ((ShadowSectionCell)itemView).setSize(model.cellHeight);
            }
          }
        };
        break;
      }
      case CellModel.VIEW_TYPE_SHADOW_BOTTOM: {
        cellViewHolder = new CellViewHolder(new ShadowBottomSectionCell(context));
        break;
      }
      case CellModel.VIEW_TYPE_TEXT:{
        cellViewHolder = new CellViewHolder(new TextCell(context)) {
          @Override protected void bindTo(CellModel model) {
            TextCell textCell = (TextCell) itemView;
            textCell.bindView(model.text, model.drawable, model.value, model.valueDrawable, model.needDivider);
          }
        };
        break;
      }
      case CellModel.VIEW_TYPE_TEXT_INFO_PRIVACY:{
        cellViewHolder = new CellViewHolder(new TextInfoPrivacyCell(context)) {
          @Override protected void bindTo(CellModel model) {
            TextInfoPrivacyCell textCell = (TextInfoPrivacyCell) itemView;
            textCell.setText(model.text);
            if (model.isBottom) {
              textCell.setBackgroundResource(R.drawable.greydivider_bottom);
            } else {
              textCell.setBackgroundResource(R.drawable.greydivider);
            }
          }
        };
        break;
      }
      case CellModel.VIEW_TYPE_SETTINGS:{
        cellViewHolder = new CellViewHolder(new TextSettingsCell(context)) {
          @Override protected void bindTo(CellModel model) {
            TextSettingsCell cell = (TextSettingsCell) itemView;
            cell.bindView(model.text, model.drawable, model.value, model.needDivider);
          }
        };
        break;
      }
      case CellModel.VIEW_TYPE_DETAIL_SETTINGS:{
        cellViewHolder = new CellViewHolder(new TextDetailSettingsCell(context)) {
          @Override protected void bindTo(CellModel model) {
            TextDetailSettingsCell cell = (TextDetailSettingsCell) itemView;
            cell.setTextAndValue(model.text, model.detail, model.needDivider);
            cell.setMultilineDetail(model.multiline);
          }
        };
        break;
      }
      case CellModel.VIEW_TYPE_CHECK:{
        cellViewHolder = new CellViewHolder(new TextCheckCell(context)) {
          @Override protected void bindTo(CellModel model) {
            TextCheckCell cell = (TextCheckCell) itemView;
            cell.bindView(model.text, model.detail, model.checked, model.needDivider);
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

  public void clearAll() {
    mItems.clear();
  }

  public ArrayList<CellModel> getItems() {
    return mItems;
  }

  public CellModel getItem(int position) {
    return mItems.get(position);
  }
}
