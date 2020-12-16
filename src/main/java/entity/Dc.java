package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dc{

	@JsonProperty("success_type")
	private String successType;

	@JsonProperty("dc_value")
	private int dcValue;

	@JsonProperty("dc_type")
	private DcType dcType;

	public String getSuccessType(){
		return successType;
	}

	public int getDcValue(){
		return dcValue;
	}

	public DcType getDcType(){
		return dcType;
	}
}