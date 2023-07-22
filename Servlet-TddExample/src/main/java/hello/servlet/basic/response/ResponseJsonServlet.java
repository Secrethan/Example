package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    //응답데이터 : json
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //application/json 스펙상 utf-8형식을 사용하도록 정의되어 있다. 따라서 charset=utf-8 과 같은 추가 파라미터를 지원하지 않음
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("kim");
        helloData.setAge(27);

        //{"username":"kim", "age":20}
        String result = objectMapper.writeValueAsString(helloData);
        // response.getWriter() -> 추가 파라미터를 동적으로 자동 추가함  response.getOutputStream()으로 출력하면 자동으로 추가하지 않음
        response.getWriter().write(result);
    }
}
