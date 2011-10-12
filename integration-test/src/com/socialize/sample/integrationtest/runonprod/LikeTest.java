package com.socialize.sample.integrationtest.runonprod;
import com.socialize.sample.integrationtest.SocializeRobotiumTest;

import android.widget.TextView;


public class LikeTest extends SocializeRobotiumTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		authenticateSocialize();
		
		robotium.clickOnButton("Like");
		robotium.waitForActivity("LikeActivity", DEFAULT_TIMEOUT_SECONDS);
	}

	public void testCreateLike() {
		
		robotium.enterText(0, DEFAULT_GET_ENTITY);
		robotium.clickOnButton("Add Like");
		
		sleep(1000);
		
		waitForSuccess();
		
		getLikeId();
		
		// Check the date
		TextView txt = (TextView) robotium.getView(com.socialize.sample.R.id.txtLikeDateCreated);
		String value = txt.getText().toString();
		
		assertNotNull(value);
		assertTrue(value.trim().length() > 0);
	}
	

	
	private int getLikeId() {
		
		sleep(2000); // Wait for text field to be updated
		
		TextView txt = (TextView) robotium.getCurrentActivity().findViewById(com.socialize.sample.R.id.txtLikeIdCreated);
		
		// This is ID, it should be integer
		assertNotNull(txt);
		
		String value = txt.getText().toString();
		return Integer.parseInt(value);
	}
}