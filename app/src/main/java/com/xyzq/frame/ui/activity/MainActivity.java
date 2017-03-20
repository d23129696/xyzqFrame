package com.xyzq.frame.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.xyzq.frame.R;
import com.xyzq.frame.ui.fragment.FourthFragment;
import com.xyzq.frame.ui.fragment.HomeFragment;
import com.xyzq.frame.ui.fragment.SecondFragment;
import com.xyzq.frame.ui.fragment.ThirdFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @InjectView(R.id.main_fragment_container)
    FrameLayout mainFragmentContainer;
    @InjectView(R.id.main_bottome_switcher_container)
    LinearLayout mainBottomeSwitcherContainer;
    private ArrayList<Fragment> arraylistFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        //1.根据底部四个选项卡,切换顶部指向帧布局的4个fragment,准备四个fragment
        initFragment();
        //2.初始化底部选项卡的点击事件
        initClick();
        //3.初始化时显示首页
        View firstView = mainBottomeSwitcherContainer.getChildAt(0);
        onClick(firstView);
    }

    /**
     * 给底部四个按钮设置点击事件
     */
    private void initClick() {
        int childCount = mainBottomeSwitcherContainer.getChildCount();
        for (int i = 0; i < childCount; i++) {
//            找到线性布局中的帧布局
            FrameLayout childFramlayout = (FrameLayout) mainBottomeSwitcherContainer.getChildAt(i);
            //给每个帧布局中添加点击事件
            childFramlayout.setOnClickListener(this);
        }
    }

    /**
     * 初始化四个fragment
     */
    private void initFragment() {
        arraylistFragments = new ArrayList<>();
        arraylistFragments.add(new HomeFragment());
        arraylistFragments.add(new SecondFragment());
        arraylistFragments.add(new ThirdFragment());
        arraylistFragments.add(new FourthFragment());
    }

    /**
     * @param v 点击的view
     */
    @Override
    public void onClick(View v) {
        //获取孩子节点对应的索引
        int indexOfChild = mainBottomeSwitcherContainer.indexOfChild(v);
        //设置图标的颜色
        changeUI(indexOfChild);
        //点击切换对应的Fragment
        changeFragment(indexOfChild);
    }

    /**
     * @param indexOfChild 切换对应的Fragment
     */
    private void changeFragment(int indexOfChild) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, arraylistFragments.get(indexOfChild)).commit();
    }

    /**
     * @param indexOfChild 改变图标颜色
     */
    private void changeUI(int indexOfChild) {
        for (int i = 0; i < mainBottomeSwitcherContainer.getChildCount(); i++) {
            View view = mainBottomeSwitcherContainer.getChildAt(i);
            //当前孩子节点索引和点击view索引相同时,
            if (i == indexOfChild) {
//                false设置不可用,
                setEnable(view, false);
            } else {
                // false设置可用,
                setEnable(view, true);
            }

        }
    }

    private void setEnable(View view, boolean b) {
        //设置是否可用
        view.setEnabled(b);
        //判读view是否是viewgroup的子类
        if (view instanceof ViewGroup) {
            //获取viewgroup容器中孩子节点的个数
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = ((ViewGroup) view).getChildAt(i);
                //递归调用
                setEnable(childAt, b);
            }
        }
    }
}
