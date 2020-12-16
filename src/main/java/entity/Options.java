package entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Options{

	@JsonProperty("choose")
	private int choose;

	@JsonProperty("from")
	private List<FromItemItem> from;

	public int getChoose(){
		return choose;
	}

	public List<FromItemItem> getFrom(){
		return from;
	}
}