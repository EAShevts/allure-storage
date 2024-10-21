package ru.eashevts.allure_storage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.eashevts.allure_storage.entity.BuildRun;
import ru.eashevts.allure_storage.repository.BuildRunRepository;
import ru.eashevts.allure_storage.repository.TestResultRepository;

@Controller
@RequestMapping("/buildruns")
public class BuildRunController {
    @Autowired
    private BuildRunRepository buildRunRepository;
    @Autowired
    private TestResultRepository testResultRepository;

    @GetMapping
    public String listTestRuns(Model model) {
        var buildRuns = buildRunRepository.findAll(PageRequest.of(0, 25, Sort.by("createDate").descending()));
        model.addAttribute("buildRuns", buildRuns);
        return "buildrun/list"; // Указывает на шаблон Thymeleaf
    }

    @GetMapping("/{id}")
    public String viewTestRun(@PathVariable Long id, Model model) {
        BuildRun buildRuns = buildRunRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid test run Id:" + id));
        model.addAttribute("buildRuns", buildRuns);
        model.addAttribute("testResults", buildRuns.getTestResults());
        return "buildrun/view";
    }


}
