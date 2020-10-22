import PageClasses.GoogleSignIn;
import PageClasses.HomePage;
import PageClasses.Movies;
import PageClasses.Sports;
import baseClasses.BaseUi;
import baseClasses.TopMenu;

public class bookMyShow {

	public static void main(String[] args) {
		BaseUi bUi = new BaseUi();

		bUi.invokeBrowser("chrome");
		HomePage home = bUi.openWebsite("https://in.bookmyshow.com");
		home.declineAlert();
		home.setLocation();
		TopMenu topMenu = home.getTopMenu();
		Sports sports = topMenu.goToSports();
		sports.setDate();
		sports.setPrice();
		// done

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		topMenu = sports.getTopMenu();
		Movies movies = topMenu.goToMovies();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		movies.clickOnComingSoon();
		movies.fetchAllMoviesLanguages();
		topMenu = movies.getTopMenu();
		GoogleSignIn gmail = topMenu.signInUsingGmail();
		gmail.setEmail("rawat");

		gmail.printError();
		gmail.closeSignIn();

	}
}