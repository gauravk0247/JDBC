package practice;

import java.util.Scanner;

enum UserStatus{
	ACTIVATED, DEACTIVATED;
}
class User{
	private String userName;
	private String userPassword;
	private UserStatus status;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserStatus getStatus() {
		return status;
	}
	public void setStatus(UserStatus status) {
		this.status = status;
	}
}
public class Practice{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name");
		String uname = sc.next();
		System.out.println("Enter User Password");
		String upwd = sc.next();
		System.out.println("Enter User Status either Activated or Deactivated");
		String status1 = sc.next();
		
		UserStatus status2 = UserStatus.valueOf(status1);
		
		User user = new User();
		user.setUserName(uname);
		user.setUserPassword(upwd);
		user.setStatus(status2);
		System.out.println(user.getUserName()+" "+ user.getUserPassword()+" "+ user.getStatus());
	}
}