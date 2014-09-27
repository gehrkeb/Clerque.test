package target.shopping.clerque;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private Button scan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scan = (Button)findViewById(R.id.scan);
//test
        ArrayList<String> items = new ArrayList<String>();
        items.add(0,"Dr. Pepper");
        items.add(1,"Mountain Dew");
        items.add(2,"Pepsi");
        items.add(3,"Coke");
    }


}
