package com.wzh.fun.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.wzh.fun.R;
import com.wzh.fun.chat.fragment.CircleFragment;
import com.wzh.fun.ui.fragment.HomeFragment;
import com.wzh.fun.ui.fragment.ImageJokeFragment;
import com.wzh.fun.ui.fragment.PersonFragment;
import com.wzh.fun.ui.fragment.TextJokeFragment;
import com.wzh.fun.view.tab.BarEntity;
import com.wzh.fun.view.tab.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhihao.wen on 2016/11/4.
 */

public class MainActivity extends BaseActivity implements BottomTabBar.OnSelectListener{
    private BottomTabBar tb ;
    private List<BarEntity> bars ;
    private HomeFragment homeFragment ;
    private TextJokeFragment textJokeFragment ;
    private ImageJokeFragment imageJokeFragment ;
    private PersonFragment personFragment ;
    private CircleFragment circleFragment ;
    private FragmentManager manager ;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_tab_main);
        initView();
    }

    private void initView() {
        manager = getSupportFragmentManager();
        tb = (BottomTabBar) findViewById(R.id.tb);
        tb.setManager(manager);
        tb.setOnSelectListener(this);
        bars = new ArrayList<>();
        bars.add(new BarEntity("主页",R.drawable.main_active,R.drawable.main));
        bars.add(new BarEntity("地图",R.drawable.map_active,R.drawable.map));
        bars.add(new BarEntity("消息",R.drawable.message_active,R.drawable.message));
        bars.add(new BarEntity("圈子",R.drawable.cirtle_active,R.drawable.circle));
        bars.add(new BarEntity("个人",R.drawable.person_active,R.drawable.person));
        tb.setBars(bars);
    }

    @Override
    public void onSelect(int position) {
        switch (position){
            case 0:
                if (homeFragment==null){
                    homeFragment = new HomeFragment();
                }
                tb.switchContent(homeFragment);
                break;
            case 1:
                if (textJokeFragment==null){
                    textJokeFragment = new TextJokeFragment();
                }
                tb.switchContent(textJokeFragment);
                break;
            case 2:
                if (imageJokeFragment==null){
                    imageJokeFragment = new ImageJokeFragment();
                }
                tb.switchContent(imageJokeFragment);
                break;
            case 3:
                if (circleFragment==null){
                    circleFragment = new CircleFragment();
                }
                tb.switchContent(circleFragment);
                break;
            case 4:
                if (personFragment==null){
                    personFragment = new PersonFragment();
                }
                tb.switchContent(personFragment);
                break;
            default:
                break;
        }
    }

}
