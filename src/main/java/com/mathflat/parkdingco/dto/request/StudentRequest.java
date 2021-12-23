package com.mathflat.parkdingco.dto.request;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.beans.ConstructorProperties;

@Getter
public class StudentRequest {
    @NotBlank
    @Length(min = 1, max = 16, message = "이름은 최소 1자리 이상 최대 16자리만 입력이 가능합니다.")
    @Pattern(regexp = "^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$", message = "영어/숫자/한글만 입력이 가능합니다.")
    private final String name;

    @Min(value = 8, message = "8세~19세 까지만 입력 가능합니다.")
    @Max(value = 19, message = "8세~19세 까지만 입력 가능합니다.")
    private final int age;

    @Pattern(regexp = "^ELEMENTARY|MIDDLE|HIGH$")
    private final String schoolType;

    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 형식이 맞지 않습니다.")
    private final String phoneNumber;

    @ConstructorProperties({"name", "age", "schoolType", "phoneNumber"})
    public StudentRequest(String name, Integer age, String schoolType, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.schoolType = schoolType;
        this.phoneNumber = phoneNumber;
    }
}
