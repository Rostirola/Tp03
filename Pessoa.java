public class Pessoa {

	private String nome;
	private String sobrenome;
	private String ultimoNome;
	private int idade;
	private float salario;
	
	public Pessoa() {
		this.nome = Constante.NOME_PADRAO;
		this.idade = Constante.MAIOR_IDADE;
		this.salario = Constante.SALARIO_MINIMO;
	}
	
	public Pessoa(String nome, int idade) {
		this();
		this.nome = nome;
		this.idade = idade;
	}
	
	public Pessoa(String nome, int idade, float salario) {
		this(nome, idade);
		this.salario = salario;
	}

	@Override
	public String toString() {
		return nome + ";" + sobrenome + ";" + ultimoNome + ";" + salario;
	}
	
	public void imprimir(){		
		float salarioLiquido = calcularSalarioLiquido();
		
		System.out.println("Funcionario: " + this);
		System.out.println("Salario Liquido = R$" + salarioLiquido);
		System.out.println("Situacao = " + obterSituacao(salarioLiquido));
	}

	public float calcularSalarioLiquido(){
		return salario;
	}
	
	public String obterSituacao(float salarioLiquido){		
		if(salarioLiquido >= Constante.SALARIO_LIQUIDO_MAXIMO) {
			return Constante.RICO;
		}		
		return Constante.POBRE;
	}

	public String obterStringSalarioPorPessoa () throws NomeIncompletoException {

		StringBuilder sb = new StringBuilder();

		sb.append(this.getNome());
		sb.append(";");
		sb.append(this.calcularSalarioLiquido());
		sb.append("\r\n");

		return sb.toString();
	}

	public String getNome() throws NomeIncompletoException {
		
		if(nome == null || sobrenome == null || ultimoNome == null) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' est� incorreto");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ultimoNome.toUpperCase().charAt(0));
		sb.append(".");
		sb.append(",");
		sb.append(" ");
		sb.append(nome.toUpperCase());
		sb.append(" ");
		sb.append(sobrenome.toLowerCase());
		sb.append(".");
		
		return sb.toString();
	}

	public void setNome(String nome) throws NomeIncompletoException {
		
		if(nome == null) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' est� incorreto");
		}
		
		int posInicial = nome.indexOf(" ");
		int posFinal = nome.lastIndexOf(" ");
		
		if(posInicial < 0 || posFinal < 0) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' est� incorreto");
		}

		this.nome = nome.substring(0, posInicial);
		this.sobrenome = nome.substring(posInicial, posFinal).trim();
		this.ultimoNome = nome.substring(posFinal).trim();
	}	

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws IdadeInvalidaException {

		if(idade < Constante.MAIOR_IDADE) {
			throw new IdadeInvalidaException("Idade invalida");
		}

		this.idade = idade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) throws SalarioInvalidoException {

		if(salario < Constante.SALARIO_MINIMO) {
			throw new SalarioInvalidoException("Salario invalido");
		}

		this.salario = salario;
	}
}