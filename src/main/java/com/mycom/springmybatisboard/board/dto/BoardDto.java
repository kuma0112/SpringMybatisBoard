package com.mycom.springmybatisboard.board.dto;


import java.time.LocalDateTime;
import java.util.Date;

import java.time.ZoneId;
public class BoardDto {
    private int boardId;
    private int userSeq;
    private String userName;
    private String userProfileImageUrl;
    private String title;
    private String content;
    private LocalDateTime regDt;
    private int readCount;

    // 게시글 상세(작성자와 현재 로그인 사용자가 동일인인지 여부)
    private boolean sameUser;

    public BoardDto() {};
    public BoardDto(int userSeq, String title, String content) {
        this.userSeq = userSeq;
        this.title = title;
        this.content = content;
    }

    public int getBoardId() {
        return boardId;
    }
    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
    public int getUserSeq() {
        return userSeq;
    }
    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }
    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getRegDt() {
        return regDt;
    }
    public void setRegDt(Date regDt) {
        this.regDt = LocalDateTime.ofInstant(
                regDt.toInstant(), ZoneId.systemDefault()
        );  // for Mybatis Date Mapping
    }
    public int getReadCount() {
        return readCount;
    }
    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }
    public boolean isSameUser() {
        return sameUser;
    }
    public void setSameUser(boolean sameUser) {
        this.sameUser = sameUser;
    }

    @Override
    public String toString() {
        return "BoardDto [boardId=" + boardId + ", userSeq=" + userSeq + ", userName=" + userName
                + ", userProfileImageUrl=" + userProfileImageUrl + ", title=" + title + ", content=" + content
                + ", regDt=" + regDt + ", readCount=" + readCount + ", sameUser=" + sameUser
                + "]";
    }
}

