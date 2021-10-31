import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class App {
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        }else {
            port = 4567;
        }
        port(port);

        staticFileLocation("/public");
        Hero.setUpNewHero();
        Hero.setUpNewHero1();
        Hero.setUpNewHero2();
        Squad.setUpNewSquad();

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAllInstances();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("heroes", heroes);
            model.put("squads",squads);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        // get: Adding new heroes
        get("/hero-form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        // get: show hero
        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero",hero);
            return new ModelAndView(model,"hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads", squads);
            ArrayList<Hero> members = Hero.getAllInstances();
            model.put("heroes", members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "Squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            Integer size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(squadName, size,cause);
            request.session().attribute("item",squadName);
            model.put("item",request.session().attribute("item"));
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //post: showing heroes created
        post("/new/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Integer age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            request.session().attribute("item",name);
            model.put("item",request.session().attribute("item"));
            model.put("newHero",newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/member/:squadId", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            request.session().attribute("selectedSquad",request.params("squadId"));
            model.put("selectedSquad", request.session().attribute("selectedSquad"));
            model.put("item",1);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/new/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params(":id"));
            Hero newMember = Hero.findById(id);
            Squad newSquad = Squad.findBySquadId(id);
            newSquad.setSquadMembers(newMember);
            model.put("item", newMember.getName());
            model.put("newHero", newSquad.getSquadName());
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
