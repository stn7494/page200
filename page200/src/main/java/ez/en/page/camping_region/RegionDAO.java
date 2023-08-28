package ez.en.page.camping_region;

import java.util.List;

public interface RegionDAO {

	public RegionDTO selectOne(String region_code);
	public List<RegionDTO> list();
}
