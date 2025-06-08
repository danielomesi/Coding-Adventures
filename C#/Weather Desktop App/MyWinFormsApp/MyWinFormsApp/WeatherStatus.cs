using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace MyWinFormsApp
{
    public class WeatherStatus
    {
        public double Latitude { get; set; }
        public double Longitude { get; set; }
        public double Temperature { get; set; }          
        public double Windspeed { get; set; }            
        public double WindDirection { get; set; }       
        public bool IsDay { get; set; }

        private string _time;
        public string Time
        {
            get
            {
                if (string.IsNullOrEmpty(_time))
                {
                    return "";
                }

                // Parse the ISO8601 string
                if (DateTime.TryParse(_time, out DateTime parsedTime))
                {
                    // Specify UTC if appropriate
                    DateTime localTime = DateTime.SpecifyKind(parsedTime, DateTimeKind.Utc).ToLocalTime();
                    return localTime.ToString("yyyy-MM-dd HH:mm");
                }
                else
                {
                    return _time; // fallback
                }
            }
            set
            {
                _time = value;
            }
        }



        public override string ToString()
        {
            return $"Time: {Time}, Temp: {Temperature}°C, Wind: {Windspeed} km/h ({WindDirection}°), Daytime: {IsDay}";
        }

        public static WeatherStatus ParseWeatherStatus(string json)
        {
            using JsonDocument doc = JsonDocument.Parse(json);

            JsonElement root = doc.RootElement;

            double latitude = root.GetProperty("latitude").GetDouble();
            double longitude = root.GetProperty("longitude").GetDouble();

            JsonElement currentWeather = root.GetProperty("current_weather");
            string time = currentWeather.GetProperty("time").GetString();
            double temperature = currentWeather.GetProperty("temperature").GetDouble();
            double windspeed = currentWeather.GetProperty("windspeed").GetDouble();
            double windDirection = currentWeather.GetProperty("winddirection").GetDouble();
            bool isDay = currentWeather.GetProperty("is_day").GetInt32() == 1;
            

            return new WeatherStatus
            {
                Latitude = latitude,
                Longitude = longitude,
                Time = time,
                Temperature = temperature,
                Windspeed = windspeed,
                WindDirection = windDirection,
                IsDay = isDay,
                
            };
        }


    }
}
