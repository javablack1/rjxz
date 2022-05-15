
import java.util.ArrayList;
        import java.util.Random;
        import java.util.Scanner;
class Account{
    private  String cardID;
    private  String password;
    private  double money;
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
class Student extends  Account {

    private  String name;
    private int age;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
class Achievement{
    private double English;
    private double Math;
    private double Chinese;

    public double getEnglish() {
        return English;
    }

    public void setEnglish(double english) {
        English = english;
    }

    public double getMath() {
        return Math;
    }

    public void setMath(double math) {
        Math = math;
    }

    public double getChinese() {
        return Chinese;
    }

    public void setChinese(double chinese) {
        Chinese = chinese;
    }
}
public class  Test{
    public static void main(String[] args) {
        ArrayList<Student> Student = new ArrayList<>();
        ArrayList<Achievement> Achievement=new ArrayList<>();
        Achievement achievement=new Achievement();
        Student s1=new Student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*************************************************");
            System.out.println("******************牛牛大学管理系统******************");
            System.out.println("                   1.学生登录                      ");
            System.out.println("                   2.教师登录                      ");
            System.out.println("*************************************************");
            System.out.println("请输入你的操作：");

            int commmand = sc.nextInt();
            switch (commmand) {
                case 1:
                    studententer(sc,s1,Student,achievement);
                    break;
                case 2:
                    teacherenter(sc,Achievement,s1,achievement);

                    break;
                default:
                    System.out.println("你的输入有误，请重新输入：");
            }

        }

    }
    //教师登录
    private static void teacherenter(Scanner sc, ArrayList<Achievement> achievement, Student s1, Achievement achievement1) {

        Student s2=new Student();
        System.out.println("请输入您的姓名：");
        String name=sc.next();
        s2.setName(name);
        System.out.println("欢迎您的到来！"+s2.getName()+"老师，您的学生"+s1.getName()+"刚刚登录了系统未查询到成绩，请您尽快录入成绩！");
        System.out.println("English:");
        double english=sc.nextDouble();
        achievement1.setEnglish(english);
        System.out.println("Chinese:");
        double chinese=sc.nextDouble();
        achievement1.setChinese(chinese);
        System.out.println("Math:");
        double math=sc.nextDouble();
        achievement1.setMath(math);
        System.out.println("成绩录入成功！");
        return;
    }
    //学生登录：
    private static void studententer(Scanner sc, Student s1, ArrayList<Student> student, Achievement achievement) {
        while (true) {
            System.out.println("*************************************************");
            System.out.println("******************学生登录系统*********************");
            System.out.println("                   1.登录                      ");
            System.out.println("                   2.注册                      ");
            System.out.println("*************************************************");
            System.out.println("请输入你的操作：");

            int commmand = sc.nextInt();
            switch (commmand) {
                case 1:
                    enter(sc,s1,student, achievement);
                    break;
                case 2:
                    register(sc,s1,student) ;
                    return;
                default:
                    System.out.println("你的输入有误，请重新输入：");
            }

        }

    }
    //学生注册账号：
    private static void register(Scanner sc, Student s1, ArrayList<Student> student) {
        System.out.println("你好！欢迎来到注册页面！");
        System.out.println("请输入您的姓名:");
        String name=sc.next();
        s1.setName(name);
        System.out.println("请输入您的年龄:");
        int age=sc.nextInt();
        s1.setAge(age);
        while (true){
            System.out.println("请输入你的密码：");
            String password= sc.next();
            System.out.println("请再次输入你的密码：");
            String passwordagain=sc.next();
            if(password.equals(passwordagain)){
                s1.setPassword(password);
                System.out.println("密码设置完成！！!");
                break;
            }
            else{
                System.out.println("俩次输入的密码不一致，请重新设置密码：");
            }
        }
        String carid=GetID();
        s1.setCardID(carid);
        System.out.println("id以获取成功");
        student.add(s1);
        System.out.println(s1.getName()+"同学,"+"恭喜你注册成功，正式成为我们牛牛大学的一份子，ID号："+s1.getCardID());
        return;

    }
    //学生获取账号ID
    private static String GetID(){
        String cardId="0";
        Random t=new Random();
        for (int i = 0; i <8 ; i++) {
            cardId+=t.nextInt(10);
        }
        return cardId;
    }
    //学生已注册账号直接登录：
    private static void enter(Scanner sc, Student s1, ArrayList<Student> student,Achievement achievement) {
        if (student.size()==0) {
            System.out.println("你还未注册账户！！！");
            return;
        }
        System.out.println("请输入你的ID号：");
        String id=sc.next();
        if(id.equals(s1.getCardID())) {
            System.out.println("请输入密码：");
            while (true) {
                String password = sc.next();
                if (password.equals(s1.getPassword())) {
                    System.out.println("密码正确。");
                    System.out.println("登录成功。");
                    System.out.println("欢迎你的到来，"+s1.getName()+"同学");
                    Menu(sc,s1,student,achievement);
                    return;
                } else {
                    System.out.println("密码错误，请重新输入：");
                }
            }
        }else{
            System.out.println("账号输入错误，请重新输入！");}
    }
    private static void Menu(Scanner sc, Student s1, ArrayList<Student> student,Achievement achievement) {

        while(true){
            System.out.println("*************************************************");
            System.out.println("******************学生操作系统*********************");
            System.out.println("                   1.查询成绩                      ");
            System.out.println("                   2.充值校园卡                      ");
            System.out.println("                   4.退出登录                      ");
            System.out.println("*************************************************");
            System.out.println("请输入你的操作：");
            int command=sc.nextInt();
            switch (command){
                case 1:
                    showAccount(achievement,s1);
                    break;
                case 2:
                    depositMoney(s1,sc,student);
                    break;
                case 4:
                    System.out.println("退出成功！！！欢迎下次登录！！！");
                    return;
                default:
                    System.out.println("输入不正确，请重新输入");
            }
        }
    }
    private static void depositMoney(Student s1, Scanner sc, ArrayList<Student> student) {
        System.out.println("请输入你需要充值的金额：");
        double money=sc.nextDouble();
        if(money>10000){
            System.out.println("你充值的金额过大，无法充值！！！ ");
        }
        else  if(money<0){
            System.out.println("输入的金额错误，请重新输入！！1");
        }
        else{
            s1.setMoney(money);
            student.add(s1);
            System.out.println("充值成功");
            System.out.println("账户信息如下");
            System.out.println("姓名:"+s1.getName());
            System.out.println("卡号:"+s1.getCardID());
            System.out.println("余额:"+s1.getMoney());
        }
    }
    private static void showAccount(Achievement achievement,Student s1) {
        if(achievement.getEnglish()==0){
            System.out.println("您的成绩还未录入，请即使联系教务处老师17356279531");
            return;
        }
        if(achievement.getEnglish()>0){
            System.out.println("你好！"+s1.getName()+"同学，你的各科成绩为：");
            System.out.println("英语："+achievement.getEnglish());
            System.out.println("数学："+achievement.getMath());
            System.out.println("语文："+achievement.getChinese());
            return;
        }
    }
}
