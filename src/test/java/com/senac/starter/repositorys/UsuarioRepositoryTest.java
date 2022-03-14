package com.senac.starter.repositorys;

import com.senac.starter.models.Animal;
import com.senac.starter.models.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository usuarioRepository;

    //@Test
    void findUsuarioById() {

        Usuario usuario = usuarioRepository.findUsuarioById(1L);

        System.out.println();
    }
    //@Test
    void findAllUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println();
    }

    @Test
    void findAllMapByCep() {

        List<Usuario> usuarios = usuarioRepository.findAll();

        HashMap<String, List<Usuario>> map = new HashMap<String, List<Usuario>>();

        for (Usuario usuario : usuarios) {
            String key  = usuario.getCep();
            if(map.containsKey(key)){
                List<Usuario> list = map.get(key);
                list.add(usuario);

            }else{
                List<Usuario> list = new ArrayList<Usuario>();
                list.add(usuario);
                map.put(key, list);
            }

        }

        System.out.println();
    }
}
