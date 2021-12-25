package com.mathflat.parkdingco.dto.request;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.beans.ConstructorProperties;

@Getter
public class ScoreRequest {
    @Min(value = 0, message = "0~100 점수만 입력 가능합니다.")
    @Max(value = 100, message = "0~100 점수만 입력 가능합니다.")
    public final int score;

    @ConstructorProperties("score")
    public ScoreRequest(int score) {
        this.score = score;
    }
}
