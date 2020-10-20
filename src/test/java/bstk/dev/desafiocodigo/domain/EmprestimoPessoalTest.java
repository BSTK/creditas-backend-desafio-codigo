package bstk.dev.desafiocodigo.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;
import bstk.dev.desafiocodigo.emprestimos.domain.EmprestimoPessoal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Emprestimo Pessoal")
class EmprestimoPessoalTest {

    private EmprestimoPessoal emprestimoPessoal = new EmprestimoPessoal();

    @ParameterizedTest
    @MethodSource("propostaDeEmprestimoRequest")
    @DisplayName("Bateria de testes - CASO SUCESSO")
    void executarTestesParametrizadosRetornandoEmprestimosValidos(final PropostaDeEmprestimoRequest request) {
        EmprestimoDto emprestimo = emprestimoPessoal.concederEmprestimo(request);

        assertThat(emprestimo).isNotNull();
        assertThat(emprestimo.getTaxa()).isEqualTo(4);
        assertThat(emprestimo.getTipo()).isEqualTo("pessoal");
    }

    private static List<Arguments> propostaDeEmprestimoRequest() {
        return List.of(
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(2_500L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_500L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(3_000L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_000L)))
        );
    }

}
