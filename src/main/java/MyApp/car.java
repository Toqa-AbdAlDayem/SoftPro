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


  public void New_Sign() throws SQLException {
      PreparedStatement ps = DB.con.prepareStatement("insert into customer (CUST_ID,NAME,PASS,CONF_PASS,EMAIL,BIRTHDATE,GENDER) values (?,?,?,?,?,?,?)");
      ps.setInt(1, Integer.parseInt(driver.findElement(By.id("user_id")).getText()));
      ps.setString(2,driver.findElement(By.id("user_name")).getText());
      ps.setString(3, driver.findElement(By.id("pass")).getText());
      ps.setString(4, driver.findElement(By.id("conf")).getText());
      ps.setString(5, String.valueOf(Integer.parseInt(driver.findElement(By.id("email")).getText())));
      ps.setDate(6, Date.valueOf(driver.findElement(By.id("birth")).getText()));
      ps.setString(6, driver.findElement(By.id("gender")).getText());
    }}





