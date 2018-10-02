
import java.io.Serializable;
import java.time.LocalDateTime;



/**
 * @author Kilian Stöckler
 */
public class Appointment implements Serializable{

    private String text;
    private LocalDateTime time;

    public Appointment(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    
}
