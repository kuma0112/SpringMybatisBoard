package com.mycom.springmybatisboard.board.service;

import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import com.mycom.springmybatisboard.board.dto.BoardResultDto;

import java.util.List;

public interface BoardService {
    BoardResultDto listBoard(BoardParamDto boardParamDto);
}
