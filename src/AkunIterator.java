import java.util.ArrayList;
import java.util.Iterator;

//This class is responsible the Iterator design pattern

public class AkunIterator implements Iterator {
    ArrayList<Akun> databaseAkun;

    public AkunIterator(ArrayList<Akun> accounts2) {
        this.databaseAkun = accounts2;
    } //This obtains an already existing ArrayList for use within this class.


    //This function returns true if the ArrayList has a space next to the current one
    public boolean hasNext(int position) {
        if (position >= databaseAkun.size()) {
            return false;
        } else {
            return true;
        }
    }

    public Object next(int position) {
        Akun AccountItem = databaseAkun.get(position);
        return AccountItem;
    }

    //This function checks when the position is at 0, and prevents the user from going back even further.
    public boolean hasPrev(int position) {
        if(position == 0)
            return false;
        else
            return true;
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }
}




