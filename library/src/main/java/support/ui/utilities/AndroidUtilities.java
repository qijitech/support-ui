package support.ui.utilities;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Hashtable;
import support.ui.app.SupportApp;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public final class AndroidUtilities {

  public static float density = 1;
  private static final Hashtable<String, Typeface> typefaceCache = new Hashtable<>();
  public static DisplayMetrics displayMetrics = new DisplayMetrics();
  public static Point displaySize = new Point();

  static {
    density = SupportApp.appResources().getDisplayMetrics().density;
    checkDisplaySize();
  }

  public static void checkDisplaySize() {
    try {
      Display[] displays = DisplayManagerCompat.getInstance(SupportApp.appContext()).getDisplays();
      if (displays != null) {
        if (displays.length == 1) {
          Display display = displays[0];
          display.getMetrics(displayMetrics);
          if (android.os.Build.VERSION.SDK_INT < 13) {
            displaySize.set(display.getWidth(), display.getHeight());
          } else {
            display.getSize(displaySize);
          }
          FileLog.e("tmessages", "display size = " + displaySize.x + " " + displaySize.y + " " + displayMetrics.xdpi + "x" + displayMetrics.ydpi);
        }
      }
    } catch (Exception e) {
      FileLog.e("tmessages", e);
    }
  }

  public static int dp(float value) {
    if (value == 0) {
      return 0;
    }
    return (int) Math.ceil(density * value);
  }

  public static float dpf2(float value) {
    if (value == 0) {
      return 0;
    }
    return density * value;
  }

  public static Typeface getTypeface(String assetPath) {
    synchronized (typefaceCache) {
      if (!typefaceCache.containsKey(assetPath)) {
        try {
          Typeface t = Typeface.createFromAsset(SupportApp.appContext().getAssets(), assetPath);
          typefaceCache.put(assetPath, t);
        } catch (Exception e) {
          FileLog.e("Typefaces", "Could not get typeface '" + assetPath + "' because " + e.getMessage());
          return null;
        }
      }
      return typefaceCache.get(assetPath);
    }
  }

  public static void showKeyboard(View view) {
    if (view == null) {
      return;
    }
    InputMethodManager inputManager = (InputMethodManager)view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    inputManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
  }

  public static boolean isKeyboardShowed(View view) {
    if (view == null) {
      return false;
    }
    InputMethodManager inputManager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    return inputManager.isActive(view);
  }

  public static void hideKeyboard(View view) {
    if (view == null) {
      return;
    }
    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
    if (!imm.isActive()) {
      return;
    }
    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }
}
