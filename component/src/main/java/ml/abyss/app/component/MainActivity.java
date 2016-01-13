package ml.abyss.app.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AutoCompleteTextView 示例界面
        Button autoCompleteButton = (Button) findViewById(R.id.autoCompleteButton);
        autoCompleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AutoCompleteTextViewActivity.class);
                startActivity(i);
            }
        });
        // ToggleButton 示例界面
        Button toggleButton = (Button) findViewById(R.id.showToggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ToggleButtonActivity.class);
                startActivity(i);
            }
        });
        // CheckBox 示例界面
        Button checkBoxButton = (Button) findViewById(R.id.showCheckBoxButton);
        checkBoxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CheckBoxActivity.class);
                startActivity(i);
            }
        });
        //RadioGroup和RadioButton示例
        Button radioGroupButton = (Button) findViewById(R.id.showRadioButton);
        radioGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RadioButtonActivity.class);
                startActivity(i);
            }
        });
    }
}
