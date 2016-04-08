package support.ui.cells;

import android.content.Context;
import support.ui.R;
import support.ui.utilities.ThemeCompat;

/**
 * Created by YuGang Yang on 04 08, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public final class CellUtils {
  private CellUtils() {

  }

  public static int getTextColor(Context context) {
    return ThemeCompat.getThemeAttrColor(context, R.attr.cellTextColor, 0xff333333);
  }

  public static int getHeaderColor(Context context) {
    return ThemeCompat.getThemeAttrColor(context, R.attr.cellHeaderColor, 0xff159588);
  }

  public static int getDetailColor(Context context) {
    return ThemeCompat.getThemeAttrColor(context, R.attr.cellDetailColor, 0xff159588);
  }

  public static int getValueColor(Context context) {
    return ThemeCompat.getThemeAttrColor(context, R.attr.cellValueColor, 0xff159588);
  }

  public static int getDividerColor(Context context) {
    return ThemeCompat.getThemeAttrColor(context, R.attr.cellDividerColor, 0xffd9d9d9);
  }
}
