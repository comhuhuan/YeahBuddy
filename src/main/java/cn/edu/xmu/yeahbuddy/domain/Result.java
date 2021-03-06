package cn.edu.xmu.yeahbuddy.domain;

import org.hibernate.annotations.NaturalId;
import org.jetbrains.annotations.Contract;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Result {

    @Id
    @GeneratedValue
    @Column(name = "ResultId", unique = true, updatable = false, nullable = false)
    private int id = Integer.MIN_VALUE;

    @NaturalId
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ResultReportId", updatable = false, nullable = false, unique = true)
    private Report report;

    @Column(name = "ResultBrief", nullable = false)
    private String brief;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ResultContent")
    private List<String> content = new ArrayList<>();

    @Column(name = "ResultSubmitted", nullable = false)
    private boolean submitted;

    public Result(){ }

    public Result(Report report, String brief) {
        this.report = report;
        this.brief = brief;
        this.content.add("");
        this.content.add("");
    }

    @Contract(pure = true)
    public int getId(){ return id; }

    @Contract(pure = true)
    public Report getReport(){ return report; }

    @Contract(pure = true)
    public Team getTeam(){ return report.getTeam(); }

    @Contract(pure = true)
    public Stage getStage(){ return report.getStage(); }

    @Contract(pure = true)
    public int getTeamId() {
        return report.getTeam().getId();
    }

    @Contract(pure = true)
    public int getStageId() {
        return report.getStage().getId();
    }

    @Contract(pure = true)
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Contract(pure = true)
    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Contract(pure = true)
    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
}
