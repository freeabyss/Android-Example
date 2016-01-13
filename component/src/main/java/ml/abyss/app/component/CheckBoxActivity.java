package ml.abyss.app.component;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        final CheckBox basketballCheckBox = (CheckBox) findViewById(R.id.checkbox_basketball);
        basketballCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String showMsg = "";
                if (isChecked) {
                    showMsg = buttonView.getText().toString()+"已被选中";
                }else {
                    showMsg = buttonView.getText().toString() + "已被取消";
                }
                Toast.makeText(CheckBoxActivity.this, showMsg, Toast.LENGTH_LONG).show();
            }
        });


    }
}
