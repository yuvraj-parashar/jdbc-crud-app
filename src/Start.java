import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException{
		System.out.println("Welcome to Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Exit App");
			int c = Integer.parseInt(br.readLine());
			if(c == 1){
				//add student...
				System.out.println("Enter Username: ");
				String name = br.readLine();
				
				System.out.println("Enter User Phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter User city: ");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if(answer){
					System.out.println("Student is added successfully!!");
				}else{
					System.out.println("Something went wrong :(");
				}
				System.out.println(st);
				
			}else if(c == 2){
				//delete student...
				
				System.out.println("Enter Student ID to delete: ");
				int userID = Integer.parseInt(br.readLine());
				boolean res = StudentDao.deleteStudent(userID);
				if(res){
					System.out.println("Successfully Deleted!!");
				}else{
					System.out.println("Something went wrong");
				}
				
			}else if(c == 3){
				//display student...
				StudentDao.showAllStudent();
				
			}else if(c == 4){
				//exit
				break;
			}else{
				
			}
			
		}
		System.out.println("Thank You for using my Application...");
		System.out.println("See you soon... Bye Bye!");
	}

}
