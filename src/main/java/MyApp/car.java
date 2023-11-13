package MyApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;

public class car {


  public   ArrayList <User> user=new ArrayList<User>();
  WebDriver driver=null;
  public void Sign_Up_Page(){
  this.driver = new ChromeDriver();
  this.driver.get("file://C://Users//PC//Desktop//selcuc//selcuc//src//main//resources//signup.html");

  }


}





