package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler kh;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler kh) {
        this.gp = gp;
        this.kh = kh;

        screenX = gp.screenWidth / 2 - gp.tileSize / 2;
        screenY = gp.screenHeight / 2 - gp.tileSize / 2;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        this.worldX = gp.tileSize * 10;
        this.worldY = gp.tileSize * 10;
        this.speed = 4;
        direction = "down";
    }

    public void update() {
        if (kh.upPressed || kh.downPressed || kh.leftPressed || kh.rightPressed) {
            if (kh.upPressed) {
                direction = "up";
                worldY -= speed;
            }
            if (kh.downPressed) {
                direction = "down";
                worldY += speed;
            }
            if (kh.leftPressed) {
                direction = "left";
                worldX -= speed;
            }
            if (kh.rightPressed) {
                direction = "right";
                worldX += speed;
            }
            spriteCounter++;
            if (spriteCounter > 10) { // the image changes every 10 frames
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = null;

        switch (direction) {
            case "down":
                if (spriteNum == 1) {
                    image = down1;

                } else {
                    image = down2;

                }
                break;
            case "up":
                if (spriteNum == 1) {
                    image = up1;

                } else {
                    image = up2;

                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;

                } else {
                    image = left2;

                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;

                } else {
                    image = right2;

                }
                break;


        }

        g2d.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);


    }

    public void getPlayerImage() {
        try {
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_front_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_front_2.png"));
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_back_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_back_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
