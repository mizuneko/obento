package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

public class Application extends Controller {


  public static class Login{
	  public String userId;
      public String password;

      public String validate() {
          if(User.authenticate(userId, password) == null) {
              return "社員ＩＤ と パスワード が一致しません。";
          }
          return null;
      }
  }

  public static Result login() {
      return ok(
    		  login.render(form(Login.class))
    		  );
  }

  public static Result authenticate() {
	  Form<Login> loginForm = form(Login.class).bindFromRequest();
      if(loginForm.hasErrors()) {
          return badRequest(login.render(loginForm));
      } else {
          session("userId", loginForm.get().userId);
          return redirect(
              routes.Orders.index()
          );
      }
  }

  public static Result logout() {
	  session().clear();
      flash("success", "ログアウトが完了しました。");
      return redirect(
    		  routes.Application.login()
    		  );
  }

  public static Result javascriptRoutes() {
      response().setContentType("text/javascript");
      return ok(
    		  Routes.javascriptRouter("jsRoutes")
      );
  }
}