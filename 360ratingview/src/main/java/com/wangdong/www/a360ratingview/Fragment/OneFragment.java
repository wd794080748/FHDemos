package com.wangdong.www.a360ratingview.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangdong.www.a360ratingview.R;

public class OneFragment extends Fragment {
    private View view=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view==null){
            view=inflater.inflate(R.layout.fragment_one,null);
        }
        return view;
    }

}
