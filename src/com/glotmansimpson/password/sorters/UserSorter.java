package com.glotmansimpson.password.sorters;

import java.util.Comparator;

import com.glotmansimpson.password.data.User;

public class UserSorter {
	
	public static class CompareByName implements Comparator<User> {
	 @Override
	 public int compare(User user1, User user2) {
		
		 return user1.getUsername().compareToIgnoreCase(user2.getUsername());
		 
	 }
	}
}
