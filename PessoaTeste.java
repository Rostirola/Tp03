public class PessoaTeste {
    public static void main(String[] args) throws IdadeInvalidaException, SalarioInvalidoException, NomeIncompletoException {
        Professor prof = new Professor();
        prof.setNome("Joao");
        prof.setIdade(30);
        prof.setSalario(1000);
        prof.setBonus(100);
        prof.setDesconto(50);

        try {
            Professor elbert = new Professor();
            elbert.setNome("Elbert");
            elbert.setIdade(30);
            elbert.setSalario(1000);
            elbert.setBonus(100);
            elbert.setDesconto(50);
        } catch (IdadeInvalidaException e) {
            System.out.println("Idade invalida");
        } catch (SalarioInvalidoException e) {
            System.out.println("Salario invalido");
        } finally {
            System.out.println("Fim do bloco try/catch");
        }
    }
}
