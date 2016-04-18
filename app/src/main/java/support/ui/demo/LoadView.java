package support.ui.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by YuGang Yang on 04 18, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class LoadView extends FrameLayout {

  public LoadView(Context context) {
    super(context);
    initialize(context);
  }

  private void initialize(Context context) {
    View view = LayoutInflater.from(context).inflate(R.layout.view_loading, this, false);
    addView(view);
  }
}
