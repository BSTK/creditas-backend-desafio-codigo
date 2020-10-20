package bstk.dev.desafiocodigo.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;
import bstk.dev.desafiocodigo.emprestimos.domain.EmprestimoConsignado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Emprestimo Cconsignado")
class EmprestimoConsignadoTest {

    private EmprestimoConsignado emprestimoConsignado = new EmprestimoConsignado();

    @ParameterizedTest
    @DisplayName("Bateria de testes - CASO SUCESSO")
    @MethodSource("propostaDeEmprestimoRequestValidos")
    void executarTestesParametrizadosRetornandoEmprestimosValidos(final PropostaDeEmprestimoRequest request) {
        EmprestimoDto emprestimo = emprestimoConsignado.concederEmprestimo(request);

        assertThat(emprestimo).isNotNull();
        assertThat(emprestimo.getTaxa()).isEqualTo(2);
        assertThat(emprestimo.getTipo()).isEqualTo("consignado");
    }

    @ParameterizedTest
    @DisplayName("Bateria de testes - CASO FALHA")
    @MethodSource("propostaDeEmprestimoRequestInvalidos")
    void executarTestesParametrizadosRetornandoEmprestimosInvalidos(final PropostaDeEmprestimoRequest request) {
        EmprestimoDto emprestimo = emprestimoConsignado.concederEmprestimo(request);

        assertThat(emprestimo).isNull();
    }

    private static List<Arguments> propostaDeEmprestimoRequestValidos() {
        return List.of(
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_500L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_100L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_001L)))
        );
    }

    private static List<Arguments> propostaDeEmprestimoRequestInvalidos() {
        return List.of(
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(2_999L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(3_000L))),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(3_100L)))
        );
    }

}
