package sierra.infrastructure.persistence.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user", unique=true, nullable=false, length=36)
	private String idUser;

	@Column(nullable=false)
	private Boolean active;

	@Column(name="creation_date")
	private Timestamp creationDate;

	@Column(nullable=false, length=100)
	private String email;

	@Column(name="first_name", nullable=false, length=100)
	private String firstName;

	@Column(name="last_name", length=100)
	private String lastName;

	@Column(name="user_name", nullable=false, length=100)
	private String userName;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user")
	private List<Message> messages;

	//bi-directional many-to-many association to Conversation
	@ManyToMany
	@JoinTable(
		name="users_conversations"
		, joinColumns={
			@JoinColumn(name="id_user", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_conversation", nullable=false)
			}
		)
	private List<Conversation> conversations;

	//bi-directional many-to-one association to UsersRole
	@OneToMany(mappedBy="user")
	private List<UsersRole> usersRoles;

	public User() {
	}

	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Timestamp getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}

	public List<Conversation> getConversations() {
		return this.conversations;
	}

	public void setConversations(List<Conversation> conversations) {
		this.conversations = conversations;
	}

	public List<UsersRole> getUsersRoles() {
		return this.usersRoles;
	}

	public void setUsersRoles(List<UsersRole> usersRoles) {
		this.usersRoles = usersRoles;
	}

	public UsersRole addUsersRole(UsersRole usersRole) {
		getUsersRoles().add(usersRole);
		usersRole.setUser(this);

		return usersRole;
	}

	public UsersRole removeUsersRole(UsersRole usersRole) {
		getUsersRoles().remove(usersRole);
		usersRole.setUser(null);

		return usersRole;
	}

}