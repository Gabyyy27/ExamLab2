/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXAM;

/**
 *
 * @author Lourdes
 */
import java.util.ArrayList;

public class UberSocial {
      private static ArrayList<SocialClass> socialAccounts = new ArrayList<>();

    public UberSocial() {
        this.socialAccounts = new ArrayList<>();
    }

    public SocialClass buscar(String username) {
        // Implementación de la búsqueda recursiva
        for (SocialClass socialAccount : socialAccounts) {
            SocialClass foundAccount = buscarEnUsuario(socialAccount, username);
            if (foundAccount != null) {
                return foundAccount;
            }
        }
        return null;
    }

    private SocialClass buscarEnUsuario(SocialClass usuario, String username) {
        if (usuario.getUsername().equals(username)) {
            return usuario;
        }

        for (String friend : usuario.getFriends()) {
            SocialClass foundAccount = buscarEnUsuario(buscar(friend), username);
            if (foundAccount != null) {
                return foundAccount;
            }
        }

        return null;
    }

   
    public static void agregarCuenta(String username, String tipo) {
        // Implementación de la lógica para agregar cuenta
        if (!existeUsuario(username)) {
            if ("FACEBOOK".equalsIgnoreCase(tipo)) {
                socialAccounts.add(new Facebook(username));
            } else if ("TWITTER".equalsIgnoreCase(tipo)) {
                socialAccounts.add(new Twitter(username));
            }
        }
    }

    private static boolean existeUsuario(String username) {
        for (SocialClass socialAccount : socialAccounts) {
            if (socialAccount.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<SocialClass> getSocialAccounts() {
        return socialAccounts;
    }

   public void agregarPost(String user, String post) {
    // Implementación de la lógica para agregar post
    SocialClass usuario = buscar(user);
    if (usuario != null) {
        if (!post.isEmpty()) {  // Verificar que el post no esté vacío
            usuario.addPost(post);
        } else {
            System.out.println("Error: El post está vacío.");
        }
    }
}

    public void agregarAmigo(String user1, String user2) {
        // Implementación de la lógica para agregar amigo
        SocialClass usuario1 = buscar(user1);
        SocialClass usuario2 = buscar(user2);

        if (usuario1 != null && usuario2 != null && usuario1.getClass() == usuario2.getClass()) {
            usuario1.addFriend(user2);
            usuario2.addFriend(user1);
        }
    }

    public void agregarComment(String user, int postID, String autor, String comment) {
        // Implementación de la lógica para agregar comentario
        SocialClass usuario = buscar(user);
        if (usuario != null && usuario instanceof Commentable) {
            Commentable commentableUser = (Commentable) usuario;
            Comment comentario = new Comment(postID, autor, comment);
            commentableUser.addComment(comentario);
        }
    }

    public void profileFrom(String user) {
        // Implementación de la lógica para imprimir el perfil
        SocialClass usuario = buscar(user);
        if (usuario != null) {
            usuario.myProfile();
        }
    }
}
