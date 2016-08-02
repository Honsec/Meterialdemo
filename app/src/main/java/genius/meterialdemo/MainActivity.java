package genius.meterialdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Slide());
            getWindow().setAllowEnterTransitionOverlap(true);//要想尽快进行transitions过渡，可在Activity中调用
//            Window.setEnterTransition()
//            Window.setExitTransition()
//            Window.setSharedElementEnterTransition()
//            Window.setSharedElementExitTransition()
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void recycler(View v){

        Intent intent = new Intent(this,RecyclerActivity.class);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
            }else{
                startActivity(intent);
            }

    }
    public void cardviewclick(View v){

        Intent intent = new Intent(this,CardViewActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }else{
            startActivity(intent);
        }
    }
}
