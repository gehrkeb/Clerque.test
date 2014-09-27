package target.shopping.clerque;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** Target API Key: J5PsS2XGuqCnkdQq0Let6RSfvU7oyPwF
 *  http://uhack.io/api/target/
 */

public class MainActivity extends Activity {
    private Button scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //scan = (Button)findViewById(R.id.scan);
//test
        ArrayList<String> items = new ArrayList<String>();
        items.add("Dr. Pepper");
        items.add("Mountain Dew");
        items.add("Pepsi");
        items.add("Coke");

        ListView lv = (ListView)findViewById(R.id.productList);

        StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        lv.setAdapter(adapter);
        // React to user clicks on item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                // We know the View is a TextView so we can cast it
                TextView clickedView = (TextView) view;
                Toast.makeText(MainActivity.this, "" + clickedView.getText() + "", Toast.LENGTH_SHORT).show();
              }
        });
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {
        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();
        public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
    }
}
