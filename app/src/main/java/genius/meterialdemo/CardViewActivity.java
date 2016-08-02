package genius.meterialdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import genius.rv.ViewHolder;
import genius.rv.adapter.CommonAdapter;

/**
 * Created by Hongsec on 2016-08-02.
 */
public class CardViewActivity  extends AppCompatActivity{
    private RecyclerView mRecyclerView;

    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //RecyclerView Demo

//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_cardview);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setEnterTransition(new Slide());
//            getWindow().setAllowEnterTransitionOverlap(true);//要想尽快进行transitions过渡，可在Activity中调用
//            Window.setEnterTransition()
//            Window.setExitTransition()
//            Window.setSharedElementEnterTransition()
//            Window.setSharedElementExitTransition()
//        }





        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(true); //固定size 优化性能

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i=0;i<10;i++){
            char a = (char) ('a'+i);
            mDatas.add(a+"");
        }


        mRecyclerView.setAdapter(new CommonAdapter<String>(this,R.layout.item_cardview,mDatas){

            @Override
            public void convert(ViewHolder holder, int position, String s) {

                holder.setText(R.id.item_cardview_txt,position+":"+s);

            }
        });

    }
}
