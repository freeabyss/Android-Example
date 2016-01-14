package ml.abyss.app.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * 创建一个可以交互的Fragment
 * Created by abyss on 14/01/2016.
 */
public class InteractionFragment extends Fragment {

    private OnInteractionListener mCallActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_interaction, container, false);
        Button addFragmentButton = (Button) v.findViewById(R.id.addFragmentButton);
        addFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallActivity != null) {
                    mCallActivity.addOtherFragment(R.id.addFragment);
                }
            }
        });
        Button showTextButton = (Button) v.findViewById(R.id.showTextOnOtherFragmentButton);
        showTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCallActivity != null) {
                    mCallActivity.showTextOnOtherFragment(R.id.addFragment, "接收到来自InteractionFragment的消息");
                }
            }
        });
        return v;
    }

    /**
     * Activity会自动调用该方法
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallActivity = (OnInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    /**
     * 回调接口，用于与父类Activity交互
     */
    public interface OnInteractionListener {
        /**
         * 添加指定的Fragment
         *
         * @param id
         */
        public void addOtherFragment(int id);

        /**
         * 在另一个Fragment中显示文字
         *
         * @param text
         */
        public void showTextOnOtherFragment(int id, String text);
    }
}
