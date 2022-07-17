package com.ll.ssg;

import com.ll.ssg.controller.WiseSayingController;

import java.util.Scanner;

public class App {

    private final Scanner sc;

    // 주입! -> DI!
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        exit:
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            Rq rq = new Rq(command);

            switch (rq.getPath()) {
                case "목록":
                    wiseSayingController.list(rq);
                    break;
                case "등록":
                    wiseSayingController.write(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "종료":
                    break exit;
            }
        }
    }
}
