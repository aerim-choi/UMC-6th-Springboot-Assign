package umc.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.apiPayload.code.status.ErrorStatus;
import umc.domain.enums.MemberStatus;
import umc.domain.enums.MissionStatus;
import umc.domain.mapping.MemberMission;
import umc.repository.MemberMissionRepository;
import umc.service.MemberMission.MemberMissionCommandService;
import umc.validation.annotation.ProgressMemberMission;
import umc.web.dto.MemberMissionRequestDTO;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProgressMemberMissionValidator implements ConstraintValidator<ProgressMemberMission, MemberMissionRequestDTO.createMemberMissionDTO> {
    private final MemberMissionCommandService memberMissionCommandService;

    @Override
    public boolean isValid(MemberMissionRequestDTO.createMemberMissionDTO dto, ConstraintValidatorContext context) {
        boolean isValid = memberMissionCommandService.isProgressMemberMission(dto.getMemberId(), dto.getMissionId());
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_ALREADY_IN_PROGRESS.toString()).addConstraintViolation();
            System.out.println(ErrorStatus.MEMBER_MISSION_ALREADY_IN_PROGRESS.toString());
        }

        return isValid;
    }

    @Override
    public void initialize(ProgressMemberMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
