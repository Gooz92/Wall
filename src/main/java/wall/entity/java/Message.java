package wall.entity.java;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGES")
public class Message extends BaseEntity {

	public static final String TEXT_PROPERTY_NAME = "text";
	public static final String DATE_PROPERTY_NAME = "date";

	@Column(name = "TEXT", nullable = false)
	private String text;

	@Column(name = "DATE", nullable = false)
	private Date date = new Date();

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
