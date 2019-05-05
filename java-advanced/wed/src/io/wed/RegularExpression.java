package io.wed;

import java.util.Scanner;

/**
 * 正则表达式之账号与密码的简单判断
 *
 * @author 徐鹏
 * 2019.5.5
 */
public class RegularExpression {
    public static void main(String[] args) {
        System.out.println("请输入您的账号：");
        //定义输入流
        Scanner scanner = new Scanner(System.in);
        //获取第一次输入的账号
        String account = scanner.nextLine();
        //判断
        if (account.matches("java")) {
            //防止机器人操作
            System.out.println("请您输入密码：");
            //获取密码
            String password = scanner.nextLine();
            if (password.matches("111")) {
                System.out.println("登录成功！");
            } else {
                while (true) {
                    System.out.println("密码有误！请重新输入！");
                    String sedPassword = scanner.nextLine();
                    if (sedPassword.matches("111")) {
                        System.out.println("密码正确！登录成功！");
                        break;
                    }
                }
            }
        } else {
            while (true) {
                System.out.println("账号有误！请重新输入！");
                String sedAccount = scanner.nextLine();
                if (sedAccount.matches("java")) {
                    System.out.println("账号正确！");
                    System.out.println("请您输入密码：");
                    String password = scanner.nextLine();
                    if (password.matches("111")) {
                        System.out.println("登录成功！");
                    } else {
                        while (true) {
                            System.out.println("密码有误！请重新输入！");
                            String sedPassword = scanner.nextLine();
                            if (sedPassword.matches("111")) {
                                System.out.println("密码正确！登录成功！");
                                break;
                            }
                        }
                    }
                }
//                break;
            }
        }
    }
}
