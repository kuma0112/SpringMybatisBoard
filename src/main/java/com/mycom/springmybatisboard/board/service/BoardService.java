package com.mycom.springmybatisboard.board.service;

import com.mycom.springmybatisboard.board.dto.BoardDto;
import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import com.mycom.springmybatisboard.board.dto.BoardResultDto;

import java.util.List;

public interface BoardService {
    BoardResultDto listBoard(BoardParamDto boardParamDto);
    BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto);
    BoardResultDto detailBoard(BoardParamDto boardParamDto);
    BoardResultDto insertBoard(BoardDto boardDto);
    BoardResultDto updateBoard(BoardDto boardDto);
    BoardResultDto deleteBoard(int boardId);

}
