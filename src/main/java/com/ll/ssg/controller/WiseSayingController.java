package com.ll.ssg.controller;

import com.ll.ssg.Rq;
import com.ll.ssg.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final List<WiseSaying> wiseSayingList;
    private int wiseSayingLastId; // 계속 갱신되야 하는 숫자이기 때문에 final 키워드 no!

    public WiseSayingController(Scanner sc) {
        wiseSayingLastId = 0;
        wiseSayingList = new ArrayList<>();
        this.sc = sc;
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor());
        }
    }

    public void write(Rq rq) {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void modify(Rq rq) {
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
    public void remove(Rq rq) {
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