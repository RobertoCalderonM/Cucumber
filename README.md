in test.configuration.properties:

Machine (Options):
local: Test will run in a local WebBrowser
grid: Test will run in Selenium Grid (Virtual Machine)
sauce_labs: Test will run in Sauce Labs (Needs valid credentials in sauce_labs.credentials.properties) (Provided)

Browser (Options):
local -> chrome (Only Webdriver avaliable)
grid -> needs Selenium Grid running with corresponding nodes.
sauce_labs -> Any available browser in Sauce Labs (Needs a valid combination of test.browser.version, test.os.name, test.os.version)
