package com.wrf.jump;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

/** 
 * @package:        com.wrf.jump
 * @Description:  TODO(������һ�仰�����������������) 
 * @author        knight
 * @Date          2018��3��12�� ����11:28:22 
 */
public class JumpJumpHelper  
{  
  
    private static final String IMAGE_NAME              = "current.png";  
  
    private static final String STORE_DIR               = "d:/jump_screencapture";  
  
    //����  
    private static final int    imageLengthLength       = 5;  
  
    //���ͼƬ�Ĵ�С  
    private static final long[] imageLength             = new long[imageLengthLength];  
  
    private final RGBInfo       rgbInfo                 = new RGBInfo();  
  
    private final String[]      ADB_SCREEN_CAPTURE_CMDS =  
                                                        { "adb shell screencap -p /sdcard/" + IMAGE_NAME,  
            "adb pull /sdcard/current.png " + STORE_DIR };  
  
    //��������Ϸ������ʾ�������·���Y���꣬300�� 1920x1080��ֵ������ʵ������޸�  
    private final int           gameScoreBottomY        = 300;  
  
    //��ѹ��ʱ��ϵ�����ɸ��ݾ�������ʵ�����  
    private final double        pressTimeCoefficient    = 1.35;  
  
    //��ѹ����ʼ�����꣬Ҳ������һ�ֵ���ʼ������  
    private final int           swipeX                  = 550;  
  
    private final int           swipeY                  = 1580;  
  
    //����֮һ�����ӵ����߶�  
    private final int           halfBaseBoardHeight     = 20;  
  
    //���ӵĿ�ȣ��ӽ�������ȡ�����е���  
    private final int           halmaBodyWidth          = 74;  
  
    //��Ϸ�����������������е����꣬��Ҫ��������Ƕȣ�������ʵ�ʵĽ������㣬����XY�ı���  
    private final int           boardX1                 = 813;  
  
    private final int           boardY1                 = 1122;  
  
    private final int           boardX2                 = 310;  
  
    private final int           boardY2                 = 813;  
  
    /** 
     * ��ȡ�����Լ���һ��������������� 
     * 
     * @return 
     * @author LeeHo 
     * @throws IOException 
     * @update 2017��12��31�� ����12:18:22 
     */  
    private int[] getHalmaAndBoardXYValue(File currentImage) throws IOException  
    {  
        BufferedImage bufferedImage = ImageIO.read(currentImage);  
        int width = bufferedImage.getWidth();  
        int height = bufferedImage.getHeight();  
        System.out.println("��ȣ�" + width + "���߶ȣ�" + height);  
        int halmaXSum = 0;  
        int halmaXCount = 0;  
        int halmaYMax = 0;  
        int boardX = 0;  
        int boardY = 0;  
        //�ӽ��������������б������ص㣬��������ɫ��Ϊλ��ʶ������ݣ�����ȡ��������ɫ������������ص��ƽ��ֵ����������������ڵ�����  
        for (int y = gameScoreBottomY; y < height; y++)  
        {  
            for (int x = 0; x < width; x++)  
            {  
                processRGBInfo(bufferedImage, x, y);  
                int rValue = this.rgbInfo.getRValue();  
                int gValue = this.rgbInfo.getGValue();  
                int bValue = this.rgbInfo.getBValue();  
                //����RGB����ɫ��ʶ�����ӵ�λ�ã�  
                if (rValue > 50 && rValue < 60 && gValue > 53 && gValue < 63 && bValue > 95 && bValue < 110)  
                {  
                    halmaXSum += x;  
                    halmaXCount++;  
                    //���ӵ��е�Y����ֵ  
                    halmaYMax = y > halmaYMax ? y : halmaYMax;  
                }  
            }  
        }  
  
        if (halmaXSum != 0 && halmaXCount != 0)  
        {  
            //���ӵ��е�X����ֵ  
            int halmaX = halmaXSum / halmaXCount;  
            //�������ӵ��̸߶ȵ�һ��  
            int halmaY = halmaYMax - halfBaseBoardHeight;  
            //��gameScoreBottomY��ʼ  
            for (int y = gameScoreBottomY; y < height; y++)  
            {  
                processRGBInfo(bufferedImage, 0, y);  
                int lastPixelR = this.rgbInfo.getRValue();  
                int lastPixelG = this.rgbInfo.getGValue();  
                int lastPixelB = this.rgbInfo.getBValue();  
                //ֻҪ���������boardX��ֵ����0���ͱ�ʾ�¸��������������Xֵȡ���ˡ�  
                if (boardX > 0)  
                {  
                    break;  
                }  
                int boardXSum = 0;  
                int boardXCount = 0;  
                for (int x = 0; x < width; x++)  
                {  
                    processRGBInfo(bufferedImage, x, y);  
                    int pixelR = this.rgbInfo.getRValue();  
                    int pixelG = this.rgbInfo.getGValue();  
                    int pixelB = this.rgbInfo.getBValue();  
                    //��������ͷ������һ�����廹�ߵ����  
                    if (Math.abs(x - halmaX) < halmaBodyWidth)  
                    {  
                        continue;  
                    }  
  
                    //������������ɨ������һ������Ķ���λ�ã��¸��������ΪԲ�Σ�Ҳ����Ϊ����ȡ����㣬��ƽ��ֵ  
                    if ((Math.abs(pixelR - lastPixelR) + Math.abs(pixelG - lastPixelG) + Math.abs(pixelB - lastPixelB)) > 10)  
                    {  
                        boardXSum += x;  
                        boardXCount++;  
                    }  
                }  
  
                if (boardXSum > 0)  
                {  
                    boardX = boardXSum / boardXCount;  
                }  
            }  
  
            //��ʵ�ʵĽǶ����㣬�ҵ��ӽ���һ�� board ���ĵ�����  
            boardY = (int) (halmaY - Math.abs(boardX - halmaX) * Math.abs(boardY1 - boardY2)  
                    / Math.abs(boardX1 - boardX2));  
            if (boardX > 0 && boardY > 0)  
            {  
                int[] result = new int[4];  
                //���ӵ�X����  
                result[0] = halmaX;  
                //���ӵ�Y����  
                result[1] = halmaY;  
                //��һ�������X����  
                result[2] = boardX;  
                //��һ�������Y����  
                result[3] = boardY;  
                return result;  
            }  
        }  
  
        return null;  
    }  
  
