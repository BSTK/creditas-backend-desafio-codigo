package bstk.dev.desafiocodigo.emprestimos.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class EmprestimoService {

    public Set<EmprestimoDto> obterPropostas(PropostaDeEmprestimoRequest request) {
        final Set<EmprestimoDto> emprestimos = new HashSet<>();

        for (TiposDeEmprestimos tipo : TiposDeEmprestimos.values()) {
            EmprestimoDto emprestimoConcedido = tipo.concederEmprestimo(request);

            if (Objects.nonNull(emprestimoConcedido)) {
                emprestimos.add(emprestimoConcedido);
            }
        }

        return emprestimos;
    }

}
