package com.mycom.springmybatisboard.board.dto;

import java.util.List;

public class BoardResultDto {
    private String result; // 요청결과
    private List<BoardDto> list; // 목록
    private BoardDto dto; // 상세
    private int count;

    public BoardResultDto() {}

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<BoardDto> getList() {
        return list;
    }

    public void setList(List<BoardDto> list) {
        this.list = list;
    }

    public BoardDto getDto() {
        return dto;
    }

    public void setDto(BoardDto dto) {
        this.dto = dto;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BoardResultDto{" +
                "result='" + result + '\'' +
                ", list=" + list +
                ", dto=" + dto +
                ", count=" + count +
                '}';
    }
}
