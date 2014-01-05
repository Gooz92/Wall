package wall.entity.java;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	public static final String ID_PROPERTY_NAME = "id";
	
	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
