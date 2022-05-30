@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    plugin = {"pretty"},
    monochrome = true
)