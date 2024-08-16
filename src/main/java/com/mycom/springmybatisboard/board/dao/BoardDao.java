package com.mycom.springmybatisboard.board.dao;

import com.mycom.springmybatisboard.board.dto.BoardDto;
import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardDao {
    List<BoardDto> listBoard(BoardParamDto boardParamDto); // limit, offset
    int listBoardTotalCount(); // 검색어 없을 때 전체 건수 카운트

    List<BoardDto> listBoardSearchWord(BoardParamDto boardParamDto); // limit, offset, searchWord
    int listBoardSearchWordTotalCount(BoardParamDto boardParamDto); // 검색 이후 전체 검수 카운트

    BoardDto detailBoard(BoardParamDto boardParamDto);

    int insertBoard(BoardDto boardDto);
    int updateBoard(BoardDto boardDto);
    int deleteBoard(int boardId);

    // 조회수 처리
    int countBoardUserRead(BoardParamDto boardParamDto);

    void insertBoardUserRead(@Param("boardId") int boardId, @Param("userSeq") int userSeq);
    void updateBoardReadCount(int boardId);
}
