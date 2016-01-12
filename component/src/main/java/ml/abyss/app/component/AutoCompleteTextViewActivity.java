package ml.abyss.app.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;

/**
 * AutoCompleteTextView 和Mu控件示例
 */
public class AutoCompleteTextViewActivity extends AppCompatActivity {

    private AutoCompleteTextView mAutoCompleteTextView;
    private MultiAutoCompleteTextView mMultiAutoCompleteTextView;
    private String[] mAutoResArray = {"advantage", "advice", "annotation",
            "appear", "aspect", "associated", "async", "asynchronous"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autoconpletetextview);
        // 添加一个适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mAutoResArray);
        // AutoCompleteTextView 示例
        mAutoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.acTextView);
        mAutoCompleteTextView.setAdapter(adapter);

        // MultiAutoCompleteTextView 示例
        mMultiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.macTextView);
        mMultiAutoCompleteTextView.setAdapter(adapter);
        mMultiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        // 设置返回按钮
        Button returnButton = (Button) findViewById(R.id.autoCompleteReturnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
