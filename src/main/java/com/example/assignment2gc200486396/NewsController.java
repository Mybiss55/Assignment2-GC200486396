package com.example.assignment2gc200486396;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsController {
    @FXML
    private WebView webView;


    @FXML
    private TextField inputURL;

    @FXML
    private TextArea contentArea;

    @FXML
    private TextField inputId;

    @FXML
    private Label newsAuthor;

    @FXML
    private Label newsTitle;

    public void initialize() {
        webView.getEngine().load("http://15.222.122.223/~Myles200486396/Assignment%203/");
        newsAuthor.setText(" ");
        newsTitle.setText(" ");
    }
    @FXML
    void showNews(ActionEvent event) {
        String appId = inputId.getText();
        appId = appId.trim();
        ApiResponse response = ApiUtility.getDataFromAPI(appId);
        String contentText = " ";
        try {
            contentText = response.getAppNews().getNewsitems().get(0).getContents();
        }catch (Exception e){
            contentText = "No news found for this game, maybe another?";
        }



        String pattern = "\\S+.(png|jpg|gif|bmp|jpeg|PNG|JPG|GIF|BMP|JPEG)"; // | <a[^>]*>.*?</a>
        Pattern regex = Pattern.compile(pattern);

        List<String> allMatches = new ArrayList<String>();
        Matcher m = regex.matcher(contentText);
        while (m.find()) {
            allMatches.add(m.group());
            String temp = m.group();
            temp = "<img src=\"" + temp + "\" />";
            contentText = contentText.replace(m.group(), "</br>" + temp + "</br>");
        }



//        contentText = regex.matcher(contentText).replaceAll(" ");

        try{
            // Change Author
            String authorText = response.getAppNews().getNewsitems().get(0).getAuthor();
            newsAuthor.setText(authorText);

            // Change Title
            String titleText = response.getAppNews().getNewsitems().get(0).getTitle();
            newsTitle.setText(titleText);
        }
        catch (Exception e){
            newsAuthor.setText("Author has gone missing!");
            newsTitle.setText("Titles eh!");
        }



//        contentArea.setText(contentText);
//        contentArea.wrapTextProperty().setValue(true);

        webView.getEngine().loadContent(contentText);
        webView.fontScaleProperty().setValue(1.5);
        webView.setZoom(0.5);
        webView.getEngine().setUserStyleSheetLocation(getClass().getResource("/styles.css").toString());
    }

    @FXML
    void showWebsite(ActionEvent event) {
        String url = inputURL.getText();
        url = url.trim();
        webView.getEngine().load(url);
        newsAuthor.setText(" ");
        newsTitle.setText(" ");
        System.out.println();
    }


}
