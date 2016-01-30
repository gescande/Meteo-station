package meteoSpringBoot.weatherStatement;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "weather")
public class Weather implements Comparable<Weather>
{
    @Id
    @JsonProperty
    private String id;
    @JsonProperty
    private Humidity humidity;
    @JsonProperty
    private Luminosity luminosity;
    @JsonProperty
    private Temperature temperature;
    @JsonProperty
    private Date date;

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public Humidity getHumidity()
    {
        return humidity;
    }

    public void setHumidity(final Humidity humidity)
    {
        this.humidity = humidity;
    }

    public Luminosity getLuminosity()
    {
        return luminosity;
    }

    public void setLuminosity(final Luminosity luminosity)
    {
        this.luminosity = luminosity;
    }

    public Temperature getTemperature()
    {
        return temperature;
    }

    public void setTemperature(final Temperature temperature)
    {
        this.temperature = temperature;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(final Date date)
    {
        this.date = date;
    }

    public Weather(){}

    public Weather(final Humidity humidity, final Luminosity luminosity, final Temperature temperature, final Date date)
    {
        this.humidity = humidity;
        this.luminosity = luminosity;
        this.temperature = temperature;
        this.date = date;
    }

    /*@Override
    public String toString()
    {
        return String.format("Weather[date=%s, humidity=%s, luminosity=%s, temperature=%s]",date, humidity.toString(),luminosity.toString(),temperature.toString());
    }*/

    @Override
    public int compareTo(final Weather o)
    {
        if (getDate() == null || o.getDate() == null)
        {
            return 0;
        }
        return getDate().compareTo(o.getDate());
    }
}
