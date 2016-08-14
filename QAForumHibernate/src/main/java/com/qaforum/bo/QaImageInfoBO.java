/**
 * 
 */
package com.qaforum.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author cdacr
 *
 */
@Entity(name = "qa_image_info")
public class QaImageInfoBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5526858876857865841L;

	/** */
	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	/** */
	private Long qaId;
	/**	 */
	@Column(name = "image_type")
	private String imageType;

	/**
	 * @return the imageId
	 */
	public final Long getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public final void setImageId(final Long imageId) {
		this.imageId = imageId;
	}

	/**
	 * @return the qaId
	 */
	public final Long getQaId() {
		return qaId;
	}

	/**
	 * @param qaId the qaId to set
	 */
	public final void setQaId(final Long qaId) {
		this.qaId = qaId;
	}

	/**
	 * @return the imagePath
	 */
	public final String getImageType() {
		return imageType;
	}

	/**
	 * @param imageType the imageType to set
	 */
	public final void setImageType(final String imageType) {
		this.imageType = imageType;
	}
}
