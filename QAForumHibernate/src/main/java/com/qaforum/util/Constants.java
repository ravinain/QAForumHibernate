/**
 * 
 */
package com.qaforum.util;

/**
 * @author cdacr
 *
 */
public enum Constants {

	/** */
	SCHEMA("QADB_DEV");

	/** */
	private String name;

	/**
	 * 
	 * @param name 
	 */
	Constants(final String name) {
		this.setName(name);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

}
