/**
 * 
 */
package sierra.domain.model;

/**
 * 
 */
public class UserED {

	private final String idUser;
	private final String userName;
	private final String firstName;
	private final String lastName;
	private final String email;
	private final Boolean active;
	
	public UserED(Builder builder) {
		this.idUser = builder.idUser;
		this.userName = builder.userName;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.email = builder.email;
		this.active = builder.active;
	}

	public String getIdUser() {
		return this.idUser;
	}

	public String getUserName() {
		return this.userName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public Boolean getActive() {
		return this.active;
	}
	
	public static class Builder {
		private String idUser;
		private String userName;
		private String firstName;
		private String lastName;
		private String email;
		private Boolean active;
		
		public Builder idUser(String idUser) {
			if(idUser == null || idUser.trim().isEmpty()) {
				throw new IllegalArgumentException("idUser cannot be empty");
			}
			
			this.idUser = idUser;
			return this;
		}
		
		public Builder userName(String userName) {
			if(userName == null || userName.trim().isEmpty()) {
				throw new IllegalArgumentException("userName cannot be empty");
			}
			
			this.userName = userName;
			return this;
		}
		
		public Builder firstName(String firstName) {
			if(firstName == null || firstName.trim().isEmpty()) {
				throw new IllegalArgumentException("firstName cannot be empty");
			}
			
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			if(lastName == null || lastName.trim().isEmpty()) {
				throw new IllegalArgumentException("lastName cannot be empty");
			}
			
			this.lastName = lastName;
			return this;
		}
		
		
		public Builder email(String email) {
			if(email == null || email.trim().isEmpty()) {
				throw new IllegalArgumentException("email cannot be empty");
			}
			
			this.email = email;
			return this;
		}
		
		public Builder active(Boolean active) {
			if(email == null) {
				throw new IllegalArgumentException("active cannot be null");
			}
			
			this.active = active;
			return this;
		}
		
		public UserED build() {
			return new UserED(this);
		}
	}
}