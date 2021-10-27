package fun.etrandafr.reports.controller;

import fun.etrandafr.reports.dto.ActivitiesOverview;
import fun.etrandafr.reports.dto.ActivityDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("report")
public class ReportsController {

    private WebClient client = WebClient.builder()
            .baseUrl("http://localhost:1234/api")
//            .defaultHeader("Content-Type", "application/json")
            .build();

    @GetMapping("isAlive")
    public String isAlive() {
        return "is Alive!";
    }

    @GetMapping("activities")
    public List<ActivityDto> find(@RequestParam(value = "search", required = false) String search) {
        return client.get()
                .uri(uri -> uri
                        .pathSegment("activities")
                        .queryParamIfPresent("search", Optional.ofNullable(search))
                        .build())
                .retrieve()
                .bodyToFlux(ActivityDto.class)
                .collectList()
                .block();
    }

    @GetMapping("overview")
    public List<ActivitiesOverview> group() {
        return client.get()
                .uri("/overview")
                .retrieve().bodyToFlux(ActivitiesOverview.class)
                .collectList()
                .block();
    }

}
