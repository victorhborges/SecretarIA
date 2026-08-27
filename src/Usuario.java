public class Usuario {
    private static String login= "admin";
    private static String senha= "1234";

    public static String getLogin(){
    return login;
    }

    public static void setLogin(String login){
        Usuario.login = login;
    }

    public static String getSenha(){
        return senha;
    }

    public static void setSenha(String senha){
        Usuario.senha = senha;
    }
}
