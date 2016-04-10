package support.ui.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import support.ui.content.ContentPresenter;
import support.ui.content.EmptyView;
import support.ui.content.ErrorView;
import support.ui.content.ReflectionContentPresenterFactory;
import support.ui.content.RequiresContent;

@RequiresContent public class ContentTestActivity extends AppCompatActivity
    implements EmptyView.OnEmptyViewClickListener, ErrorView.OnErrorViewClickListener {

  ReflectionContentPresenterFactory factory =
      ReflectionContentPresenterFactory.fromViewClass(getClass());
  ContentPresenter contentPresenter;

  @Bind(R.id.container) FrameLayout container;
  Fragment fragment;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_content_test);
    ButterKnife.bind(this);
    fragment = getSupportFragmentManager().findFragmentById(R.id.support_ui_content_view);
    contentPresenter = factory.createContentPresenter();
    contentPresenter.onCreate(this);
    contentPresenter.attachContainer(container);
    contentPresenter.attachContentView(fragment.getView());
    contentPresenter.setOnEmptyViewClickListener(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    contentPresenter.onDestroy();
    ButterKnife.unbind(this);
  }

  @OnClick({
      R.id.btn_load, R.id.btn_empty, R.id.btn_error, R.id.btn_content,
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_load:
        contentPresenter.displayLoadView();
        break;
      case R.id.btn_empty:
        //contentPresenter.buildEmptyImageView(R.drawable.support_ui_empty)
        //    .buildEmptyTitle(R.string.support_ui_empty_title_placeholder)
        //    .buildEmptySubtitle(R.string.support_ui_empty_subtitle_placeholder)
        //    .displayEmptyView();
        contentPresenter.displayEmptyView();
        break;
      case R.id.btn_content:
        contentPresenter.displayContentView();
        break;
      case R.id.btn_error:
        //contentPresenter.buildErrorImageView(R.drawable.support_ui_error_network)
        //    .buildErrorTitle(R.string.support_ui_error_title_placeholder)
        //    .buildErrorSubtitle(R.string.support_ui_error_subtitle_placeholder)
        //    .displayErrorView();
        contentPresenter.displayErrorView();
        break;
    }
  }

  @Override public void onEmptyViewClick(View view) {
    contentPresenter.displayLoadView();
  }

  @Override public void onErrorViewClick(View view) {
    contentPresenter.displayLoadView();
  }
}
