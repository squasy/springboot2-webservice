package com.squasy.example.springboot.domain.posts;

import com.squasy.example.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Getter //클래스내 모든 필드를 자동으로 생성 : lombok
@NoArgsConstructor  //기본생성자 자동 추가
@Entity //jpa에서 사용하는 클래스별 테이블 매핑 : 실제 db테이블과 매칭 될 테이블 . SalesManager -> sales_manager
//필수 어노테이션을 클래스에 가깝게 둔다....Getter는 lombok 지원으로서 필수는 아니지만 jpa에서는 Entity가 필수 어노테이션 : 이유는 언어전환이 있을 경우 롬복이 필요없을 경우 쉽게 수정 가능
public class Posts extends BaseTimeEntity {
    @Id //pk 격
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성 로직....auto_increment 같은거... spring 2.0과 1.5가 설정법이 다르므로 민감성 숙지
    private Long id;

    @Column(length = 500, nullable = false) //컬럼에 대한 설명,,,길이는 500, null 안됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    @Builder
    public Posts(Long id, String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
