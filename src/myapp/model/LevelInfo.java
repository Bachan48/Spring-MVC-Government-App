package myapp.model;

import java.util.HashSet;
import java.util.Set;

public class LevelInfo {
String level_id;
String level_desc;

public LevelInfo()
{
	
}

public LevelInfo(String level_id, String level_desc) {
	super();
	this.level_id = level_id;
	this.level_desc = level_desc;
}

public String getLevel_id() {
	return level_id;
}
public void setLevel_id(String level_id) {
	this.level_id = level_id;
}
public String getLevel_desc() {
	return level_desc;
}
public void setLevel_desc(String level_desc) {
	this.level_desc = level_desc;
}

}
