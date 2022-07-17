package com.ll.ssg.controller;

import com.ll.ssg.Rq;
import com.ll.ssg.WiseSaying;
import com.ll.ssg.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService wiseSayingService;


    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wiseSayingList = wiseSayingService.findAll();

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

        WiseSaying wiseSaying = wiseSayingService.add(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("수정할 명언의 아이디를 입력해주세요");
            return;
        }

        WiseSaying wiseSaying = wiseSayingService.findById(id);
        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        wiseSayingService.update(id, content, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    // 명언 삭제
    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("삭제할 명언의 아이디를 입력해주세요");
            return;
        }

        WiseSaying findWiseSaying = wiseSayingService.findById(id);
        if (findWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayingService.delete(id);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

}
