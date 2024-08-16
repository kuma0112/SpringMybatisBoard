package com.mycom.springmybatisboard.board.controller;

import com.mycom.springmybatisboard.board.dto.BoardDto;
import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import com.mycom.springmybatisboard.board.dto.BoardResultDto;
import com.mycom.springmybatisboard.board.service.BoardService;
import com.mycom.springmybatisboard.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        // searchWord 포함 여부 분리
        BoardResultDto boardResultDto;
        if (Strings.isEmpty(boardParamDto.getSearchWord())) {
            boardResultDto = boardService.listBoard(boardParamDto);
        } else {
            boardResultDto = boardService.listBoardSearchWord(boardParamDto);
        }
        return boardResultDto;
    }

    @GetMapping("/detail/{boardId}")
    @ResponseBody
    public BoardResultDto detailBoard(@PathVariable int boardId, HttpSession session) {
        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setBoardId(boardId);
        int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq(); // 로그인할 때 세션에 담은 객체에서 user seq 추출
        boardParamDto.setUserSeq(userSeq);
        return boardService.detailBoard(boardParamDto);
    }

    @PostMapping("/insert")
    @ResponseBody
    public BoardResultDto insertBoard(BoardDto boardDto, HttpSession session) {
        int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq(); // 로그인할 때 세션에 담은 객체에서 user seq 추출
        boardDto.setUserSeq(userSeq);
        return boardService.insertBoard(boardDto);
    }

    @PostMapping("/update")
    @ResponseBody
    public BoardResultDto updateBoard(BoardDto boardDto, HttpSession session) {
//        int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq(); // 로그인할 때 세션에 담은 객체에서 user seq 추출
//        boardDto.setUserSeq(userSeq);
        return boardService.updateBoard(boardDto);
    }

    @GetMapping("/delete/{boardId}")
    @ResponseBody
    public BoardResultDto deleteBoard(@PathVariable int boardId) {
        return boardService.deleteBoard(boardId);
    }
}
