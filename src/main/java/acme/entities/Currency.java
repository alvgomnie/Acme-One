package acme.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Currency extends AbstractEntity {

	protected static final long serialVersionUID = 1L;
	
	@NotBlank
	protected String name;
	
	@NotNull
	protected Boolean isDefault;

	@NotNull
	protected Boolean isAccepted;

}
