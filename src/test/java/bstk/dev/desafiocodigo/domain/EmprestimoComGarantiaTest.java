package bstk.dev.desafiocodigo.domain;

import bstk.dev.desafiocodigo.emprestimos.api.EmprestimoDto;
import bstk.dev.desafiocodigo.emprestimos.api.PropostaDeEmprestimoRequest;
import bstk.dev.desafiocodigo.emprestimos.domain.EmprestimoComGarantia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Emprestimo Com Garantia")
class EmprestimoComGarantiaTest {

    private EmprestimoComGarantia emprestimoComGarantia = new EmprestimoComGarantia();

    @ParameterizedTest
    @DisplayName("Bateria de testes - CASO SUCESSO")
    @MethodSource("propostaDeEmprestimoRequestValidos")
    void executarTestesParametrizadosRetornandoEmprestimosValidos(final PropostaDeEmprestimoRequest request) {
        EmprestimoDto emprestimo = emprestimoComGarantia.concederEmprestimo(request);

        assertThat(emprestimo).isNotNull();
        assertThat(emprestimo.getTaxa()).isEqualTo(3);
        assertThat(emprestimo.getTipo()).isEqualTo("com_garantia");
    }

    @ParameterizedTest
    @DisplayName("Bateria de testes - CASO FALHA")
    @MethodSource("propostaDeEmprestimoRequestInvalidos")
    void executarTestesParametrizadosRetornandoEmprestimosInvalidos(final PropostaDeEmprestimoRequest request) {
        EmprestimoDto emprestimo = emprestimoComGarantia.concederEmprestimo(request);

        assertThat(emprestimo).isNull();
    }

    private static List<Arguments> propostaDeEmprestimoRequestValidos() {
        return List.of(
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(4_500L), "SP", 29)),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(2_500L), "SP", 29)),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_500L), "SP", 29))
        );
    }

    private static List<Arguments> propostaDeEmprestimoRequestInvalidos() {
        return List.of(
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(1_500L), "BA", 30)),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(5_500L), "bh", 30)),
            Arguments.of(new PropostaDeEmprestimoRequest(BigDecimal.valueOf(3_100L), "RJ", 28))
        );
    }

}
