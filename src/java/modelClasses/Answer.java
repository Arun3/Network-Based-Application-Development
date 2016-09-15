/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClasses;
import java.io.Serializable;
/**
 *
 * @author Arun
 */
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4352593278915377668L;
	
	private String email; //Email of the participant
	private int choice; //Choice from 1 to 7
/*	getAverage()
	getMinimum()
	getMaximum()
	getSD()
*/
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the choice
	 */
	public int getChoice() {
		return choice;
	}
	/**
	 * @param choice the choice to set
	 */
	public void setChoice(int choice) {
		this.choice = choice;
	}
}

