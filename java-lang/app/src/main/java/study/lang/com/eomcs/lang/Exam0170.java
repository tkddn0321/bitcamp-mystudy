package study.lang.com.eomcs.lang;

//# 산술 연산자 : 명시적 형변환
//
public class Exam0170 {
  public static void main(String[] args) {

    byte b;

    // 4바이트 크기를 갖는 정수 리터럴을 byte 변수에 저장할 수 없다.
    //    b = 259; // 컴파일 오류!

    // 저장하고 싶다면 형변환(type casting)을 명시적으로 지정하라!
    // => 단 메모리에 들어가기에 큰 값이라면 형변환할 때 값이 잘린다.
    b = (byte)259;
    // int(4 byte)  => 0000 0000 0000 0000 0000 0001 0000 0011
    // byte(1 byte) => ---- ---- ---- ---- ---- ---- 0000 0011
    //
    // => 4바이트 중에서 앞의 3바이트가 잘리고 뒤의 1바이트만 b에 저장된다.
    // 
    System.out.println(b); // 3

    // 결론!
    // => 큰 메모리의 값을 작은 메모리에 넣으려고 형변환을 사용하기도 하는데
    //    다만 형변환하더라도(즉 작은 메모리에 넣더라도) 값이 잘리지 않을 때만 하라!
    // => 형변환하더라도 값이 소실되지 않을 때만 "명시적 형변환"을 지시하라!
  }
}






