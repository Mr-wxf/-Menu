package com.wxf.youkumenu;

import com.wxf.Utils.AnimationUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	private RelativeLayout rl_menu1;
	private ImageView ib_memu;
	private ImageView ib_home;
	private RelativeLayout rl_menu2;
	private RelativeLayout rl_menu3;
	private Boolean isMenu1 = true;
	private Boolean isMenu2 = true;
	private Boolean isMenu3 = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUI();
	}

	private void initUI() {
		ib_home = (ImageView) findViewById(R.id.ib_home);
		ib_memu = (ImageView) findViewById(R.id.ib_memu);
		rl_menu1 = (RelativeLayout) findViewById(R.id.rl_menu1);
		rl_menu2 = (RelativeLayout) findViewById(R.id.rl_menu2);
		rl_menu3 = (RelativeLayout) findViewById(R.id.rl_menu3);
		ib_home.setOnClickListener(this);
		ib_memu.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ib_home:
			if (AnimationUtil.isRuningAnimation > 0) {
				return;
			}
			long index = 0;
			if (isMenu3) {
				AnimationUtil.outAnimation(rl_menu3, 0);
				index += 200;
				isMenu3 = !isMenu3;
				if (isMenu2) {
					AnimationUtil.outAnimation(rl_menu2, index);
					isMenu2 = !isMenu2;
				}
			} else {
				if (isMenu2) {
					AnimationUtil.outAnimation(rl_menu2, index);
					isMenu2 = !isMenu2;
				} else {
					AnimationUtil.inAnimation(rl_menu3, 0);
					isMenu3 = !isMenu3;
					index += 200;
					AnimationUtil.inAnimation(rl_menu2, index);
					isMenu2 = !isMenu2;
				}
			}
			break;
		case R.id.ib_memu:
			if (AnimationUtil.isRuningAnimation > 0) {
				return;
			}
			if (isMenu3) {
				AnimationUtil.outAnimation(rl_menu3, 0);
			} else {
				AnimationUtil.inAnimation(rl_menu3, 0);
			}
			isMenu3 = !isMenu3;
			break;

		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (AnimationUtil.isRuningAnimation > 0) {
			return true;
		}
		long index = 0;
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			if (isMenu3) {
				AnimationUtil.outAnimation(rl_menu3, 0);
				isMenu3 = !isMenu3;
				index += 200;
				AnimationUtil.outAnimation(rl_menu2, index);
				isMenu2 = !isMenu2;
				index += 200;
				AnimationUtil.outAnimation(rl_menu1, index);
				isMenu1 = !isMenu1;
			} else {
				if (isMenu2) {
					AnimationUtil.outAnimation(rl_menu2, 0);
					isMenu2 = !isMenu2;
					index += 200;
					AnimationUtil.outAnimation(rl_menu1, index);
					isMenu1 = !isMenu1;
				} else {
					if (isMenu1) {
						AnimationUtil.outAnimation(rl_menu1, index);
						isMenu1 = !isMenu1;
					} else {
						AnimationUtil.inAnimation(rl_menu3, 0);
						isMenu3 = !isMenu3;
						index += 200;
						AnimationUtil.inAnimation(rl_menu2, index);
						isMenu2 = !isMenu2;
						index += 200;
						AnimationUtil.inAnimation(rl_menu1, index);
						isMenu1 = !isMenu1;
					}
				}
			}
		}
		return true;
	}
}
