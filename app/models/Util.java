package models;

import java.security.SecureRandom;

import play.Configuration;
import play.api.Play;

public class Util {
  public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  public static SecureRandom rnd = new SecureRandom();
  
  public static String getConfigValueByKey(String key) {
    Configuration config = Play.current().injector().instanceOf(Configuration.class);
    
    return config.getString(key);
  }
  
  public static String getEmail() {
    return getConfigValueByKey("owner.email");
  }
  
  public static String getPhone() {
    return getConfigValueByKey("owner.phone");
  }
  
  public static String getAddress() {
    return getConfigValueByKey("owner.street") + ", " + getConfigValueByKey("owner.city");
  }
  
  public static String getName() {
    return getConfigValueByKey("owner.name");
  }
  
  public static String getRequestPath() {
	  return play.mvc.Http.Context.current().request().path();
  }
}