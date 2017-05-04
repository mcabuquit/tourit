package android.login.com.tourit.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Denzel on 05/03/2017.
 */
@Table(name = "Location")
public class Location extends Model{
    @Column(name = "location")
    String location;

    public static List<Location> getAvailableLocations(){
        return new Select().from(Location.class).execute();
    }

    public static Location getLocationByName(String location){
        return new Select().from(Location.class).where("location = ?", location).executeSingle();
    }


    @Override
    public String toString() {
        return this.location;
    }
}
