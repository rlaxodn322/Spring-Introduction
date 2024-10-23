package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }
    @Test()
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get() ;
         Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("spring1");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("spring2");
        repository.save(member1);

        Member result = repository.findByName("spring1").get();
         Assertions.assertThat(result).isEqualTo(member);

    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("String");
        repository.save(member);

        Member member1 = new Member();
        member1.setName("string2");
        repository.save(member1);

        List<Member> result = repository.findAll();
         Assertions.assertThat(result.size()).isEqualTo(2);


    }
}
