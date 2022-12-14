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
         System.out.println("1.�Է� 2.���� 3.���� 4.��ȣ�˻� 5.��ΰ˻� 6.Ű����˻�");
         System.out.println("����� x�Է�[����Ϸ��� �ƹ�Ű]:");
         System.out.println("===========================");
         System.out.println("�޴��� �����ϼ���:");
         menu = br.readLine();

         if (menu.equals("1")) {
            System.out.println("======================");
            System.out.println("1.���Է� ������");
            System.out.println("======================");
            System.out.println("����:");
            String title = br.readLine();
            System.out.println("����:");
            String content = br.readLine();
            System.out.println("�ۼ���:");
            String writer = br.readLine();
            BoardVO vo = new BoardVO();
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);
            int result = dao.insert(vo);
//            System.out.println("result:"+result);
            if (result == 1)
               System.out.println("�Է¼���");
            else
               System.out.println("�Է½���");

         } else if (menu.equals("2")) {
            System.out.println("======================");
            System.out.println("2.�ۼ��� ������");
            System.out.println("======================");
            System.out.println("�۹�ȣ:");
            String num = br.readLine();
            System.out.println("����:");
            String title = br.readLine();
            System.out.println("����:");
            String content = br.readLine();
            System.out.println("�ۼ���:");
            String writer = br.readLine();
            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            vo.setTitle(title);
            vo.setContent(content);
            vo.setWriter(writer);
            
            int result = dao.update(vo);
//            System.out.println("result:"+result);
            if (result == 1)
               System.out.println("��������");
            else
               System.out.println("��������");

         } else if (menu.equals("3")) {
            System.out.println("======================");
            System.out.println("3.�ۻ��� ������");
            System.out.println("======================");
            System.out.println("�۹�ȣ:");
            String num = br.readLine();

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            int result = dao.delete(vo);
//            System.out.println("result:"+result);
            if (result == 1)
               System.out.println("��������");
            else
               System.out.println("��������");

         } else if (menu.equals("4")) {
            System.out.println("======================");
            System.out.println("4.��ȣ�˻� ������");
            System.out.println("======================");
            System.out.println("�۹�ȣ:");
            String num = br.readLine();

            BoardVO vo = new BoardVO();
            vo.setNum(Integer.parseInt(num));
            BoardVO vo2 = dao.selectOne(vo);
            if (vo2.getNum() == 0) {
               System.out.println("�ش��ȣ�� ����.");
            } else {
               System.out.print(vo2.getNum()+" | ");
               System.out.print(vo2.getTitle()+" | ");
               System.out.print(vo2.getContent()+" | ");
               System.out.print(vo2.getWriter()+" | ");
               System.out.println(vo2.getWdate());
            }

         }else if (menu.equals("5")) {
            System.out.println("======================");
            System.out.println("5.��ΰ˻� ������");
            System.out.println("======================");
            System.out.println("�۹�ȣ | ���� | ���� | �ۼ��� | �ۼ�����");
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
            System.out.println("6.�˻���˻� ������");
            System.out.println("======================");
            System.out.println("�˻�Ű�� �Է��ϼ���:[title or content]");
            String searchKey = br.readLine();
            System.out.println("�˻�� �Է��ϼ���:");
            String searchWord = br.readLine();
            System.out.println("-----------------------------------");
            System.out.println("�۹�ȣ | ���� | ���� | �ۼ��� | �ۼ�����");
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
      // 1.�Է� 2.���� 3.���� 4.��ȣ�˻� 5.��ΰ˻� 6.Ű����˻�
      // �����[x]
      // ===============================================
      // �޴��� �����ϼ���:
      // 1
      // ===============================================
      // 1.���Է� ������
      // ====================
      // ���� :
      // ����:
      // �ۼ���:
      // �Է¼���/����
      // ===============================================
      // 1.�Է� 2.���� 3.���� 4.��ȣ�˻� 5.��ΰ˻� 6.Ű����˻�
      // �����[x]
      // ===============================================
      // 2.�ۼ��� ������
      // ====================
      // �۹�ȣ:
      // ���� :
      // ����:
      // �ۼ���:
      // �Է¼���/����

   }// end main

}// end class