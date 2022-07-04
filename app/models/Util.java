package models;

import java.security.SecureRandom;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import play.mvc.Http;
import play.libs.typedmap.TypedMap;
import play.routing.Router;
import play.routing.Router.Attrs;

public class Util {
  public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  public static SecureRandom rnd = new SecureRandom();
  
  public static String getConfigValueByKey(String key) {
    Config config = ConfigFactory.load();
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
  
  public static String getRequestPath(Http.Request request) {
    TypedMap tags = request.attrs();
    return tags.get(Attrs.HANDLER_DEF).controller() + "." + tags.get(Router.Attrs.HANDLER_DEF).method();
  }
}