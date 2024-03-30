import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.legion.pages.HomePage;
import org.legion.utilities.BaseTest;

public class LegionCoursesTest extends BaseTest {
private static final Logger logger = LogManager.getLogger(LegionCoursesTest.class);

    @Epic("Courses")
    @Feature("Courses Page - Search")
    @Story("Verify that the user can successfully search for a course.")
    @Severity(SeverityLevel.NORMAL)
    @Tag("regression")
    @ParameterizedTest
    @ValueSource(strings = {"QA", "Java", "Python"})
    public void LegionSearchCourseTest(String input){
        logger.info("Starting the test");
        page.getPage(HomePage.class)
                .givenIAmAtHomePage()
                .whenIClickCoursesTab()
                .andISearchForTheCourse(input)
                .verifyCourseFound();
    }
}
