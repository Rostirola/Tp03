import java.util.Scanner;

public class TP02 {

	private static Pessoa[] pessoas;

	private static void imprimir() {		
		for (int i = 0; i < Constante.TAMANHO; i++) {
			if(pessoas[i] != null) {
				pessoas[i].imprimir();
			}
		}
	}

	public static void main(String[] args) throws IdadeInvalidaException, SalarioInvalidoException, NomeIncompletoException {

		pessoas = new Pessoa[Constante.TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Cadastrar professor");
			System.out.println("[2] Cadastrar aluno");
			System.out.println("[3] Consultar situação de um docente/discente.");
			System.out.println("[4] Sair.");
			
			System.out.print("Informe a opcao desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < Constante.TAMANHO) {
					
					Professor prof = new Professor();
					
					System.out.print("Informe o seu nome: ");	
					prof.setNome(in.next());
	
					System.out.print("Informe a sua idade: ");	
					prof.setIdade(in.nextInt());
	
					System.out.print("Informe o seu salario: ");	
					prof.setSalario(in.nextFloat());
					
					System.out.print("Informe o seu bonus: ");	
					prof.setBonus(in.nextFloat());

					System.out.print("Informe o seu desconto: ");	
					prof.setDesconto(in.nextFloat());
					
					pessoas[pos] = prof;

					pessoas[pos].imprimir();
					System.out.println("Codigo: " + pos);

					pos++;
				} else {
					System.out.println("Imposs�vel realizar um novo cadastramento!");
				}
				break;

			case "2":
				if(pos < Constante.TAMANHO) {
										
					System.out.print("Informe o seu nome: ");
					String nome = in.next();
						
					System.out.print("Informe a sua idade: ");
					int idade = in.nextInt();
										
					Aluno prog = new Aluno(nome, idade);
					
					System.out.print("Informe o seu sal�rio: ");	
					prog.setSalario(in.nextFloat());
					
					System.out.print("Informe se � fullstack: ");	
					prog.setDevFull(in.nextBoolean());

					System.out.print("Informe o sua linguagem principal: ");	
					prog.setLinguagem(in.next());
					
					pessoas[pos] = prog;

					pessoas[pos].imprimir();

					pos++;
				} else {
					System.out.println("Imposs�vel realizar um novo cadastramento!");
				}
				break;

			case "3":
				System.out.print("Informe o funcion�rio para impress�o: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					pessoas[id].imprimir();
				} else {
					System.out.println("O �ndice ["+id+"] � inv�lido!!!");
				}
				break;

			case "4":
				imprimir();
				break;

			case "5":
				System.out.println("Sa�da");
				break;

			default:
				System.out.println("A op��o ["+opcao+"] inv�lida");
				break;
			}
		} while (!"5".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!!!");
		
		in.close();
	}
}