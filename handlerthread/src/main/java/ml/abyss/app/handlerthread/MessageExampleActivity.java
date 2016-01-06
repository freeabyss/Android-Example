package ml.abyss.app.handlerthread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

/**
 * Handler 使用Message
 */
public class MessageExampleActivity extends Activity {
    private Handler mHandler = new UpdateTextMessageHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_example);
        Looper.prepare();
        Looper.myLooper();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.arg1 = 100;
                msg.obj = "obj";
                mHandler.sendMessage(msg);
            }
        }).start();
    }

    /**
     * 继承Handler并重载handleMessage方法来接收消息
     */
    private class UpdateTextMessageHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "消息发来的参数：" + msg.arg1, Toast.LENGTH_SHORT).show();
        }
    }
}
