package com.ll.ssg.repository;

import com.ll.ssg.App;
import com.ll.ssg.WiseSaying;
import com.ll.ssg.WiseSayingTable;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private final WiseSayingTable wiseSayingTable;

    public WiseSayingRepository() {
        wiseSayingTable = new WiseSayingTable(App.getBaseDir());
    }

    public List<WiseSaying> findAll() {
        return wiseSayingTable.findAll();
    }


    public WiseSaying add(String content, String author) {
        return wiseSayingTable.save(content, author);
    }

    public void update(int id, String content, String author) {
        wiseSayingTable.save(id, content, author);
    }

    public void delete(int id) {
        wiseSayingTable.removeById(id);
    }

    // 번호로 명언 찾기
    public WiseSaying findById(int id) {
        return wiseSayingTable.findById(id);
    }
}
