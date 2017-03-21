// Generated code from Butter Knife. Do not modify!
package com.xyzq.frame.ui.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class MainActivity$$ViewInjector {
  public static void inject(Finder finder, final com.xyzq.frame.ui.activity.MainActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427413, "field 'mainFragmentContainer'");
    target.mainFragmentContainer = (android.widget.FrameLayout) view;
    view = finder.findRequiredView(source, 2131427414, "field 'mainBottomeSwitcherContainer'");
    target.mainBottomeSwitcherContainer = (android.widget.LinearLayout) view;
  }

  public static void reset(com.xyzq.frame.ui.activity.MainActivity target) {
    target.mainFragmentContainer = null;
    target.mainBottomeSwitcherContainer = null;
  }
}
