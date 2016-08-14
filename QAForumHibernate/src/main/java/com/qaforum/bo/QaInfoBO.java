/**
 * 
 */
package com.qaforum.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 * @author cdacr
 * 
 */
@Entity(name = "QAINFO")
public class QaInfoBO implements Serializable {

	private static final long serialVersionUID = 1677917346380389565L;

	/**
	 * 
	 */
	@Id
	@Column(name = "qaId", unique = true, nullable = false)
	@TableGenerator(name = "TABLE_GEN", table = "SEQUENCE_TABLE", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "QA_COUNT", allocationSize = 1)
	@GeneratedValue(generator = "TABLE_GEN", strategy = GenerationType.TABLE)
	private Long qaId;
	/** */
	private String question;
	/** */
	private String answer;
	/** */
	private String type;
	/** */
	private Date lastUpdatedDt;
	/** */
	private String lastUpdatedBy;

	/**
	 * @return the qaId
	 */
	public final Long getQaId() {
		return qaId;
	}

	/**
	 * @param qaId
	 *            the qaId to set
	 */
	public final void setQaId(final Long qaId) {
		this.qaId = qaId;
	}

	/**
	 * @return the question
	 */
	public final String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public final void setQuestion(final String question) {
		this.question = question;
	}

	/**
	 * @return the answer
	 */
	public final String getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public final void setAnswer(final String answer) {
		this.answer = answer;
	}

	/**
	 * @return the typeId
	 */
	public final String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the typeId to set
	 */
	public final void setType(final String type) {
		this.type = type;
	}

	/**
	 * @return the lastUpdatedDt
	 */
	public final Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	/**
	 * @param lastUpdatedDt
	 *            the lastUpdatedDt to set
	 */
	public final void setLastUpdatedDt(final Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public final String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy
	 *            the lastUpdatedBy to set
	 */
	public final void setLastUpdatedBy(final String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}
