package br.com.areadigital.backendmogodb.models.add;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Endereco {


	private String rua;

	private String numero;

	private String bairro;

	private String cep;

}
