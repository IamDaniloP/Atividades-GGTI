public class Crc {
    private static final char[] VOGAIS = {'A', 'E', 'I', 'O', 'U'};

    public static String executa(String palavra) {
        int qtdConsoantes = palavra.length();
        String[] contemVogais = {"0", "0", "0", "0", "0"};

        for (int i = 0; i < palavra.length(); i++) {
            char letraPalavra = Character.toUpperCase(palavra.charAt(i));
            for (int indexVogal = 0; indexVogal < VOGAIS.length; indexVogal++) {
                if (letraPalavra == VOGAIS[indexVogal]) {
                    contemVogais[indexVogal] = "1";
                    qtdConsoantes--;
                    break;
                }
            }
        }

        int convertePInteiro = Integer.parseInt(String.join("", contemVogais), 2);
        String crc = String.format("%d%02d", convertePInteiro, qtdConsoantes);

        return "O CRC de " + palavra + " é: " + crc;
    }
}
