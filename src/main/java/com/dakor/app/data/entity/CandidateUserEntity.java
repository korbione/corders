package com.dakor.app.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * .
 *
 * @author dkor
 */
@Entity
@Table(name = "CANDIDATE_USERS")
public class CandidateUserEntity extends AbstractUserEntity {
	@Column(name = "ACTIVATION_KEY", nullable = false, unique = true, insertable = false, length = 16)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name ="uuid", strategy = "uuid2")
	private String activationKey;

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public String getActivationKey() {
		return activationKey;
	}
}
