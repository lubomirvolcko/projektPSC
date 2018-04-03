package com.ServerPSC.resources;


import com.ServerPSC.db.MySQL;

import javax.ws.rs.GET;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;


@Path("/posta")
public class getCityPsc
{
    @GET
    @Path("/obec/{obec}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPSC(@PathParam("obec")String city)throws SQLException
    {

        List<String> list = new MySQL().getCity(city);

        boolean x = false;

        String result = "{\"psc\":[";
        for (String temp : list) {
            if (x == true) {
                result += ',';
            } else
                x = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";

        return  result;
    }

    @GET
    @Path("/psc/{psc}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCityByPSC(@PathParam("psc") String psc)throws SQLException
    {
        List<String> list2 = new MySQL().getCityByPSC(psc);

        boolean x = false;

        String result = "{\"obec\":[";
        for (String temp : list2) {
            if (x == true) {
                result += ',';
            } else
                x = true;
            result += "\"" + temp + "\"";

        }
        result += "]})";

        return  result;
    }

}