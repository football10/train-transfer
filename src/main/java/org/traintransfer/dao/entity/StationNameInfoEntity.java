package org.traintransfer.dao.entity;

public class StationNameInfoEntity {

	// Station的Code
	public int station_g_cd;
	// Station的名称(中文)
	public String station_name_cn;
	// Station的名称(日语)
	public String station_name;
	// Station的名称(日语的发音)
	public String station_name_r;

	public int getStation_g_cd() {
		return station_g_cd;
	}
	public void setStation_g_cd(int station_g_cd) {
		this.station_g_cd = station_g_cd;
	}
	public String getStation_name_cn() {
		return station_name_cn;
	}
	public void setStation_name_cn(String station_name_cn) {
		this.station_name_cn = station_name_cn;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getStation_name_r() {
		return station_name_r;
	}
	public void setStation_name_r(String station_name_r) {
		this.station_name_r = station_name_r;
	}

}
