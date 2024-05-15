import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class Main extends Frame {
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private Label timeLabel;
    private Label dayLabel;
    private Label dateLabel;
    private String time;
    private String day;
    private String date;
    private boolean is24HourFormat;

    public Main() {
        this.setTitle("Digital Clock");
        this.setLayout(new FlowLayout());
        this.setSize(350, 250);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");

        timeLabel = new Label();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timeLabel.setForeground(Color.GREEN);

        dayLabel = new Label();
        dayLabel.setFont(new Font("Arial", Font.BOLD, 35));
        dayLabel.setForeground(Color.YELLOW);

        dateLabel = new Label();
        dateLabel.setFont(new Font("Arial", Font.BOLD, 25));
        dateLabel.setForeground(Color.ORANGE);

        Button toggle12HourButton = new Button("12-Hour");
        toggle12HourButton.setBackground(Color.BLUE);
        toggle12HourButton.setForeground(Color.WHITE);
        toggle12HourButton.setFont(new Font("Arial", Font.BOLD, 14));
        toggle12HourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                set12HourFormat();
            }
        });

        Button toggle24HourButton = new Button("24-Hour");
        toggle24HourButton.setBackground(Color.RED);
        toggle24HourButton.setForeground(Color.WHITE);
        toggle24HourButton.setFont(new Font("Arial", Font.BOLD, 14));
        toggle24HourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                set24HourFormat();
            }
        });

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(toggle12HourButton);
        this.add(toggle24HourButton);
        this.setVisible(true);

        set24HourFormat(); 
        setTime();
    }

    public void setTime() {
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void set12HourFormat() {
        timeFormat.applyPattern("hh:mm:ss a");
        is24HourFormat = false;
    }

    private void set24HourFormat() {
        timeFormat.applyPattern("HH:mm:ss");
        is24HourFormat = true;
    }

    public static void main(String[] args) {
        new Main();
    }
}
