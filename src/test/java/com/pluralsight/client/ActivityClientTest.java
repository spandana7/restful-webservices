package com.pluralsight.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pluralsight.model.Activity;

public class ActivityClientTest {

	@Test // to get an activity
	public void test() {
		ActivityClient activityClient = new ActivityClient();
		Activity activity=activityClient.get("4565");
		assertNotNull(activity);
		
	}
	
	@Test(expected=RuntimeException.class) // to check if it works fine for error codes
	public void getActivityException()
	{
		ActivityClient activityClient = new ActivityClient();
		activityClient.get("123");
		
	}

	
	@Test // gets list of activities
	public void getActivities()
	{
		ActivityClient activityClient = new ActivityClient();
		List<Activity> activities=activityClient.getActivities();
		assertNotNull(activities);
		
	}
	
	@Test // create an activity
	public void testCreate()
	{
		ActivityClient activityClient = new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Swimmning");
		activity.setDuration(90);
		activity = activityClient.createActivity(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testPut()
	{
		Activity activity = new Activity();
		activity.setActivityId("7890");
		activity.setDescription("jogging");
		activity.setDuration(70);
		ActivityClient activityClient=new ActivityClient();
		activity=activityClient.update(activity);
		assertNotNull(activity);
	}
	
}
