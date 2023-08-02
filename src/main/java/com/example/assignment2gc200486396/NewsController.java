package com.example.assignment2gc200486396;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsController {

    @FXML
    private WebView webView;
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
        appId = appId.trim();
        ApiResponse response = ApiUtility.getDataFromAPI(appId);
        String contentText = " ";
        try {
            contentText = response.getAppNews().getNewsitems().get(0).getContents();
        }catch (Exception e){
            contentText = "No news found for this game";
        }




        // Get rid of any images in the content and the <a> tags
        // TODO - Find a way to display the links rather than removing them
//        String pattern = ".*\\.(png|jpg|gif|bmp|jpeg|PNG|JPG|GIF|BMP|JPEG) | <a[^>]*>.*?</a>"; // <[^\n<>]+>
//        Pattern regex = Pattern.compile(pattern);
//        contentText = regex.matcher(contentText).replaceAll(" ");

        // Change Author
        String authorText = response.getAppNews().getNewsitems().get(0).getAuthor();
        newsAuthor.setText(authorText);

        // Change Title
        String titleText = response.getAppNews().getNewsitems().get(0).getTitle();
        newsTitle.setText(titleText);
//        contentArea.setText(contentText);
//        contentArea.wrapTextProperty().setValue(true);

        webView.getEngine().loadContent(contentText);
    }

}
