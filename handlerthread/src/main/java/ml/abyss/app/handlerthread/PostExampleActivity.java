package ml.abyss.app.handlerthread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

/**
 * Handler post演示
 */
public class PostExampleActivity extends Activity {
    private Handler mHandler = new Handler();
    private TextView mUpdateTextView;
    private UpdateTextRunnable mUpdateTextRunnable = new UpdateTextRunnable();
    private int index = 0;

    private Handler mOtherHandler = new Handler();
    private TextView mOtherThreadUpdateTextView;
    private int otherIndex = 0;
    private UpdateTextOhterRunnable mUpdateTextOhterRunnable = new UpdateTextOhterRunnable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_example);

        mUpdateTextView = (TextView) findViewById(R.id.updateTextView);
        mOtherThreadUpdateTextView = (TextView) findViewById(R.id.otherThreadUpdateTextView);
        // 发送处理runnable，handler还可以在其他线程中使用post
        mHandler.postDelayed(mUpdateTextRunnable, 1 * 1000);
        //在另外一个线程中post runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                mOtherHandler.postDelayed(mUpdateTextOhterRunnable, 2 * 1000);
            }
        }).start();

    }

    private class UpdateTextRunnable implements Runnable {

        @Override
        public void run() {
            mUpdateTextView.setText("计时：" + index++);
            mHandler.postDelayed(mUpdateTextRunnable, 1 * 1000);
        }
    }

    private class UpdateTextOhterRunnable implements Runnable {

        @Override
        public void run() {
            mOtherThreadUpdateTextView.setText("其他线程：" + otherIndex++);
            mOtherHandler.postDelayed(mUpdateTextOhterRunnable, 2 * 1000);
        }
    }
}
