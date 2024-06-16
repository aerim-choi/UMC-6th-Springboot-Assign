package umc.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.validation.validator.ProgressMemberMissionValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProgressMemberMissionValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProgressMemberMission {
    String message() default "이미 진행중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
