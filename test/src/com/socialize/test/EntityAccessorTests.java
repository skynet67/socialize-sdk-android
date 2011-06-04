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
package com.socialize.test;

import com.socialize.entity.Application;
import com.socialize.entity.Comment;
import com.socialize.entity.Stats;
import com.socialize.entity.User;

/**
 * @author Jason Polites
 *
 */
public class EntityAccessorTests extends SocializeUnitTest {

	public void testStatsEntityAccessors() {
		
		Stats stats = new Stats();
		
		int comments = 1;
		int id = 2;
		int likes = 3;
		int shares = 4;
		int views = 5;
		
		stats.setComments(comments);
		stats.setId(id);
		stats.setLikes(likes);
		stats.setShares(shares);
		stats.setViews(views);
		
		assertEquals(comments, stats.getComments());
		assertEquals(id, stats.getId());
		assertEquals(likes, stats.getLikes());
		assertEquals(shares, stats.getShares());
		assertEquals(views, stats.getViews());
	}
	
	public void testUserEntityAccessors() {
		
		User user = new User();
		Stats stats = new Stats();
		
		String description = "description";
		String firstName = "firstName";
		String largeImageUri = "largeImageUri";
		String location = "location";
		String mediumImageUri = "mediumImageUri";
		String smallImageUri = "smallImageUri";
		String username = "username";
		
		user.setDescription(description );
		user.setFirstName(firstName);
		user.setLargeImageUri(largeImageUri);
		user.setLocation(location);
		user.setMediumImageUri(mediumImageUri);
		user.setSmallImageUri(smallImageUri);
		user.setStats(stats);
		user.setUsername(username);
		
		assertEquals(description, user.getDescription());
		assertEquals(firstName, user.getFirstName());
		assertEquals(largeImageUri, user.getLargeImageUri());
		assertEquals(location, user.getLocation());
		assertEquals(mediumImageUri, user.getMediumImageUri());
		assertEquals(smallImageUri, user.getSmallImageUri());
		assertEquals(username, user.getUsername());
		assertEquals(stats, user.getStats());
	}
	
	public void testApplicationEntityAccessors() {
		Application application = new Application();
		String name = "name";
		application.setName(name );
		assertEquals(name, application.getName());
	}
	
	public void testCommentEntityAccessors() {
		Comment comment = new Comment();
		String text = "text";
		comment.setText(text );
		assertEquals(text, comment.getText());
	}
}
