package study;

public class ResourceBundle {
	
	public static void main(String args[]) {
		 ResourceBundle bundle = ResourceBundle.getBundle("拡張子なし任意ファイル名");
		 String value = bundle.getString("任意キー");
		 System.out.println(value);
		 }
}
