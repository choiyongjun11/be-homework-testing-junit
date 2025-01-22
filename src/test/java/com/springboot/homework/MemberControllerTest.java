package com.springboot.homework;

import com.google.gson.Gson;
import com.springboot.member.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.StartsWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc //이 애너테이션은 mock mvc를 주입하기 위해 필수로 필요함
@Transactional
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc; // mock <- 실제와 최대한 유사한 것

    @Autowired
    private Gson gson; //build.gradle 에 gson 추가하기

    @Test
    void postMemberTest() throws Exception {
        //given : 준비
        MemberDto.Post post = new MemberDto.Post("lucky@cat.house", "김러키", "010-1234-5678");
        String content = gson.toJson(post);
        //whenm : 기능 실행
        ResultActions actions =mockMvc.perform(
                post("/v11/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        //then : 검증
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))));
    }

    @Test
    void getMemberTest() throws Exception {
        //given: 준비
            //1. 회원 가입을 먼저 진행 해야 합니다.

        MemberDto.Post post = new MemberDto.Post("lucky@cat.house", "김러키", "010-1234-5678");
        String content = gson.toJson(post);
        //whenm : 기능 실행
        ResultActions postActions =mockMvc.perform(
                post("/v11/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));
                //2. postActions에서 헤더에 있는 회원의 기본키를 가져옵니다.
        String location = postActions.andReturn().getResponse().getHeader("Location");
            //location에 담긴 데이터는 "/v11/members/1"

        //when: 기능 실행
        ResultActions getActions = mockMvc.perform(
                get(location)
                        .accept(MediaType.APPLICATION_JSON));


        //then : 검증
        getActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()));
    }

}
