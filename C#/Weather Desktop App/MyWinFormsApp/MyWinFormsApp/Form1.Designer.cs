namespace MyWinFormsApp
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            components = new System.ComponentModel.Container();
            contextMenuStrip1 = new ContextMenuStrip(components);
            tabControl1 = new TabControl();
            homeTab = new TabPage();
            label4 = new Label();
            weatherTab = new TabPage();
            groupBox1 = new GroupBox();
            windDirectionLabel = new Label();
            label7 = new Label();
            dayOrNightPictureBox = new PictureBox();
            windSpeedLabel = new Label();
            label5 = new Label();
            temperatureLabel = new Label();
            label3 = new Label();
            timeLabel = new Label();
            label2 = new Label();
            bigTextBox = new TextBox();
            getWeatherButton = new Button();
            cityTextBox = new TextBox();
            label1 = new Label();
            tabControl1.SuspendLayout();
            homeTab.SuspendLayout();
            weatherTab.SuspendLayout();
            groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)dayOrNightPictureBox).BeginInit();
            SuspendLayout();
            // 
            // contextMenuStrip1
            // 
            contextMenuStrip1.ImageScalingSize = new Size(24, 24);
            contextMenuStrip1.Name = "contextMenuStrip1";
            contextMenuStrip1.Size = new Size(61, 4);
            // 
            // tabControl1
            // 
            tabControl1.Controls.Add(homeTab);
            tabControl1.Controls.Add(weatherTab);
            tabControl1.Location = new Point(12, 12);
            tabControl1.Name = "tabControl1";
            tabControl1.SelectedIndex = 0;
            tabControl1.Size = new Size(791, 442);
            tabControl1.TabIndex = 2;
            // 
            // homeTab
            // 
            homeTab.Controls.Add(label4);
            homeTab.Location = new Point(4, 34);
            homeTab.Name = "homeTab";
            homeTab.Padding = new Padding(3);
            homeTab.Size = new Size(783, 404);
            homeTab.TabIndex = 0;
            homeTab.Text = "Home";
            homeTab.UseVisualStyleBackColor = true;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Font = new Font("Segoe UI", 20F, FontStyle.Regular, GraphicsUnit.Point);
            label4.Location = new Point(64, 144);
            label4.Name = "label4";
            label4.Size = new Size(634, 54);
            label4.TabIndex = 0;
            label4.Text = "Welcome to a simple weather app!";
            // 
            // weatherTab
            // 
            weatherTab.Controls.Add(groupBox1);
            weatherTab.Controls.Add(bigTextBox);
            weatherTab.Controls.Add(getWeatherButton);
            weatherTab.Controls.Add(cityTextBox);
            weatherTab.Controls.Add(label1);
            weatherTab.Location = new Point(4, 34);
            weatherTab.Name = "weatherTab";
            weatherTab.Padding = new Padding(3);
            weatherTab.Size = new Size(783, 404);
            weatherTab.TabIndex = 1;
            weatherTab.Text = "Weather";
            weatherTab.UseVisualStyleBackColor = true;
            // 
            // groupBox1
            // 
            groupBox1.Controls.Add(windDirectionLabel);
            groupBox1.Controls.Add(label7);
            groupBox1.Controls.Add(dayOrNightPictureBox);
            groupBox1.Controls.Add(windSpeedLabel);
            groupBox1.Controls.Add(label5);
            groupBox1.Controls.Add(temperatureLabel);
            groupBox1.Controls.Add(label3);
            groupBox1.Controls.Add(timeLabel);
            groupBox1.Controls.Add(label2);
            groupBox1.Location = new Point(18, 122);
            groupBox1.Name = "groupBox1";
            groupBox1.Size = new Size(398, 270);
            groupBox1.TabIndex = 4;
            groupBox1.TabStop = false;
            groupBox1.Text = "Weather Details";
            // 
            // windDirectionLabel
            // 
            windDirectionLabel.AutoSize = true;
            windDirectionLabel.Location = new Point(158, 149);
            windDirectionLabel.Name = "windDirectionLabel";
            windDirectionLabel.Size = new Size(0, 25);
            windDirectionLabel.TabIndex = 8;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(18, 149);
            label7.Name = "label7";
            label7.Size = new Size(134, 25);
            label7.TabIndex = 7;
            label7.Text = "Wind Direction:";
            // 
            // dayOrNightPictureBox
            // 
            dayOrNightPictureBox.Location = new Point(242, 120);
            dayOrNightPictureBox.Name = "dayOrNightPictureBox";
            dayOrNightPictureBox.Size = new Size(150, 144);
            dayOrNightPictureBox.SizeMode = PictureBoxSizeMode.StretchImage;
            dayOrNightPictureBox.TabIndex = 6;
            dayOrNightPictureBox.TabStop = false;
            // 
            // windSpeedLabel
            // 
            windSpeedLabel.AutoSize = true;
            windSpeedLabel.Location = new Point(137, 112);
            windSpeedLabel.Name = "windSpeedLabel";
            windSpeedLabel.Size = new Size(0, 25);
            windSpeedLabel.TabIndex = 5;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(18, 112);
            label5.Name = "label5";
            label5.Size = new Size(113, 25);
            label5.TabIndex = 4;
            label5.Text = "Wind Speed:";
            // 
            // temperatureLabel
            // 
            temperatureLabel.AutoSize = true;
            temperatureLabel.Location = new Point(138, 78);
            temperatureLabel.Name = "temperatureLabel";
            temperatureLabel.Size = new Size(0, 25);
            temperatureLabel.TabIndex = 3;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(18, 78);
            label3.Name = "label3";
            label3.Size = new Size(114, 25);
            label3.TabIndex = 2;
            label3.Text = "Temperature:";
            // 
            // timeLabel
            // 
            timeLabel.AutoSize = true;
            timeLabel.Location = new Point(83, 47);
            timeLabel.Name = "timeLabel";
            timeLabel.Size = new Size(0, 25);
            timeLabel.TabIndex = 1;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(18, 47);
            label2.Name = "label2";
            label2.Size = new Size(59, 25);
            label2.TabIndex = 0;
            label2.Text = "Time: ";
            // 
            // bigTextBox
            // 
            bigTextBox.Location = new Point(532, 27);
            bigTextBox.Multiline = true;
            bigTextBox.Name = "bigTextBox";
            bigTextBox.Size = new Size(225, 198);
            bigTextBox.TabIndex = 3;
            bigTextBox.TextChanged += textBox1_TextChanged;
            // 
            // getWeatherButton
            // 
            getWeatherButton.BackColor = Color.LightSkyBlue;
            getWeatherButton.Location = new Point(249, 27);
            getWeatherButton.Name = "getWeatherButton";
            getWeatherButton.Size = new Size(167, 65);
            getWeatherButton.TabIndex = 2;
            getWeatherButton.Text = "Get Current Weather";
            getWeatherButton.UseVisualStyleBackColor = false;
            getWeatherButton.Click += getWeatherButton_Click;
            // 
            // cityTextBox
            // 
            cityTextBox.Location = new Point(70, 44);
            cityTextBox.Name = "cityTextBox";
            cityTextBox.Size = new Size(150, 31);
            cityTextBox.TabIndex = 1;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(18, 44);
            label1.Name = "label1";
            label1.Size = new Size(46, 25);
            label1.TabIndex = 0;
            label1.Text = "City:";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(10F, 25F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(tabControl1);
            Name = "Form1";
            Text = "My Weather App";
            Load += Form1_Load;
            tabControl1.ResumeLayout(false);
            homeTab.ResumeLayout(false);
            homeTab.PerformLayout();
            weatherTab.ResumeLayout(false);
            weatherTab.PerformLayout();
            groupBox1.ResumeLayout(false);
            groupBox1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)dayOrNightPictureBox).EndInit();
            ResumeLayout(false);
        }

        #endregion
        private ContextMenuStrip contextMenuStrip1;
        private TabControl tabControl1;
        private TabPage homeTab;
        private TabPage weatherTab;
        private Button getWeatherButton;
        private TextBox cityTextBox;
        private Label label1;
        private TextBox bigTextBox;
        private GroupBox groupBox1;
        private Label timeLabel;
        private Label label2;
        private Label label4;
        private Label label5;
        private Label temperatureLabel;
        private Label label3;
        private PictureBox dayOrNightPictureBox;
        private Label windSpeedLabel;
        private Label windDirectionLabel;
        private Label label7;
    }
}