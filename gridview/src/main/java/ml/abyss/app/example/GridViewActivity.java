package ml.abyss.app.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class GridViewActivity extends Activity {

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取gridview 实例
        mGridView = (GridView) findViewById(R.id.gridView);
        //设置适配器
        mGridView.setAdapter(new TextAdapter(getData()));

    }

    /**
     * 获取gridview数据
     * @return
     */
    private List<GridViewItemPojo> getData() {
        List<GridViewItemPojo> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            GridViewItemPojo pojo = new GridViewItemPojo();
            pojo.setTitle("Title" + i);
            list.add(pojo);
        }
        return list;
    }

    /**
     * 自定义适配器
     */
    private class TextAdapter extends ArrayAdapter<GridViewItemPojo> {
        public TextAdapter(List<GridViewItemPojo> itemPojoList) {
            super(GridViewActivity.this, 0, itemPojoList);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                // 获取子视图
                convertView = getLayoutInflater().inflate(R.layout.gridview_item, parent,false);
            }
            TextView titleTextView = (TextView) convertView.findViewById(R.id.grid_text_item);
            GridViewItemPojo pojo = getItem(position);
            titleTextView.setText(pojo.getTitle());
            return convertView;
        }
    }
}
