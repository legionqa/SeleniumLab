import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.legion.pages.HomePage;
import utilities.BaseTest;

public class LegionHomePageTest extends BaseTest {

    @Epic("Legion Home Page")
    @Feature("Home Page navigation")
    @Story("Verify that user can navigate to the home page")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("sanity")
    @Owner("Lev")
    @Disabled
    @Test
    public void legionURLTest() {
        page.getPage(HomePage.class)
                .givenIAmAtHomePage()
                .verifyHomePageIsLoaded();
    }

    @Epic("Legion Home Page")
    @Feature("Home Page navigation - Courses")
    @Story("Verify that the user can successfully open the courses page.")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("sanity")
    @Owner("Lev")
    @Test
    public void legionCoursesPageTest(){
        page.getPage(HomePage.class)
                .givenIAmAtHomePage()
                .whenIClickCoursesTab()
                .verifyCoursesPageIsLoaded();
    }


}
