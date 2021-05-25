package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        // 비지니스 로직 실행
        Member member = new Member();
        member.setUsername(paramMap.get("username"));
        member.setAge(Integer.parseInt(paramMap.get("age")));
        memberRepository.save(member);

        // 모델 정의
        model.put("member", member);
        return "save-result";
    }
}
