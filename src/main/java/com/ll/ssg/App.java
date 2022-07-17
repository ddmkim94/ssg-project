package com.ll.ssg;

import java.util.Scanner;

public class App {

    private Scanner sc;

    // 주입! -> DI!
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        exit:
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            switch (command) {
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    break;
                case "종료":
                    break exit;
            }
        }
    }
}