    /** 
     * ִ������ 
     * 
     * @param command 
     * @author LeeHo 
     * @update 2017��12��31�� ����12:13:39 
     */  
    private void executeCommand(String command)  
    {  
        Process process = null;  
        try  
        {  
            process = Runtime.getRuntime().exec(command);  
            System.out.println("exec command start: " + command);  
            process.waitFor();  
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));  
            String line = bufferedReader.readLine();  
            if (line != null)  
            {  
                System.out.println(line);  
            }  
            System.out.println("exec command end: " + command);  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        finally  
        {  
            if (process != null)  
            {  
                process.destroy();  
            }  
        }  
    }  
  
    /** 
     * ADB��ȡ��׿���� 
     *  
     * @author LeeHo 
     * @update 2017��12��31�� ����12:11:42 
     */  
    private void executeADBCaptureCommands()  
    {  
        for (String command : ADB_SCREEN_CAPTURE_CMDS)  
        {  
            executeCommand(command);  
        }  
    }  
  
    /** 
     * ��һ�� 
     * 
     * @param distance 
     * @author LeeHo 
     * @update 2017��12��31�� ����12:23:19 
     */  
    private void doJump(double distance)  
    {  
        System.out.println("distance: " + distance);  
        //���㰴ѹʱ�䣬��С200����  
        int pressTime = (int) Math.max(distance * pressTimeCoefficient, 200);  
        System.out.println("pressTime: " + pressTime);  
        //ִ�а�ѹ����  
        String command = String.format("adb shell input swipe %s %s %s %s %s", swipeX, swipeY, swipeX, swipeY,  
                pressTime);  
        System.out.println(command);  
        executeCommand(command);  
    }  
  
    /** 
     * ����һ�� 
     *  
     * @author LeeHo 
     * @update 2017��12��31�� ����12:47:06 
     */  
    private void replayGame()  
    {  
        String command = String.format("adb shell input tap %s %s", swipeX, swipeY);  
        executeCommand(command);  
    }  
  
    /** 
     * ������Ծ�ľ��룬Ҳ��������֮��ľ��� 
     * 
     * @param halmaX 
     * @param halmaY 
     * @param boardX 
     * @param boardY 
     * @return 
     * @author LeeHo 
     * @update 2017��12��31�� ����12:27:30 
     */  
    private double computeJumpDistance(int halmaX, int halmaY, int boardX, int boardY)  
    {  
        return Math.sqrt(Math.pow(Math.abs(boardX - halmaX), 2) + Math.pow(Math.abs(boardY - halmaY), 2));  
    }  
  
    public static void main(String[] args)  
    {  
        try  
        {  
            File storeDir = new File(STORE_DIR);  
            if (!storeDir.exists()) {  
               boolean flag = storeDir.mkdir();  
               if (!flag) {  
                   System.err.println("����ͼƬ�洢Ŀ¼ʧ��");  
                   return;  
               }  
            }  
              
            JumpJumpHelper jumpjumpHelper = new JumpJumpHelper();  
            //ִ�д���  
            int executeCount = 0;  
            for (;;)  
            {  
                //ִ��ADB�����ȡ��׿����  
                jumpjumpHelper.executeADBCaptureCommands();  
                File currentImage = new File(STORE_DIR, IMAGE_NAME);  
                if (!currentImage.exists())  
                {  
                    System.out.println("ͼƬ������");  
                    continue;  
                }  
  
                long length = currentImage.length();  
                imageLength[executeCount % imageLengthLength] = length;  
                //�鿴�Ƿ���Ҫ���¿���  
                jumpjumpHelper.checkDoReplay();  
                executeCount++;  
                System.out.println("��ǰ��" + executeCount + "��ִ��!");  
                //��ȡ����͵װ����������  
                int[] result = jumpjumpHelper.getHalmaAndBoardXYValue(currentImage);  
                if (result == null)  
                {  
                    System.out.println("The result of method getHalmaAndBoardXYValue is null!");  
                    continue;  
                }  
                int halmaX = result[0];  
                int halmaY = result[1];  
                int boardX = result[2];  
                int boardY = result[3];  
                System.out.println("halmaX: " + halmaX + ", halmaY: " + halmaY + ", boardX: " + boardX + ", boardY: "  
                        + boardY);  
                //������Ծ�ľ���  
                double jumpDistance = jumpjumpHelper.computeJumpDistance(halmaX, halmaY, boardX, boardY);  
                jumpjumpHelper.doJump(jumpDistance);  
                //ÿ��ͣ��2.5��  
                TimeUnit.MILLISECONDS.sleep(2500);  
            }  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * ����Ƿ���Ҫ���¿��� 
     *  
     * @author LeeHo 
     * @update 2017��12��31�� ����1:39:18 
     */  
    private void checkDoReplay()  
    {  
        if (imageLength[0] > 0 && imageLength[0] == imageLength[1] && imageLength[1] == imageLength[2]  
                && imageLength[2] == imageLength[3] && imageLength[3] == imageLength[4])  
        {  
            //��ʱ��ʾ�Ѿ�����5��ͼƬ��Сһ���ˣ���֪��ǰ��Ļ��������һ��  
            Arrays.fill(imageLength, 0);  
            //ģ��������һ�ְ�ť���¿���  
            replayGame();  
        }  
    }  
  
    /** 
     * ��ȡָ�������RGBֵ 
     * 
     * @param bufferedImage 
     * @param x 
     * @param y 
     * @author LeeHo 
     * @update 2017��12��31�� ����12:12:43 
     */  
    private void processRGBInfo(BufferedImage bufferedImage, int x, int y)  
    {  
        this.rgbInfo.reset();  
        int pixel = bufferedImage.getRGB(x, y);  
        //ת��ΪRGB����    
        this.rgbInfo.setRValue((pixel & 0xff0000) >> 16);  
        this.rgbInfo.setGValue((pixel & 0xff00) >> 8);  
        this.rgbInfo.setBValue((pixel & 0xff));  
    }  
  
    class RGBInfo  
    {  
        private int RValue;  
  
        private int GValue;  
  
        private int BValue;  
  
        public int getRValue()  
        {  
            return RValue;  
        }  
  
        public void setRValue(int rValue)  
        {  
            RValue = rValue;  
        }  
  
        public int getGValue()  
        {  
            return GValue;  
        }  
  
        public void setGValue(int gValue)  
        {  
            GValue = gValue;  
        }  
  
        public int getBValue()  
        {  
            return BValue;  
        }  
  
        public void setBValue(int bValue)  
        {  
            BValue = bValue;  
        }  
  
        public void reset()  
        {  
            this.RValue = 0;  
            this.GValue = 0;  
            this.BValue = 0;  
        }  
    }  
}  