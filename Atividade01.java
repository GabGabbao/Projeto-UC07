import java.security.SecureRandom;

public class Atividade01 { 

    private static final String LETRAS_MAIUS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETRAS_MINUS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMEROS = "0123456789"; 
    private static final String SIMBOLOS = "!@#$%^&*()-_=+[]{}|;:,.<>?";
    private static final SecureRandom randm = new SecureRandom();

    public static void main(String[] args) {
        String senha = gerarSenha(12);
        System.out.println("Senha gerada: " + senha);
        System.out.println("Força da senha: " + (senhaForte(senha) ? "Forte" : "Fraca"));

    }

    public static String gerarSenha(int tamanho) {
        String conjunto = LETRAS_MAIUS + LETRAS_MINUS + NUMEROS + SIMBOLOS;
        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            int index = randm.nextInt(conjunto.length());
            senha.append(conjunto.charAt(index));
        }

        return senha.toString();
    }

    public static boolean senhaForte(String senha) {
        boolean temMaius = false;
        boolean temMinus = false;
        boolean temNumero = false;
        boolean temSimbolo = false;

        for (char c : senha.toCharArray()) {
           if(LETRAS_MAIUS.indexOf(c) >= 0) temMaius = true;
           else if(LETRAS_MINUS.indexOf(c) >= 0) temMinus = true;
           else if(NUMEROS.indexOf(c) >= 0) temNumero = true;
           else if(SIMBOLOS.indexOf(c) >= 0) temSimbolo = true;
        } 

        return senha.length() >= 8 && temMaius && temMinus && temNumero && temSimbolo;
    }
}
