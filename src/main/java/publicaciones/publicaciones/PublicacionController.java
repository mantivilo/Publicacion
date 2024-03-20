package publicaciones.publicaciones;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PublicacionController {
   private List<Publicacion> publicaciones = new ArrayList<>();

   public PublicacionController(){
    //initialize list with data

    publicaciones.add(new Publicacion(0, "estudiantiles", "matemática", "muy interesante", 5));
    publicaciones.add(new Publicacion(0, "negocios", "finanzas", "taza de valores", 3));
    publicaciones.add(new Publicacion(0, "deportes", "Arturo Vidal", "deportivos", 4));
    publicaciones.add(new Publicacion(0, "transporte", "tarifa metro", "aburrido", 5));
    publicaciones.add(new Publicacion(0, "presidencial", "crisis politica", "comunidad social", 7));    
   }

   @GetMapping("/publicaciones")
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }   

}
