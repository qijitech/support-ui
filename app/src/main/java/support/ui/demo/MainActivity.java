package support.ui.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ButterKnife.unbind(this);
  }

  @OnClick({
      R.id.btn_cell,
      R.id.btn_content,
      R.id.btn_buttons
  }) public void onClick(View view) {
    switch (view.getId()) {
      case R.id.btn_cell:
        startActivity(new Intent(this, CellsActivity.class));
        break;
      case R.id.btn_content:
        startActivity(new Intent(this, ContentTestActivity.class));
        break;
      case R.id.btn_buttons:
        startActivity(new Intent(this, ButtonsActivity.class));
        break;
    }
  }

}
