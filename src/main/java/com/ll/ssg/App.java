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
            String command = sc.nextLine();

            switch (command) {
                case "종료":
                    break exit;
            }
        }
    }
}
