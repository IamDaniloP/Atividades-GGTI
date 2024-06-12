//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static String sequenciaDeLetrasENumerosMaiuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String sequenciaDeLetrasENumerosMinuscula = sequenciaDeLetrasENumerosMaiuscula.toLowerCase();

    public static String executaCifraDeCesar(String palavra, Integer deslocamento) {
        String[] arrayCharPalavra = palavra.split("");
        String palavraCifrada = "";

        for (int i = 0; i < arrayCharPalavra.length; i++) {
            if (sequenciaDeLetrasENumerosMinuscula.contains(arrayCharPalavra[i].toLowerCase())) {

                if (sequenciaDeLetrasENumerosMinuscula.contains(arrayCharPalavra[i])) {
                    Integer indexLetraPalavraNaSequenciaDeLetras = sequenciaDeLetrasENumerosMinuscula.indexOf(arrayCharPalavra[i]);
                    palavraCifrada += sequenciaDeLetrasENumerosMinuscula.split("")[indexLetraPalavraNaSequenciaDeLetras + deslocamento];
                } else {
                    Integer indexLetraPalavraNaSequenciaDeLetras = sequenciaDeLetrasENumerosMaiuscula.indexOf(arrayCharPalavra[i]);
                    palavraCifrada += sequenciaDeLetrasENumerosMaiuscula.split("")[indexLetraPalavraNaSequenciaDeLetras + deslocamento];
                }

            } else {
                return "O caracter: ".concat(arrayCharPalavra[i]).concat(" na posição: ").concat(String.valueOf(i)).concat(" é inválido");
            }
        }

        return palavraCifrada;
    }

    public static void main(String[] args) {
        System.out.println(executaCifraDeCesar("Raul", 2));
    }
}