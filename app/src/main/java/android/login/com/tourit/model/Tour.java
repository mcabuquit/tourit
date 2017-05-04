package android.login.com.tourit.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Denzel on 05/03/2017.
 */

@Table(name = "Tour")
public class Tour extends Model{
    @Column(name = "Amount")
    public long amount;

    @Column(name = "Section")
    public String section;

    @Column(name = "Description")
    public String description;

    @Column(name = "Location")
    public Location location;


    public static List<Tour> getTourSearch(long amount, String section, Location location){
        return new Select().from(Tour.class).where("Location = ?", location.getId())
                .and("Amount <= ? ", amount).and("Section = ?", section).execute();
    }



}
