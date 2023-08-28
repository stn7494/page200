package ez.en.page.camping_region;

public class RegionDTO {
	
	private String region_code;
	private String region_name;
	
	public RegionDTO() {};
	
	public RegionDTO(String region_code, String region_name) {
		super();
		this.region_code = region_code;
		this.region_name = region_name;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	@Override
	public String toString() {
		return "Camping_regionDTO [region_code=" + region_code + ", region_name=" + region_name + "]";
	}
	
	
	
	
	
	
}
