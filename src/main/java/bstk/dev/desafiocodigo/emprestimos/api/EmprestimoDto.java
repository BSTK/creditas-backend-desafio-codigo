package bstk.dev.desafiocodigo.emprestimos.api;

import java.io.Serializable;

public class EmprestimoDto implements Serializable {

    private final String tipo;
    private final Integer taxa;

    public EmprestimoDto(final String tipo, final Integer taxa) {
        this.tipo = tipo;
        this.taxa = taxa;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getTaxa() {
        return taxa;
    }

    @Override
    public String toString() {
        return "EmprestimoDto {" +
            "tipo='" + tipo + '\'' +
            ", taxa=" + taxa +
            " }";
    }
}
