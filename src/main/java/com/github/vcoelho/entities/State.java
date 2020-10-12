package com.github.vcoelho.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({
	@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {

	@Id
	private Long id;

	@Column(name = "nome")
	private String name;

	private String uf;

	private Integer ibge;

	@ManyToOne
	@JoinColumn(name = "pais", referencedColumnName = "id")
	private Country country;

	//usado anotacao para retornar no ddd no formato de json.
	@Type(type = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "ddd", columnDefinition = "jsonb")
	private List<Integer> ddd;

}
