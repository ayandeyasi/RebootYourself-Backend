/**
 * 
 */
package com.reboot.yourself.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reboot.yourself.model.AppConfigModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * @author AlokeT
 *
 */
@RestController
@RequestMapping("/api")
@Api(value="AppConfig", description="Application specific configuration for Frontend")
public class AppConfigController {

	@Autowired
	SessionFactory sessionFactory;
	
	@ApiOperation(value = "View of available config key-value pair", response = AppConfigModel.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@RequestMapping(value="${config.default-api-vesrion}/config", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<AppConfigModel> getDefaultConfig() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<AppConfigModel> list = session.createCriteria(AppConfigModel.class).list();
		return list;
	}

	@RequestMapping(value="${config.default-api-vesrion}/addconfig", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addConfig() {
		return "{\"hello\":\"world\"}";
	}
	
//	@RequestMapping(value="${config.default-api-vesrion}/config", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody String getDefaultConfig() {
//		return "{\"hello\":\"world\"}";
//	}
//	@RequestMapping(value="${config.default-api-vesrion}/config", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody String getDefaultConfig() {
//		return "{\"hello\":\"world\"}";
//	}
}
