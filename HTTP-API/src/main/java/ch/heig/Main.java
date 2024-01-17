package ch.heig;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7777);
        app.before(ctx -> logRequestDetails(ctx)); // Middleware pour enregistrer les détails des requêtes

        ClientController clientController = new ClientController();
        app.get("/", ctx -> ctx.result("Bienvenue sur la page de l'API"));
        app.get("/api/clients", clientController::getAll);
        app.get("/api/clients/{id}", clientController::getOne);
        app.post("/api/clients/", clientController::create);
        app.put("/api/clients/{id}", clientController::update);
        app.delete("/api/clients/{id}", clientController::delete);
    }

    private static void logRequestDetails(Context ctx) {
        String method = String.valueOf(ctx.method());
        String path = ctx.path();
        String queryString = ctx.queryString();
        String ipAddress = ctx.ip();

        logger.info("Received {} request on {}{} from IP address {}", method, path, queryString, ipAddress);
    }
}

