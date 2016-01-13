package ml.abyss.app.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        final TextView showTextView = (TextView) findViewById(R.id.showTextView);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             *
             * @param buttonView 控件本身
             * @param isChecked 控件状态
             */
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    showTextView.setText("按钮被打开了");
                } else {
                    showTextView.setText("按钮被关闭了");
                }
            }
        });
    }
}
