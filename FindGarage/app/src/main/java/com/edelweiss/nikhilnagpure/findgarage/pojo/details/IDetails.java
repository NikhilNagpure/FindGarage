package com.edelweiss.nikhilnagpure.findgarage.pojo.details;


import org.json.JSONObject;

public interface IDetails
{


	public String getId();

	public void setId(String id);

	public String getName();

	public void setName(String name);

	public String getParentId();

	public void setParentId(String parentId);

	public String getParentName();

	public void setParentName(String parentName);

	public String getType();

	public void setType(String type);


	public JSONObject toJson();

	public String getJsonString();

	public void setJsonString(String jsonStr);

	public Object getPojo();

	public void setPojo(Object jsonStr);


}
