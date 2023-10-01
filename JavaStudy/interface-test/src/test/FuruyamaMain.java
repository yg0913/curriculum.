package test;

public class FuruyamaMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		 // 3. 現実（1, 2 を使ってみる）
		 Furuyama Furuyama = new Furuyama("古山", "2019/03");
		 Furuyama.daseyaKinmuhyo();
		 Furuyama.daseyaKotsuhi();
		 Furuyama.doNothing();
		 Furuyama.goToSevenEleven();
		 
		final String message = Furuyama.doCreateJavaCurriculum();
		System.out.println("message = " + message);
	}

}
