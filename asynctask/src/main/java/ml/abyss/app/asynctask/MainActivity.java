package ml.abyss.app.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView showResultTextView = (TextView) findViewById(R.id.showResultTextView);
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button  startAsyncButton = (Button) findViewById(R.id.startAsyncButton);
        startAsyncButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ProgressAsyncTask(showResultTextView,progressBar).execute(15);
            }
        });
    }
}
