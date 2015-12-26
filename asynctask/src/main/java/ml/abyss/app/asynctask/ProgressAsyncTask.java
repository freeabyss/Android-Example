package ml.abyss.app.asynctask;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 异步加载程序
 * Created by abyss on 26/12/2015.
 */
public class ProgressAsyncTask extends AsyncTask<Integer, Integer, String> {
    private TextView mShowResultTextView;
    private ProgressBar mProgressBar;

    public ProgressAsyncTask(TextView textView, ProgressBar progressBar) {
        mShowResultTextView = textView;
        mProgressBar = progressBar;
    }

    /**
     * 后台处理
     *
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(Integer... params) {
        BackgroundOperator backgroundOperator = new BackgroundOperator();
        int count = params[0];
        for (int i = 0; i < count; i++) {
            backgroundOperator.backgroundProgress(1000);
            publishProgress((int) (i / (float) count) * 100);

            if (isCancelled()) {
                break;
            }
        }
        return params[0].toString();
    }

    /**
     * 用来更新进度条，此函数在UI线程中被调用
     *
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        mProgressBar.setProgress(value);
    }

    /**
     * 处理后台任务前的函数调用，该函数在UI线程中被调用
     */
    @Override
    protected void onPreExecute() {
        mShowResultTextView.setText("开始异步线程");
    }


    /**
     * 处理完毕后的函数调用，该函数在UI线程中被调用，在该函数中可以访问UI
     *
     * @param s
     */
    @Override
    protected void onPostExecute(String s) {
        mShowResultTextView.setText("异步线程结束:" + s);
    }

}
