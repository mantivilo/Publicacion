package publicaciones.publicaciones;

public class Publicacion {
    private int id;
    private String titulo;
    private String contenido;
    private String comentarios;
    private int calificaciones;

    public Publicacion(int id, String titulo,String contenido, String comentarios, int calificaciones){
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.comentarios = comentarios;
        this.calificaciones = calificaciones;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getContenido(){
        return contenido;
    }

    public String getComentarios(){
        return comentarios;
    }

    public int getCalificaciones(){
        return calificaciones;
    }

  


}
