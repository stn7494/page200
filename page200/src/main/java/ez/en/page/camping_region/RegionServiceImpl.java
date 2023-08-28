package ez.en.page.camping_region;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl implements RegionService {

		@Inject
		private RegionDAO regionDAO;

		@Override
		public RegionDTO selectOne(String region_code) {
			return regionDAO.selectOne(region_code);
		}

		@Override
		public List<RegionDTO> list() {
			return regionDAO.list();
		}
		
		
}
