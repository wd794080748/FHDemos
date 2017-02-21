package com.wangdong.www.a360ratingview.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangdong.www.a360ratingview.R;


public class ThreeFragment extends Fragment {
   private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(contentView==null){
            contentView=inflater.inflate(R.layout.fragment_three,null);
        }
        return contentView;
    }

}
