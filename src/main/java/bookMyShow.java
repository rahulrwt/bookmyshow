import baseClasses.BaseUi;

public class bookMyShow {

	public static void main(String[] args) {
		BaseUi bUi=new BaseUi();
		bUi.invokeBrowser("chrome");
		bUi.openWebsite("https://in.bookmyshow.com/explore/home/mumbai");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bUi.setLocation();
	}
}