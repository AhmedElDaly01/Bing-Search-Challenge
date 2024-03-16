package org.example.stepDefs;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;


    @Before
    public void OpenBrowser() throws IOException, CsvException {

        String BrowserName = configReader.get("BrowserName");
        if( BrowserName.contains("chrome")){ driver = new ChromeDriver(); }
        else if (BrowserName.contains("edge")){ driver = new EdgeDriver(); }
        else if (BrowserName.contains("firefox")){ driver = new FirefoxDriver();} //Need set property or WebDriverManager

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        List<String []> testData;

        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AMIT\\IdeaProjects\\vodafoneSearchChallenge\\ExcelData.csv"));
        testData = reader.readAll();

        reader.close();

        testData.remove(0);

        String URL = null;
        for(String[] data : testData){
            URL = data[0];
        }

        driver.get(URL);

    }

    @After
    public void Quit() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

}
