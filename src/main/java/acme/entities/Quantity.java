package acme.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Quantity extends AbstractEntity{

	protected static final long	serialVersionUID	= 1L;
	
	@Min(0)
	protected Integer amount;
	
	@ManyToOne(optional = true)
	@Valid
	@NotNull
	@OnDelete(action = OnDeleteAction.CASCADE)
	protected Item item;
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	protected Toolkit toolkit;
}
