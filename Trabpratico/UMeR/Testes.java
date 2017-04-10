

/**
 * Escreva a descrição da classe Testes aqui.
 * 
 * @celia 1.0
 */
public class Testes{
    public static void main(String[] args) {
        
        LocalDate hoje = LocalDate.now();
        LocalDate dataNascimento = LocalDate.of(1993,12, 24); // dia 24 de dezembro de 1993
        Period dif = nascimento.until(hoje);
        System.out.println("A tua idade é: "+dif.getYears());
    }
}

