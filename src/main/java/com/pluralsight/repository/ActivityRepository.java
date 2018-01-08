package com.pluralsight.repository;

import java.util.List;

import com.pluralsight.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();

	Activity findActivity(String ActivityId);

	
	void createActivity(Activity activity);

	Activity updateActivity(Activity activity);

}