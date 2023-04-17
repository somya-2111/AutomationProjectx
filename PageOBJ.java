package projectAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageOBJ {
	@FindBy(xpath = "//a[text()='Home']")
	WebElement home;
	@FindBy(xpath = "//a[text()='Football']")
	WebElement foball;
	@FindBy(xpath = "//a[text()='Busketball']")
	WebElement bball;
	@FindBy(xpath = "//a[text()='Kriket']")
	WebElement krik;
	@FindBy(xpath = "//a[text()='Cibersport']")
	WebElement ciber;
}

