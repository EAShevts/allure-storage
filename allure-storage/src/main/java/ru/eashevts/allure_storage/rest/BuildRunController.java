package ru.eashevts.allure_storage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eashevts.allure_storage.dto.BuildRunDiff;
import ru.eashevts.allure_storage.entity.BuildRun;
import ru.eashevts.allure_storage.repository.BuildRunRepository;
import ru.eashevts.allure_storage.service.BuildDiffService;

import java.util.List;

@Controller
@RequestMapping("/buildruns")
public class BuildRunController {
    @Autowired
    private BuildRunRepository buildRunRepository;

    @Autowired
    BuildDiffService buildDiffService;

    @GetMapping
    public String viewBuildRuns(Model model) {


        var buildRuns = buildRunRepository.findAll(PageRequest.of(0, 25, Sort.by("createDate").descending()));
        model.addAttribute("buildRuns", buildRuns);
        return "buildrun/list"; // Указывает на шаблон Thymeleaf
    }

    @GetMapping("/{id}")
    public String viewBuildRun(@PathVariable Long id, Model model) {
        BuildRun buildRun = buildRunRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid test run Id:" + id));
        model.addAttribute("buildRun", buildRun);
        model.addAttribute("testResults", buildRun.getTestResults());
        return "buildrun/view";
    }
    @GetMapping("/compare")
    public String diffBuildRun(Model model,
            @RequestParam Long buildRunMasterId,
            @RequestParam Long buildRunSlaveId) {
        List<BuildRunDiff> buildRunDiffs = buildDiffService.compareBuildRun(buildRunMasterId,buildRunSlaveId);
        model.addAttribute("buildRunDiffs", buildRunDiffs);
        return "buildrun/diff";
    }


}
