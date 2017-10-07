//purpose :getter setter for registration

package com.bridgelabz.Component;

public class Registration {
private static String name;
private static String email;
private static int phoneNumber;
private static String password;
public static String getName() {
	return name;
}
public static void setName(String name) {
	Registration.name = name;
}
public static String getEmail() {
	return email;
}
public static void setEmail(String email) {
	Registration.email = email;
}
public int getphoneNumber() {
	return phoneNumber;
}
public static void setphoneNumber(int phoneNumber) {
	Registration.phoneNumber = phoneNumber;
}
public static String getPassword() {
	return password;
}
public static void setPassword(String password) {
	Registration.password = password;
}

}
