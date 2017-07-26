package Models;

import java.io.Serializable;
import java.util.Date;

public class BookModel implements Serializable{

	private int id;

	private String name;

	private int typeId;

	private String typeName;

	private String author;
	private Date pubDate;

	public BookModel(){}
	public BookModel(int id, String name, int typeId, String typeName, String author, Date pubDate) {
		super();
		this.id = id;
		this.name = name;
		this.typeId = typeId;
		this.typeName = typeName;
		this.author = author;
		this.pubDate = pubDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}


}
