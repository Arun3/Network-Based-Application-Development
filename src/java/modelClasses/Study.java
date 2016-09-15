/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClasses;

/**
 *
 * @author Arun
 */
import java.io.Serializable;
import java.util.List;

public class Study implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5961419768192890808L;
	private String name;
	private int code;
	private String dateCreated;
	private String email;// (Creator)
	private String question;
	private String imageURL; // URL that can be used in your pages, pointing to
								// an image file within the project for your
								// question. Generated from study code.
	private int requestedParticipants; // How many participants does the creator
										// want
	private int numOfParitipants;// How participants have finished this study
									// thus far.
	private String description;
	private String status;
	private List<Answer> answer; // Collection (your choice) of answer.

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question
	 *            the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL
	 *            the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the requestedParticipants
	 */
	public int getRequestedParticipants() {
		return requestedParticipants;
	}

	/**
	 * @param requestedParticipants the requestedParticipants to set
	 */
	public void setRequestedParticipants(int requestedParticipants) {
		this.requestedParticipants = requestedParticipants;
	}

	/**
	 * @return the numOfParitipants
	 */
	public int getNumOfParitipants() {
		return numOfParitipants;
	}

	/**
	 * @param numOfParitipants the numOfParitipants to set
	 */
	public void setNumOfParitipants(int numOfParitipants) {
		this.numOfParitipants = numOfParitipants;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the answer
	 */
	public List<Answer> getAnswer() {
		return answer;
	}

	/**
	 * @param answer
	 *            the answer to set
	 */
	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
}

