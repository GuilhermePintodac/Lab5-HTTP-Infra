package ch.heig;

import io.javalin.http.Context;

import java.util.concurrent.ConcurrentHashMap;
public class ClientController {
    private ConcurrentHashMap<Integer, Client> clients =
            new ConcurrentHashMap<Integer, Client>();
    private int lastId = 0;

    public ClientController() {
        Voiture voitureAnita = new Voiture("VW",  "panne électrique");
        Voiture voitureBill = new Voiture("Audi",  "panne électrique");
        Voiture voitureChris = new Voiture( "Ferrari",  "Changement de freins");

        clients.put(++lastId, new Client("Anita", voitureAnita));
        clients.put(++lastId, new Client("Bill", voitureBill));
        clients.put(++lastId, new Client("Chris B.", voitureChris));
    }

    public void getOne(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        ctx.json(clients.get(id));
    }

    public void getAll(Context ctx) {
        ctx.json(clients);
    }

    public void create(Context ctx) {
        Client Client = ctx.bodyAsClass(Client.class);
        clients.put(++lastId, Client);
        ctx.status(201);
    }

    public void delete(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        clients.remove(id);
        ctx.status(204);
    }

    public void update(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Client Client = ctx.bodyAsClass(Client.class);
        clients.put(id, Client);
        ctx.status(200);
    }
}