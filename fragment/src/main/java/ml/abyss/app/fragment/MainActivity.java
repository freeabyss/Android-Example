package ml.abyss.app.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity implements InteractionFragment.OnInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();
        InteractionFragment interactionFragment = new InteractionFragment();
        FragmentManager fm = getFragmentManager();

        fm.beginTransaction()
                .add(R.id.firstFragment, firstFragment)
                .add(R.id.sencodFragment, secondFragment)
                .add(R.id.interactionFragment, interactionFragment)
                .commit();

    }

    /**
     * 在Fragment
     *
     * @param id Fragment标识
     */
    @Override
    public void addOtherFragment(int id) {
        if (getFragmentManager().findFragmentById(id) == null) {
            AddFragment addFragment = new AddFragment();
            getFragmentManager().beginTransaction()
                    .add(id, addFragment).commit();
        }

    }

    /**
     * 显示文本
     *
     * @param id   Fragment标识
     * @param text
     */
    @Override
    public void showTextOnOtherFragment(int id, String text) {
        AddFragment addFragment = (AddFragment) getFragmentManager().findFragmentById(id);
        addFragment.showText(text);
    }
}
