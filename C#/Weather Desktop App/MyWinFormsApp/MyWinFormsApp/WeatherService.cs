using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Text.Json;
using System.Reflection.Metadata;

namespace MyWinFormsApp
{
    public class WeatherService
    {
        public const String NOMINATIM_API_BASE_URL_START = "https://nominatim.openstreetmap.org/search?q=";
        public const String NOMINATIM_API_BASE_URL_ENDING = "&format=json&limit=1";
        public const String NOMINATION_API_LATITUDE_PROPERY_NAME = "lat";
        public const String NOMINATION_API_LONGITUDE_PROPERY_NAME = "lon";


        public static async Task<Coordinates> getCoordinatesByCityName(string cityName)
        {
            Coordinates result = null;
            String url = NOMINATIM_API_BASE_URL_START + cityName + NOMINATIM_API_BASE_URL_ENDING;
            using (HttpClient client = new HttpClient())
            {
                client.DefaultRequestHeaders.UserAgent.ParseAdd("MyWinFormsApp/1.0");
                HttpResponseMessage response = await client.GetAsync(url);
                if (response.IsSuccessStatusCode)
                {
                    string json = await response.Content.ReadAsStringAsync();  
                    using JsonDocument doc = JsonDocument.Parse(json);
                    JsonElement root = doc.RootElement;
                    if (root.GetArrayLength() > 0)
                    {
                        JsonElement firstItem = root[0];
                        double latitude = Double.Parse(firstItem.GetProperty(NOMINATION_API_LATITUDE_PROPERY_NAME).GetString());
                        double longitude = Double.Parse(firstItem.GetProperty(NOMINATION_API_LONGITUDE_PROPERY_NAME).GetString());

                        result = new Coordinates(latitude, longitude);
                    }

                }
               
            }
            return result;
           
        }

        public static async Task<WeatherStatus> GetWeatherDataByCoordinates(double latitude, double longitude)
        {
            string baseUrl = "https://api.open-meteo.com/v1/forecast";
            string queryParams = $"?latitude={latitude}&longitude={longitude}&current_weather=true";
            string url = baseUrl + queryParams;
            WeatherStatus weatherStatus = null;
            using (HttpClient client = new HttpClient())
            {
                
                HttpResponseMessage response = await client.GetAsync(url);
                string json = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    weatherStatus = WeatherStatus.ParseWeatherStatus(json);
                }

                return weatherStatus;
                
            }
        }


    }
}
