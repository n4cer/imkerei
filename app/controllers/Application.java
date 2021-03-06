package controllers;


import javax.inject.Inject;

import play.api.Configuration;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {
  @Inject FormFactory formFactory;
  @Inject Configuration configuration;

  public Result index() {
    return ok(index.render());
  }
  
  public Result news() {
    return ok(news.render());
  }
  
  public Result honey() {
    return ok(honey.render());
  }
  
  public Result swarm() {
    return ok(swarm.render());
  }
  
  public Result imprint() {
    String name = configuration.underlying().getString("owner.name");
    String street = configuration.underlying().getString("owner.street");
    String city = configuration.underlying().getString("owner.city");
    String email = configuration.underlying().getString("owner.email");
    String email_encoded = "";
    for (int i = 0; i < email.length(); i++) {
      email_encoded += ("&#" + email.codePointAt(i) + ";");
    }
    
    return ok(imprint.render(name, street, city, email_encoded));
  }
  
  public Result privacy() {
    String name = configuration.underlying().getString("owner.name");
    String street = configuration.underlying().getString("owner.street");
    String city = configuration.underlying().getString("owner.city");
    String country = configuration.underlying().getString("privacy.country");
    String email = configuration.underlying().getString("privacy.email");
    String email_encoded = "";
    for (int i = 0; i < email.length(); i++) {
      email_encoded += ("&#" + email.codePointAt(i) + ";");
    }
    
    return ok(privacy.render(name, street, city, country, email_encoded));
  }
}