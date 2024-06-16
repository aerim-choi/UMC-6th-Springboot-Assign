package umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.apiPayload.ApiResponse;
import umc.coverter.MemberMissionConverter;
import umc.coverter.MissionConverter;
import umc.domain.Mission;
import umc.domain.mapping.MemberMission;
import umc.service.MemberMission.MemberMissionCommandService;
import umc.service.MissionService.MissionCommandService;
import umc.web.dto.MemberMissionRequestDTO;
import umc.web.dto.MemberMissionResponseDTO;
import umc.web.dto.MissionRequestDTO;
import umc.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("missions")
public class MissionRestController {
    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.createMissionResultDTO> createMission(@RequestBody @Valid MissionRequestDTO.createMissionDTO request){
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }
    @PostMapping("/members/")
    public ApiResponse<MemberMissionResponseDTO.createMemberMissionResultDTO> createMemberMission(@RequestBody @Valid MemberMissionRequestDTO.createMemberMissionDTO request){
        MemberMission mission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResultDTO(mission));
    }
}
