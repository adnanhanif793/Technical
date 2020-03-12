# Firefox Browser 46 or older - no additional drivers required
# Firefox Browser 47 or above - Geckodriver is needed.

from selenium import webdriver

# Gecko Driver download Path: https://github.com/mozilla/geckodriver/releases

driver = webdriver.Firefox(executable_path='C:\\Users\\Joby\\Documents\\Automation\\webdrivers\\geckodriver')

driver.get("http://www.bbc.com")

driver.close()


