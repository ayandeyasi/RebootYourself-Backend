/**
 * 
 */
package com.reboot.yourself.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author AlokeT
 *
 */
@Entity
@Table(name = "app_config", schema = "master")
public class AppConfigModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRIMARY_ID")
	@ApiModelProperty(notes = "The database generated product ID")
	private int id;
	@Column(name = "KEY_ID")
	@ApiModelProperty(notes = "The key of the config file")
	private String key;
	@Column(name = "KEY_VALUE")
	@ApiModelProperty(notes = "The value corresponing to the key")
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AppConfigModel [id=" + id + ", key=" + key + ", value=" + value + "]";
	}

	public Map<String, AppConfigModel> getConfig() {
		Map<String, AppConfigModel> config = new HashMap<String, AppConfigModel>(0);
		config.put(this.getKey(), this);
		return config;
	}

}
