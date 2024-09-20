package org.example.alugueldecarros.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Cliente extends Usuario {


    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "profissao", nullable = false)
    private String profissao;

    @ElementCollection
    @CollectionTable(name = "entidades_empregadoras", joinColumns = @JoinColumn(name = "cliente_id"))
    @Column(name = "entidade_empregadora")
    private List<String> entidadesEmpregadoras;

//    @ElementCollection
//    @CollectionTable(name = "rendimentos", joinColumns = @JoinColumn(name = "cliente_id"))
//    @Column(name = "rendimento")
//    private List<Float> rendimentos;

//    public void cadastrar() {
//
//    }
}