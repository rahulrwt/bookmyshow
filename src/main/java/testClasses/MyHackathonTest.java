package testClasses;

import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import baseClasses.BaseUi;
import baseClasses.TopMenu;
import pageClasses.GoogleSignIn;
import pageClasses.HomePage;
import pageClasses.Movies;
import pageClasses.Sports;

public class MyHackathonTest extends BaseUi {
	HomePage homePage;
	TopMenu topmenu;
	Sports sports;
	Movies movies;
	GoogleSignIn googleSignIn;
	
	@Test
	public void myHackathonTest() {
		BaseUi baseUi = new BaseUi();
		baseUi.invokeBrowser("chrome");
		
		homePage = baseUi.openWebsite("URL");
		topmenu = homePage.declineAlert();

		movies = topmenu.goToMovies();
		movies.fetchAllMoviesLanguages();
		
		sports = topmenu.goToSports();
		sports.filter();
		sports.sportsWithLeastCharges();
		
		
		topmenu.signInClick();
		googleSignIn = topmenu.signInUsingGmail();
		googleSignIn.setEmailOne("manish@gmail.com");
		
		topmenu.signInUsingGmail();
		googleSignIn.setEmailTwo("");
		
		topmenu.signInUsingGmail();
		googleSignIn.setEmailThree("manish@gmailcom");
		
		topmenu.signInUsingGmail();
		googleSignIn.setEmailFour("ak577975@gmail.com");
		
		topmenu.signInUsingGmail();
		googleSignIn.setMobileOne("8450009037");
		
		topmenu.signInUsingGmail();
		googleSignIn.setMobileTwo("9887");
		
	
		
		
	}

}
