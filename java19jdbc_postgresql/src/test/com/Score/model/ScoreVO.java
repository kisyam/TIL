package test.com.Score.model;

import java.util.Objects;

public class ScoreVO {

	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	//매개변수가 없는 생성자.-디폴트생성자.
	//생략가능
public ScoreVO() {
	System.out.println("ScoreVO()...");
}

public ScoreVO(int num, String name, int kor, int eng, int math) {
	super();
	this.num = num;
	this.name = name;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
}

@Override
public String toString() {
	return "ScoreVO [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getKor() {
	return kor;
}

public void setKor(int kor) {
	this.kor = kor;
}

public int getEng() {
	return eng;
}

public void setEng(int eng) {
	this.eng = eng;
}

public int getMath() {
	return math;
}

public void setMath(int math) {
	this.math = math;
}

@Override
public int hashCode() {
	return Objects.hash(eng, kor, math, name, num);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ScoreVO other = (ScoreVO) obj;
	return eng == other.eng && kor == other.kor && math == other.math && Objects.equals(name, other.name)
			&& num == other.num;
}



}
