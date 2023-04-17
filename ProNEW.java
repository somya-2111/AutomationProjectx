package projectAutomation;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ProNEW {

	public WebDriver driver;

	@BeforeTest
	public void Launch() throws Exception {
		FileInputStream f = new FileInputStream("C:\\Users\\HP\\Desktop\\autopro.xls");

		Workbook wb = Workbook.getWorkbook(f);

		Sheet s = wb.getSheet("Sheet1");

		System.setProperty("webdriver.chrome.driver", s.getCell(1, 0).getContents());

		driver = new ChromeDriver();

		driver.get(s.getCell(1, 1).getContents());
		driver.manage().window();
	}

	@AfterTest
	public void Close() {
		driver.close();

	}

	@Test
	public void Scenario1() {
		PageOBJ ob = PageFactory.initElements(driver, PageOBJ.class);
		SoftAssert so = new SoftAssert();

		boolean h = ob.home.isDisplayed();
		so.assertEquals(h, true);
		System.out.println("HOME IS AVAILABLE");

		boolean f = ob.foball.isDisplayed();
		so.assertEquals(f, false);
		System.out.println("FOOTBALL IS AVAILABLE");

		boolean b = ob.bball.isDisplayed();
		so.assertEquals(b, true);
		System.out.println("BASKETBALL IS AVAILABLE");

		boolean cc = ob.ciber.isDisplayed();
		so.assertEquals(cc, true);
		System.out.println("CYBERSPORT IS AVAILABLE");
	}

	@Test
	public void Scenario2() throws Exception {
		PageOBJ ob = PageFactory.initElements(driver, PageOBJ.class);
		SoftAssert so = new SoftAssert();

		ob.home.click();
		String s1 = driver.getCurrentUrl();
		so.assertEquals(s1.contains("home"), false);
		System.out.println("HOME TAB URL IS - " + s1);

		ob.foball.click();
		String s2 = driver.getCurrentUrl();
		so.assertEquals(s2.contains("football"), true);
		System.out.println("FOOTBALL TAB URL IS - " + s2);

		ob.bball.click();
		String s3 = driver.getCurrentUrl();
		so.assertEquals(s3.contains("busketball"), true);
		System.out.println("BASKETBALL TAB URL IS - " + s3);

		ob.krik.click();
		String s4 = driver.getCurrentUrl();
		so.assertEquals(s4.contains("kriket"), true);
		System.out.println("KRIKET TAB URL IS - " + s4);

		ob.ciber.click();
		String s5 = driver.getCurrentUrl();
		so.assertEquals(s5.contains("cibersport"), true);
		System.out.println("CYBERSPORTS TAB URL IS - " + s5);

		System.out.println("-----Storing  the  URL in excel sheet------");

		FileOutputStream fo = new FileOutputStream("C:\\Users\\HP\\Desktop\\urls.xlxs");
		WritableWorkbook wrb = Workbook.createWorkbook(fo);
		WritableSheet ws = wrb.createSheet("url", 1);

		Label x = new Label(0, 0, " HOME TAB URL :- " + s1);
		Label y = new Label(0, 1, "FOOTBALL TAB URL :- " + s2);
		Label z = new Label(0, 2, "CRICKET TAB URL :- " + s3);
		Label d = new Label(0, 3, "BASKETBALL TAB URL :- " + s4);
		Label e = new Label(0, 4, "CYBERSPORT TAB URL :- " + s5);
		ws.addCell(x);
		ws.addCell(y);
		ws.addCell(z);
		ws.addCell(d);
		ws.addCell(e);

		wrb.write();
		wrb.close();

	}

}