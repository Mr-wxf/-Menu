package com.wxf.Utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class AnimationUtil {
	public static int isRuningAnimation = 0;

	public static void outAnimation(RelativeLayout rl, long index) {
		int childCount = rl.getChildCount();
		for (int i = 0; i < childCount; i++) {
			rl.getChildAt(i).setEnabled(false);

		}
		RotateAnimation rotateAnimation = new RotateAnimation(0f, -180f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 1f);
		rotateAnimation.setStartOffset(index);
		rotateAnimation.setDuration(500);
		rotateAnimation.setFillAfter(true);

		rl.startAnimation(rotateAnimation);

		rotateAnimation.setAnimationListener(new MyAnimationListener());
	}

	public static void inAnimation(RelativeLayout rl, long index) {
		int childCount = rl.getChildCount();
		for (int i = 0; i < childCount; i++) {
			rl.getChildAt(i).setEnabled(true);

		}
		RotateAnimation rotateAnimation = new RotateAnimation(-180f, 0f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 1f);

		rotateAnimation.setDuration(500);
		rotateAnimation.setFillAfter(true);
		rotateAnimation.setStartOffset(index);
		rl.startAnimation(rotateAnimation);

		rotateAnimation.setAnimationListener(new MyAnimationListener());
	}

	static class MyAnimationListener implements AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {
			isRuningAnimation++;
		}

		@Override
		public void onAnimationEnd(Animation animation) {
			isRuningAnimation--;
		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}

	}

}
