package check;

import constants.Constants;

public class Check {
	
	private static String firstName = "yosuke";
	private static String lastName = "goto";
	
	private static String printName(String firstName, String lastName) {
		return firstName + lastName;
	}
	
	public static void main(String args[]) {

		System.out.println("printNameメソッド → " + printName(lastName, firstName));
		
		Pet n = new Pet(Constants.CHECK_CLASS_JAVA, Constants.CHECK_CLASS_HOGE);
		
		RobotPet m = new RobotPet(Constants.CHECK_CLASS_R2D2, Constants.CHECK_CLASS_LUKE);
		
		n.introduce();
		m.introduce();
	}
	
}