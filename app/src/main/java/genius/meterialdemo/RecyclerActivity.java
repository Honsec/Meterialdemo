package genius.meterialdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Pair;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;

import genius.rv.ViewHolder;
import genius.rv.adapter.CommonAdapter;

/**
 * Created by Hongsec on 2016-08-02.
 */
public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //RecyclerView Demo

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
            getWindow().setAllowEnterTransitionOverlap(true);//要想尽快进行transitions过渡，可在Activity中调用
//            Window.setEnterTransition()
//            Window.setExitTransition()
//            Window.setSharedElementEnterTransition()
//            Window.setSharedElementExitTransition()
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);





         mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        mRecyclerView.setHasFixedSize(true); //固定size 优化性能

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i=0;i<10;i++){
            char a = (char) ('a'+i);
            mDatas.add(a+"");
        }


        mRecyclerView.setAdapter(new CommonAdapter<String>(this,R.layout.item_recyleritem,mDatas){

            @Override
            public void convert(final ViewHolder holder, final int position, final String s) {

                holder.setText(R.id.item_recycler_textview,position+":"+s);
                holder.getView(R.id.item_recycler_textview).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent  = new Intent(RecyclerActivity.this,ShareElementActivity.class);
                        intent.putExtra("value",position+":"+s);
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                                ActivityOptions activityOptions = null;
                                activityOptions = ActivityOptions.makeSceneTransitionAnimation(RecyclerActivity.this, Pair.create(holder.getView(R.id.item_recycler_textview),"txt"),Pair.create(holder.getView(R.id.item_recycler_image),"img"));
                                startActivity(intent,activityOptions.toBundle());
                            }else{
                                startActivity(intent);
                            }

                    }
                });
            }
        });

    }
}
