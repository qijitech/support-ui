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
  public static final int VIEW_TYPE_SETTINGS = 5;
  public static final int VIEW_TYPE_DETAIL_SETTINGS = 6;
  public static final int VIEW_TYPE_DIVIDER = 7;
  public static final int VIEW_TYPE_LOADING = 8;
  public static final int VIEW_TYPE_SHADOW_BOTTOM = 9;

  public boolean enabled;
  public boolean checked;
  public boolean needDivider;
  public boolean multiline;

  public int itemViewType;
  public int tag;
  public int cellHeight;

  public Drawable drawable;
  public Drawable valueDrawable;
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

  public static CellModel.Builder dividerCell() {
    return new CellModel.Builder(VIEW_TYPE_DIVIDER);
  }

  public static CellModel.Builder loadingCell() {
    return new CellModel.Builder(VIEW_TYPE_LOADING);
  }

  public static CellModel.Builder emptyCell() {
    return new CellModel.Builder(VIEW_TYPE_EMPTY);
  }

  public static CellModel.Builder emptyCell(int height) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_EMPTY);
    builder.cellHeight = height;
    return builder;
  }

  public static CellModel.Builder shadowBottomCell() {
    return new CellModel.Builder(VIEW_TYPE_SHADOW_BOTTOM);
  }

  public static CellModel.Builder shadowCell() {
    return new CellModel.Builder(VIEW_TYPE_SHADOW);
  }

  public static CellModel.Builder shadowCell(int height) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_SHADOW);
    builder.cellHeight = height;
    return builder;
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

  public static CellModel.Builder checkCell(String text, boolean checked) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_CHECK);
    builder.text = text;
    builder.checked = checked;
    builder.enabled = true;
    return builder;
  }

  public static CellModel.Builder settingCell(String text) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_SETTINGS);
    builder.text = text;
    builder.enabled = true;
    return builder;
  }

  public static CellModel.Builder detailSettingCell(String text, String detail) {
    CellModel.Builder builder = new CellModel.Builder(VIEW_TYPE_DETAIL_SETTINGS);
    builder.text = text;
    builder.detail = detail;
    builder.enabled = true;
    return builder;
  }

  public static class Builder {
    private boolean enabled;
    private boolean checked;
    private boolean needDivider;
    private boolean multiline;

    private int itemViewType;
    private int tag;
    private int cellHeight;

    private Drawable drawable;
    private Drawable valueDrawable;
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
      model.needDivider = needDivider;
      model.multiline = multiline;
      model.tag = tag;
      model.cellHeight = cellHeight;
      model.drawable = drawable;
      model.valueDrawable = valueDrawable;
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

    public Builder needDivider(boolean needDivider) {
      this.needDivider = needDivider;
      return this;
    }

    public Builder multiline(boolean multiline) {
      this.multiline = multiline;
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

    public Builder valueDrawable(Drawable drawable) {
      this.valueDrawable = drawable;
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
