package sierra.infrastructure.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


/**
 * The persistent class for the permissions database table.
 * 
 */
@Entity
@Table(name="permissions")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_permission", unique=true, nullable=false, length=36)
	private String idPermission;

	@Column(nullable=false, length=2147483647)
	private String name;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="permissions")
	private List<Role> roles;

	public Permission() {
	}

	public String getIdPermission() {
		return this.idPermission;
	}

	public void setIdPermission(String idPermission) {
		this.idPermission = idPermission;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}