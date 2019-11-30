package dto;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private List< Student > students = new ArrayList<> ( );

    public List< Student > getStudents ( ) {
        return students;
    }

    public void add ( Student student ) {
        this.students.add ( student );
    }
}
