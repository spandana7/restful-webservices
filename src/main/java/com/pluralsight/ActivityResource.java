package com.pluralsight;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.pluralsight.model.Activity;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource  {
	
	private ActivityRepository activityRepository= new ActivityRepositoryStub();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Activity> getAllActivities()
	{
		 activityRepository= new ActivityRepositoryStub();
		
		return activityRepository.findAllActivities();
		
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Path("{activityId}")
	public Response getActivity(@PathParam("activityId") String ActivityId)
	{
		  activityRepository= new ActivityRepositoryStub();
		  
		  if(ActivityId == null || ActivityId.length()<4)
		  {
			  return Response.status(Status.BAD_REQUEST).build();
		  }
		  
		  Activity activity = activityRepository.findActivity(ActivityId);
		  if(activity == null)
			  return Response.status(Status.NOT_FOUND).build();
		
		return Response.ok(activity).build() ;
		
	}
	
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Activity createActivityParms(MultivaluedMap<String, String> formParms)
	{
		
		Activity activity=new Activity();
		activity.setDescription(formParms.getFirst("description"));
		activity.setDuration(Integer.parseInt(formParms.getFirst("duration")));
		activityRepository.createActivity(activity);
		return activity;
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Activity createActivity(Activity activity)
	{
		return activity;
	}
	
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateActivity(Activity activity) {
		activity=activityRepository.updateActivity(activity);
		
		
		return Response.ok().entity(activity).build();
		
		
		
	}

}
