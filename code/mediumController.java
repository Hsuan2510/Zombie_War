package project;

import java.net.URL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class mediumController implements Initializable{
	static int bestmin=1000,bestsec=1000;
	Timeline Died;
	Timeline rc1;
	Timeline MakeZ;
	Timeline manmove;
	Timeline fps1;
	Timeline fps2;
	Timeline fps3;
	Timeline fps4;
	Timeline move;
	Timeline clock;
	Timeline Attack;
	ArrayList<Timeline> Move=new ArrayList<Timeline>();
	public int sec=0,min=0;
	public int m=1000;
	@FXML
	public Button Back;
	public Button Back1;
	@FXML
	public void onBackPressed(){
			MAIN.currentStage.setScene(MAIN.menuScene);
	}
	@FXML
	public AnchorPane _field;
	@FXML
	public ImageView bullet;
	LinkedList<ImageView > bullets1=new LinkedList<ImageView >();
	LinkedList<ImageView > bullets2=new LinkedList<ImageView >();
	LinkedList<ImageView > bullets3=new LinkedList<ImageView >();
	LinkedList<ImageView > bullets4=new LinkedList<ImageView >();
	@FXML
	public AnchorPane PauseField;
	public Button GoBack;
	public ImageView wasd;
	public ImageView ground;
	public Text AT;
	public Text one;
	public Text two;
	public Text three;
	public Text YW;
	public Text Spent;
	public Text _time;
	public Text GO;
	public Text at;
	public Text value;
	public Text BS;
	public Text rec;
	@FXML
	public void GoBackPressed(){
		MAIN.currentStage.setScene(MAIN.menuScene);
	}
	@FXML
	public ImageView man;
	@FXML
	public ImageView zombie;
	ArrayList<ImageView> zombies=new ArrayList<ImageView>();
	private int record=0;
	private boolean up=false,left=false,down=false,right=false,space=false;
	public boolean pause=false;
	public int cnt=0;
	public int shoot=0;
	public int blood;
	public void pressedHandle(KeyEvent e) {
			if(e.getCode()==KeyCode.W) {
				up=true;
			}
			if(e.getCode()==KeyCode.A) {
				left=true;
			}
			if(e.getCode()==KeyCode.S) {
				down=true;
			}
			if(e.getCode()==KeyCode.D) {
				right=true;
			}
			if(e.getCode()==KeyCode.SPACE) {
				space=true;
			}
			if(e.getCode()==KeyCode.P) {
				pause=!pause;
				if(pause) {
					manmove.pause();
					MakeZ.pause();
					fps1.pause();
					fps2.pause();
					fps3.pause();
					fps4.pause();
					rc1.pause();
					Died.pause();
					clock.pause();
					Attack.pause();
					for(int i=0;i<Move.size();i++) {
						Move.get(i).pause();
					}
					PauseField.setVisible(true);
					GoBack.setVisible(true);
					wasd.setVisible(true);
					ground.setVisible(true);
					one.setVisible(true);
					two.setVisible(true);
					three.setVisible(true);
				}
				else {
					rc1.play();
					MakeZ.play();
					manmove.play();
					fps1.play();
					fps2.play();
					fps3.play();
					fps4.play();
					Died.play();
					clock.play();
					Attack.play();
					for(int i=0;i<Move.size();i++) {
						Move.get(i).play();
					}
					PauseField.setVisible(false);
					GoBack.setVisible(false);
					wasd.setVisible(false);
					ground.setVisible(false);
					one.setVisible(false);
					two.setVisible(false);
					three.setVisible(false);
				}
			}
        }
	
	public void releaseHandle(KeyEvent e) {
			if(e.getCode()==KeyCode.W) {
				up=false;
				
			}
			if(e.getCode()==KeyCode.A) {
				left=false;
				
			}
			if(e.getCode()==KeyCode.S) {
				down=false;
				
			}
			if(e.getCode()==KeyCode.D) {
				right=false;
			}
			if(e.getCode()==KeyCode.SPACE) {
				space=false;
			}
    }
	
	public void animation(ImageView Z) {
		move = new Timeline(new KeyFrame(Duration.millis(m),(e)-> {
    		double x = Z.getLayoutX()+Z.getFitWidth()/2;
    		double y = Z.getLayoutY()+Z.getFitHeight()/2;
    		if(Z.getLayoutY()<0||Z.getLayoutY()+Z.getFitHeight()>_field.getHeight())  Z.setLayoutY(Z.getLayoutY());
			if(Z.getLayoutX()<0||Z.getLayoutX()+Z.getFitWidth()>_field.getWidth())  Z.setLayoutX(Z.getLayoutX());
			if(x>man.getLayoutX()&& x<man.getLayoutX()+man.getFitWidth()) {
				if(y>man.getLayoutY()+man.getFitHeight()/2) {
					Z.setLayoutY(Z.getLayoutY()-20);
					Z.setRotate(180);
					if(x>man.getLayoutX()+15 && x<man.getLayoutX()+40) {
						Z.setLayoutX(Z.getLayoutX()+10);
					}
					else if(x>man.getLayoutX()+man.getFitWidth()/2 && x<man.getLayoutX()+70) {
						Z.setLayoutX(Z.getLayoutX()-10);
					}
					else if(x==man.getLayoutX()+man.getFitWidth()/2) {
						Z.setLayoutX(Z.getLayoutX());
					}
				}
				if (y<man.getLayoutY()+man.getFitHeight()/2) {
					Z.setLayoutY(Z.getLayoutY()+20);
					Z.setRotate(0);
					if(x>man.getLayoutX()+15 && x<man.getLayoutX()+40) {
						Z.setLayoutX(Z.getLayoutX()+10);
					}
					else if(x>man.getLayoutX()+man.getFitWidth()/2 && x<man.getLayoutX()+70) {
						Z.setLayoutX(Z.getLayoutX()-10);
					}
					else if(x==man.getLayoutX()+man.getFitWidth()/2) {
						Z.setLayoutX(Z.getLayoutX());
					}
				}
				
			}
			else if(y>man.getLayoutY() && y<man.getLayoutY()+man.getFitHeight()) {
				if(x>man.getLayoutX()+man.getFitWidth()/2) {
					Z.setLayoutX(Z.getLayoutX()-20);
					Z.setRotate(90);
					if(y>man.getLayoutY()+35 && y<man.getLayoutY()+man.getFitHeight()/2 ) {
						Z.setLayoutY(Z.getLayoutY()+10);
					}
					else if(y>man.getLayoutY()+man.getFitHeight()/2 && y<man.getLayoutY()+80) {
						Z.setLayoutY(Z.getLayoutY()-10);
					}
					else if(y==man.getLayoutY()+man.getFitHeight()/2) {
						Z.setLayoutY(Z.getLayoutY());
					}
				}
				if(x<man.getLayoutX()+man.getFitWidth()/2) {
					Z.setLayoutX(Z.getLayoutX()+20);
					Z.setRotate(270);
					if(y>man.getLayoutY()+35 && y<man.getLayoutY()+man.getFitHeight()/2 ) {
						Z.setLayoutY(Z.getLayoutY()+10);
					}
					else if(y>man.getLayoutY()+man.getFitHeight()/2 && y<man.getLayoutY()+80) {
						Z.setLayoutY(Z.getLayoutY()-10);
					}
					else if(y==man.getLayoutY()+man.getFitHeight()/2) {
						Z.setLayoutY(Z.getLayoutY());
					}
				}
			}
			else {
				if (x<man.getLayoutX()+man.getFitWidth()/2) {
					Z.setLayoutX(Z.getLayoutX()+20);
				}
				if (x>man.getLayoutX()+man.getFitWidth()/2) {
					Z.setLayoutX(Z.getLayoutX()-20);
				}
				if (y>man.getLayoutY()+man.getFitHeight()/2) {
					Z.setLayoutY(Z.getLayoutY()-20);
					Z.setRotate(180);
				}
				if (y<man.getLayoutY()+man.getFitHeight()/2) {
					Z.setLayoutY(Z.getLayoutY()+20);
					Z.setRotate(0);
				}
			}
			
			}));
			move.setCycleCount(Timeline.INDEFINITE);
			Move.add(move);
			move.play();
	}
	public void best() {
		if(min<bestmin) {
			BS.setText("BestScore:"+String.format("%02d",min)+":"+String.format("%02d", sec));
			MenuCotroller.twomin=min;
			MenuCotroller.twosec=sec;
			rec.setVisible(true);
			
		}
		else if(min==bestmin) {
			if(sec<bestsec) {
				BS.setText("BestScore:"+String.format("%02d",min)+":"+String.format("%02d", sec));
				MenuCotroller.twomin=min;
				MenuCotroller.twosec=sec;
				rec.setVisible(true);
			}
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(MenuCotroller.twomin!=1000) {
			bestmin=MenuCotroller.twomin;
			bestsec=MenuCotroller.twosec;
			BS.setText("BestScore:"+String.format("%02d",MenuCotroller.twomin)+":"+String.format("%02d", MenuCotroller.twosec));
		}
		blood=100;
		record=0;
		fps1=new Timeline(new KeyFrame(Duration.millis(1000/60),(e)->{
			int run=1;
			ArrayList<ImageView> tBullets=new ArrayList<ImageView>(bullets1);
			for(var b :tBullets) {
				if(run==0) break;
				b.setLayoutY(b.getLayoutY()-5);
				for(var Z :zombies) {
					if(b.getLayoutX()+b.getFitWidth()/2>Z.getLayoutX() && b.getLayoutX()+b.getFitWidth()/2<Z.getLayoutX()+70) {
						if(b.getLayoutY()+b.getFitHeight()/2>Z.getLayoutY() && b.getLayoutY()+b.getFitHeight()/2<Z.getLayoutY()+80) {
							bullets1.remove(b);
							_field.getChildren().remove(b);
							zombies.remove(Z);
							_field.getChildren().remove(Z);
							run=0;
							shoot++;
							if(shoot==100) {
								best();
								YW.setVisible(true);
								Spent.setVisible(true);
								_time.setText(String.format("%02d",min)+":"+String.format("%02d", sec));
								_time.setVisible(true);
								Died.stop();
								rc1.stop();
								MakeZ.stop();
								manmove.stop();
								fps1.stop();
								fps2.stop();
								fps3.stop();
								fps4.stop();
								move.stop();
								clock.stop();
								Attack.stop();
							}
							break;
						}
					}
				}
				/*for(int i=0;i<zombies.size();i++) {
					if(b.getLayoutX()>zombies.get(i).getLayoutX() && b.getLayoutX()<zombies.get(i).getLayoutX()+70) {
						if(b.getLayoutY()>zombies.get(i).getLayoutY() && b.getLayoutY()<zombies.get(i).getLayoutY()+80) {
							bullets1.remove(b);
							_field.getChildren().remove(b);
							ImageView temp;
							temp=zombies.get(i);
							zombies.set(i, zombies.get(zombies.size()-1));
							zombies.set(zombies.size()-1,temp);
							zombies.remove(zombies.size()-1);
							_field.getChildren().remove(zombies.get(zombies.size()-1));
						}
					}
				}*/
				if(b.getLayoutY()<0||b.getLayoutY()>_field.getHeight()||b.getLayoutX()>_field.getWidth()||b.getLayoutX()<0) {
					bullets1.remove(b);
					_field.getChildren().remove(b);
				}
				}}));
		fps2=new Timeline(new KeyFrame(Duration.millis(1000/60),(e)->{
			ArrayList<ImageView> tBullets=new ArrayList<ImageView>(bullets2);
			int run=1;
			for(var b :tBullets) {
				if(run==0) break;
				b.setLayoutX(b.getLayoutX()-5);
				for(var Z :zombies) {
					if(b.getLayoutX()+b.getFitWidth()/2>Z.getLayoutX() && b.getLayoutX()+b.getFitWidth()/2<Z.getLayoutX()+70) {
						if(b.getLayoutY()+b.getFitHeight()/2>Z.getLayoutY() && b.getLayoutY()+b.getFitHeight()/2<Z.getLayoutY()+80) {
							bullets2.remove(b);
							_field.getChildren().remove(b);
							zombies.remove(Z);
							_field.getChildren().remove(Z);
							run=0;
							shoot++;
							if(shoot==100) {
								best();
								YW.setVisible(true);
								Spent.setVisible(true);
								_time.setText(String.format("%02d",min)+":"+String.format("%02d", sec));
								_time.setVisible(true);
								Died.stop();
								rc1.stop();
								MakeZ.stop();
								manmove.stop();
								fps1.stop();
								fps2.stop();
								fps3.stop();
								fps4.stop();
								move.stop();
								clock.stop();
								Attack.stop();
							}
							break;
						}
					}
				}
				if(b.getLayoutY()<0||b.getLayoutY()>800||b.getLayoutX()>750||b.getLayoutX()<0) {
					bullets2.remove(b);
					_field.getChildren().remove(b);
				}
				}}));
		fps3=new Timeline(new KeyFrame(Duration.millis(1000/60),(e)->{
			ArrayList<ImageView> tBullets=new ArrayList<ImageView>(bullets3);
			int run=1;
			for(var b :tBullets) {
				if(run==0) break;
				b.setLayoutY(b.getLayoutY()+5);
				for(var Z :zombies) {
					if(b.getLayoutX()+b.getFitWidth()/2>Z.getLayoutX() && b.getLayoutX()+b.getFitWidth()/2<Z.getLayoutX()+70) {
						if(b.getLayoutY()+b.getFitHeight()/2>Z.getLayoutY() && b.getLayoutY()+b.getFitHeight()/2<Z.getLayoutY()+80) {
							bullets3.remove(b);
							_field.getChildren().remove(b);
							zombies.remove(Z);
							_field.getChildren().remove(Z);
							run=0;
							shoot++;
							if(shoot==100) {
								best();
								YW.setVisible(true);
								Spent.setVisible(true);
								_time.setText(String.format("%02d",min)+":"+String.format("%02d", sec));
								_time.setVisible(true);
								Died.stop();
								rc1.stop();
								MakeZ.stop();
								manmove.stop();
								fps1.stop();
								fps2.stop();
								fps3.stop();
								fps4.stop();
								move.stop();
								clock.stop();
								Attack.stop();
							}
							break;
						}
					}
				}
				if(b.getLayoutY()<0||b.getLayoutY()>800||b.getLayoutX()>750||b.getLayoutX()<0) {
					bullets3.remove(b);
					_field.getChildren().remove(b);
				}
				}}));
		fps4=new Timeline(new KeyFrame(Duration.millis(1000/60),(e)->{
			int run=1;
			ArrayList<ImageView> tBullets=new ArrayList<ImageView>(bullets4);
			for(var b :tBullets) {
				if(run==0)break;
				b.setLayoutX(b.getLayoutX()+5);
				for(var Z :zombies) {
					if(b.getLayoutX()+b.getFitWidth()/2>Z.getLayoutX() && b.getLayoutX()+b.getFitWidth()/2<Z.getLayoutX()+70) {
						if(b.getLayoutY()+b.getFitHeight()/2>Z.getLayoutY() && b.getLayoutY()+b.getFitHeight()/2<Z.getLayoutY()+80) {
							bullets4.remove(b);
							_field.getChildren().remove(b);
							zombies.remove(Z);
							_field.getChildren().remove(Z);
							run=0;
							shoot++;
							if(shoot==100) {
								best();
								YW.setVisible(true);
								Spent.setVisible(true);
								_time.setText(String.format("%02d",min)+":"+String.format("%02d", sec));
								_time.setVisible(true);
								Died.stop();
								rc1.stop();
								MakeZ.stop();
								manmove.stop();
								fps1.stop();
								fps2.stop();
								fps3.stop();
								fps4.stop();
								move.stop();
								clock.stop();
								Attack.stop();
							}
							break;
						}
					}
				}
				if(b.getLayoutY()<0||b.getLayoutY()>800||b.getLayoutX()>750||b.getLayoutX()<0) {
					bullets4.remove(b);
					_field.getChildren().remove(b);
				}
				}}));
		manmove = new Timeline(new KeyFrame(Duration.millis(50),(e)-> {
			if(up) {
				if(man.getLayoutY()<0) man.setLayoutY(man.getLayoutY());
				else {
					man.setLayoutY(man.getLayoutY()-10);
					man.setRotate(0);
				}
			}
			if(left) {
				if(man.getLayoutX()<0) man.setLayoutX(man.getLayoutX());
				else {
					man.setLayoutX(man.getLayoutX()-10);
					man.setRotate(270);
				}
			}
			if(down) {
				if(man.getLayoutY()+man.getFitHeight()>_field.getHeight()) man.setLayoutY(man.getLayoutY());
				else {
					man.setLayoutY(man.getLayoutY()+10);
					man.setRotate(180);
				}
			}
			if(right) {
				if(man.getLayoutX()+man.getFitWidth()>_field.getWidth()) man.setLayoutX(man.getLayoutX());
				else {
					man.setLayoutX(man.getLayoutX()+10);
					man.setRotate(90);
				}
			}
			if(record==0) {
				if(space) {
					Image image = new Image("file:C:\\Users\\dell\\Desktop\\javaTest\\javatest\\src\\project\\bulletnew.png");
					ImageView newBullet1=new ImageView();
					newBullet1.setImage(image);
					newBullet1.setFitHeight(26);
					newBullet1.setFitWidth(53);
					ImageView newBullet2=new ImageView();
					newBullet2.setImage(image);
					newBullet2.setFitHeight(26);
					newBullet2.setFitWidth(53);
					ImageView newBullet3=new ImageView();
					newBullet3.setImage(image);
					newBullet3.setFitHeight(26);
					newBullet3.setFitWidth(53);
					ImageView newBullet4=new ImageView();
					newBullet4.setImage(image);
					newBullet4.setFitHeight(26);
					newBullet4.setFitWidth(53);
					record=1;
					if(man.getRotate()==0) {
						newBullet1.setRotate(270);
						newBullet1.setLayoutX(man.getLayoutX()+newBullet1.getFitWidth()-newBullet1.getFitWidth()/2+15);
						newBullet1.setLayoutY(
							man.getLayoutY()-man.getFitHeight()/2);
						bullets1.push(newBullet1);
						_field.getChildren().add(newBullet1);
					}
					else if(man.getRotate()==270) {
						newBullet2.setRotate(180);
						newBullet2.setLayoutY(man.getLayoutY()+15);
						newBullet2.setLayoutX(
							man.getLayoutX()-man.getFitHeight()/2);
						bullets2.push(newBullet2);
						_field.getChildren().add(newBullet2);
					}
					else if(man.getRotate()==180) {
						newBullet3.setRotate(90);
						newBullet3.setLayoutX(man.getLayoutX()-15);
						newBullet3.setLayoutY(man.getLayoutY()+man.getFitHeight()/2+15);
						bullets3.push(newBullet3);
						_field.getChildren().add(newBullet3);
					}
					else if(man.getRotate()==90) {
						newBullet4.setRotate(0);
						newBullet4.setLayoutX(man.getLayoutX()+newBullet4.getFitWidth()-newBullet4.getFitWidth()/2+30);
						newBullet4.setLayoutY(man.getLayoutY()+man.getFitHeight()/2+10);
						bullets4.push(newBullet4);
						_field.getChildren().add(newBullet4);
					}
				}
			}

		}));
		MakeZ=new Timeline(new KeyFrame(Duration.millis(800),(e)->{
			int i = (int) (Math.random() * (681));
			int m=(int)(Math.random()*4);
			Image img = new Image("file:C:\\Users\\dell\\Desktop\\javaTest\\javatest\\src\\project\\zombie.png");
			ImageView newZombie=new ImageView();
			zombies.add(newZombie);
			newZombie.setImage(img);
			newZombie.setFitHeight(80);
			newZombie.setFitWidth(70);
			if(m==0) {
				newZombie.setLayoutX(i);
				newZombie.setLayoutY(0);
			}
			else if(m==1){
				newZombie.setLayoutX(i);
				newZombie.setLayoutY(750);
				newZombie.setRotate(180);
			}
			else if(m==2) {
				newZombie.setLayoutX(0);
				newZombie.setLayoutY(i);
				newZombie.setRotate(270);
			}
			else if(m==3) {
				newZombie.setLayoutX(_field.getWidth()-80);
				newZombie.setLayoutY(i);
				newZombie.setRotate(90);
			}
			animation(newZombie);
			_field.getChildren().add(newZombie);
		}));
		rc1=new Timeline(new KeyFrame(Duration.millis(300),(e)->{
			record=0;
		}));
		Attack=new Timeline(new KeyFrame(Duration.millis(300),(e)->{
			for(var Z :zombies) {
				double mid=Z.getLayoutX()+Z.getFitWidth()/2;
				double y=Z.getLayoutY()+Z.getFitHeight();
				if(mid>man.getLayoutX()&& mid<man.getLayoutX()+man.getFitWidth()) {
					if(y>man.getLayoutY()+man.getFitHeight()/2 &&y<man.getLayoutY()+man.getFitHeight()) {
						blood=blood-10;
						AT.setText("Blood Volume "+ ":"+" "+blood);
						value.setText(""+blood);
						at.setLayoutX(562);
						at.setLayoutY(200);
						Z.setLayoutX(Z.getLayoutX());
						Z.setLayoutY(Z.getLayoutY());
						break;
					}
				}
			}/*
			for(var Z :zombies) {
				double midX=man.getLayoutX()+man.getFitWidth()/2;
				double midY=man.getLayoutY()+man.getFitHeight()/2;
				if(midX>Z.getLayoutX() && midX<Z.getLayoutX()+Z.getFitWidth()) {
					if(midY>Z.getLayoutY() && midY<Z.getLayoutY()+Z.getFitHeight()) {
						blood=blood-10;
						AT.setText("Blood Volume "+ ":"+" "+blood);
						value.setText(""+blood);
						at.setLayoutX(562);
						at.setLayoutY(200);
						Z.setLayoutX(Z.getLayoutX());
						Z.setLayoutY(Z.getLayoutY());
						break;
					}
				}
			}*/
		}));
		Died=new Timeline(new KeyFrame(Duration.millis(100),(e)->{
			if(blood==0) {
				PauseField.setVisible(true);
				GO.setVisible(true);
				Back1.setVisible(true);
				value.setVisible(false);
				Died.stop();
				rc1.stop();
				MakeZ.stop();
				manmove.stop();
				fps1.stop();
				fps2.stop();
				fps3.stop();
				fps4.stop();
				for(int i=0;i<Move.size();i++) {
					Move.get(i).stop();
				}
				clock.stop();
				Attack.stop();
			}
		}));
		clock=new Timeline(new KeyFrame(Duration.millis(1000),(e)->{
			at.setVisible(false);
			sec++;
			if(sec>60) {
				min++;
				sec=0;
			}
			if(sec>15) {
				if(m>400) {
					m=m-100;
				}	
			}
		}));
		clock.setCycleCount(Timeline.INDEFINITE);
		Died.setCycleCount(Timeline.INDEFINITE);
		MakeZ.setCycleCount(100);
		rc1.setCycleCount(Timeline.INDEFINITE);
		manmove.setCycleCount(Timeline.INDEFINITE);
		fps1.setCycleCount(Timeline.INDEFINITE);
		fps2.setCycleCount(Timeline.INDEFINITE);
		fps3.setCycleCount(Timeline.INDEFINITE);
		fps4.setCycleCount(Timeline.INDEFINITE);
		Attack.setCycleCount(Timeline.INDEFINITE);
		rc1.play();
		MakeZ.play();
		manmove.play();
		fps1.play();
		fps2.play();
		fps3.play();
		fps4.play();
		Died.play();
		clock.play();
		Attack.play();
	}
}