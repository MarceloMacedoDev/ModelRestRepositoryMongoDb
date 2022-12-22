package br.com.areadigital.backendmogodb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collation = "tb_role")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String authority;

    public Role(String authority) {
        this.authority = authority;
    }
}
