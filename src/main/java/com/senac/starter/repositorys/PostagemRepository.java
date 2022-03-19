package com.senac.starter.repositorys;

import com.senac.starter.models.Postagem;
import com.senac.starter.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
    Postagem findPostagemById(Long id);
}
