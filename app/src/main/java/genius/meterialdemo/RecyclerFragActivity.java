package genius.meterialdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

/**
 * Created by Hongsec on 2016-08-02.
 */
public class RecyclerFragActivity extends AppCompatActivity {

    private FrameLayout activity_recycler_frag_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_frag);
        activity_recycler_frag_content = (FrameLayout) findViewById(R.id.activity_recycler_frag_content);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentRecycler fragmentRecycler  = new FragmentRecycler();
        fragmentTransaction.replace(R.id.activity_recycler_frag_content,fragmentRecycler,FragmentRecycler.class.getSimpleName()).commitAllowingStateLoss();

//        ft.addToBackStack(tag);
//        ft.add(R.id.act_main_content, fragment, tag).commitAllowingStateLoss();

//        getFragmentManager().popBackStackImmediate();

    }
}
