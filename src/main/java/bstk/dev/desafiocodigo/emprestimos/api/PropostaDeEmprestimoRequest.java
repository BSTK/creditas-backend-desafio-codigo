package bstk.dev.desafiocodigo.emprestimos.api;

import java.math.BigDecimal;

public class PropostaDeEmprestimoRequest {

    private String nome;
    private String cpf;
    private Integer idade;
    private String localizacao;
    private BigDecimal salario;

    public PropostaDeEmprestimoRequest() { }

    public PropostaDeEmprestimoRequest(BigDecimal salario) {
        this.salario = salario;
    }

    public PropostaDeEmprestimoRequest(BigDecimal salario, String localizacao, Integer idade) {
        this.salario = salario;
        this.localizacao = localizacao;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Request ( " +
            "idade=" + idade +
            ", localizacao='" + localizacao + '\'' +
            ", salario= " + salario +
            " )";
    }
}
