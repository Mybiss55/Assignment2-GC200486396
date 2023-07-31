package com.example.assignment2gc200486396;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsController {

    @FXML
    private TextArea contentArea;

    @FXML
    private TextField inputId;

    @FXML
    private Label newsAuthor;

    @FXML
    private Label newsTitle;

    @FXML
    void showNews(ActionEvent event) {
        String appId = inputId.getText();
        ApiResponse response = ApiUtility.getDataFromAPI(appId);
        String contentText = response.getAppNews().getNewsitems().get(0).getContents();


        // Get rid of any images in the content
        String pattern = ".*\\.(png|jpg)";
        Pattern regex = Pattern.compile(pattern);
        contentText = regex.matcher(contentText).replaceAll("");

        // Change Author
        String authorText = response.getAppNews().getNewsitems().get(0).getAuthor();
        newsAuthor.setText(authorText);

        // Change Title
        String titleText = response.getAppNews().getNewsitems().get(0).getTitle();
        newsTitle.setText(titleText);





        contentArea.setText(contentText);
        contentArea.wrapTextProperty().setValue(true);
    }

}
