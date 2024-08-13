package com.mycom.springmybatisboard.board.controller;

import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import com.mycom.springmybatisboard.board.dto.BoardResultDto;
import com.mycom.springmybatisboard.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    @ResponseBody
    public BoardResultDto listBoard(BoardParamDto boardParamDto)  {
        return boardService.listBoard(boardParamDto);
    }
}
