package ml.abyss.app.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        RadioGroup sexRadioGroup = (RadioGroup) findViewById(R.id.sexRadioGroup);
        sexRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String showMsg = "";
                switch (checkedId) {
                    case R.id.manRadio:
                        showMsg = "男";
                        break;
                    case R.id.womanRadio:
                        showMsg = "女";
                        break;
                    default:
                        showMsg = "未选中性别";
                        break;
                }
                Toast.makeText(RadioButtonActivity.this, "你是" + showMsg + "性", Toast.LENGTH_LONG).show();
            }
        });
    }
}
