package support.ui.cells;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import support.ui.utilities.AndroidUtilities;
import support.ui.utilities.LayoutHelper;
import support.ui.utilities.LocaleController;

/**
 * Created by YuGang Yang on 04 07, 2016.
 * Copyright 2015-2016 qiji.tech. All rights reserved.
 */
public class TextCell extends FrameLayout {

  private TextView textView;
  private TextView valueTextView;
  private ImageView imageView;
  private ImageView valueImageView;

  public TextCell(Context context) {
    super(context);

    textView = new TextView(context);
    textView.setTextColor(0xff212121);
    textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
    textView.setLines(1);
    textView.setMaxLines(1);
    textView.setSingleLine(true);
    textView.setEllipsize(TextUtils.TruncateAt.END);
    textView.setGravity((LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.CENTER_VERTICAL);
    addView(textView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT, (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, LocaleController.isRTL ? 16 : 71, 0, LocaleController.isRTL ? 71 : 16, 0));

    valueTextView = new TextView(context);
    valueTextView.setTextColor(0xff2f8cc9);
    valueTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
    valueTextView.setLines(1);
    valueTextView.setMaxLines(1);
    valueTextView.setSingleLine(true);
    valueTextView.setGravity((LocaleController.isRTL ? Gravity.LEFT : Gravity.RIGHT) | Gravity.CENTER_VERTICAL);
    addView(valueTextView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.MATCH_PARENT, (LocaleController.isRTL ? Gravity.LEFT : Gravity.RIGHT) | Gravity.TOP, LocaleController.isRTL ? 24 : 0, 0, LocaleController.isRTL ? 0 : 24, 0));

    imageView = new ImageView(context);
    imageView.setScaleType(ImageView.ScaleType.CENTER);
    addView(imageView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, LocaleController.isRTL ? 0 : 16, 5, LocaleController.isRTL ? 16 : 0, 0));

    valueImageView = new ImageView(context);
    valueImageView.setScaleType(ImageView.ScaleType.CENTER);
    addView(valueImageView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, (LocaleController.isRTL ? Gravity.LEFT : Gravity.RIGHT) | Gravity.CENTER_VERTICAL, LocaleController.isRTL ? 24 : 0, 0, LocaleController.isRTL ? 0 : 24, 0));
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48), MeasureSpec.EXACTLY));
  }

  public void setTextColor(int color) {
    textView.setTextColor(color);
  }

  public void bindView(String text, Drawable iconDrawable, String value, Drawable valueDrawable) {
    textView.setText(text);
    boolean paddingSet = false;
    if (iconDrawable != null) {
      imageView.setImageDrawable(iconDrawable);
      imageView.setVisibility(VISIBLE);
      imageView.setPadding(0, AndroidUtilities.dp(7), 0, 0);
      paddingSet = true;
    } else {
      imageView.setVisibility(INVISIBLE);
    }
    if (!TextUtils.isEmpty(value)) {
      valueTextView.setText(value);
      valueTextView.setVisibility(VISIBLE);
    } else {
      valueTextView.setVisibility(INVISIBLE);
    }
    if (valueDrawable != null) {
      valueImageView.setImageDrawable(valueDrawable);
      valueImageView.setVisibility(VISIBLE);
      if (!paddingSet) {
        imageView.setPadding(0, AndroidUtilities.dp(7), 0, 0);
      }
    } else {
      valueImageView.setVisibility(INVISIBLE);
    }
  }

}
