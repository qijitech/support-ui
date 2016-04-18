package support.ui.demo;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import support.ui.adapters.EasyViewHolder;
import support.ui.cells.CellModel;

/**
 * Created by YuGang Yang on 04 18, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class AccountHeader extends EasyViewHolder<User> {

  public AccountHeader(Context context, ViewGroup parent) {
    super(context, parent, R.layout.list_item_account_header);
    ButterKnife.bind(this, itemView);
  }

  @Override public void bindTo(int position, User value) {

  }
}
