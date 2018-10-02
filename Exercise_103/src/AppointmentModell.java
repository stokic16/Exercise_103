
import java.util.ArrayList;
import javax.swing.AbstractListModel;



/**
 * @author Kilian Stöckler
 */
public class AppointmentModell extends AbstractListModel
{
    private ArrayList<Appointment> apts = new ArrayList<>();
    
    public void addApt(Appointment apt){
        apts.add(apt);
        fireIntervalAdded(this, apts.size()-1, apts.size()-1);
    }
    
    public void deleteApt(int idx){
        apts.remove(idx);
        fireIntervalRemoved(this, idx, idx);
    }
    
    public void changeApt(Appointment apt,int idx){
        Appointment a=apts.get(idx);
        a.setText(apt.getText());
        a.setTime(apt.getTime());
        fireContentsChanged(this, 0, apts.size()-1);
    }
    @Override
    public int getSize() {
        return apts.size();
    }

    @Override
    public Object getElementAt(int index) {
        return apts.get(index);
    }

}
