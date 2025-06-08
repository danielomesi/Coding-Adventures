namespace MyWinFormsApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void wToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private async void getWeatherButton_Click(object sender, EventArgs e)
        {
            string cityName = cityTextBox.Text;
            if (string.IsNullOrEmpty(cityName)) { MessageBox.Show("Please enter a city name"); }
            else
            {
                Coordinates coordinates = await WeatherService.getCoordinatesByCityName(cityName);
                if (coordinates == null)
                {
                    MessageBox.Show("Couldn't find a city with that name");
                    return;
                }
                String longitude = coordinates.getLongitude().ToString();
                String latitude = coordinates.getLatitude().ToString();
                bigTextBox.Text = $"longitude: {longitude}, latitude: {latitude}";
                WeatherStatus weatherStatus = await WeatherService.GetWeatherDataByCoordinates(coordinates.getLatitude(), coordinates.getLongitude());
                if (weatherStatus != null)
                {
                    bigTextBox.Text = weatherStatus.ToString();
                    timeLabel.Text = weatherStatus.Time.ToString();
                    temperatureLabel.Text = weatherStatus.Temperature.ToString();
                    windSpeedLabel.Text = weatherStatus.Windspeed.ToString() + "km/h";
                    windDirectionLabel.Text = weatherStatus.WindDirection.ToString() + "°";
                    string pictureName = weatherStatus.IsDay ? "day.png" : "night.png";
                    string imagePath = Path.Combine(Directory.GetParent(Application.StartupPath).Parent.Parent.Parent.FullName, "images", pictureName);
                    dayOrNightPictureBox.Image = Image.FromFile(imagePath);
                }
            }
        }

    }
}