package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int worldX;
    public int worldY;
    public int speed;

    public BufferedImage down1, down2, up1, up2, left1, left2, right1, right2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;


}
