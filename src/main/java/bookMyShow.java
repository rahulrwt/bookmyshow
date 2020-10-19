import PageClasses.HomePage;
import PageClasses.Movies;
import PageClasses.Sports;
import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class bookMyShow {

	public static void main(String[] args) {
		BaseUi bUi=new BaseUi();
		
		bUi.invokeBrowser("chrome");
		HomePage home=bUi.openWebsite("https://in.bookmyshow.com");
		home.declineAlert();
		home.setLocation();
		TopMenu topMenu=home.getTopMenu();
		Sports sports=topMenu.goToSports();
		sports.setDate();
		sports.setPrice();
		topMenu=sports.getTopMenu();
		Movies movies=topMenu.gotToMovies();
		movies.clickOnComingSoon();
		
		
	}
}