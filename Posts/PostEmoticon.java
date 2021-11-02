/*

    PostEmoticon.java
    Autor: Francisco Javier Castillo Cerna 21562
    Modelo de los Posts de Emoticon Texto, hereda de Post

*/

package Posts;

import java.util.ArrayList;
import java.util.Date;

public class PostEmoticon extends Post{
    private String emoticon;

    public PostEmoticon(String emoticon, String autor, ArrayList<String> hashtags, Date fechaDePublicacion){
        super(autor, hashtags, fechaDePublicacion);
        this.emoticon = emoticon;
    }
    
    
    /** 
     * @return String El post expandido
     */
    public String getPost(){
        String post = "";
        post += "-------------------------------------------------\n";
        post += this.getAutor() + " publico el " + this.getFechaDePublicacion() + "\n";
        post += "Hashtags: ";
        for (String hashtag : this.getHashtags()) {
            post += hashtag + " ";
        }
        post += "\n";
        post += "Likes: " + this.getLikes() + "\n\n";
        post += "(emoticon) " + this.emoticon + "\n\n";
        post += ">>>>> Comentarios:\n";
        int i = 1;
        for (String comentario : this.getComentarios()) {
            post += "(" + i++ + ")\t" + comentario + "\n";
        }
        post += "-------------------------------------------------\n";
        return post;
    }
    
    /** 
     * @return String El encabezado para seleccionar este post
     */
    public String getEncabezado(){
        String encabezado = "(Emoticon) De " + this.getAutor() + ". Publicdo el: " + this.getFechaDePublicacion();
        return encabezado;
    }
    
    /** 
     * @return String El efecto de reproducir el post de emoticon
     */
    public String play(){
        String texto = "(emoticon) " + this.emoticon + "\n\n";
        return texto;
    }
}
