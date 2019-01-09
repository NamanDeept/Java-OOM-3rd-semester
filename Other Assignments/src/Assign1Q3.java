

import java.util.Scanner;
class students{
    private String name;
    private String roll_num;
    students(String roll_num,String name)
    {
        this.name = name;
        this.roll_num = roll_num;
    }
    public String getName(){
        return this.name;
    }
    public String getRoll(){
        return this.roll_num;
    }
    public void display(){
        System.out.println(this.roll_num+" "+this.name);
    }
}
class t_a{
    private String name;
    private String roll_num;
    t_a(String roll_num,String name)
    {
        this.name = name;
        this.roll_num = roll_num;
    }
    public String getName(){
        return this.name;
    }
    public String getRoll(){
        return this.roll_num;
    }
    public void display(){
        System.out.println(this.roll_num+" "+this.name);
    }
}


class sorting_main
{
    void bubblesort(students s[],int n){
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
             if((s[j].getRoll()).compareTo((s[j+1].getRoll())) > 0 )
                 {
                  students temp = null;
                  temp = s[j];
                  s[j] = s[j+1];
                  s[j+1] = temp;
                 }
            }
        }
    }
}

class getData
{
    public static void main(String args[]){
        Scanner scr = new Scanner(System.in);
        int test = scr.nextInt();
        for(int j = 0; j < test ; j++){
            int number_ta = scr.nextInt();
            int number_students = scr.nextInt();
            int assign = scr.nextInt();
            students s[] = new students [number_students];
            t_a t[] = new t_a [number_ta];
            for(int i = 0 ; i < number_ta ; i++){
                String ta_roll = scr.next();
                String ta_name = scr.next();
                t[i] = new t_a (ta_roll,ta_name);
            }
            for(int i = 0 ; i < number_students ; i++){
                String student_roll = scr.next();
                String student_name = scr.next();
                s[i] = new students(student_roll,student_name);
            }
            sorting_main sm = new sorting_main();
            sm.bubblesort(s,number_students);
            for(int i = 0 ; i < number_students ; i ++){
                if((i/assign) < number_ta)
                {
                System.out.println(s[i].getRoll()+" "+s[i].getName()+" "+ t[i/assign].getRoll()+" "+t[i/assign].getName());
            }
            else
            {
                 System.out.println(s[i].getRoll()+" "+s[i].getName()+" "+ t[number_ta-1].getRoll()+" "+t[number_ta-1].getName());
            }
            }
        }
    }
    
}



