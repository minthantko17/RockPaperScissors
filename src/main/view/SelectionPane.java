package main.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import main.controllers.AllCustomHandlers;

public class SelectionPane extends ScrollPane{
    private Pane getDetailedPane(){
        VBox selectionPaneInfo=new VBox();
        selectionPaneInfo.setBorder(null);
        selectionPaneInfo.setPadding(new Insets(15,15,15,15));
        selectionPaneInfo.setAlignment(Pos.CENTER);
        
        HBox choicePane=new HBox(10);
        choicePane.setPadding(new Insets(18,18,18,18));
        choicePane.setAlignment(Pos.CENTER);;
        
        HBox fightPane=new HBox(10);
        fightPane.setPadding(new Insets(18,18,18,18));
        fightPane.setAlignment(Pos.CENTER);
        

        StackPane rockImgGroup=new StackPane();
        StackPane paperImgGroup=new StackPane();
        StackPane scissorsImgGroup=new StackPane();
        
        ImageView background1=new ImageView(new Image("resources/buttonBg.png"));
        ImageView background2=new ImageView(new Image("resources/buttonBg.png"));
        ImageView background3=new ImageView(new Image("resources/buttonBg.png"));
        ImageView rock=new ImageView(new Image("resources/rock.png"));
        ImageView paper=new ImageView(new Image("resources/paper.png"));
        ImageView scissors=new ImageView(new Image("resources/scissors.png"));

        rockImgGroup.getChildren().addAll(background1,rock);
        paperImgGroup.getChildren().addAll(background2,paper);
        scissorsImgGroup.getChildren().addAll(background3,scissors);

        rockImgGroup.setOnMouseClicked(new AllCustomHandlers.chooseRock());
        paperImgGroup.setOnMouseClicked(new AllCustomHandlers.choosePaper());
        scissorsImgGroup.setOnMouseClicked(new AllCustomHandlers.chooseScissors());

        choicePane.getChildren().addAll(rockImgGroup, paperImgGroup, scissorsImgGroup);

        Button fightBtn=new Button("Fight!");
        fightBtn.setOnAction(new AllCustomHandlers.fightAction());

        fightPane.getChildren().addAll(fightBtn);

        selectionPaneInfo.getChildren().addAll(choicePane, fightPane);

        return selectionPaneInfo;
    }

    public void drawPane(){
        Pane selectionPane=getDetailedPane();
        this.setStyle("-fx-background-color: BLUE");
        this.setContent(selectionPane);
    }

}
