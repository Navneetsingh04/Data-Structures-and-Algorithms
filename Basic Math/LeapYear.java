import java.util.Scanner;
public class LeapYear {
    public static boolean leapYear(int year){
        if(year%400 == 0 && year%100 == 0){
            return true;
        }
        else if(year%4== 0&& year%100 != 0){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = s.nextInt();
        boolean isleapyear = leapYear(year);
        if(isleapyear){
            System.out.println(year +" is a Leap Year");
        }
        else{
            System.out.println(year+" is not a Leap Year");
        }
        s.close();
    }
}
