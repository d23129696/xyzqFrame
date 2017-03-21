// Generated code from Butter Knife. Do not modify!
package com.xyzq.frame.ui.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SplashActivity$$ViewInjector {
  public static void inject(Finder finder, final com.xyzq.frame.ui.activity.SplashActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427416, "field 'ivSplash'");
    target.ivSplash = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131427415, "field 'activitySplash'");
    target.activitySplash = (android.widget.RelativeLayout) view;
  }

  public static void reset(com.xyzq.frame.ui.activity.SplashActivity target) {
    target.ivSplash = null;
    target.activitySplash = null;
  }
}
