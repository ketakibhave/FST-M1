@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SimpleAlert",
    plugin = {"pretty"},
    monochrome = true
)

public class ActivitiesRunner {
    //This is intentionally blank
}