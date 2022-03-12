package com.senac.starter.repositorys;

import com.senac.starter.models.Animal;
import com.senac.starter.models.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Transacao,Long> {
    Transacao findVendaById(Long id);
}
