package genius.meterialdemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hongsec on 2016-08-08.
 */
public class FragShareElement extends Fragment {

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          inflate = inflater.inflate(R.layout.item_recyleritem2, null, false);

//        Bundle extras = getArguments();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
//            String value = extras.getString("txt_tran", "");
//            String value2 = extras.getString("image_tran", "");
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                inflate.findViewById(R.id.item_recycler_textview2).setTransitionName(value);
//                inflate.findViewById(R.id.item_recycler_image).setTransitionName(value2);
//            }
//        }

        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle extras = getArguments();
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
                String value = extras.getString("value", "");
                ((TextView) inflate.findViewById(R.id.item_recycler_textview2)).setText(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
