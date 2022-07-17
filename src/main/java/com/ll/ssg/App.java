package com.ll.ssg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    int wiseSayingLastId;
    private List<WiseSaying> wiseSayingList;

    // 주입! -> DI!
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingLastId = 0;
        wiseSayingList = new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 SSG ==");

        exit:
        while (true) {
            System.out.print("명령) ");
            String command = sc.nextLine().trim();

            Rq rq = new Rq(command);

            switch (rq.getPath()) {
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
                case "수정":
                    modify(rq);
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "종료":
                    break exit;
            }
        }
    }

    private void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("수정할 명언의 아이디를 입력해주세요");
            return;
        }

        WiseSaying findWiseSaying = findById(id);
        if (findWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", findWiseSaying.getContent());
        System.out.print("명언 : ");
        findWiseSaying.setContent(sc.nextLine());

        System.out.printf("작가(기존) : %s\n", findWiseSaying.getAuthor());
        System.out.print("작가 : ");
        findWiseSaying.setAuthor(sc.nextLine());

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    // 명언 삭제
    private void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("삭제할 명언의 아이디를 입력해주세요");
            return;
        }

        WiseSaying findWiseSaying = findById(id);
        if (findWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingList.remove(findWiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    // 번호로 명언 찾기
    private WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
