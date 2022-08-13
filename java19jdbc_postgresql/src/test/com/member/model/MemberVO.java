package test.com.member.model;

import java.io.Serializable;
import java.util.Objects;

public class MemberVO implements Serializable{
	
	private int num;
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	
	public MemberVO() {
		
	}


	
	@Override
	public String toString() {
		return "MemberVO [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", tel=" + tel + "]";
	}



	public MemberVO(int num, String id, String pw, String name, String tel) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}





	public MemberVO(int i, String string, Object println) {
		// TODO Auto-generated constructor stub
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, name, num, pw, tel);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && num == other.num && pw == other.pw
				&& tel == other.tel;
	}
	
	

	
		//��ȣ(num), ���̵�(id), ���(pw), �̸�(name), ����(tel) �Ӽ� �����ؼ� ����
		
		//�Ű����� ���� ������1�� ����ð�
		
		//��� �Ӽ��� �Ű��������ϴ� ������ 1�� �߰�
		
		//����&���� ����
		
		//toString ������
		
		//������Ŭ������ �Լ� ������ (�ؽ��ڵ�, ������)


}
