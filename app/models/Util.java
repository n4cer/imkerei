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
}