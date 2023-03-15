import DAO.ScoreDAO;
import Model.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ScoreDAO scoreDAO = new ScoreDAO();
    public static void Menu(){
        System.out.println("================== QUAN LY DIEM =================");
        System.out.println("===== 1. Them moi sinh vien               =======");
        System.out.println("===== 2. Cap nhat thong tin sinh vien     =======");
        System.out.println("===== 3. Xoa sinh vien theo ma sinh vien  =======");
        System.out.println("===== 4. In danh sach sinh vien           =======");
        System.out.println("===== 5. Tim sinh vien theo Ma sinh vien  =======");
        System.out.println("===== 6. Tim sinh vien theo Ten sinh vien =======");
        System.out.println("=================================================");
    }
    public static void option1(Scanner in){
        Score score = new Score();
        System.out.println("Nhap ten:");
        String ten = in.nextLine();
        score.setStdName(ten);
        //
        System.out.println("Nhap tuoi:");
        int tuoi = Integer.parseInt(in.nextLine());
        score.setStdAge(tuoi);
        //
        System.out.println("Nhap lop:");
        String lop = in.nextLine();
        score.setStdClass(lop);
        //
        System.out.println("Nhap diem:");
        double gpa = Double.parseDouble(in.nextLine());
        score.setStdGPA(gpa);
        //
        System.out.println("Nhap gioi tinh:");
        String gender = in.nextLine();
        score.setStdGender(gender);
        scoreDAO.insertStd(score);
    }
    public static void option4(){
        List<Score> scoreList = scoreDAO.getAll();
        for (int i = 0; i < scoreList.size(); i++){
            Score score = scoreList.get(i);
            System.out.println(score);
        }
    }

    public static void option5(Scanner in) {
        System.out.println("Nhap id can tim:");
        int id = in.nextInt();
        System.out.println(scoreDAO.getById(id));
    }

    public static void option6(Scanner in){
        System.out.println("Nhap ten can tim:");
        String name = in.nextLine();
        System.out.println(scoreDAO.getByName(name));
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;
        do {
            Menu();
            try {
                System.out.println("Nhap option: ");
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Sai dinh dang");
            }
            if (option <= 0 || option > 6) {
                System.out.println("Moi nhap lai");
                continue;
            }
            switch (option) {
                case 1:
                    option1(in);
                    break;
                case 2:
                case 3:
                case 4:
                    option4();
                    break;
                case 5:
                    option5(in);
                    break;
                case 6:
                    option6(in);
                    break;
            }
        } while (option != 7);
    }
}
