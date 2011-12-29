/*
 * Copyright (c) 2011 Socialize Inc.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.socialize.ui.action;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.socialize.Socialize;
import com.socialize.log.SocializeLogger;
import com.socialize.ui.view.EntityView;
import com.socialize.util.Drawables;

/**
 * @author Jason Polites
 */
public class ActionDetailView extends EntityView {

	private ActionDetailLayoutView actionLayoutView;
	private View view;
	
	public ActionDetailView(Context context) {
		super(context);
	}

	/* (non-Javadoc)
	 * @see com.socialize.ui.view.EntityView#getView(android.os.Bundle, java.lang.Object[])
	 */
	@Override
	protected View getView(Bundle bundle, Object... entityKeys) {
		if (entityKeys != null) {
			if(actionLayoutView == null) {
				actionLayoutView = container.getBean("actionDetailLayoutView", entityKeys);
				
				LayoutParams scrollViewLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				LayoutParams childViewLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				
				ScrollView scrollView = new ScrollView(getContext());
				scrollView.setFillViewport(true);
				scrollView.setLayoutParams(scrollViewLayout);
				scrollView.addView(actionLayoutView, childViewLayout);	
				
				LinearLayout layout = new LinearLayout(getContext());
				LayoutParams masterParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT);
				
				layout.setLayoutParams(masterParams);
				layout.setBackgroundDrawable(((Drawables)container.getBean("drawables")).getDrawable("slate.png", true, true, true));
				
				layout.addView(scrollView);
				
				view = layout;
			}
			
			return view;
		}
		else {
			Log.e(SocializeLogger.LOG_TAG, "No user id specified for " + getClass().getSimpleName());
			return null;
		}		
	}

	/* (non-Javadoc)
	 * @see com.socialize.ui.view.EntityView#getEntityKeys()
	 */
	@Override
	protected String[] getBundleKeys() {
		return new String[]{Socialize.USER_ID, Socialize.ACTION_ID};
	}

	public void onProfileUpdate() {
		if(actionLayoutView != null) {
			actionLayoutView.onProfileUpdate();
		}
	}

	@Override
	public View getLoadingView() {
		return null;
	}
	
	public boolean onCreateOptionsMenu(final Activity source, Menu menu) {
		createOptionsMenuItem(source, menu);
		return true;
	}	
}
