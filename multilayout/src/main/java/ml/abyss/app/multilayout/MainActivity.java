package ml.abyss.app.multilayout;

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

        // linearlayout布局示例
        Button linearButton = (Button) findViewById(R.id.showLinearLayoutButton);
        linearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LinearLayourActivity.class);
                startActivity(i);
            }
        });
        // RelativeLayout示例
        Button relativeButton = (Button) findViewById(R.id.showRelativeLayoutButton);
        relativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(i);
            }
        });
        // FrameLayout 示例
        Button frameButton = (Button) findViewById(R.id.showFrameLayoutButton);
        frameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FrameLayoutActivity.class);
                startActivity(i);
            }
        });


    }
}
