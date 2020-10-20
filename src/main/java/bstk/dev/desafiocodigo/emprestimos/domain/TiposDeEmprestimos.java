package bstk.dev.desafiocodigo.emprestimos.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;

public enum TiposDeEmprestimos {

    EMPRESTIMO_PESSOAL(new EmprestimoPessoal()),
    EMPRESTIMO_CONSIGNADO(new EmprestimoConsignado()),
    EMPRESTIMO_COM_GARANTIA(new EmprestimoComGarantia());

    private final PropostaEmprestimo propostaEmprestimo;

    TiposDeEmprestimos(final PropostaEmprestimo propostaEmprestimo) {
        this.propostaEmprestimo = propostaEmprestimo;
    }

    public EmprestimoDto concederEmprestimo(PropostaDeEmprestimoRequest request) {
        return propostaEmprestimo.concederEmprestimo(request);
    }
}
