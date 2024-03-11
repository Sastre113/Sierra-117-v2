package sierra.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the users_roles database table.
 * 
 */
@Entity
@Table(name="users_roles")
@NamedQuery(name="UsersRole.findAll", query="SELECT u FROM UsersRole u")
public class UsersRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsersRolePK id;

	@Column(name="assignment_date", nullable=false)
	private Timestamp assignmentDate;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role", nullable=false, insertable=false, updatable=false)
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user", nullable=false, insertable=false, updatable=false)
	private User user;

	public UsersRole() {
	}

	public UsersRolePK getId() {
		return this.id;
	}

	public void setId(UsersRolePK id) {
		this.id = id;
	}

	public Timestamp getAssignmentDate() {
		return this.assignmentDate;
	}

	public void setAssignmentDate(Timestamp assignmentDate) {
		this.assignmentDate = assignmentDate;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}