/*package ressources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Employe;


@Path("employes")
public class EmployeRessource {
	
	public static List<Employe> employes=new ArrayList<Employe>();
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addEmployes(Employe e)
	{
		if (employes.add(e))
		return "employe ajoute" ;
		return "employe non ajoute";
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employe> getAll() {
		return employes;
	
	}
	@DELETE
    @Path("{cin}")
	public void supprimerEmploye(@PathParam(value = "cin") String cin)
	{
	employes.remove(cin);
	}
	
}*/
package ressources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import entities.Employe;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("employes")
public class EmployeRessource {
    public static List<Employe> elist = new ArrayList<Employe>();
    Employe e1 = new Employe("1", "ali", "mooohammed");
    Employe e2 = new Employe("2", "ahmed", "mooohammed");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employe> displayEmployeesList() {
        return elist;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addEmployee(Employe employe) {
        if (elist.add(employe)) {
            return "add successful";
        } else {
            return "add failed";
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public String updateEmployee(Employe employe) {
        if (elist.contains(employe)) {
            elist.remove(employe);
            elist.add(employe);
        }
        return "update successful";
    }

    @GET
    @Path("/{cin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employe searchEmployee(@PathParam("cin") String cin) {
        for (Employe e : elist) {
            if (e.getCin().equals(cin)) {
                return e;
            }
        }
        return null;
    }

    @DELETE
    @Path("/{cin}")
    public Boolean deleteEmployee(@PathParam("cin") String cin) {
        for (Employe e : elist) {
            if (e.getCin().equals(cin)) {
                elist.remove(e);
                return true;
            }
        }
        return false;
    }
}