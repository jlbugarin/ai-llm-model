package pe.redhat;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.inject.Inject;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.annotation.Counted;

@Path("/llm")
public class GreetingResource {

    @Inject
    AiService aiServiceModel;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(value="buga", description="Cantidad de solicitudes al endpoint llm")
    @Timed(value="bugat", description="Tiempo que toma ejecutar el método prompt")
    public String prompt() {
        //return "Hello from RESTEasy Reactive";
        //String consulta = "listame las 5 ciudades del peru mas importantes";
        String consulta = "que sabes de la empresa red hat";
        return aiServiceModel.chat(consulta);
    }
}
