package assignment.hello.controller;

import assignment.hello.repository.JpaMemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class webController {

    private final JpaMemberRepository memberRepository;

}
