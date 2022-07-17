package com.ll.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    private List<WiseSaying> wiseSayingList;

    // 주입! -> DI!
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingList = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        int wiseSayingLastId = 0;

        exit:
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            switch (command) {
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
                        WiseSaying wiseSaying = wiseSayingList.get(i);
                        System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());
                    }

                    break;
                case "등록":
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();

                    int id = ++wiseSayingLastId;
                    WiseSaying wiseSaying = new WiseSaying(id, content, author);
                    wiseSayingList.add(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "종료":
                    break exit;
            }
        }
    }
}
