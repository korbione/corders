package com.dakor.app.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * .
 *
 * @author dkor
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsEntity extends AbstractEntity {
	@OneToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserEntity user;

	@OneToOne
	@JoinColumn(name = "PROP_ID", nullable = false)
	private PropertyEntity property;

	@Column(name = "PROP_VALUE")
	private String propertyValue;
}
