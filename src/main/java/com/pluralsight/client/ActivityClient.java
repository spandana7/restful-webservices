package com.pluralsight.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pluralsight.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient()
	{
		client=ClientBuilder.newClient();
	}
	

	public Activity get(String id)
	{
		WebTarget webTarget=client.target("http://localhost:8080/exercise-services/webapi/");
		//String response = webTarget.path("activities/").request(MediaType.APPLICATION_JSON).get(String.class);
		//System.out.println(response);
		Response response = webTarget.path("activities/" + id).request(MediaType.APPLICATION_JSON).get(Response.class);
		if(response.getStatus()!=200)
		{
			throw new RuntimeException(response.getStatus()+"there was an error on the server");
		}
		return response.readEntity(Activity.class);
	}
	
	
	public List<Activity> getActivities(){
		WebTarget webTarget = client.target("http://localhost:8080/exercise-services/webapi/");
		List<Activity> activities=webTarget.path("activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>() {});
		
		return activities;
	}


	public Activity createActivity(Activity activity) {
		WebTarget webTarget=client.target("http://localhost:8080/exercise-services/webapi");
		Response response= webTarget.path("activities/activity").request(MediaType.APPLICATION_JSON).post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		if(response.getStatus()!=200)
			
			throw new RuntimeException(response.getStatus()+"there was an error on the server");
		
		return response.readEntity(Activity.class);
	}




	public Activity update(Activity activity) {
		WebTarget webTarget=client.target("http://localhost:8080/exercise-services/webapi");
		Response response=webTarget.path("activities/" +activity.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(activity, MediaType.APPLICATION_JSON));
		if(response.getStatus()!=200)
		{
			 throw new RuntimeException(response.getStatus()+"there was an error on the server");
		}
		
		return response.readEntity(Activity.class);
		
	}
}
