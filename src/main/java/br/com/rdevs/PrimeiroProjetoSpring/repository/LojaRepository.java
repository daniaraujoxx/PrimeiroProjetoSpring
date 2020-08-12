package br.com.rdevs.PrimeiroProjetoSpring.repository;

import br.com.rdevs.PrimeiroProjetoSpring.model.entity.LojaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LojaRepository extends JpaRepository<LojaEntity, Integer> {
    List<LojaEntity> findByNome (String nome);
}
