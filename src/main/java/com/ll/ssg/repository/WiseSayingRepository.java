package com.ll.ssg.repository;

import com.ll.ssg.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayingList;
    private int wiseSayingLastId; // 계속 갱신되야 하는 숫자이기 때문에 final 키워드 no!

    public WiseSayingRepository() {
        wiseSayingList = new ArrayList<>();
        wiseSayingLastId = 0;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }


    public WiseSaying add(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public void update(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public void delete(int id) {
        WiseSaying wiseSaying = findById(id);
        wiseSayingList.remove(wiseSaying);
    }

    // 번호로 명언 찾기
    public WiseSaying findById(int id) {
        for (WiseSaying wiseSaying : wiseSayingList) {
            if (wiseSaying.getId() == id) {
                return wiseSaying;
            }
        }
        return null;
    }
}
