
package org.soulcodeacademy.helpr.domain.dto;
import org.hibernate.validator.constraints.Length;
import org.soulcodeacademy.helpr.domain.enums.Setor;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class FuturoCandidatoDTO {

    @NotBlank(message = "O campo nome é obrigatório!")
    private String nomeCompleto;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email é obrigatório!")
    private String email;

    @NotBlank(message = "A descrição é obrigatória!")
    @Length(max = 120, message = "Limite de caracteres excedido!")
    private String descricaoDasHabilidades;

    private Setor setor;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricaoDasHabilidades() {
        return descricaoDasHabilidades;
    }

    public void setDescricaoDasHabilidades(String descricaoDasHabilidades) {
        this.descricaoDasHabilidades = descricaoDasHabilidades;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
