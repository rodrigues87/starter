package com.senac.starter.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Getter
@Setter
@SuppressWarnings("serial")
public class UsuarioCepColapsedDto extends HashMap<String, String> {

    private boolean expansive;
}
