/** Program: NFL Draft Simulator 10
 * File: NFLDraftSimulator10.java
 * Summary: Final Project: NFL Draft Application
 * Author: Richard Boyd
 * Date: January 28, 2018
 */

package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class NFLDraftSimulator10 extends Application{
	@Override
	public void start(Stage primaryStage) {		
		PlayerManager players = new PlayerManager();
		Pane start = new VBox(15);                                    //Start screen of the app
		start.setPadding(new Insets(15, 15, 15, 15));
		((VBox) start).setAlignment(Pos.CENTER);
		
		Image logo = new Image(getClass().getResourceAsStream("image/Draft10.png"));
		ImageView logo1 = new ImageView(logo); 
		start.getChildren().add(logo1);
		
		Font impact = Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 25);
		String startMenu = new String("Press start to begin the NFL Draft experience");
		Label startLabel = new Label(startMenu);
		startLabel.setFont(impact);
		start.getChildren().add(startLabel);
		
		Button startbutton = new Button("Start");
		start.getChildren().add(startbutton);
		
		Scene scene = new Scene(start, 500, 500);
		primaryStage.setTitle("NFL Draft Simulator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//---------------------------------------------------------------------------------
		                                                                 //main menu
		Pane main = new VBox(20);                                  
		main.setPadding(new Insets(20, 20, 20, 20));
		((VBox) main).setAlignment(Pos.CENTER);
		
		Button number = new Button("Choose a player by number");
		Button position = new Button("Choose players by position");
		Button roster = new Button("See your current roster");
		
		ImageView logo2 = new ImageView(logo);
		logo2.setPreserveRatio(true);
		logo2.setFitHeight(200);
		
		main.getChildren().addAll(logo2, number, position, roster);
		
		Scene mainScene = new Scene(main, 500, 500);
		
		startbutton.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		//-----------------------------------------------------------------------------------
		                                                                     //roster scene
		Pane rosterpane = new VBox(20);
		rosterpane.setPadding(new Insets(20, 20, 20, 20));
		((VBox) rosterpane).setAlignment(Pos.CENTER);
		Label rostertitle = new Label(new String("This is your current roster"));
		rostertitle.setFont(impact);
		rosterpane.getChildren().add(rostertitle);
		Button back19 = new Button("Return to Main Menu");
		rosterpane.getChildren().add(back19);
		
		Button manningroster = new Button("Peyton Manning"); //buttons to show who is added to roster
		Button brownroster = new Button("Donald Brown");
		Button garconroster = new Button("Pierre Garcon");
		Button cutlerroster = new Button("Jay Cutler");
		Button forteroster = new Button("Matt Forte");
		Button knoxroster = new Button("Johnny Knox");
		Button bethearoster = new Button("Antoine Bethea");
		Button powersroster = new Button("Jerraud Powers");
		Button harrisroster = new Button("Chris Harris");
		Button tillmanroster = new Button("Charles Tillman");
		
		Scene rosterScene = new Scene(rosterpane, 500, 500);
		
		roster.setOnAction(new EventHandler<ActionEvent>(){   //roster button from main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back19.setOnAction(new EventHandler<ActionEvent>(){   //another back to main menu button
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
			
		//-----------------------------------------------------------------------------------
		                                                                     //player scenes
		GridPane manningpane = new GridPane();                               //comments apply to all player scenes
		manningpane.setAlignment(Pos.TOP_LEFT);
		manningpane.setPadding(new Insets(10, 10, 10, 10));
		manningpane.setHgap(20);
		manningpane.setVgap(20);
		
		Label manningname = new Label(new String(players.offensivelist.get(0).getName()));
		manningname.setFont(impact);
		manningpane.add(manningname, 0, 0);
		manningpane.add(new Label(new String(Integer.toString(players.offensivelist.get(0).getAge()) + " years old")), 1, 0); //pulls name and all info from the player object and displays it on the players scene
		manningpane.add(new Label(new String(players.offensivelist.get(0).getPosition())), 0, 1);
		manningpane.add(new Label(new String("#"+ (players.offensivelist.get(0).getNumber()))), 1, 1);
		manningpane.add(new Label(new String("Pass Attempts: "+ Integer.toString(players.offensivelist.get(0).getPassAtt()))), 0, 2);
		manningpane.add(new Label(new String("Passes Completed: "+ Integer.toString(players.offensivelist.get(0).getPassCmp()))), 1, 2);
		manningpane.add(new Label(new String("Rushes Attempted: "+ Integer.toString(players.offensivelist.get(0).getRushAtt()))), 0, 3);
		manningpane.add(new Label(new String("Rushing Yards: "+ Integer.toString(players.offensivelist.get(0).getRushYrds()))), 1, 3);
		manningpane.add(new Label(new String("Receptions: "+ Integer.toString(players.offensivelist.get(0).getRec()))), 0, 4);
		manningpane.add(new Label(new String("Receiving Yards: "+ Integer.toString(players.offensivelist.get(0).getRecYrds()))), 1, 4);
		Button manningadd = new Button("Add to roster"); //default buttons
		manningpane.add(manningadd, 0, 6); 
		Button back2 = new Button("Return to Main Menu");
		manningpane.add(back2, 1, 6);		
		
		Scene manningScene = new Scene(manningpane, 500, 500);
		
		Button manningremove = new Button("Remove from roster"); //buttons for after they are added to roster
		Button rosterback = new Button("Return to roster");
		
		manningadd.setOnAction(new EventHandler<ActionEvent>(){   //action for clicking add to roster
			@Override
			public void handle(ActionEvent e) {
				manningpane.getChildren().remove(manningadd);    //changes the buttons on the player scene once they are on the roster
				manningpane.add(manningremove, 0, 6);
				manningpane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);         //adds the player's button to the roster scene and makes sure the back button is always at the bottom
				rosterpane.getChildren().add(manningroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		manningremove.setOnAction(new EventHandler<ActionEvent>(){   //action for clicking remove from roster
			@Override
			public void handle(ActionEvent e) {
				manningpane.getChildren().remove(rosterback);      //changes buttons back after removing them from roster
				manningpane.getChildren().remove(manningremove);
				manningpane.add(manningadd, 0, 6);
				rosterpane.getChildren().remove(manningroster);   //removes player's button from roster scene
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		manningroster.setOnAction(new EventHandler<ActionEvent>(){   //brings you back to player's scene when clikcing on their name in roster
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(manningScene);
				primaryStage.show();
			}
		});
		
		rosterback.setOnAction(new EventHandler<ActionEvent>(){   //returns to roster scene instead of main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back2.setOnAction(new EventHandler<ActionEvent>(){   //main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane brownpane = new GridPane();
		brownpane.setAlignment(Pos.TOP_LEFT);
		brownpane.setPadding(new Insets(10, 10, 10, 10));
		brownpane.setHgap(20);
		brownpane.setVgap(20);
		
		Label brownname = new Label(new String(players.offensivelist.get(1).getName()));
		brownname.setFont(impact);
		brownpane.add(brownname, 0, 0);
		brownpane.add(new Label(new String(Integer.toString(players.offensivelist.get(1).getAge()) + " years old")), 1, 0);
		brownpane.add(new Label(new String(players.offensivelist.get(1).getPosition())), 0, 1);
		brownpane.add(new Label(new String("#"+ (players.offensivelist.get(1).getNumber()))), 1, 1);
		brownpane.add(new Label(new String("Pass Attempts: "+ Integer.toString(players.offensivelist.get(1).getPassAtt()))), 0, 2);
		brownpane.add(new Label(new String("Passes Completed: "+ Integer.toString(players.offensivelist.get(1).getPassCmp()))), 1, 2);
		brownpane.add(new Label(new String("Rushes Attempted: "+ Integer.toString(players.offensivelist.get(1).getRushAtt()))), 0, 3);
		brownpane.add(new Label(new String("Rushing Yards: "+ Integer.toString(players.offensivelist.get(1).getRushYrds()))), 1, 3);
		brownpane.add(new Label(new String("Receptions: "+ Integer.toString(players.offensivelist.get(1).getRec()))), 0, 4);
		brownpane.add(new Label(new String("Receiving Yards: "+ Integer.toString(players.offensivelist.get(1).getRecYrds()))), 1, 4);
		Button brownadd = new Button("Add to roster");
		brownpane.add(brownadd, 0, 6);
		Button back3 = new Button("Return to Main Menu");
		brownpane.add(back3, 1, 6);		
		
		Scene brownScene = new Scene(brownpane, 500, 500);
		
		Button brownremove = new Button("Remove from roster");
		Button rosterback1 = new Button("Return to roster");
		
		brownadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				brownpane.getChildren().remove(brownadd);
				brownpane.add(brownremove, 0, 6);
				brownpane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(brownroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		brownremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				brownpane.getChildren().remove(rosterback);
				brownpane.getChildren().remove(brownremove);
				brownpane.add(brownadd, 0, 6);
				rosterpane.getChildren().remove(brownroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		brownroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(brownScene);
				primaryStage.show();
			}
		});
		
		rosterback1.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back3.setOnAction(new EventHandler<ActionEvent>(){   
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane garconpane = new GridPane();
		garconpane.setAlignment(Pos.TOP_LEFT);
		garconpane.setPadding(new Insets(10, 10, 10, 10));
		garconpane.setHgap(20);
		garconpane.setVgap(20);
		
		Label garconname = new Label(new String(players.offensivelist.get(2).getName()));
		garconname.setFont(impact);
		garconpane.add(garconname, 0, 0);
		garconpane.add(new Label(new String(Integer.toString(players.offensivelist.get(2).getAge()) + " years old")), 1, 0);
		garconpane.add(new Label(new String(players.offensivelist.get(2).getPosition())), 0, 1);
		garconpane.add(new Label(new String("#"+ (players.offensivelist.get(2).getNumber()))), 1, 1);
		garconpane.add(new Label(new String("Pass Attempts: "+ Integer.toString(players.offensivelist.get(2).getPassAtt()))), 0, 2);
		garconpane.add(new Label(new String("Passes Completed: "+ Integer.toString(players.offensivelist.get(2).getPassCmp()))), 1, 2);
		garconpane.add(new Label(new String("Rushes Attempted: "+ Integer.toString(players.offensivelist.get(2).getRushAtt()))), 0, 3);
		garconpane.add(new Label(new String("Rushing Yards: "+ Integer.toString(players.offensivelist.get(2).getRushYrds()))), 1, 3);
		garconpane.add(new Label(new String("Receptions: "+ Integer.toString(players.offensivelist.get(2).getRec()))), 0, 4);
		garconpane.add(new Label(new String("Receiving Yards: "+ Integer.toString(players.offensivelist.get(2).getRecYrds()))), 1, 4);
		Button garconadd = new Button("Add to roster");
		garconpane.add(garconadd, 0, 6);
		Button back4 = new Button("Return to Main Menu");
		garconpane.add(back4, 1, 6);		
		
		Scene garconScene = new Scene(garconpane, 500, 500);
		
		Button garconremove = new Button("Remove from roster");
		Button rosterback2 = new Button("Return to roster");
		
		garconadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				garconpane.getChildren().remove(garconadd);
				garconpane.add(garconremove, 0, 6);
				garconpane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(garconroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		garconremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				garconpane.getChildren().remove(rosterback);
				garconpane.getChildren().remove(garconremove);
				garconpane.add(garconadd, 0, 6);
				rosterpane.getChildren().remove(garconroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		garconroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(garconScene);
				primaryStage.show();
			}
		});
		
		rosterback2.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back4.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane betheapane = new GridPane();
		betheapane.setAlignment(Pos.TOP_LEFT);
		betheapane.setPadding(new Insets(10, 10, 10, 10));
		betheapane.setHgap(20);
		betheapane.setVgap(20);
		
		Label betheaname = new Label(new String(players.defensivelist.get(0).getName()));
		betheaname.setFont(impact);
		betheapane.add(betheaname, 0, 0);
		betheapane.add(new Label(new String(Integer.toString(players.defensivelist.get(0).getAge()) + " years old")), 1, 0);
		betheapane.add(new Label(new String(players.defensivelist.get(0).getPosition())), 0, 1);
		betheapane.add(new Label(new String("#"+ (players.defensivelist.get(0).getNumber()))), 1, 1);
		betheapane.add(new Label(new String("Interceptions: "+ Integer.toString(players.defensivelist.get(0).getInter()))), 0, 2);
		betheapane.add(new Label(new String("Yards on Interceptions: "+ Integer.toString(players.defensivelist.get(0).getIntYrds()))), 1, 2);
		betheapane.add(new Label(new String("Sacks: "+ Integer.toString(players.defensivelist.get(0).getSacks()))), 0, 3);
		betheapane.add(new Label(new String("Tackles: "+ Integer.toString(players.defensivelist.get(0).getTackles()))), 1, 3);
		Button betheaadd = new Button("Add to roster");
		betheapane.add(betheaadd, 0, 6);
		Button back5 = new Button("Return to Main Menu");
		betheapane.add(back5, 1, 6);		
		
		Scene betheaScene = new Scene(betheapane, 500, 500);
		
		Button bethearemove = new Button("Remove from roster");
		Button rosterback3 = new Button("Return to roster");
		
		betheaadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				betheapane.getChildren().remove(betheaadd);
				betheapane.add(bethearemove, 0, 6);
				betheapane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(bethearoster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		bethearemove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				betheapane.getChildren().remove(rosterback);
				betheapane.getChildren().remove(bethearemove);
				betheapane.add(betheaadd, 0, 6);
				rosterpane.getChildren().remove(bethearoster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		bethearoster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(betheaScene);
				primaryStage.show();
			}
		});
		
		rosterback3.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back5.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane powerspane = new GridPane();
		powerspane.setAlignment(Pos.TOP_LEFT);
		powerspane.setPadding(new Insets(10, 10, 10, 10));
		powerspane.setHgap(20);
		powerspane.setVgap(20);
		
		Label powersname = new Label(new String(players.defensivelist.get(1).getName()));
		powersname.setFont(impact);
		powerspane.add(powersname, 0, 0);
		powerspane.add(new Label(new String(Integer.toString(players.defensivelist.get(1).getAge()) + " years old")), 1, 0);
		powerspane.add(new Label(new String(players.defensivelist.get(1).getPosition())), 0, 1);
		powerspane.add(new Label(new String("#"+ (players.defensivelist.get(1).getNumber()))), 1, 1);
		powerspane.add(new Label(new String("Interceptions: "+ Integer.toString(players.defensivelist.get(1).getInter()))), 0, 2);
		powerspane.add(new Label(new String("Yards on Interceptions: "+ Integer.toString(players.defensivelist.get(1).getIntYrds()))), 1, 2);
		powerspane.add(new Label(new String("Sacks: "+ Integer.toString(players.defensivelist.get(1).getSacks()))), 0, 3);
		powerspane.add(new Label(new String("Tackles: "+ Integer.toString(players.defensivelist.get(1).getTackles()))), 1, 3);
		Button powersadd = new Button("Add to roster");
		powerspane.add(powersadd, 0, 6);
		Button back6 = new Button("Return to Main Menu");
		powerspane.add(back6, 1, 6);		
		
		Scene powersScene = new Scene(powerspane, 500, 500);
		
		Button powersremove = new Button("Remove from roster");
		Button rosterback4 = new Button("Return to roster");
		
		powersadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				powerspane.getChildren().remove(powersadd);
				powerspane.add(powersremove, 0, 6);
				powerspane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(powersroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		powersremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				powerspane.getChildren().remove(rosterback);
				powerspane.getChildren().remove(powersremove);
				powerspane.add(powersadd, 0, 6);
				rosterpane.getChildren().remove(powersroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		powersroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(powersScene);
				primaryStage.show();
			}
		});
		
		rosterback4.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back6.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane cutlerpane = new GridPane();
		cutlerpane.setAlignment(Pos.TOP_LEFT);
		cutlerpane.setPadding(new Insets(10, 10, 10, 10));
		cutlerpane.setHgap(20);
		cutlerpane.setVgap(20);
		
		Label cutlername = new Label(new String(players.offensivelist.get(3).getName()));
		cutlername.setFont(impact);
		cutlerpane.add(cutlername, 0, 0);
		cutlerpane.add(new Label(new String(Integer.toString(players.offensivelist.get(3).getAge()) + " years old")), 1, 0);
		cutlerpane.add(new Label(new String(players.offensivelist.get(3).getPosition())), 0, 1);
		cutlerpane.add(new Label(new String("#"+ (players.offensivelist.get(3).getNumber()))), 1, 1);
		cutlerpane.add(new Label(new String("Pass Attempts: "+ Integer.toString(players.offensivelist.get(3).getPassAtt()))), 0, 2);
		cutlerpane.add(new Label(new String("Passes Completed: "+ Integer.toString(players.offensivelist.get(3).getPassCmp()))), 1, 2);
		cutlerpane.add(new Label(new String("Rushes Attempted: "+ Integer.toString(players.offensivelist.get(3).getRushAtt()))), 0, 3);
		cutlerpane.add(new Label(new String("Rushing Yards: "+ Integer.toString(players.offensivelist.get(3).getRushYrds()))), 1, 3);
		cutlerpane.add(new Label(new String("Receptions: "+ Integer.toString(players.offensivelist.get(3).getRec()))), 0, 4);
		cutlerpane.add(new Label(new String("Receiving Yards: "+ Integer.toString(players.offensivelist.get(3).getRecYrds()))), 1, 4);
		Button cutleradd = new Button("Add to roster");
		cutlerpane.add(cutleradd, 0, 6);
		Button back7 = new Button("Return to Main Menu");
		cutlerpane.add(back7, 1, 6);		
		
		Scene cutlerScene = new Scene(cutlerpane, 500, 500);
		
		Button cutlerremove = new Button("Remove from roster");
		Button rosterback5 = new Button("Return to roster");
		
		cutleradd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				cutlerpane.getChildren().remove(cutleradd);
				cutlerpane.add(cutlerremove, 0, 6);
				cutlerpane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(cutlerroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		cutlerremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				cutlerpane.getChildren().remove(rosterback);
				cutlerpane.getChildren().remove(cutlerremove);
				cutlerpane.add(cutleradd, 0, 6);
				rosterpane.getChildren().remove(cutlerroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		cutlerroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(cutlerScene);
				primaryStage.show();
			}
		});
		
		rosterback5.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back7.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane fortepane = new GridPane();
		fortepane.setAlignment(Pos.TOP_LEFT);
		fortepane.setPadding(new Insets(10, 10, 10, 10));
		fortepane.setHgap(20);
		fortepane.setVgap(20);
		
		Label fortename = new Label(new String(players.offensivelist.get(4).getName()));
		fortename.setFont(impact);
		fortepane.add(fortename, 0, 0);
		fortepane.add(new Label(new String(Integer.toString(players.offensivelist.get(4).getAge()) + " years old")), 1, 0);
		fortepane.add(new Label(new String(players.offensivelist.get(4).getPosition())), 0, 1);
		fortepane.add(new Label(new String("#"+ (players.offensivelist.get(4).getNumber()))), 1, 1);
		fortepane.add(new Label(new String("Pass Attempts: "+ Integer.toString(players.offensivelist.get(4).getPassAtt()))), 0, 2);
		fortepane.add(new Label(new String("Passes Completed: "+ Integer.toString(players.offensivelist.get(4).getPassCmp()))), 1, 2);
		fortepane.add(new Label(new String("Rushes Attempted: "+ Integer.toString(players.offensivelist.get(4).getRushAtt()))), 0, 3);
		fortepane.add(new Label(new String("Rushing Yards: "+ Integer.toString(players.offensivelist.get(4).getRushYrds()))), 1, 3);
		fortepane.add(new Label(new String("Receptions: "+ Integer.toString(players.offensivelist.get(4).getRec()))), 0, 4);
		fortepane.add(new Label(new String("Receiving Yards: "+ Integer.toString(players.offensivelist.get(4).getRecYrds()))), 1, 4);
		Button forteadd = new Button("Add to roster");
		fortepane.add(forteadd, 0, 6);
		Button back8 = new Button("Return to Main Menu");
		fortepane.add(back8, 1, 6);		
		
		Scene forteScene = new Scene(fortepane, 500, 500);
		
		Button forteremove = new Button("Remove from roster");
		Button rosterback6 = new Button("Return to roster");
		
		forteadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				fortepane.getChildren().remove(forteadd);
				fortepane.add(forteremove, 0, 6);
				fortepane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(forteroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		forteremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				fortepane.getChildren().remove(rosterback);
				fortepane.getChildren().remove(forteremove);
				fortepane.add(forteadd, 0, 6);
				rosterpane.getChildren().remove(forteroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		forteroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(forteScene);
				primaryStage.show();
			}
		});
		
		rosterback6.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back8.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane knoxpane = new GridPane();
		knoxpane.setAlignment(Pos.TOP_LEFT);
		knoxpane.setPadding(new Insets(10, 10, 10, 10));
		knoxpane.setHgap(20);
		knoxpane.setVgap(20);
		
		Label knoxname = new Label(new String(players.offensivelist.get(5).getName()));
		knoxname.setFont(impact);
		knoxpane.add(knoxname, 0, 0);
		knoxpane.add(new Label(new String(Integer.toString(players.offensivelist.get(5).getAge()) + " years old")), 1, 0);
		knoxpane.add(new Label(new String(players.offensivelist.get(5).getPosition())), 0, 1);
		knoxpane.add(new Label(new String("#"+ (players.offensivelist.get(5).getNumber()))), 1, 1);
		knoxpane.add(new Label(new String("Pass Attempts: "+ Integer.toString(players.offensivelist.get(5).getPassAtt()))), 0, 2);
		knoxpane.add(new Label(new String("Passes Completed: "+ Integer.toString(players.offensivelist.get(5).getPassCmp()))), 1, 2);
		knoxpane.add(new Label(new String("Rushes Attempted: "+ Integer.toString(players.offensivelist.get(5).getRushAtt()))), 0, 3);
		knoxpane.add(new Label(new String("Rushing Yards: "+ Integer.toString(players.offensivelist.get(5).getRushYrds()))), 1, 3);
		knoxpane.add(new Label(new String("Receptions: "+ Integer.toString(players.offensivelist.get(5).getRec()))), 0, 4);
		knoxpane.add(new Label(new String("Receiving Yards: "+ Integer.toString(players.offensivelist.get(5).getRecYrds()))), 1, 4);
		Button knoxadd = new Button("Add to roster");
		knoxpane.add(knoxadd, 0, 6);
		Button back9 = new Button("Return to Main Menu");
		knoxpane.add(back9, 1, 6);		
		
		Scene knoxScene = new Scene(knoxpane, 500, 500);
		
		Button knoxremove = new Button("Remove from roster");
		Button rosterback7 = new Button("Return to roster");
		
		knoxadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				knoxpane.getChildren().remove(knoxadd);
				knoxpane.add(knoxremove, 0, 6);
				knoxpane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(knoxroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		knoxremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				knoxpane.getChildren().remove(rosterback);
				knoxpane.getChildren().remove(knoxremove);
				knoxpane.add(knoxadd, 0, 6);
				rosterpane.getChildren().remove(knoxroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		knoxroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(knoxScene);
				primaryStage.show();
			}
		});
		
		rosterback7.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back9.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane harrispane = new GridPane();
		harrispane.setAlignment(Pos.TOP_LEFT);
		harrispane.setPadding(new Insets(10, 10, 10, 10));
		harrispane.setHgap(20);
		harrispane.setVgap(20);
		
		Label harrisname = new Label(new String(players.defensivelist.get(2).getName()));
		harrisname.setFont(impact);
		harrispane.add(harrisname, 0, 0);
		harrispane.add(new Label(new String(Integer.toString(players.defensivelist.get(2).getAge()) + " years old")), 1, 0);
		harrispane.add(new Label(new String(players.defensivelist.get(2).getPosition())), 0, 1);
		harrispane.add(new Label(new String("#"+ (players.defensivelist.get(2).getNumber()))), 1, 1);
		harrispane.add(new Label(new String("Interceptions: "+ Integer.toString(players.defensivelist.get(2).getInter()))), 0, 2);
		harrispane.add(new Label(new String("Yards on Interceptions: "+ Integer.toString(players.defensivelist.get(2).getIntYrds()))), 1, 2);
		harrispane.add(new Label(new String("Sacks: "+ Integer.toString(players.defensivelist.get(2).getSacks()))), 0, 3);
		harrispane.add(new Label(new String("Tackles: "+ Integer.toString(players.defensivelist.get(2).getTackles()))), 1, 3);
		Button harrisadd = new Button("Add to roster");
		harrispane.add(harrisadd, 0, 6);
		Button back10 = new Button("Return to Main Menu");
		harrispane.add(back10, 1, 6);		
		
		Scene harrisScene = new Scene(harrispane, 500, 500);
		
		Button harrisremove = new Button("Remove from roster");
		Button rosterback8 = new Button("Return to roster");
		
		harrisadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				harrispane.getChildren().remove(harrisadd);
				harrispane.add(harrisremove, 0, 6);
				harrispane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(harrisroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		harrisremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				harrispane.getChildren().remove(rosterback);
				harrispane.getChildren().remove(harrisremove);
				harrispane.add(harrisadd, 0, 6);
				rosterpane.getChildren().remove(harrisroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		harrisroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(harrisScene);
				primaryStage.show();
			}
		});
		
		rosterback8.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back10.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//------------------
		
		GridPane tillmanpane = new GridPane();
		tillmanpane.setAlignment(Pos.TOP_LEFT);
		tillmanpane.setPadding(new Insets(10, 10, 10, 10));
		tillmanpane.setHgap(20);
		tillmanpane.setVgap(20);
		
		Label tillmanname = new Label(new String(players.defensivelist.get(3).getName()));
		tillmanname.setFont(impact);
		tillmanpane.add(tillmanname, 0, 0);
		tillmanpane.add(new Label(new String(Integer.toString(players.defensivelist.get(3).getAge()) + " years old")), 1, 0);
		tillmanpane.add(new Label(new String(players.defensivelist.get(3).getPosition())), 0, 1);
		tillmanpane.add(new Label(new String("#"+ (players.defensivelist.get(3).getNumber()))), 1, 1);
		tillmanpane.add(new Label(new String("Interceptions: "+ Integer.toString(players.defensivelist.get(3).getInter()))), 0, 2);
		tillmanpane.add(new Label(new String("Yards on Interceptions: "+ Integer.toString(players.defensivelist.get(3).getIntYrds()))), 1, 2);
		tillmanpane.add(new Label(new String("Sacks: "+ Integer.toString(players.defensivelist.get(3).getSacks()))), 0, 3);
		tillmanpane.add(new Label(new String("Tackles: "+ Integer.toString(players.defensivelist.get(3).getTackles()))), 1, 3);
		Button tillmanadd = new Button("Add to roster");
		tillmanpane.add(tillmanadd, 0, 6);
		Button back11 = new Button("Return to Main Menu");
		tillmanpane.add(back11, 1, 6);		
		
		Scene tillmanScene = new Scene(tillmanpane, 500, 500);
		
		Button tillmanremove = new Button("Remove from roster");
		Button rosterback9 = new Button("Return to roster");
		
		tillmanadd.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				tillmanpane.getChildren().remove(tillmanadd);
				tillmanpane.add(tillmanremove, 0, 6);
				tillmanpane.add(rosterback, 1, 7);
				rosterpane.getChildren().remove(back19);
				rosterpane.getChildren().add(tillmanroster);
				rosterpane.getChildren().add(back19);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		tillmanremove.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				tillmanpane.getChildren().remove(rosterback);
				tillmanpane.getChildren().remove(tillmanremove);
				tillmanpane.add(tillmanadd, 0, 6);
				rosterpane.getChildren().remove(tillmanroster);
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		tillmanroster.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(tillmanScene);
				primaryStage.show();
			}
		});
		
		rosterback9.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rosterScene);
				primaryStage.show();
			}
		});
		
		back11.setOnAction(new EventHandler<ActionEvent>(){   
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		//-----------------------------------------------------------------------------------
		                                                                  //Select by number
		Pane numselect = new VBox(25);                   
		numselect.setPadding(new Insets(20, 20, 20, 20));
		((VBox) numselect).setAlignment(Pos.CENTER);
		
		
		Label numselect1 = new Label(new String("Enter a player's number to see their stats"));
		numselect1.setFont(Font.font("Impact", 20));         
		numselect.getChildren().add(numselect1);
		
		Label numselecterror = new Label(new String("Please enter a player's one or two digit number"));
		numselecterror.setFont(Font.font("Impact", 15));
		numselecterror.setTextFill(Color.color(1, 0, 0));
		                                                                  //sets up number scene
		TextField playernumber = new TextField();
		playernumber.setPromptText("Two digit number");
		numselect.getChildren().add(playernumber);
		
		Button numsubmit = new Button("Submit");
		numselect.getChildren().add(numsubmit);
		
		Button back = new Button("Return to Main Menu");
		back.setAlignment(Pos.BOTTOM_RIGHT);
		numselect.getChildren().add(back);

		Scene numselectScene = new Scene(numselect, 500, 500);
		
		numsubmit.setOnAction(new EventHandler<ActionEvent>(){ 
			@Override
			public void handle(ActionEvent e) {
				if ((playernumber.getText().equals(players.offensivelist.get(0).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(manningScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.offensivelist.get(1).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(brownScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.offensivelist.get(2).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(garconScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.offensivelist.get(3).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(cutlerScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.offensivelist.get(4).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(forteScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.offensivelist.get(5).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(knoxScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.defensivelist.get(0).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(betheaScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.defensivelist.get(1).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(powersScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.defensivelist.get(2).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(harrisScene);
					primaryStage.show();
				}
				
				else if ((playernumber.getText().equals(players.defensivelist.get(3).getNumber()))) {
					numselect.getChildren().remove(numselecterror);
					primaryStage.setScene(tillmanScene);
					primaryStage.show();
				}
				
				else {
					numselect.getChildren().remove(numsubmit);
					numselect.getChildren().remove(back);
					numselect.getChildren().add(numselecterror);
					numselect.getChildren().add(numsubmit);
					numselect.getChildren().add(back);
					primaryStage.setScene(numselectScene);
					primaryStage.show();
				}
			}
		});
		
		number.setOnAction(new EventHandler<ActionEvent>(){  //by number button action from main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(numselectScene);
				primaryStage.show();
			}
		});
		
		back.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		//------------------------------------------------------------------------------------
		                                                                       //Position Screens
		Pane offenseplayers = new VBox(25);
		offenseplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) offenseplayers).setAlignment(Pos.CENTER);
		
		Label offensetitle = new Label(new String("Select a player to see their stats"));
		offensetitle.setFont(impact);
		offenseplayers.getChildren().add(offensetitle);
		
		Button offmanning = new Button(players.offensivelist.get(0).getName());
		offenseplayers.getChildren().add(offmanning);
		
		Button offbrown = new Button(players.offensivelist.get(1).getName());
		offenseplayers.getChildren().add(offbrown);
		
		Button offgarcon = new Button(players.offensivelist.get(2).getName());
		offenseplayers.getChildren().add(offgarcon);
		
		Button offcutler = new Button(players.offensivelist.get(3).getName());
		offenseplayers.getChildren().add(offcutler);
		
		Button offforte = new Button(players.offensivelist.get(4).getName());
		offenseplayers.getChildren().add(offforte);
		
		Button offknox = new Button(players.offensivelist.get(5).getName());
		offenseplayers.getChildren().add(offknox);
		
		Button back12 = new Button("Return to Main Menu");
		back12.setAlignment(Pos.BOTTOM_RIGHT);
		offenseplayers.getChildren().add(back12);
		
		Scene offenseplayersScene = new Scene(offenseplayers, 500, 500);
		
		offmanning.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(manningScene);
				primaryStage.show();
			}
		});
		
		offbrown.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(brownScene);
				primaryStage.show();
			}
		});
		
		offgarcon.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(garconScene);
				primaryStage.show();
			}
		});
		
		offcutler.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(cutlerScene);
				primaryStage.show();
			}
		});
		
		offforte.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(forteScene);
				primaryStage.show();
			}
		});
		
		offknox.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(knoxScene);
				primaryStage.show();
			}
		});
		
		back12.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//--------------------
		
		Pane defenseplayers = new VBox(25);
		defenseplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) defenseplayers).setAlignment(Pos.CENTER);
		
		Label defensetitle = new Label(new String("Select a player to see their stats"));
		defensetitle.setFont(impact);
		defenseplayers.getChildren().add(defensetitle);
		
		Button defbethea = new Button(players.defensivelist.get(0).getName());
		defenseplayers.getChildren().add(defbethea);
		
		Button defpowers = new Button(players.defensivelist.get(1).getName());
		defenseplayers.getChildren().add(defpowers);
		
		Button defharris = new Button(players.defensivelist.get(2).getName());
		defenseplayers.getChildren().add(defharris);
		
		Button deftillman = new Button(players.defensivelist.get(3).getName());
		defenseplayers.getChildren().add(deftillman);
		
		Button back13 = new Button("Return to Main Menu");
		back13.setAlignment(Pos.BOTTOM_RIGHT);
		defenseplayers.getChildren().add(back13);
		
		Scene defenseplayersScene = new Scene(defenseplayers, 500, 500);
		
		defbethea.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(betheaScene);
				primaryStage.show();
			}
		});
		
		defpowers.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(powersScene);
				primaryStage.show();
			}
		});
		
		defharris.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(harrisScene);
				primaryStage.show();
			}
		});
		
		deftillman.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(tillmanScene);
				primaryStage.show();
			}
		});
		
		back13.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//--------------------
		
		Pane quarplayers = new VBox(25);
		quarplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) quarplayers).setAlignment(Pos.CENTER);
		
		Label quartitle = new Label(new String("Select a Quarterback to see their stats"));
		quartitle.setFont(impact);
		quarplayers.getChildren().add(quartitle);
		
		Button quarmanning = new Button(players.offensivelist.get(0).getName());
		quarplayers.getChildren().add(quarmanning);
		
		Button quarcutler = new Button(players.offensivelist.get(3).getName());
		quarplayers.getChildren().add(quarcutler);
		
		Button back14 = new Button("Return to Main Menu");
		back14.setAlignment(Pos.BOTTOM_RIGHT);
		quarplayers.getChildren().add(back14);
		
		Scene quarplayersScene = new Scene(quarplayers, 500, 500);
		
		quarmanning.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(manningScene);
				primaryStage.show();
			}
		});
		
		quarcutler.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(cutlerScene);
				primaryStage.show();
			}
		});
		
		back14.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//--------------------
		
		Pane runplayers = new VBox(25);
		runplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) runplayers).setAlignment(Pos.CENTER);
		
		Label runtitle = new Label(new String("Select a Running Back to see their stats"));
		runtitle.setFont(impact);
		runplayers.getChildren().add(runtitle);
		
		Button runbrown = new Button(players.offensivelist.get(1).getName());
		runplayers.getChildren().add(runbrown);
		
		Button runforte = new Button(players.offensivelist.get(4).getName());
		runplayers.getChildren().add(runforte);
		
		Button back15 = new Button("Return to Main Menu");
		back15.setAlignment(Pos.BOTTOM_RIGHT);
		runplayers.getChildren().add(back15);
		
		Scene runplayersScene = new Scene(runplayers, 500, 500);
		
		runbrown.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(brownScene);
				primaryStage.show();
			}
		});
		
		runforte.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(forteScene);
				primaryStage.show();
			}
		});
		
		back15.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//--------------------
		
		Pane wideplayers = new VBox(25);
		wideplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) wideplayers).setAlignment(Pos.CENTER);
		
		Label widetitle = new Label(new String("Select a Wide Receiver to see their stats"));
		widetitle.setFont(impact);
		wideplayers.getChildren().add(widetitle);
		
		Button widegarcon = new Button(players.offensivelist.get(2).getName());
		wideplayers.getChildren().add(widegarcon);
		
		Button wideknox = new Button(players.offensivelist.get(5).getName());
		wideplayers.getChildren().add(wideknox);
		
		Button back16 = new Button("Return to Main Menu");
		back16.setAlignment(Pos.BOTTOM_RIGHT);
		wideplayers.getChildren().add(back16);
		
		Scene wideplayersScene = new Scene(wideplayers, 500, 500);
		
		widegarcon.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(garconScene);
				primaryStage.show();
			}
		});
		
		wideknox.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(knoxScene);
				primaryStage.show();
			}
		});
		
		back16.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//--------------------
		
		Pane freeplayers = new VBox(25);
		freeplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) freeplayers).setAlignment(Pos.CENTER);
		
		Label freetitle = new Label(new String("Select a Free Safety to see their stats"));
		freetitle.setFont(impact);
		freeplayers.getChildren().add(freetitle);
		
		Button freebethea = new Button(players.defensivelist.get(0).getName());
		freeplayers.getChildren().add(freebethea);
		
		Button freeharris = new Button(players.defensivelist.get(2).getName());
		freeplayers.getChildren().add(freeharris);
		
		Button back17 = new Button("Return to Main Menu");
		back17.setAlignment(Pos.BOTTOM_RIGHT);
		freeplayers.getChildren().add(back17);
		
		Scene freeplayersScene = new Scene(freeplayers, 500, 500);
		
		freebethea.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(betheaScene);
				primaryStage.show();
			}
		});
		
		freeharris.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(harrisScene);
				primaryStage.show();
			}
		});
		
		back17.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});//--------------------
		
		Pane rightplayers = new VBox(25);
		rightplayers.setPadding(new Insets(20, 20, 20, 20));
		((VBox) rightplayers).setAlignment(Pos.CENTER);
		
		Label righttitle = new Label(new String("Select a Right Cornerback to see their stats"));
		righttitle.setFont(impact);
		rightplayers.getChildren().add(righttitle);
		
		Button rightpowers = new Button(players.defensivelist.get(1).getName());
		rightplayers.getChildren().add(rightpowers);
		
		Button righttillman = new Button(players.defensivelist.get(3).getName());
		rightplayers.getChildren().add(righttillman);
		
		Button back18 = new Button("Return to Main Menu");
		back18.setAlignment(Pos.BOTTOM_RIGHT);
		rightplayers.getChildren().add(back18);
		
		Scene rightplayersScene = new Scene(rightplayers, 500, 500);
		
		rightpowers.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(powersScene);
				primaryStage.show();
			}
		});
		
		righttillman.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(tillmanScene);
				primaryStage.show();
			}
		});
		
		back18.setOnAction(new EventHandler<ActionEvent>(){   //back button to main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		//------------------------------------------------------------------------------------
		                                                                       //select by position
		GridPane posselect = new GridPane();
		posselect.setAlignment(Pos.CENTER);
		posselect.setPadding(new Insets(10, 10, 10, 10));
		posselect.setHgap(20);
		posselect.setVgap(20);
		
		Button offense = new Button("All offensive players");                //adds position options
		Button defense = new Button("All defensive players");
		Button quarter = new Button("Quarterbacks");
		Button run     = new Button("Running Backs");
		Button wide    = new Button("Wide Receiver");
		Button free    = new Button("Free Safety");
		Button right   = new Button("Right Cornerback");
		Label postitle = new Label(new String("Select a position"));
		postitle.setFont(Font.font("Impact", 20));
		
		posselect.add(postitle, 0, 0);
		posselect.add(offense, 0, 1);
		posselect.add(quarter, 0, 2);
		posselect.add(run, 0, 3);
		posselect.add(wide, 0, 4);
		posselect.add(defense, 1, 1);
		posselect.add(free, 1, 2);
		posselect.add(right, 1, 3);
		Button back1 = new Button("Return to Main Menu");
		posselect.add(back1, 1, 6);
		
		Scene posselectScene = new Scene(posselect, 500, 500);
		
		position.setOnAction(new EventHandler<ActionEvent>(){  //by number button action from main menu
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(posselectScene);
				primaryStage.show();
			}
		});
		
		offense.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(offenseplayersScene);
				primaryStage.show();
			}
		});
		
		defense.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(defenseplayersScene);
				primaryStage.show();
			}
		});
		
		quarter.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(quarplayersScene);
				primaryStage.show();
			}
		});
		
		run.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(runplayersScene);
				primaryStage.show();
			}
		});
		
		wide.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(wideplayersScene);
				primaryStage.show();
			}
		});
		
		free.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(freeplayersScene);
				primaryStage.show();
			}
		});
		
		right.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(rightplayersScene);
				primaryStage.show();
			}
		});
		
		back1.setOnAction(new EventHandler<ActionEvent>(){   //Start button action from start screen
			@Override
			public void handle(ActionEvent e) {
				primaryStage.setScene(mainScene);
				primaryStage.show();
			}
		});
		
		//------------------------------------------------------------------------------------
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
