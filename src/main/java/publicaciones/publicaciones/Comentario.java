package publicaciones.publicaciones;

public class Comentario {
    private String codigo;
    private String commentText;

    public Comentario(String codigo, String commentText){
        this.codigo = codigo;
        this.commentText = commentText;
    }

    //getters
    public String getCodigo(){
        return codigo;
    }

    public String getcommentText(){
        return commentText;
    }
}