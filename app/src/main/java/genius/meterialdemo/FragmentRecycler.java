package genius.meterialdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import genius.rv.ViewHolder;
import genius.rv.adapter.CommonAdapter;

/**
 * Created by Hongsec on 2016-08-08.
 */
public class FragmentRecycler extends Fragment {

    private View inflate;
    private RecyclerView recyclerview;
    private ArrayList<String> mDatas = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         recyclerview =  (RecyclerView) inflate.findViewById(R.id.recyclerview);

        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        for(int i=0;i<10;i++){
            char a = (char) ('a'+i);
            mDatas.add(a+"");
        }


        recyclerview.setAdapter(new CommonAdapter<String>(getActivity(),R.layout.item_recyleritem,mDatas){
            @Override
            public void convert(final ViewHolder holder, final int position, final String s) {

                holder.setText(R.id.item_recycler_textview,position+":"+s);
                holder.getView(R.id.item_recycler_textview).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        FragShareElement fragShareElement = new FragShareElement();
                        Bundle bundle = new Bundle();
                        bundle.putString("value",position+":"+s);


                        fragmentTransaction.addToBackStack(null);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            ViewCompat.setTransitionName( holder.getView(R.id.item_recycler_textview),position+"_txt");
                            ViewCompat.setTransitionName( holder.getView(R.id.item_recycler_image),position+"_img");
                            fragmentTransaction.addSharedElement(holder.getView(R.id.item_recycler_textview),"txt");
                            fragmentTransaction.addSharedElement(holder.getView(R.id.item_recycler_image),"img");


                            setSharedElementReturnTransition(new DefaultTransaction());
                            setExitTransition(new Fade());
//                            setSharedElementEnterTransition(new DefaultTransaction());
//                            fragShareElement.setSharedElementReturnTransition(new DefaultTransaction());
                            fragShareElement.setSharedElementEnterTransition(new DefaultTransaction());
                            fragShareElement.setEnterTransition(new Fade());

                        }
                        fragShareElement.setArguments(bundle);
                        fragmentTransaction.replace(R.id.activity_recycler_frag_content,fragShareElement,FragShareElement.class.getSimpleName()).commitAllowingStateLoss();

                    }
                });

            }
        });


    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private class DefaultTransaction extends TransitionSet{


        public DefaultTransaction() {
            init();
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public DefaultTransaction(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            setOrdering(ORDERING_SEQUENTIAL);
//            addTransition(new ChangeBounds());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                addTransition(new ChangeTransform());
//                addTransition(new ChangeImageTransform());
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          inflate = inflater.inflate(R.layout.fragment_recycler, null, false);
        return inflate;
    }



}
