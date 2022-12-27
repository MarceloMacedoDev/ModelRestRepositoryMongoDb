package br.com.areadigital.backendmogodb.models.add;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Contato   implements Serializable {
	private static final long serialVersionUID = 1L;

	private String telefone;

	private String cPNJCPF;

}
