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
@Table(name = "PROPERTIES")
public class PropertyEntity extends AbstractEntity {
	@Column(name = "NAME", unique = true, nullable = false, length = 20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
