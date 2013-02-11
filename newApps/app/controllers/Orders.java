package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import java.util.*;

import models.*;

import views.html.*;

@Security.Authenticated(Secured.class)
public class Orders extends Controller {

	public static Result index() {
		return ok(
			ocalendar.render(User.find.byId(request().username()))
			/*calendar.render(
				Order.findInvolving(request().username()),
				User.find.byId(request().username())
			)*/
		);
	}
}
