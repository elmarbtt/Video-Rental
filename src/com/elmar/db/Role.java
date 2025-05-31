package com.elmar.db;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id", insertable=false, updatable=false)
	private Long roleId;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date lastUpdated;

	private String role;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="updatedBy")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="createdBy")
	private User user2;
	
	//bi-directional many-to-many association to User
		/*@ManyToMany(mappedBy="roles3")
		private List<User> users;*/
		
		@OneToMany(mappedBy="role1")
		private List<UserRole> userRoles1;

		//bi-directional many-to-one association to UserRole
		@OneToMany(mappedBy="role2")
		private List<UserRole> userRoles2;
		
		@ManyToMany(mappedBy="role")
		private Set<User> users = new HashSet<User>();


	public Role() {
	}

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	/*public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	public List<UserRole> getUserRoles1() {
		return userRoles1;
	}

	public void setUserRoles1(List<UserRole> userRoles1) {
		this.userRoles1 = userRoles1;
	}

	public List<UserRole> getUserRoles2() {
		return userRoles2;
	}

	public void setUserRoles2(List<UserRole> userRoles2) {
		this.userRoles2 = userRoles2;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}