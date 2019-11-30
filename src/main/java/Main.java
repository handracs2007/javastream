import dto.ClassRoom;
import dto.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main ( String[] args ) {
        // Let's add 100 students to the ClassRoom
        ClassRoom classRoom = new ClassRoom ( );

        for ( int i = 0 ; i < 100 ; i++ ) {
            int age = ( int ) ( Math.random ( ) * 20.0 + 1.0 );
            String name = "Student" + ( i + 1 );

            Student student = new Student ( );
            student.setAge ( age );
            student.setName ( name );

            classRoom.add ( student );
        }

        // Test forEach
        classRoom.getStudents ( ).stream ( ).forEach ( student ->
            System.out.println ( "Name: " + student.getName ( ) + ", Age: " + student.getAge ( ) ) );

        // Test map and collect
        List studentNames = classRoom.getStudents ( ).stream ( )
            .map ( student -> student.getName ( ) ).collect ( Collectors.toList ( ) );
        studentNames.stream ( ).forEach ( System.out::println );

        // Test sum
        int sum = classRoom.getStudents ( ).stream ( )
            .mapToInt ( student -> student.getAge ( ) ).sum ( );
        System.out.println ( "Sum of age: " + sum );

        // Test filter
        classRoom.getStudents ( ).stream ( )
            .filter ( student -> student.getAge ( ) >= 15 && student.getAge ( ) <= 17 )
            .forEach ( student ->
                System.out.println ( "Name: " + student.getName ( ) + ", Age: " + student.getAge ( ) ) );
    }
}