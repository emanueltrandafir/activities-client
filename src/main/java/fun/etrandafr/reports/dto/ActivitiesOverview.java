package fun.etrandafr.reports.dto;

public interface ActivitiesOverview {
    ActivityDto.Type getType();
    int getNumberOfActivities();
    int getTotalDurationInMinutes();
}