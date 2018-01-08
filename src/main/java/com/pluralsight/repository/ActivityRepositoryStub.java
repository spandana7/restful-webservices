package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.Activity;

public class ActivityRepositoryStub implements ActivityRepository {
	
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.ActivityRepository#findAllActivities()
	 */
	
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.ActivityRepository#findAllActivities()
	 */
	@Override
	public List<Activity> findAllActivities(){
		
		List<Activity> activities =new ArrayList<Activity>();
		
		Activity activity1=new Activity();
		activity1.setDescription("Reading");
		activity1.setDuration(1);
		activities.add(activity1);
		
		Activity activity2=new Activity();
		activity2.setDescription("Swimming");
		activity2.setDuration(2);
		activities.add(activity2);
		
		Activity activity3=new Activity();
		activity3.setDescription("riding");
		activity3.setDuration(3);
		activities.add(activity3);
		
		return activities;
		
	}

	@Override
	public Activity findActivity(String activityId) {
		Activity activity1=new Activity();

		activity1.setActivityId(activityId);
		activity1.setDescription("Playing");
		activity1.setDuration(1);
		
		
		return activity1;
	}

	public void createActivity(Activity activity) {
		// insert data into db
		
	}

	@Override
	public Activity updateActivity(Activity activity) {
		// database update search for id and update the record
		return activity;
		
	}

	


	

}
