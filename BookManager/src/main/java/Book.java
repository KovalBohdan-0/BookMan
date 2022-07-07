
public class Book {
	public String name;
	public String author;
	public String email;
	public String pagesCount;
	public String description;
	
	public Book(String name, String author, String email, String pagesCount, String description) {
	this.setName(name);
	this.setAuthor(author);
	this.email = email;
	this.setPagesCount(pagesCount);
	this.setDesciption(description);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public String getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(String pagesCount) {
		this.pagesCount = pagesCount;
	}

	public String getDesciption() {
		return description;
	}

	public void setDesciption(String desciption) {
		this.description = desciption;
	}
}
