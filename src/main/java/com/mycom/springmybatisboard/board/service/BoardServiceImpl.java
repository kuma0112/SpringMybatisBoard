package com.mycom.springmybatisboard.board.service;

import com.mycom.springmybatisboard.board.dao.BoardDao;
import com.mycom.springmybatisboard.board.dto.BoardDto;
import com.mycom.springmybatisboard.board.dto.BoardParamDto;
import com.mycom.springmybatisboard.board.dto.BoardResultDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardDao boardDao;

    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }


    @Override
    public BoardResultDto listBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            List<BoardDto> list = boardDao.listBoard(boardParamDto);
            int count = boardDao.listBoardTotalCount();
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto listBoardSearchWord(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            List<BoardDto> list = boardDao.listBoardSearchWord(boardParamDto);
            int count = boardDao.listBoardSearchWordTotalCount(boardParamDto);
            boardResultDto.setList(list);
            boardResultDto.setCount(count);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    @Transactional
    public BoardResultDto detailBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            // 조회수
            int userReadCnt = boardDao.countBoardUserRead(boardParamDto);
            System.out.println("boardId : " + boardParamDto.getBoardId());
            System.out.println("userSeq : " + boardParamDto.getUserSeq());
            System.out.println("userReadCnt : " + userReadCnt);

            if(userReadCnt == 0) {
                boardDao.insertBoardUserRead(boardParamDto.getBoardId(), boardParamDto.getUserSeq());

                // transaction test
//                String s = null;
//                s.length(); // NPE 터질 것

                boardDao.updateBoardReadCount(boardParamDto.getBoardId());
            }

            // #3 NPE를 지우고 테스트
            // 예외가 터지지 않더라도 코드가 수행되기 때문에 무조건 롤백 발생
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

            BoardDto boardDto = boardDao.detailBoard(boardParamDto);

            // 글쓴이와 보는 이가 같은지 여부
            if (boardDto.getUserSeq() == boardParamDto.getUserSeq()) { // 컨트롤러에서 세션으로부터 얻어서 보내준다
                boardDto.setSameUser(true);
            } else {
                boardDto.setSameUser(false);
            }
            boardResultDto.setDto(boardDto);
            boardResultDto.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");

            // 런타임 exception이기 때문에 detailboard()를 호출한 쪽으로 넘어갈 것
            // #1 RuntimeException 객체를 상위 호출자에게 전달
//            throw new RuntimeException("detailBoard() error");

            // TransactionAspectSupport의 static method를 통해
            // 현재 트랜잭션을 관리하고 있는 TransactionStatus 객체에 접근할 수 있으며,
            // 이 객체를 사용해 현재 트랜잭션을 롤백 상태로 설정할 수 있다.
            boardDao.updateBoardReadCount(boardParamDto.getBoardId());

        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto insertBoard(BoardDto boardDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            int ret = boardDao.insertBoard(boardDto);

            if (ret == 1) boardResultDto.setResult("success");
            else boardResultDto.setResult("fail");

        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto updateBoard(BoardDto boardDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            int ret = boardDao.updateBoard(boardDto);

            if (ret == 1) boardResultDto.setResult("success");
            else boardResultDto.setResult("fail");

        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }

    @Override
    public BoardResultDto deleteBoard(int boardId) {
        BoardResultDto boardResultDto = new BoardResultDto();
        try {
            int ret = boardDao.deleteBoard(boardId);

            if (ret == 1) boardResultDto.setResult("success");
            else boardResultDto.setResult("fail");

        } catch (Exception e) {
            e.printStackTrace();
            boardResultDto.setResult("fail");
        }

        return boardResultDto;
    }
}
