package com.elmar.db;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
@NamedQuery(name="UserRole.findAll", query="SELECT b FROM UserRole b")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long user_role_ID;

	//bi-directional many-to-one association to Role
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="role_ID", insertable=false, updatable=false)
	private Role role1;

	//bi-directional many-to-one association to Role
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="role_ID", insertable=false, updatable=false)
	private Role role2;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user_ID", insertable=false, updatable=false)
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="user_ID", insertable=false, updatable=false)
	private User user2;

	public UserRole() {
	}

	public Long getUser_role_ID() {
		return this.user_role_ID;
	}

	public void setUser_role_ID(Long user_role_ID) {
		this.user_role_ID = user_role_ID;
	}

	public Role getRole1() {
		return this.role1;
	}

	public void setRole1(Role role1) {
		this.role1 = role1;
	}

	public Role getRole2() {
		return this.role2;
	}

	public void setRole2(Role role2) {
		this.role2 = role2;
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

}