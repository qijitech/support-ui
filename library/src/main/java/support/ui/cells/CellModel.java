package support.ui.cells;

import android.graphics.drawable.Drawable;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class CellModel {

  public static final int VIEW_TYPE_EMPTY = 0;
  public static final int VIEW_TYPE_HEADER = 1;
  public static final int VIEW_TYPE_CHECK = 2;
  public static final int VIEW_TYPE_TEXT = 3;
  public static final int VIEW_TYPE_SHADOW = 4;

  public boolean enabled;
  public boolean checked;
  public boolean divider;
  public boolean accessory;

  public int itemViewType;
  public int tag;

  public Drawable drawable;
  public String text;
  public String subtitle;
  public String detail;
  public Object data;

  private CellModel(int itemViewType) {
    this.itemViewType = itemViewType;
  }

  public static CellModel createModel(int itemViewType) {
    return new CellModel(itemViewType);
  }

  public static CellModel.Builder headCell(String text) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_HEADER);
    builder.text = text;
    builder.enabled = false;
    return builder;
  }

  public static CellModel.Builder textCell(String text) {
    return textCell(text, true);
  }

  public static CellModel.Builder textCell(String text, boolean enabled) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_TEXT);
    builder.text = text;
    builder.enabled = enabled;
    return builder;
  }

  public static class Builder {
    private boolean enabled;
    private boolean checked;
    private boolean divider;
    private boolean accessory;

    private int itemViewType;
    private int tag;

    private Drawable drawable;
    private String text;
    private String subtitle;
    private String detail;
    private Object data;

    public Builder(int itemViewType) {
      this.itemViewType = itemViewType;
    }

    public CellModel build() {
      CellModel model = new CellModel(itemViewType);
      model.enabled = enabled;
      model.checked = checked;
      model.divider = divider;
      model.accessory = accessory;
      model.tag = tag;
      model.drawable = drawable;
      model.text = text;
      model.subtitle = subtitle;
      model.detail = detail;
      model.data = data;
      return model;
    }

    public Builder enabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public Builder checked(boolean checked) {
      this.checked = checked;
      return this;
    }

    public Builder divider(boolean divider) {
      this.divider = divider;
      return this;
    }

    public Builder accessory(boolean accessory) {
      this.accessory = accessory;
      return this;
    }

    public Builder itemViewType(int itemViewType) {
      this.itemViewType = itemViewType;
      return this;
    }

    public Builder drawable(Drawable drawable) {
      this.drawable = drawable;
      return this;
    }

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder subtitle(String subtitle) {
      this.subtitle = subtitle;
      return this;
    }

    public Builder detail(String detail) {
      this.detail = detail;
      return this;
    }

    public Builder tag(int tag) {
      this.tag = tag;
      return this;
    }

    public Builder data(Object data) {
      this.data = data;
      return this;
    }
  }

}
