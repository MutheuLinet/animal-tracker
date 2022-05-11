package models;

import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;

public class Sightings implements SightingsManagement{
    private int animalId;
    private int id;
    private String animalName;
    private String location;
    private String ranger;
    private Timestamp timestamp;

    public Sightings(int animalId, String location, String ranger) {
        if (ranger.equals("")){
            throw new IllegalArgumentException("Please enter the Ranger's name");
        }
        this.animalId = animalId;
        this.location = location;
        this.ranger = ranger;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRanger() {
        return ranger;
    }

    public void setRanger(String ranger) {
        this.ranger = ranger;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    //Overriding save  method && implement method save() from sighting management class

    @Override
    public void save() {
        String sql = "INSERT INTO sightings (animalId, location, ranger, timestamp) VALUES (:animalId, :location, :ranger, now());";
        System.out.println("INSERT INTO sightings (animalId, location, ranger, timestamp) VALUES (:animalId, :location, :ranger, now());");
        try (Connection con = DB.sql2o.open()) {
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("location", this.location)
                    .addParameter("ranger", this.ranger)
                    .executeUpdate()
                    .getKey();
        }
    }

    //Listing all sightings from  sightings table
    public static List<Sightings> all() {
        String sql = "SELECT * FROM sightings ORDER BY timestamp DESC;";

        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
        }
    }

    //Listing sighting by animal id
    public static List<Sightings> allByAnimal(int animalId) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE animalId = :animalId ORDER BY timestamp DESC";
            return con.createQuery(sql)
                    .addParameter("animalId", animalId)
                    .executeAndFetch(Sightings.class);
        }
    }

    //Overriding sighting
    public boolean equals(Object otherSighting){
        if(!(otherSighting instanceof Sightings)){
            return false;
        }else{
            Sightings newSighting = (Sightings) otherSighting;
            return this.getAnimalId()==newSighting.getAnimalId() && this.getRanger().equals(newSighting.getRanger());
        }
    }

    // finding a sighting using its id && with unchecked exception  that ensures index number entered by the user is within the range of the array.
    public static Sightings find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings WHERE id=:id;";
            Sightings sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sightings.class);
            return sighting;
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    //implement method delete() from Database management class
    public void delete(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id=:id;";
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    //update the sighting table && throwing an exception incase the id is not mapped
    public void update() {
        String sql = "UPDATE sightings SET location = :location, ranger = :ranger WHERE id = :id";

        try(Connection con = DB.sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("location", location)
                    .addParameter("ranger", ranger)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }


}
