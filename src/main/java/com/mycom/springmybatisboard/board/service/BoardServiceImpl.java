package com.mycom.springmybatisboard.board.service;

import com.mycom.springmybatisboard.board.dao.BoardDao;
import com.mycom.springmybatisboard.board.dto.BoardDto;
import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import com.mycom.springmybatisboard.board.dto.BoardResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }


    @Override
    public BoardResultDto listBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try{
            List<BoardDto> list = boardDao.listBoard(boardParamDto);
            boardResultDto.setList(list);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }
}
