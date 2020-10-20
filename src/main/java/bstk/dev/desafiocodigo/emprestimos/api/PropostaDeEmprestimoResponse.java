package bstk.dev.desafiocodigo.emprestimos.api;

import java.io.Serializable;
import java.util.Set;

public class PropostaDeEmprestimoResponse implements Serializable {

    private final String cliente;
    private final Set<EmprestimoDto> emprestimos;

    public PropostaDeEmprestimoResponse(final Set<EmprestimoDto> emprestimos, final String cliente) {
        this.cliente = cliente;
        this.emprestimos = emprestimos;
    }

    public String getCliente() {
        return cliente;
    }

    public Set<EmprestimoDto> getEmprestimos() {
        return emprestimos;
    }

}
