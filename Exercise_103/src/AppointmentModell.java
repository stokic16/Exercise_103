
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 * @author Kilian Stöckler
 */
public class AppointmentModell extends AbstractListModel {

    private ArrayList<Appointment> apts = new ArrayList<>();

    public void addApt(Appointment apt) {
        apts.add(apt);
        fireIntervalAdded(this, apts.size() - 1, apts.size() - 1);
    }

    public void deleteApt(int idx) {
        apts.remove(idx);
        fireIntervalRemoved(this, idx, idx);
    }

    public void changeApt(Appointment apt, int idx) {
        Appointment a = apts.get(idx);
        a.setText(apt.getText());
        a.setTime(apt.getTime());
        fireContentsChanged(this, 0, apts.size() - 1);
    }

    public void save(File f) throws Exception {
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Appointment apt : apts) {
            oos.writeObject(apt);
        }
        
        fos.flush();
        fos.close();
    }
        public void load(File f) throws Exception {
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object input;
        try{
            while ((input = ois.readObject()) != null) {
            if (input instanceof Appointment) {
                apts.add((Appointment) input);
            }
        }
        }catch(EOFException ex){
            
        }
        ois.close();
        fis.close();
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
