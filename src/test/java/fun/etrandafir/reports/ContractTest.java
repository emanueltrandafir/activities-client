package fun.etrandafir.reports;

import fun.etrandafr.reports.Application;
import fun.etrandafr.reports.controller.ReportsController;
import fun.etrandafr.reports.dto.ActivityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = Application.class)
@AutoConfigureStubRunner(ids = {"fun.etrandafir:activities-api:+:stubs:1234"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ContractTest {

    @Autowired
    private ReportsController controller;

    @Test
    void findAll() {
        List<ActivityDto> dtos = controller.find(null);
        System.err.println(dtos);
    }
}