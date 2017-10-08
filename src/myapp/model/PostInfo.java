package myapp.model;

public class PostInfo {
String post_id,post_name,level_id;
LevelInfo level_info;
public PostInfo(String post_id, String post_name, String level_id) {
	super();
	this.post_id = post_id;
	this.post_name = post_name;
	this.level_id = level_id;
}


public PostInfo()
{
	
}
public LevelInfo getLevel_info() {
	return level_info;
}

public void setLevel_info(LevelInfo level_info) {
	this.level_info = level_info;
}

public String getPost_id() {
	return post_id;
}

public void setPost_id(String post_id) {
	this.post_id = post_id;
}

public String getPost_name() {
	return post_name;
}

public void setPost_name(String post_name) {
	this.post_name = post_name;
}

public String getLevel_id() {
	return level_id;
}

public void setLevel_id(String level_id) {
	this.level_id = level_id;
}
}
