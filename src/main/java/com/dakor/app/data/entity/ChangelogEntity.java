package com.dakor.app.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * .
 *
 * @author dkor
 */
@Entity
@Table(name = "CHANGELOG")
public class ChangelogEntity extends AbstractEntity {
	@Column(name = "VERSION", nullable = false, unique = true, length = 7)
	private String version;

	@Column(name = "DESC", nullable = false)
	private String description;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
