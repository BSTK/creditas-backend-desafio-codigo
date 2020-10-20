package bstk.dev.desafiocodigo.emprestimos.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;

public interface PropostaEmprestimo {

    EmprestimoDto concederEmprestimo(final PropostaDeEmprestimoRequest request);

}
