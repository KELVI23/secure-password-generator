package com.glotmansimpson.password.data;
/**
 * 
 */

/**
 * @author kmusodza
 *
 */
public class User {
	
	public static final int ATTRIBUTE_COUNT = 4;
	
	private String username;
	private String fullName;
	private String email;
	private String password;
	private String workStation;
	
	public static class Builder {
		//Required parameters
		private final String username;
		private final String password;
		private final String workStation;
		
		//optional parameters
		private String fullName;
		private String email;
		public Builder(String userName, String password, String workStation) {
			this.username = userName;
			this.password = password;
			this.workStation = workStation;
		}


		public Builder setFullName(String fullName) {
			this.fullName = fullName;
			
			return this;
		}
		
		public Builder setEmail(String email) {
			this.email = email;
			
			return this;
		}
		
		public User build() {
			return new User(this);
		}
		
	}
	
	/*
	 * Default constructor
	 */
	private User(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
		this.fullName = builder.fullName;
		this.email = builder.email;
		this.workStation = builder.workStation;
	}
	

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}

	public String getWorkStation() {
		return workStation;
	}

	public String getFullName() {
		return fullName;
	}
	
	
	/**
	 * Get the attribute count used for input validation.
	 *
	 * @return the attribute count
	 */
	public static int getAttributeCount() {
		return ATTRIBUTE_COUNT;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", workStation=" + workStation + "]";
	}

	
	
}
