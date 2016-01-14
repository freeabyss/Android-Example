package ml.abyss.app.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by abyss on 14/01/2016.
 */
public class AddFragment extends Fragment {
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        mTextView = (TextView) v.findViewById(R.id.showTextView);
        return v;
    }

    public void showText(String text) {
        mTextView.setText(text);
    }
}
