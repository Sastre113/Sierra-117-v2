package sierra.infrastructure.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The primary key class for the users_roles database table.
 * 
 */
@Embeddable
public class UsersRolePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_user", insertable=false, updatable=false, unique=true, nullable=false, length=36)
	private String idUser;

	@Column(name="id_role", insertable=false, updatable=false, unique=true, nullable=false, length=36)
	private String idRole;

	public UsersRolePK() {
	}
	public String getIdUser() {
		return this.idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getIdRole() {
		return this.idRole;
	}
	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UsersRolePK)) {
			return false;
		}
		UsersRolePK castOther = (UsersRolePK)other;
		return 
			this.idUser.equals(castOther.idUser)
			&& this.idRole.equals(castOther.idRole);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser.hashCode();
		hash = hash * prime + this.idRole.hashCode();
		
		return hash;
	}
}