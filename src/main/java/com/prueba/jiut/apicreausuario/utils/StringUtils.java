package com.prueba.jiut.apicreausuario.utils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Clase de utilidad.");
    }

    public static boolean esFormatoEmailValido(String email){
        return email.matches(Constants.EMAIL_REGEX);
    }

    public static boolean esFormatoPasswordValido(String password){
        return password.matches(Constants.PASSWORD_REGEX);
    }
}
