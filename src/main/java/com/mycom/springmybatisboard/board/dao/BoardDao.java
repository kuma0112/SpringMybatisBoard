package com.mycom.springmybatisboard.board.dao;

import com.mycom.springmybatisboard.board.dto.BoardDto;
import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {
    List<BoardDto> listBoard(BoardParamDto boardParamDto);
}
