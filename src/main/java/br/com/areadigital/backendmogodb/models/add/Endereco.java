package br.com.areadigital.backendmogodb.models.add;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Endereco   implements Serializable {
	private static final long serialVersionUID = 1L;


	private String rua;

	private String numero;

	private String bairro;

	private String cep;

}
