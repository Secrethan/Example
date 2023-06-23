package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {
    //Lombok 라이브러리 사용 OR Ctrl + N (Generate) -> getter , setter 생성 가능
    private String username;
    private int age;



}
