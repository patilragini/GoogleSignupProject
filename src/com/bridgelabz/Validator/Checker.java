/****************************************************************************** 
 *  @author  Ragini Patil
 *  @version 1.0
 *  @since   5-10-2017
 *	@purpose  Checker class has different methods to check 
 *			 
 ******************************************************************************/
package com.bridgelabz.Validator;

import java.util.regex.Pattern;

public class Checker {
	/*
	 * public static String checkData(String name, String password, long
	 * phoneNumber, String email) {
	 * 
	 * String regexName="[a-zA-Z0-9\\s]{4,}"; String regexPhoneNumber =
	 * "[0-9]";//{10} String
	 * regexEmail="[a-z0-9]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}"; if
	 * (Pattern.matches(regexName, name)==false || name == "") {
	 * System.out.println("false"); return "input name"; } if (password.length()
	 * < 6) { System.out.println("error password"); return "password"; } if
	 * (email == null || email == ""|| Pattern.matches(regexEmail,email)==false)
	 * { System.out.println("error email"); return "email"; } if ((int)
	 * Math.log10(phoneNumber) + 1 != 10) {
	 * System.out.println("error phone number"); return "phone number"; } return
	 * "valid";
	 * 
	 * }
	 */
	public static String checkName(String name) {
		String regexName = "[a-zA-Z0-9\\s]{4,}";
		if (Pattern.matches(regexName, name) == false || name == null) {
			//System.out.println("false!!!");
			return "name error";
		}
		return "valid";
	}

	public static String checkemail(String email) {
		String regexEmail = "[a-z0-9]{1,}[@]{1}[a-z]{1,}[.]{1}[a-z]{1,}";
		if (Pattern.matches(regexEmail, email) == false || email == "") {
			//System.out.println("false");
			return "email error";
		}
		return "valid";
	}

	public static String checkphoneNumber(long phoneNumber) {

		if ((int) Math.log10(phoneNumber) + 1 != 10) {
			//System.out.println("error phone number");
			return "phoneNumber error";
		}
		return "valid";
	}

	public static String checkpassword(String password) {

		if (password.length() < 6) {
		//	System.out.println("error password");
			return "password error";
		}
		return "valid";
	}

}
