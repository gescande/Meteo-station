package meteoSpringBoot.persistance;

import org.springframework.data.mongodb.repository.MongoRepository;

import meteoSpringBoot.weatherStatement.Weather;

public interface WeatherDirectory extends MongoRepository<Weather, String>
{
}
