package com.ktds.jgu.hr.vo;

public class CountriesVO {

	private String countryId;
	private String countryName;
	private int regionId;
	
	// Join 하기 위해 테이블 VO 추가.
	private RegionsVO regions;
	
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	
	// Join 하기 위해 추가한 테이블 VO의 getter, setter를 추가한다.
	public RegionsVO getRegions() {
		if ( regions == null ) {
			regions = new RegionsVO();
		}
		return regions;
	}
	public void setRegions(RegionsVO regions) {
		this.regions = regions;
	}
	
}
