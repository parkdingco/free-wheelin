package com.mathflat.parkdingco.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.beans.ConstructorProperties;

@Getter
public class SubjectRequest {
    @NotBlank
    @Length(min = 1, max = 12, message = "과목명은 최소 1자리 이상 최대 12자리만 입력이 가능합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$", message = "영어/숫자/한글만 입력이 가능합니다.")
    private final String name;

    @ConstructorProperties({"name"})
    public SubjectRequest(String name) {
        this.name = name;
    }
}
