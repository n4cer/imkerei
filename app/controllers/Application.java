package controllers;


import javax.inject.Inject;

import play.api.Configuration;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import play.mvc.Http;

public class Application extends Controller {
  @Inject FormFactory formFactory;
  @Inject Configuration configuration;

  public Result index(Http.Request request) {
    return ok(index.render(request));
  }
  
  public Result news(Http.Request request) {
    return ok(news.render(request));
  }
  
  public Result honey(Http.Request request) {
    return ok(honey.render(request));
  }
  
  public Result swarm(Http.Request request) {
    return ok(swarm.render(request));
  }
  
  public Result imprint(Http.Request request) {
    String name = configuration.underlying().getString("owner.name");
    String street = configuration.underlying().getString("owner.street");
    String city = configuration.underlying().getString("owner.city");
    String email = configuration.underlying().getString("owner.email");
    String email_encoded = "";
    for (int i = 0; i < email.length(); i++) {
      email_encoded += ("&#" + email.codePointAt(i) + ";");
    }
    
    return ok(imprint.render(name, street, city, email_encoded, request));
  }
  
  public Result privacy(Http.Request request) {
    String name = configuration.underlying().getString("owner.name");
    String street = configuration.underlying().getString("owner.street");
    String city = configuration.underlying().getString("owner.city");
    String country = configuration.underlying().getString("privacy.country");
    String email = configuration.underlying().getString("privacy.email");
    String email_encoded = "";
    for (int i = 0; i < email.length(); i++) {
      email_encoded += ("&#" + email.codePointAt(i) + ";");
    }
    
    return ok(privacy.render(name, street, city, country, email_encoded, request));
  }
}