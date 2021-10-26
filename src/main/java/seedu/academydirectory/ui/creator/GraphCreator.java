package seedu.academydirectory.ui.creator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import seedu.academydirectory.model.AdditionalInfo;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jfree.chart.fx.ChartViewer;

public class GraphCreator extends Creator {

    private static final String FXML = "/creator/GraphCreator.fxml";

    private final Map<String, List<Integer>> studentAssessmentResults;

    @FXML
    private StackPane placeHolder;

    /**
     * Constructor of Graph Creator
     * @param additionalInfo info to be passed in
     */
    public GraphCreator(AdditionalInfo<?> additionalInfo) {
        super(additionalInfo, FXML);
        Map<String, List<Integer>> rawResults = (Map<String, List<Integer>>) additionalInfo.get();
        this.studentAssessmentResults = this.cleanAssessmentResults(rawResults);

        BoxAndWhiskerCategoryDataset dataset = this.createDataset();
        ChartViewer chartViewer = new ChartViewer(createChart(dataset));

        placeHolder.getChildren().add(chartViewer);
    }

    private List<Integer> filterList(Predicate<Integer> predicate, List<Integer> list) {
        return list.stream().filter(num -> predicate.test(num)).collect(Collectors.toList());
    }

    private Map<String, List<Integer>> cleanAssessmentResults(Map<String, List<Integer>> assessmentResults) {

        return assessmentResults.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        //Remove all -1 from the grades
                        entrySet -> filterList(value -> value >= 0, entrySet.getValue())));
    }

    private BoxAndWhiskerCategoryDataset createDataset() {
        String[] entities = {"RA1", "Midterm", "Final"};

        DefaultBoxAndWhiskerCategoryDataset dataset = new
                DefaultBoxAndWhiskerCategoryDataset();

        this.studentAssessmentResults.entrySet()
                .stream()
                .forEachOrdered(entrySet -> dataset.add(entrySet.getValue(), "Assessments", entrySet.getKey()));

        return dataset;
    }

    private JFreeChart createChart(
            final BoxAndWhiskerCategoryDataset dataset) {

        BoxAndWhiskerRenderer boxRenderer = new BoxAndWhiskerRenderer();

        boxRenderer.setFillBox(true);
        boxRenderer.setSeriesFillPaint(0, Color.BLUE);

        boxRenderer.setSeriesPaint(1, Color.RED);
        boxRenderer.setSeriesPaint(100, Color.BLUE);
        boxRenderer.setMaximumBarWidth(0.1);
        boxRenderer.setMedianVisible(true);
        boxRenderer.setMeanVisible(false);

        CategoryAxis xAxis = new CategoryAxis("Assessments");
        NumberAxis yAxis = new NumberAxis("Grade");
        yAxis.setAutoRangeIncludesZero(false);
        CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, boxRenderer);
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);

        StandardChartTheme theme = (StandardChartTheme) StandardChartTheme.createDarknessTheme();
        theme.apply(chart);

        boxRenderer.setSeriesPaint(0, new Color(0, 255, 0, 150));

        return chart;
    }

    /**
     * Create the view
     * @return new View
     */
    @Override
    public Node create() {
        return this.getRoot();
    }
}