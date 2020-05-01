
public class Movie {
	public String title;
	public String category;
	
	public Movie(String title, String category) {
		this.title = title;
		this.category =  category;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	@Override
	public String toString() {
		return getTitle();
	}
}
