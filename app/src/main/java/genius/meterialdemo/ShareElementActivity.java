package genius.meterialdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Hongsec on 2016-08-02.
 */
public class ShareElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.item_recyleritem);

        Bundle extras = getIntent().getExtras();
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                String value = extras.getString("value", "");
                ((TextView) findViewById(R.id.item_recycler_textview)).setText(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
