package com.wangdong.www.a360ratingview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.wangdong.www.a360ratingview.Fragment.OneFragment;
import com.wangdong.www.a360ratingview.Fragment.ThreeFragment;
import com.wangdong.www.a360ratingview.Fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {
    private String spinnerTitle[]=new String[]{"Fragment1","Fragment2","Fragment3"};
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        ShowFragment(new OneFragment());
                        break;
                    case 1:
                        ShowFragment(new TwoFragment());
                        break;
                    case 2:
                        ShowFragment(new ThreeFragment());
                        break;
                }
            }
        });
    }
    private void ShowFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }

    private void initData() {
        spinner.setAdapter(new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,spinnerTitle));
    }

    private void initView() {
        spinner= (Spinner) findViewById(R.id.spinner);

    }
}
