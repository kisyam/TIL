package test.com.board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import test.com.board.model.BoardDAO;
import test.com.board.model.BoardDAOimpl;
import test.com.board.model.BoardVO;

public class BoardMenu {

   public static void main(String[] args) throws IOException {
      System.out.println("Hello Board");
      BoardDAO dao = new BoardDAOimpl();
      Reader r = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(r);

      boolean bool = true;
      String menu = "y";
      do {
         System.out.println("===========================");
         System.out.println("1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색");
         System.out.println("종료시 x입력[계속하려면 아무키]:");
         System.out.println("===========================");
         System.out.println("메뉴를 선택하세요:");
         menu = br.readLine();

         if (menu.equals("1")) {
            System.out.println("======================");
            System.out.println("1.글입력 페이지");
            System.out.println("======================");
            System.out.println("제목:");
            String title = br.readLine();
            System.out.println("내용:");
            String content = br.readLine();
            System.out.println("작성자:");
            String writer = br.readLine();
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);
            int result = dao.insert(vo);
//            System.out.println("result:"+result);
            if (result == 1)
               System.out.println("입력성공");
            else
               System.out.println("입력실패");

         } else if (menu.equals("2")) {
            System.out.println("======================");
            System.out.println("2.글수정 페이지");
            System.out.println("======================");
            System.out.println("글번호:");
            String num = br.readLine();
            System.out.println("제목:");
            String title = br.readLine();
            System.out.println("내용:");
            String content = br.readLine();
            System.out.println("작성자:");
            String writer = br.readLine();
            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);
            
            int result = dao.update(vo);
//            System.out.println("result:"+result);
            if (result == 1)
               System.out.println("수정성공");
            else
               System.out.println("수정실패");

         } else if (menu.equals("3")) {
            System.out.println("======================");
            System.out.println("3.글삭제 페이지");
            System.out.println("======================");
            System.out.println("글번호:");
            String num = br.readLine();

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            int result = dao.delete(vo);
//            System.out.println("result:"+result);
            if (result == 1)
               System.out.println("삭제성공");
            else
               System.out.println("삭제실패");

         } else if (menu.equals("4")) {
            System.out.println("======================");
            System.out.println("4.번호검색 페이지");
            System.out.println("======================");
            System.out.println("글번호:");
            String num = br.readLine();

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            BoardVO vo2 = dao.selectOne(vo);
            if (vo2.getNum() == 0) {
               System.out.println("해당번호글 없음.");
            } else {
               System.out.print(vo2.getNum()+" | ");
               System.out.print(vo2.getTitle()+" | ");
               System.out.print(vo2.getContent()+" | ");
               System.out.print(vo2.getWriter()+" | ");
               System.out.println(vo2.getWdate());
            }

         }else if (menu.equals("5")) {
            System.out.println("======================");
            System.out.println("5.모두검색 페이지");
            System.out.println("======================");
            System.out.println("글번호 | 제목 | 내용 | 작성자 | 작성일자");
            System.out.println("-----------------------------------");
            List<BoardVO> vos = dao.selectAll();
            for (BoardVO x : vos) {
               System.out.print(x.getNum()+" | ");
               System.out.print(x.getTitle()+" | ");
               System.out.print(x.getContent()+" | ");
               System.out.print(x.getWriter()+" | ");
               System.out.println(x.getWdate());
            }
         }else if (menu.equals("6")) {
            System.out.println("======================");
            System.out.println("6.검색어검색 페이지");
            System.out.println("======================");
            System.out.println("검색키를 입력하세요:[title or content]");
            String searchKey = br.readLine();
            System.out.println("검색어를 입력하세요:");
            String searchWord = br.readLine();
            System.out.println("-----------------------------------");
            System.out.println("글번호 | 제목 | 내용 | 작성자 | 작성일자");
            System.out.println("-----------------------------------");
            List<BoardVO> vos = dao.searchList(searchKey, searchWord);
            for (BoardVO x : vos) {
               System.out.print(x.getNum()+" | ");
               System.out.print(x.getTitle()+" | ");
               System.out.print(x.getContent()+" | ");
               System.out.print(x.getWriter()+" | ");
               System.out.println(x.getWdate());
            }
         }

         if (menu.equals("x"))
            break;
      } while (bool);

      System.out.println("end main....");

      // ===============================================
      // 1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색
      // 종료시[x]
      // ===============================================
      // 메뉴를 선택하세요:
      // 1
      // ===============================================
      // 1.글입력 페이지
      // ====================
      // 제목 :
      // 내용:
      // 작성자:
      // 입력성공/실패
      // ===============================================
      // 1.입력 2.수정 3.삭제 4.번호검색 5.모두검색 6.키워드검색
      // 종료시[x]
      // ===============================================
      // 2.글수정 페이지
      // ====================
      // 글번호:
      // 제목 :
      // 내용:
      // 작성자:
      // 입력성공/실패

   }// end main

}// end class