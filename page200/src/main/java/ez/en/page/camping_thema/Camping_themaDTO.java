package ez.en.page.camping_thema;

public class Camping_themaDTO {
	
	private String thema_code;
	private String thema_name;
	
	public Camping_themaDTO() {}

	public String getThema_code() {
		return thema_code;
	}

	public void setThema_code(String thema_code) {
		this.thema_code = thema_code;
	}

	public String getThema_name() {
		return thema_name;
	}

	public void setThema_name(String thema_name) {
		this.thema_name = thema_name;
	}

	@Override
	public String toString() {
		return "Camping_themaDTO [thema_code=" + thema_code + ", thema_name=" + thema_name + "]";
	}
	
	

}
